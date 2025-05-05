
# JE SUIS débutante => c'est mon premier projet SPRING BOOT -> Version application web

JAVA / MAVEN / SPRING BOOT
_________________________________________________________________________

# git

Fichier .gitignore pour cacher application.properties

Ajoute cette ligne à la racine de ton projet dans le fichier .gitignore :

________________________________________________________________________

# Ignorer le fichier de configuration Spring Boot
src/main/resources/application.properties

Si tu utilises plusieurs fichiers de configuration (par exemple pour différents profils : application-dev.properties, etc.), tu peux ajouter :

text
src/main/resources/application-*.properties

Ainsi, tous les fichiers de configuration Spring Boot seront ignorés par Git et ne seront pas poussés sur GitHub ou un autre dépôt distant.

Remarque importante :
Si tu as déjà commité ce fichier, il faudra le retirer de l’index Git avec la commande suivante avant que .gitignore ne soit pris en compte :

bash
git rm --cached src/main/resources/application.properties

Puis fais un commit pour enregistrer ce changement.

Résumé :

    Commente chaque ligne de ton fichier de configuration pour plus de clarté.

    Ajoute src/main/resources/application.properties dans .gitignore pour protéger tes identifiants et mots de passe.

____________________________________________________________________________
# Pour lancer mon serveur Spring boot
Pour régénérer votre fichier pom.xml avec les dépendances correctes et résoudre les erreurs, vous pouvez utiliser les commandes Maven suivantes dans votre terminal ou invite de commandes. Voici les étapes à suivre :

    Nettoyer le Projet :
        Utilisez la commande suivante pour nettoyer votre projet et supprimer les fichiers générés précédemment :

    mvn clean

Mettre à Jour les Dépendances :

    Pour forcer Maven à mettre à jour les dépendances, vous pouvez utiliser :

    mvn clean install -U

    L'option -U force la mise à jour des snapshots et des versions des dépendances.

Vérifier la Configuration :

    Vous pouvez vérifier la configuration de votre projet avec :

    mvn validate

Exécuter l'Application :

    Une fois que tout est configuré correctement, vous pouvez exécuter votre application Spring Boot avec :

        mvn spring-boot:run

Ces commandes devraient vous aider à régénérer votre pom.xml et à résoudre les problèmes de configuration. Assurez-vous que votre fichier pom.xml est correctement configuré comme indiqué dans ma réponse précédente avant d'exécuter ces commandes.
_______________________________________________________________________
# Dans mon navigateur pour visualiser le retour
http://localhost:8080
#
http://localhost:8080/utilisateur

# test
http://localhost:8080/utilisateur/demo

____________________________________________________________________


///////

28/05/2025

Résumé des endpoints CRUD

    Créer un utilisateur :
    POST /utilisateur/ajouter
    (avec un JSON Utilisateur dans le corps)

    Lire tous les utilisateurs :
    GET /utilisateur/

    Lire un utilisateur par matricule :
    GET /utilisateur/{matricule}

    Mettre à jour un utilisateur par id :
    PUT /utilisateur/modifier/{id}
    (avec un JSON Utilisateur dans le corps)

    Supprimer un utilisateur par id :
    DELETE /utilisateur/supprimer/{id}

________________________________________________________________________

# création des vues

src/
└── main/
    ├── java/
    │   └── com/
    │       └── emi/
    │           └── GestionnaireFormation/
    │               └── controller/
    │                   ├── AccueilController.java
    │                   └── UtilisateurController.java
    └── resources/
        └── templates/
            ├── index.html
            └── utilisateur/
                └── liste.html

_____________________________________________________________________________

# clean install
mvn clean spring-boot:run

mvn clean compile

______________________________________________________________________________

# Résumé des routes
Action	Méthode HTTP	URL	Vue / Action côté serveur
Liste	GET	/utilisateur/liste	utilisateur/liste.html
Ajouter (form)	GET	/utilisateur/ajouter	utilisateur/ajouter.html
Ajouter (traitement)	POST	/utilisateur/ajouter	Redirection vers /utilisateur/liste
Modifier (form)	GET	/utilisateur/modifier/{id}	utilisateur/modifier.html
Modifier (traitement)	POST	/utilisateur/modifier/{id}	Redirection vers /utilisateur/liste
Désactiver	POST	/utilisateur/desactiver/{id}	Redirection vers /utilisateur/liste

____________________________________________________________________________
_________________________________________________________________________

#### ATTENTION => TO DO
# pour une meilleur logique mon formateur:
ME conseil de séparer l'utilisateur et le role...
# => TO DO
Pour lèinstant j'injecte le role dans l'utilisateur.

_______________________________________________________________________
# 29/04/2025 suite en centre 

Problème avec le rôle

Problème avec Postman

-------------------------------------------

GestionnaireFormation/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── emi/
│       │           └── GestionnaireFormation/
│       │               ├── controller/
│       │               │   ├── AccueilController.java
│       │               │   └── UtilisateurController.java
│       │               ├── model/
│       │               │   └── Role.java
│       │               ├── repository/
│       │               │   └── RoleRepository.java
│       │               └── service/
│       │                   └── UtilisateurService.java
│       └── resources/
│           ├── static/
│           │   └── css/
│           │       └── styles.css
│           ├── templates/
│           │   ├── index.html
│           │   ├── utilisateur/
│           │   │   ├── ajouter.html
│           │   │   ├── liste.html
│           │   │   └── modifier.html
│           │   └── error.html
│           └── application.properties
├── pom.xml
└── (fichiers SQL d’export ou de création de la base, non inclus dans le build Maven)

_________________________________________________________________________

Lundi 05 mai 2025 
Jour présenciel en centre