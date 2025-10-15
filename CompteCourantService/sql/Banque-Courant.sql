CREATE TABLE Status (
    idStatus INTEGER GENERATED ALWAYS AS IDENTITY,
    libelle VARCHAR(50),
    PRIMARY KEY (idStatus)
);

CREATE TABLE TypeOperation (
    idTypeOperation INTEGER GENERATED ALWAYS AS IDENTITY,
    libelle VARCHAR(50),
    credit BOOLEAN,
    PRIMARY KEY (idTypeTransaction)
);

CREATE TABLE CompteCourant (
    idCompteCourant INTEGER GENERATED ALWAYS AS IDENTITY,
    numeroCompte VARCHAR(50) NOT NULL,
    idClient INTEGER,
    soldeActuel NUMERIC(15,2),
    dateOuverture TIMESTAMP NOT NULL,
    dateCloture TIMESTAMP,
    decouvertAutorise NUMERIC(15,2),
    PRIMARY KEY (idCompteCourant),
    UNIQUE (numeroCompte)
);

CREATE TABLE HistoriqueVirement (
    idVirement INTEGER GENERATED ALWAYS AS IDENTITY,
    montant NUMERIC(15,2),
    numeroCompteSource VARCHAR(50),
    numeroCompteDestination VARCHAR(50),
    dateVirement TIMESTAMP,
    PRIMARY KEY (idVirement)
);

CREATE TABLE OperationsCourant (
    idOperation INTEGER GENERATED ALWAYS AS IDENTITY,
    montant NUMERIC(15,2),
    dateOperation TIMESTAMP NOT NULL,
    dateValeur TIMESTAMP,
    soldeActuel NUMERIC(15,2),
    idVirement INTEGER,
    idTypeOperation INTEGER NOT NULL,
    idCompteCourant INTEGER NOT NULL,
    PRIMARY KEY (idOperation),
    FOREIGN KEY (idTypeTransaction) REFERENCES TypeOperation(idTypeTransaction),
    FOREIGN KEY (idCompteCourant) REFERENCES CompteCourant(idCompteCourant)
);
-- ici 
CREATE TABLE HistoriqueStatus (
    idHistoriqueCourant INTEGER,
    idCompteCourant INTEGER,
    idStatus INTEGER NOT NULL,
    dateChangement TIMESTAMP,
    PRIMARY KEY (idHistoriqueCourant),
    FOREIGN KEY (idStatus) REFERENCES Status(idStatus),
    FOREIGN KEY (idCompteCourant) REFERENCES CompteCourant(idCompteCourant)
);
