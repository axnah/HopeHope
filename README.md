# HOPE HOPE

## Hub des Outils et Plateformes pour les Enseignements

HopeHope est une application web conçue pour centraliser et gérer les outils et plateformes pédagogiques utilisés par les enseignants et étudiants dans le cadre des enseignements (cours, TP, projets, etc.). L'objectif est de remplacer un fichier Excel existant par une application moderne, intuitive et fonctionnelle.

---

## Table des matières

1. [Prérequis](#prérequis)
2. [Installation et Lancement](#installation-et-lancement)
3. [Fonctionnalités](#fonctionnalités)
4. [Architecture du Projet](#architecture-du-projet)
5. [Configuration des Rôles](#configuration-des-rôles)
6. [Technologies Utilisées](#technologies-utilisées)
7. [Documentation API](#documentation-api)
8. [Problèmes Connus et Limitations](#problèmes-connus-et-limitations)
9. [Contributeurs](#contributeurs)

---

## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre machine :

- **Docker** : Téléchargez Docker Desktop.
- **Docker Compose** : Inclus avec Docker Desktop ou installé via CLI.
- **Java 17 ou version supérieure**.
- **Maven** : Pour gérer les dépendances et construire le projet.

---

## Installation et Lancement

### 1. Télécharger le projet

Clonez ce dépôt sur votre machine locale :

```bash
git clone <url-de-votre-repository>
cd <dossier-du-projet>
```

### 2. Lancer les conteneurs Docker

Le fichier `docker-compose.yml` configure deux services :

- **MariaDB** : Base de données principale.
- **Adminer** : Interface graphique pour interagir avec MariaDB.

Pour lancer les conteneurs :

```bash
docker-compose up -d
```

Le flag `-d` permet de lancer les conteneurs en arrière-plan.

### 3. Configurer l'application

Vérifiez que votre fichier `application.properties` contient les bonnes configurations pour la base de données :

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/PROJET
spring.datasource.username=anna
spring.datasource.password=chat
```

### 4. Lancer l'application

Construisez et démarrez l'application Spring Boot avec Maven :

```bash
mvn spring-boot:run
```

Lancez une requête post sur postman ou insomnia : 

http://localhost:8080/api/excel/import

OU

Si vous avez curl, lancez la commande suivante à la racine du projet : 

curl -X POST "http://localhost:8080/api/excel/import"

Pour importer les données de l'excel

### 5. Accéder à l'application

- **Application Web** : [http://localhost:8080](http://localhost:8080)
- **Adminer** : [http://localhost:8888](http://localhost:8888)
  - Serveur : `mariadb`
  - Utilisateur : `anna`
  - Mot de passe : `chat`
  - Base de données : `PROJET`

---

## Fonctionnalités

### Authentification

- **Page de connexion avec gestion des rôles** : Enseignant, Étudiant, Administrateur.
- **Gestion des sessions** avec affichage dynamique du profil utilisateur.

### Gestion des Outils et Plateformes

- **Liste Synthétique** : Vue tableau affichant les informations principales des outils.
- **Détails** : Page avec description détaillée des outils.
- **CRUD** :
  - Ajout d'outils ou plateformes.
  - Modification des informations (restreinte par rôle).
  - Suppression d'outils (administrateur uniquement).

### Recherche Multicritère

- **Recherche par titre, domaine, ou description**.

### Feedbacks

- **Ajout de retours** sur les outils, avec restrictions selon le rôle.

### Import et Visualisation Excel

- **Import de données** depuis un fichier Excel pour peupler la base de données.
- **Affichage des données importées** dans une interface utilisateur.

---

## Architecture du Projet

- **Frontend** : Géré avec Thymeleaf (templates HTML dynamiques).
- **Backend** : Basé sur Spring Boot avec :
  - **Spring Security** : Authentification et gestion des rôles.
  - **Spring Data JPA** : Accès aux données avec Hibernate.
- **Base de Données** : MariaDB.
- **Docker** : Conteneurisation de l'application et de la base de données.

---

## Configuration des Rôles

| Rôle       | Actions autorisées                          |
|------------|--------------------------------------------|
| **Admin**  | Accès complet : CRUD, validation.          |
| **Enseignant** | Consultation, suggestion d'outils.       |
| **Étudiant**   | Consultation, ajout limité de feedback. |

---

## Technologies Utilisées

- **Langages** : Java 17, HTML, CSS.
- **Frameworks** : Spring Boot, Spring Security, Spring Data JPA.
- **Base de Données** : MariaDB.
- **Conteneurs** : Docker, Docker Compose.
- **Frontend** : Thymeleaf.
- **Outils** : Maven, Adminer.

---

## Documentation API

Pour visualiser la documentation des endpoints REST :

1. Lancer l'application.
2. Accéder à [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

---

## Problèmes Connus et Limitations

- **Les validations des données utilisateur sont basiques** (doivent être renforcées).
- **L'authentification fonctionne en mémoire** pour le moment, pas encore connectée à une base de données.
- **Les logs d’erreur doivent être améliorés** pour une meilleure traçabilité.

---

## Contributeurs

- **Membres** :
  - Durand Arnaud
  - Cahagne Marius
  - Calvino Felisaz Arthur
  - Nieto Anna
  - Faouzi Elias
=======
ReadME HOPE HOPE

Hub des Outils et Plateformes pour les Enseignements
HopeHope est une application web conçue pour centraliser et gérer les outils et plateformes pédagogiques utilisés par les enseignants et étudiants dans le cadre des enseignements (cours, TP, projets, etc.). L'objectif est de remplacer un fichier Excel existant par une application moderne, intuitive et fonctionnelle.
________________________________________
Table des matières
1.	Prérequis
2.	Installation et Lancement
3.	Fonctionnalités
4.	Architecture du Projet
5.	Configuration des Rôles
6.	Technologies Utilisées
7.	Documentation API
8.	Problèmes Connus et Limitations
9.	Contributeurs
________________________________________
Prérequis
Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre machine :
•	Docker : Téléchargez Docker Desktop.
•	Docker Compose : Inclus avec Docker Desktop ou installé via CLI.
•	Java 17 ou version supérieure.
•	Maven : Pour gérer les dépendances et construire le projet.
________________________________________
Installation et Lancement
1. Télécharger le projet
Clonez ce dépôt sur votre machine locale :
bash
CopierModifier
git clone <url-de-votre-repository>
cd <dossier-du-projet>
2. Lancer les conteneurs Docker
Le fichier docker-compose.yml configure deux services :
•	MariaDB : Base de données principale.
•	Adminer : Interface graphique pour interagir avec MariaDB.
Pour lancer les conteneurs :
bash
CopierModifier
docker-compose up -d
Le flag -d permet de lancer les conteneurs en arrière-plan.
3. Configurer l'application
Vérifiez que votre fichier application.properties contient les bonnes configurations pour la base de données :
properties
CopierModifier
spring.datasource.url=jdbc:mariadb://localhost:3306/PROJET
spring.datasource.username=anna
spring.datasource.password=chat
4. Lancer l'application
Construisez et démarrez l'application Spring Boot avec Maven :
bash
CopierModifier
mvn spring-boot:run
5. Accéder à l'application
•	Application Web : http://localhost:8080
•	Adminer : http://localhost:8888
o	Serveur : mariadb
o	Utilisateur : anna
o	Mot de passe : chat
o	Base de données : PROJET
________________________________________
Fonctionnalités
Authentification
•	Page de connexion avec gestion des rôles : Enseignant, Étudiant, Administrateur.
•	Gestion des sessions avec affichage dynamique du profil utilisateur.
Gestion des Outils et Plateformes
•	Liste Synthétique : Vue tableau affichant les informations principales des outils.
•	Détails : Page avec description détaillée des outils.
•	CRUD :
o	Ajout d'outils ou plateformes.
o	Modification des informations (restreinte par rôle).
o	Suppression d'outils (administrateur uniquement).
Recherche Multicritère
•	Recherche par titre, domaine, ou description.
Feedbacks
•	Ajout de retours sur les outils, avec restrictions selon le rôle.
Import et Visualisation Excel
•	Import de données depuis un fichier Excel pour peupler la base de données.
•	Affichage des données importées dans une interface utilisateur.
________________________________________
Architecture du Projet
•	Frontend : Géré avec Thymeleaf (templates HTML dynamiques).
•	Backend : Basé sur Spring Boot avec :
o	Spring Security : Authentification et gestion des rôles.
o	Spring Data JPA : Accès aux données avec Hibernate.
•	Base de Données : MariaDB.
•	Docker : Conteneurisation de l'application et de la base de données.
________________________________________
Configuration des Rôles
Rôle	Actions autorisées
Admin	Accès complet : CRUD, validation.
Enseignant	Consultation, suggestion d'outils.
Étudiant	Consultation, ajout limité de feedback.
________________________________________
Technologies Utilisées
•	Langages : Java 17, HTML, CSS.
•	Frameworks : Spring Boot, Spring Security, Spring Data JPA.
•	Base de Données : MariaDB.
•	Conteneurs : Docker, Docker Compose.
•	Frontend : Thymeleaf.
•	Outils : Maven, Adminer.
________________________________________
Documentation API
Pour visualiser la documentation des endpoints REST :
1.	Lancer l'application.
2.	Accéder à http://localhost:8080/swagger-ui.html.
________________________________________
Problèmes Connus et Limitations
•	Les validations des données utilisateur sont basiques (doivent être renforcées).
•	L'authentification fonctionne en mémoire pour le moment, pas encore connectée à une base de données.
•	Les logs d’erreur doivent être améliorés pour une meilleure traçabilité.
________________________________________
Contributeurs
•	Nom de l'équipe : 3AME
•	Membres :
o	Durand Arnaud
o	Cahagne Marius
o	Calvino Felisaz Arthur	
o	Nieto Anna
o	Faouzi Elias
o	Benanane Ilyes
