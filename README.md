#                                                         WILDLIFE TRACKER! :paw_prints:

# DISPLAY

## AUTHOR

COLLINS KARIUKI

## DESCRIPTION :page_with_curl: :paw_prints:

This application allows Rangers to track wildlife sightings in the area, record them and ensure the animals are isolated to a safer zone. All with the help of a user-friendly interface and fast database.

[Check-Out App!](https://wl-tracker.herokuapp.com/)

## User Story

- Ranger can add a Animal.

- Ranger add a Sighting of a Single Animal

- Ranger can delete both Animal and Sightings Recorded.

- Application can Keep track of Engdangered animals, health, date of sighting, location age, identity number and number of animals. 

## PRE-REQUISITES.

A couple of things to get you started:

1. Ensure you have [Java](https://java.com/en/download/) installed

A simple way to install Java is using [sdkman](https://sdkman.io/).

Simply follow the instructions to have _sdkman_ installed and install java:

```bash
sdk install java
```

2. [Gradle](https://gradle.org/)

Gradle is used as the build tool and can be installed with sdkman:

```bash
sdk install gradle
```

3. Postgresql

Ensure you have installed postgresql on your localmachine

This will be used as the System Database for Hair Saloon.

Once u Have it installed Follow the below Instructions.

- Open your bash terminal

NOTE!

The ``` $ ``` and ``` =# ``` are only used to indicate the current location!... DO NOT TYPE THEM!

- Initialize postgresql Database using the below commands.

```
$ psql
```

- Create DataBase

```
=# CREATE DATABASE wildlife_tracker;
```

- Connect to DataBase

```
=# \c wildlife_tracker
```

- Create Animal Table

```
=# CREATE TABLE animal (id int PRIMARY KEY,name VARCHAR,category VARCHAR,health VARCHAR, age VARCHAR, status VARCHAR);
```

- Create Client Table

```
=# CREATE TABLE sighting (id serial PRIMARY KEY,ranger_name VARCHAR,location VARCHAR,doing VARCHAR,animal VARCHAR,date VARCHAR,month VARCHAR);
```

- CREATE Test DataBase

```
=# CREATE DATABASE wildlife_tracker WITH TEMPLATE wildlife_tracker_test;
```

