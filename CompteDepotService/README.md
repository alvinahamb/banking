# Projet .NET WebAPI avec Entity Framework Core et Swagger

Ce projet est une **API REST en .NET** qui utilise **Entity Framework Core** pour la persistance des données avec PostgreSQL et **Swagger** pour la documentation interactive.

---

## 1. Installation des packages

### Swagger (documentation API)
```bash
dotnet add package Swashbuckle.AspNetCore

# Tools → NuGet Package Manager → Package Manager Console
# Installer le provider PostgreSQL pour EF Core
Install-Package Npgsql.EntityFrameworkCore.PostgreSQL

# Installer les outils EF Core pour gérer les migrations
Install-Package Microsoft.EntityFrameworkCore.Tools

## 2. Configuration de la base de données

# Dans appsettings.json, ajouter la connection string PostgreSQL :
{
  "ConnectionStrings": {
    "DefaultConnection": "Server=localhost;Database=NomDB;User Id=postgres;Password=ton_mot_de_passe;"
}
# Dans Program.cs :
builder.Services.AddDbContext<AppDbContext>(options =>
    options.UseNpgsql(builder.Configuration.GetConnectionString("DefaultConnection")));

# 3. Création et mise à jour de la base
# Créer la migration initiale
Add-Migration InitialCreate

# Appliquer la migration à la base
Update-Database

# Install-Package Swashbuckle.AspNetCore.Annotations