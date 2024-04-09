# UCE Génie Logiciel Avancé : Techniques de tests

 [![CircleCI](https://img.shields.io/circleci/build/github/AmineSaadoun/ceri-m1-techniques-de-test?label=CircleCI&logo=circleci&style=flat-square)](https://app.circleci.com/pipelines/github/AmineSaadoun/ceri-m1-techniques-de-test?branch=master)
[![codecov](https://codecov.io/gh/AmineSaadoun/ceri-m1-techniques-de-test/graph/badge.svg?token=8BQTZ3EETD)](https://codecov.io/gh/AmineSaadoun/ceri-m1-techniques-de-test)
[![Checkstyle](/target/site/badges/checkstyle-result.svg)](/target/checkstyle-result.xml)

Lien vers Javadoc : [Javadoc](https://aminesaadoun.github.io/ceri-m1-techniques-de-test/)

# Raport TP6
Le rapport sur le TP6 montre des problèmes importants dans l'implémentation de la Team Rocket pour la création de Pokémon. Voici les principaux problèmes identifiés :

Génération aléatoire des statistiques : Les statistiques telles que les niveaux d'attaque, de défense et de stamina sont générées de manière aléatoire, ce qui ne suit pas les règles établies de Pokémon. Idéalement, ces valeurs devraient être basées sur les statistiques de base de l'espèce et le niveau de l'individu.

Valeurs par défaut inappropriées : Les statistiques sont définies à 1000 lorsque l'index est négatif. Cela ne correspond pas aux valeurs appropriées et peut causer des problèmes dans le fonctionnement du système.

Gestion des cas inexistants : Il n'y a pas de traitement correct pour les cas où l'index pour lequel il n'y a pas de Pokémon. Une gestion appropriée de cette situation devrait être mise en place pour éviter les erreurs et assurer le bon fonctionnement du système.

Mauvaise conception de la fonction generateRandomStat : Cette fonction semble mal conçue, ce qui entraîne une génération incohérente des statistiques des Pokémon. Il est nécessaire de revoir et de corriger cette conception pour garantir des résultats cohérents.

Indexation incorrecte : L'indexation des Pokémon démarre à -1 au lieu de 0, ce qui est en contradiction avec la convention habituelle. Cela peut causer des confusions et des erreurs dans le traitement des données et doit être corrigé pour suivre les conventions standard.

## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance    Commits on Feb 6, 2024        3552b618cb8942d319d441e92fdefbd05fb03fdc
- TP2 : 2ème séance    Commits on Feb 6, 2024        3552b618cb8942d319d441e92fdefbd05fb03fdc
- TP3 : 3ème séance    Commited on Mar 6, 2024       9e97e14ee2ab1dec6eca2137aeb0fc02382b9693
- TP4 : 5ème séance    Commited on Mar 20, 2024
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.
