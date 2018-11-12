DROP DATABASE IF EXISTS gestionEtudiant;
CREATE DATABASE gestionEtudiant;
\c gestionetudiant

CREATE TABLE utilisateur(
	nom varchar,
	prenom varchar,
	motDePasse varchar
);

CREATE TABLE Etudiant(
	nom varchar,
	prenom varchar,
	contact varchar,
	region varchar,
	sexe varchar
);

