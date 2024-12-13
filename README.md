# HopeHope
Hub des Outils et Plateformes pour les Enseignements

# Prérequis

Avant de démarrer, assure-toi d'avoir installé :

# Docker : Télécharger Docker
Docker Compose : Inclus avec Docker Desktop ou installé via CLI.
Contenu du Docker Compose

Le fichier docker-compose.yml définit deux services :

MariaDB : La base de données principale.
Adminer : Interface graphique pour interagir avec MariaDB.

# Étapes pour lancer les conteneurs

## 1. Télécharger le projet
Clone le projet depuis le dépôt :

git clone <url-de-ton-repository>
cd <dossier-du-projet>

## 2. Lancer les conteneurs
Exécute la commande suivante pour démarrer les services :

docker-compose up -d
-d permet de lancer les conteneurs en arrière-plan.

## 3. Accéder aux services
Base de données MariaDB
Port : 3306
Configuration pour se connecter depuis ton application Spring Boot :
spring.datasource.url=jdbc:mariadb://localhost:3306/PROJET
spring.datasource.username=anna
spring.datasource.password=chat
Interface Adminer
Accède à Adminer via :
http://localhost:8888
Serveur : mariadb
Utilisateur : anna
Mot de passe : chat
Base de données : PROJET
