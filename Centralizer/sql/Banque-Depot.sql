CREATE TABLE Taux(
   IdTaux INTEGER GENERATED ALWAYS AS IDENTITY,
   Valeur INTEGER,
   PRIMARY KEY(idTaux)
);

CREATE TABLE CompteDepot(
   IdCompteDepot INTEGER GENERATED ALWAYS AS IDENTITY,
   NumeroCompte VARCHAR(50) UNIQUE,
   IdClient INTEGER NOT NULL,
   SoldeActuel NUMERIC(15,2) NOT NULL,
   DateOuverture TIMESTAMP NOT NULL,
   DateCloture TIMESTAMP,
   IdTaux INTEGER NOT NULL,
   PRIMARY KEY(IdCompteDepot),
   FOREIGN KEY(IdTaux) REFERENCES Taux(IdTaux)
);

CREATE TABLE TypeOperation(
   IdTypeTransaction INTEGER GENERATED ALWAYS AS IDENTITY,
   Libelle VARCHAR(50),
   Credit BOOLEAN,
   PRIMARY KEY(IdTypeTransaction)
);

CREATE TABLE Status(
   IdStatus INTEGER GENERATED ALWAYS AS IDENTITY,
   Libelle VARCHAR(50),
   PRIMARY KEY(IdStatus)
);

CREATE TABLE OperationsDepot(
   IdOperation INTEGER GENERATED ALWAYS AS IDENTITY,
   Montant NUMERIC(15,2),
   DateOperation TIMESTAMP,
   DateValeur TIMESTAMP,
   SoldeActuel NUMERIC(15,2),
   IdVirement INTEGER,
   IdTypeTransaction INTEGER NOT NULL,
   IdCompteDepot INTEGER NOT NULL,
   PRIMARY KEY(IdOperation),
   FOREIGN KEY(IdTypeTransaction) REFERENCES TypeOperation(IdTypeTransaction),
   FOREIGN KEY(IdCompteDepot) REFERENCES CompteDepot(IdCompteDepot)
);

-- association
CREATE TABLE HistoriqueStatusComptes(
   IdHistoriqueDepot INTEGER GENERATED ALWAYS AS IDENTITY,
   IdCompteDepot INTEGER NOT NULL,
   IdStatus INTEGER NOT NULL,
   DateChangement TIMESTAMP,
   PRIMARY KEY(IdHistoriqueDepot),
   FOREIGN KEY(IdCompteDepot) REFERENCES CompteDepot(IdCompteDepot),
   FOREIGN KEY(IdStatus) REFERENCES Status(IdStatus)
);
-- TABLE 
DROP TABLE Taux;
DROP TABLE CompteDepot;
DROP TABLE TypeOperation;
DROP TABLE Status;
DROP TABLE OperationsDepot;
DROP TABLE HistoriqueStatusComptes;