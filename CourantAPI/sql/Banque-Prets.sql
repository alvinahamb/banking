CREATE TABLE TypePret(
   idTypePret INTEGER GENERATED ALWAYS AS IDENTITY,
   libelle VARCHAR(50) ,
   modalite INTEGER,
   montant_min NUMERIC(15,2) ,
   montant_max NUMERIC(15,2) ,
   revenus_min NUMERIC(15,2)  ,
   taux INTEGER,
   PRIMARY KEY(idTypePret)
);

CREATE TABLE StatusPret(
   idStatusPret INTEGER GENERATED ALWAYS AS IDENTITY,
   libelle VARCHAR(50) ,
   PRIMARY KEY(idStatusPret)
);

CREATE TABLE ModeDePaiement(
   idModeDePaiement INTEGER GENERATED ALWAYS AS IDENTITY,
   libelle VARCHAR(50)  NOT NULL,
   PRIMARY KEY(idModeDePaiement),
   UNIQUE(libelle)
);
CREATE TABLE Pret(
   idPret INTEGER GENERATED ALWAYS AS IDENTITY,
   idClient INTEGER,
   montant INTEGER,
   date_operation TIMESTAMP,
   date_valeur TIMESTAMP,
   duree_mois INTEGER,
   idTypePret INTEGER NOT NULL,
   PRIMARY KEY(idPret),
   FOREIGN KEY(idTypePret) REFERENCES TypePret(idTypePret)
);

CREATE TABLE Echeance(
   idEcheance INTEGER GENERATED ALWAYS AS IDENTITY,
   capital_debut NUMERIC(15,2)  ,
   montant_interet NUMERIC(15,2)  ,
   amortissement NUMERIC(15,2)  ,
   annuite NUMERIC(15,2)  ,
   capital_fin NUMERIC(15,2)  ,
   date_echance TIMESTAMP,
   idPret INTEGER NOT NULL,
   idStatusPret INTEGER NOT NULL,
   PRIMARY KEY(idEcheance),
   FOREIGN KEY(idPret) REFERENCES Pret(idPret),
   FOREIGN KEY(idStatusPret) REFERENCES StatusPret(idStatusPret)
);
-- ici 
CREATE TABLE Remboursement(
   idRemboursement INTEGER GENERATED ALWAYS AS IDENTITY,
   idClient INTEGER,
   montant NUMERIC(15,2) ,
   date_remboursement TIMESTAMP,
   numero_compte VARCHAR(50),
   idEcheance INTEGER NOT NULL,
   idModeDePaiement INTEGER NOT NULL,
   idPret INTEGER NOT NULL,
   PRIMARY KEY(idRemboursement),
   FOREIGN KEY(idEcheance) REFERENCES Echeance(idEcheance),
   FOREIGN KEY(idModeDePaiement) REFERENCES ModeDePaiement(idModeDePaiement),
   FOREIGN KEY(idPret) REFERENCES Pret(idPret)
);

-- association 
CREATE TABLE HistoriquePret(
   idHistoriquePret INTEGER GENERATED ALWAYS AS IDENTITY,
   idPret INTEGER,
   idStatusPret INTEGER,
   date_changement TIMESTAMP,
   PRIMARY KEY(idHistoriquePret),
   FOREIGN KEY(idPret) REFERENCES Pret(idPret),
   FOREIGN KEY(idStatusPret) REFERENCES StatusPret(idStatusPret)
);
