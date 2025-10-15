CREATE TABLE taux(
   IdTaux INTEGER GENERATED ALWAYS AS IDENTITY,
   Valeur INTEGER,
   PRIMARY KEY(idTaux)
);

-- done
CREATE TABLE compteDepot(
   IdCompteDepot INTEGER GENERATED ALWAYS AS IDENTITY,
   NumeroCompte VARCHAR(50) UNIQUE,
   IdClient INTEGER NOT NULL,
   SoldeActuel NUMERIC(15,2) NOT NULL,
   DateOuverture TIMESTAMP NOT NULL,
   DateCloture TIMESTAMP,
   IdTaux INTEGER NOT NULL,
   PRIMARY KEY(IdCompteDepot),
   FOREIGN KEY(IdTaux) REFERENCES taux(IdTaux)
);

CREATE TABLE typeOperation(
   IdTypeTransaction INTEGER GENERATED ALWAYS AS IDENTITY,
   Libelle VARCHAR(50),
   Credit BOOLEAN,
   PRIMARY KEY(IdTypeTransaction)
);

CREATE TABLE status(
   IdStatus INTEGER GENERATED ALWAYS AS IDENTITY,
   Libelle VARCHAR(50),
   PRIMARY KEY(IdStatus)
);

-- done
CREATE TABLE operationsDepot(
   IdOperation INTEGER GENERATED ALWAYS AS IDENTITY,
   Montant NUMERIC(15,2),
   DateOperation TIMESTAMP,
   DateValeur TIMESTAMP,
   SoldeActuel NUMERIC(15,2),
   IdVirement INTEGER,
   IdTypeOperation INTEGER NOT NULL,
   IdCompteDepot INTEGER NOT NULL,
   PRIMARY KEY(IdOperation),
   FOREIGN KEY(IdTypeTransaction) REFERENCES typeOperation(IdTypeTransaction),
   FOREIGN KEY(IdCompteDepot) REFERENCES compteDepot(IdCompteDepot)
);

-- done
-- association
CREATE TABLE historiqueStatusComptes(
   IdHistoriqueDepot INTEGER GENERATED ALWAYS AS IDENTITY,
   IdCompteDepot INTEGER NOT NULL,
   IdStatus INTEGER NOT NULL,
   DateChangement TIMESTAMP,
   PRIMARY KEY(IdHistoriqueDepot),
   FOREIGN KEY(IdCompteDepot) REFERENCES compteDepot(IdCompteDepot),
   FOREIGN KEY(IdStatus) REFERENCES status(IdStatus)
);
-- TABLE 
DROP TABLE taux;
DROP TABLE compteDepot;
DROP TABLE typeOperation;
DROP TABLE status;
DROP TABLE operationsDepot;
DROP TABLE historiqueStatusComptes;