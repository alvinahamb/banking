CREATE TABLE Clients(
   idClients INTEGER GENERATED ALWAYS AS IDENTITY,
   nom VARCHAR(50) ,
   prenoms VARCHAR(50) ,
   date_de_naissance DATE,
   lieu_de_naissance VARCHAR(50) ,
   adresse VARCHAR(50) ,
   telephone VARCHAR(50) ,
   email VARCHAR(50) ,
   numero_identite VARCHAR(50) ,
   date_ajout DATE,
   PRIMARY KEY(idClients)
);

CREATE TABLE Tranche_revenu(
   idTranche INTEGER GENERATED ALWAYS AS IDENTITY,
   valeur_min NUMERIC(15,2),
   valeur_max NUMERIC(15,2),
   PRIMARY KEY(idTranche)
);

CREATE TABLE Status(
   idStatus INTEGER GENERATED ALWAYS AS IDENTITY,
   valeur VARCHAR(50) ,
   PRIMARY KEY(idStatus)
);

CREATE TABLE Information_professionel(
   idInfo INTEGER GENERATED ALWAYS AS IDENTITY,
   emploi VARCHAR(50) ,
   date_changement DATE NOT NULL,
   idTranche INTEGER NOT NULL,
   idClients INTEGER NOT NULL,
   PRIMARY KEY(idInfo),
   FOREIGN KEY(idTranche) REFERENCES Tranche_revenu(idTranche),
   FOREIGN KEY(idClients) REFERENCES Clientss(idClients)
);

-- association
CREATE TABLE Historique_Clients(
   idClients INTEGER GENERATED ALWAYS AS IDENTITY,
   idStatus INTEGER,
   date_changement TIMESTAMP,
   PRIMARY KEY(idClients, idStatus),
   FOREIGN KEY(idClients) REFERENCES Clientss(idClients),
   FOREIGN KEY(idStatus) REFERENCES Status(idStatus)
);
