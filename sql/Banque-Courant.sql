CREATE TABLE Status (
    idStatus INTEGER GENERATED ALWAYS AS IDENTITY,
    valeur VARCHAR(50),
    PRIMARY KEY (idStatus)
);

CREATE TABLE TypeOperation (
    idTypeTransaction INTEGER GENERATED ALWAYS AS IDENTITY,
    libelle VARCHAR(50),
    credit BOOLEAN,
    PRIMARY KEY (idTypeTransaction)
);

CREATE TABLE CompteCourant (
    idCompteCourant INTEGER GENERATED ALWAYS AS IDENTITY,
    numero_compte VARCHAR(50) NOT NULL,
    idClient INTEGER,
    solde_actuel NUMERIC(15,2),
    date_ouverture TIMESTAMP NOT NULL,
    date_cloture TIMESTAMP,
    decouvert_autorise NUMERIC(15,2),
    PRIMARY KEY (idCompteCourant),
    UNIQUE (numero_compte)
);

CREATE TABLE HistoriqueVirement (
    idVirement INTEGER GENERATED ALWAYS AS IDENTITY,
    montant NUMERIC(15,2),
    numero_compte_source VARCHAR(50),
    numero_compte_destination VARCHAR(50),
    date_virement TIMESTAMP,
    PRIMARY KEY (idVirement)
);

CREATE TABLE OperationsCourant (
    idOperation INTEGER GENERATED ALWAYS AS IDENTITY,
    montant NUMERIC(15,2),
    date_operation TIMESTAMP NOT NULL,
    date_valeur TIMESTAMP,
    solde_actuel NUMERIC(15,2),
    idVirement INTEGER,
    idTypeTransaction INTEGER NOT NULL,
    idCompteCourant INTEGER NOT NULL,
    PRIMARY KEY (idOperation),
    FOREIGN KEY (idTypeTransaction) REFERENCES TypeOperation(idTypeTransaction),
    FOREIGN KEY (idCompteCourant) REFERENCES CompteCourant(idCompteCourant)
);

CREATE TABLE HistoriqueComptesC (
    idStatus INTEGER,
    idCompteCourant INTEGER,
    date_changement TIMESTAMP,
    PRIMARY KEY (idStatus, idCompteCourant),
    FOREIGN KEY (idStatus) REFERENCES Status(idStatus),
    FOREIGN KEY (idCompteCourant) REFERENCES CompteCourant(idCompteCourant)
);
