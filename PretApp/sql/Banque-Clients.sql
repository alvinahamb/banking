CREATE TABLE Clients(
   idClient INTEGER GENERATED ALWAYS AS IDENTITY,
   nom VARCHAR(50) ,
   prenoms VARCHAR(50) ,
   date_de_naissance DATE,
   lieu_de_naissance VARCHAR(50) ,
   adresse VARCHAR(50) ,
   telephone VARCHAR(50) ,
   email VARCHAR(50) ,
   numero_identite VARCHAR(50) ,
   date_ajout DATE,
   PRIMARY KEY(idClient)
);

CREATE TABLE TrancheRevenu(
   idTranche INTEGER GENERATED ALWAYS AS IDENTITY,
   valeur_min NUMERIC(15,2),
   valeur_max NUMERIC(15,2),
   PRIMARY KEY(idTranche)
);

CREATE TABLE StatusClient(
   idStatusClient INTEGER GENERATED ALWAYS AS IDENTITY,
   libelle VARCHAR(50) ,
   PRIMARY KEY(idStatus)
);

CREATE TABLE InformationProfessionel(
   idInfo INTEGER GENERATED ALWAYS AS IDENTITY,
   emploi VARCHAR(50) ,
   date_changement DATE NOT NULL,
   idTranche INTEGER NOT NULL,
   idClient INTEGER NOT NULL,
   PRIMARY KEY(idInfo),
   FOREIGN KEY(idTranche) REFERENCES Tranche_revenu(idTranche),
   FOREIGN KEY(idClient) REFERENCES Clientss(idClient)
);

-- association
CREATE TABLE HistoriqueClients(
   idHistorique INTEGER GENERATED ALWAYS AS IDENTITY,
   idStatusClient INTEGER,
   idClient INTEGER,
   date_changement TIMESTAMP,
   PRIMARY KEY(idHistorique),
   FOREIGN KEY(idClient) REFERENCES Clients(idClient),
   FOREIGN KEY(idStatusClient) REFERENCES Status(idStatusClient)
);
