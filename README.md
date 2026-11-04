# 🏦 Banque — Plateforme bancaire en architecture micro-services

Application de gestion bancaire composée de **trois services indépendants** (Java EE / WildFly, .NET 9) orchestrés par un **portail web Spring Boot**. Elle couvre la gestion des **clients**, des **comptes courants**, des **comptes de dépôt** et des **prêts** (échéanciers, remboursements, historiques).

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-6DB33F?logo=springboot&logoColor=white)
![Jakarta EE](https://img.shields.io/badge/Jakarta%20EE-10-blue)
![WildFly](https://img.shields.io/badge/WildFly-JBoss-red)
![.NET](https://img.shields.io/badge/.NET-9-512BD4?logo=dotnet)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?logo=postgresql&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?logo=thymeleaf&logoColor=white)

---

##  Sommaire

- [Fonctionnalités](#-fonctionnalités)
- [Architecture](#-architecture)
- [Stack technique](#-stack-technique)
- [Structure du dépôt](#-structure-du-dépôt)
- [Installation et lancement](#-installation-et-lancement)
- [API REST](#-api-rest)
- [Règles métier](#-règles-métier)
- [Auteur](#-auteur)

---

##  Fonctionnalités

### 👤 Clients
- Création et consultation des clients (identité, coordonnées, pièce d'identité)
- Informations professionnelles et **tranches de revenus**
- Statuts client avec **historique des changements**

### 💳 Comptes courants
- Ouverture de comptes et suivi du solde
- Opérations (dépôt, retrait, remboursement…) selon des **types d'opération** paramétrables
- Virements et historique des virements
- Historique des statuts du compte

### 💰 Comptes de dépôt
- Ouverture de comptes de dépôt avec **taux** paramétrables
- Opérations et transactions
- Historique des statuts

### 📄 Prêts
- Catalogue de **types de prêt** (montants, taux et durées min/max, revenus minimum requis)
- Demande de prêt avec **vérification automatique d'éligibilité**
- Génération de l'**échéancier** (annuité constante)
- **Remboursement** d'une échéance depuis un compte courant ou un compte de dépôt
- Suivi des statuts : `EN_COURS`, `EN_RETARD`, `TERMINE`, `ANNULE`, et historique du prêt

---

##  Architecture

Le portail **Centralizer** ne contient aucune logique de persistance : il consomme les API REST des trois services métier via `RestTemplate`. Chaque service possède sa propre base PostgreSQL.

```
                        ┌──────────────────────────────┐
        Navigateur ───▶ │  Centralizer (Spring Boot)   │
                        │  Thymeleaf · port 8099       │
                        └──────┬───────────┬───────────┘
                               │ REST      │ REST
              ┌────────────────┼───────────┼─────────────────┐
              ▼                ▼                             ▼
   ┌────────────────┐  ┌────────────────┐         ┌────────────────────┐
   │  PretModule    │  │ CourantModule  │         │  DepotServiceAPI   │
   │  (WAR)         │  │ (WAR)          │         │  (.NET 9 Web API)  │
   │  Clients+Prêts │  │ Comptes courants│        │  Comptes de dépôt  │
   │  WildFly :8080 │  │ WildFly :8080  │         │  Kestrel :5058     │
   └───────┬────────┘  └───────┬────────┘         └─────────┬──────────┘
           ▼                   ▼                            ▼
   PostgreSQL            PostgreSQL                   PostgreSQL
   « pret » + « client » « courant »                  « depot »
```

| Composant | Techno | Rôle | URL locale |
|---|---|---|---|
| **Centralizer** | Spring Boot 3.5, Thymeleaf | Portail web / orchestration | http://localhost:8099 |
| **PretService** (`PretModule`) | Jakarta EE 10, JPA/Hibernate, JAX-RS | Clients, prêts, échéances, remboursements | http://localhost:8080/PretModule/api |
| **CompteCourantService** (`CourantModule`) | Jakarta EE 10, JPA/Hibernate, JAX-RS | Comptes courants, opérations, virements | http://localhost:8080/CourantModule/api |
| **CompteDepotService** (`DepotServiceAPI`) | ASP.NET Core 9, EF Core, Swagger | Comptes de dépôt, taux, opérations | http://localhost:5058 |
| **WildFly** (console d'admin) | — | Serveur d'applications | http://localhost:9990 |

---

##🧰 Stack technique

| Couche | Technologies |
|---|---|
| Portail web | Spring Boot 3.5, Spring MVC, Thymeleaf, DevTools |
| Services Java | Jakarta EE 10 (EJB, JAX-RS, JPA), Hibernate, WildFly, Maven |
| Service .NET | ASP.NET Core 9, Entity Framework Core 9, Npgsql, Swashbuckle (Swagger) |
| Base de données | PostgreSQL |
| Modélisation | Looping (MCD) |

---

##  Structure du dépôt

```
banking/
├── Centralizer/              # Portail web Spring Boot (contrôleurs, services REST clients, templates Thymeleaf)
├── PretService/              # Module WildFly : clients, prêts, échéances, remboursements
├── CompteCourantService/     # Module WildFly : comptes courants, opérations, virements
├── CompteDepotService/       # API .NET 9 : comptes de dépôt (EF Core + Swagger)
├── Looping/                  # Modèles conceptuels de données (MCD)
└── sql/                      # Scripts SQL (schémas par domaine + reset.sql)
```

---

##  Installation et lancement

### Prérequis

- **JDK 17** et **Maven 3.9+**
- **WildFly** (compatible Jakarta EE 10)
- **.NET SDK 9**
- **PostgreSQL**

### 1. Bases de données

```sql
CREATE DATABASE pret;
CREATE DATABASE depot;
CREATE DATABASE courant;
CREATE DATABASE client;
```

(ces instructions sont aussi dans [`sql/reset.sql`](sql/reset.sql) ; les schémas de référence se trouvent dans [`sql/`](sql/)). Les tables sont créées/mises à jour automatiquement par Hibernate (`schema-generation = update`) et par les migrations EF Core.

### 2. Datasources WildFly

Déclarer trois datasources PostgreSQL dans WildFly, avec les JNDI attendus par les modules :

| JNDI | Base | Utilisé par |
|---|---|---|
| `java:/jdbc/PretDS` | `pret` | PretModule |
| `java:/jdbc/ClientDS` | `client` | PretModule |
| `java:/jdbc/CourantDS` | `courant` | CourantModule |

### 3. Déployer les modules Java sur WildFly

```bash
# PretModule
cd PretService
mvn clean package wildfly:deploy

# CourantModule
cd ../CompteCourantService
mvn clean package wildfly:deploy
```

> Le plugin `wildfly-maven-plugin` cible `localhost:9990`. Adaptez les identifiants d'administration dans le `pom.xml` à votre installation.

### 4. Lancer l'API de dépôt (.NET)

Renseigner la chaîne de connexion dans `CompteDepotService/DepotServiceAPI/appsettings.json` :

```json
"ConnectionStrings": {
  "DefaultConnection": "Host=localhost;Port=5432;Database=depot;Username=postgres;Password=<votre_mot_de_passe>"
}
```

Puis :

```bash
cd CompteDepotService/DepotServiceAPI
dotnet ef database update      # applique les migrations
dotnet run --urls http://localhost:5058
```

La documentation Swagger est disponible en environnement `Development`.

### 5. Lancer le portail Centralizer

```bash
cd Centralizer
./mvnw spring-boot:run
```

Ouvrir ensuite **http://localhost:8099**.

---

##  API REST

### Modules Java (WildFly) — préfixe `/{Module}/api`

| Module | Ressources principales |
|---|---|
| `PretModule` | `/pret`, `/typepret`, `/statuspret`, `/echeance`, `/remboursement`, `/historiquepret`, `/clients`, `/info`, `/trancherevenu`, `/statusclient`, `/historiqueclients`, `/virements` |
| `CourantModule` | `/comptecourant`, `/operationscourant`, `/typeoperation`, `/status`, `/historiquestatus`, `/historiquevirement` |

Les ressources exposent un CRUD classique : `GET /all`, `GET /{id}`, `POST /create`, `POST /update/{id}`, `GET /delete/{id}`, ainsi que des endpoints spécifiques (`/byPret/{id}`, `/latestByPret/{idPret}`, `/lastEnCours/{idPret}`, `/libelle/{libelle}`…).

### API .NET — `http://localhost:5058/api`

`/comptedepot`, `/operationsdepot`, `/taux`, `/typeoperation`, `/status`, `/historiquestatus`

---

## 📐 Règles métier

### Éligibilité d'un prêt
Une demande est refusée si :
- le client n'existe pas ;
- le **montant**, le **taux** ou la **durée** sortent des bornes du type de prêt choisi ;
- la **tranche de revenus** du client est inférieure au revenu minimum requis par le type de prêt.

### Calcul de l'échéancier (annuité constante)

```
A = M × t / (1 − (1 + t)^(−n))
```

- `M` : montant du prêt
- `t` : taux périodique = `taux / 100 / 12` (mensuel)
- `n` : durée en mois

Pour chaque échéance :

```
Intérêt                 = Capital restant × t
Amortissement           = A − Intérêt
Nouveau capital restant = Ancien capital restant − Amortissement
```

### Remboursement d'une échéance
- Le compte à débiter est identifié par son numéro : préfixe **`C`** (compte courant) ou **`D`** (compte de dépôt), suivi de l'identifiant.
- Le **solde doit être suffisant**.
- Sur un **compte de dépôt**, le prélèvement ne peut pas faire descendre le solde sous **50 %** de sa valeur avant opération.
- Une opération de type « remboursement » est enregistrée sur le compte, l'échéance passe au statut **payé** et le remboursement est historisé.

---

##  Auteur

**R.A Kasaina Alvinah**

Projet réalisé dans un cadre d'apprentissage de l'architecture micro-services et de l'interopérabilité Java / .NET.
