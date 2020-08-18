# Video Game Backlog Helper

A basic CLI to track and sort your video game backlog, for all the other steam summer sale and humble bundle users out there

## Features

- [x] Takes command line user input
  - [x] Parsed by commands and data
    - [x] Program requests command input
      - [x] May also be requested to list commands
    - [x] Reads command and follows up requesting relevant data

- [x] Can add and remove to list of games
- [x] Can display list of games
- [x] Can display sublist of games based on genre, control method, or if the game has been started
- [x] Can select random game from list or sublists

- [x] Persists game list to database
  - [x] GameList mirroring database created on program start

## How to Use

Program requires : maven, java, docker for postgresql, and junit

Note : port 5432 must be free
Before program is run, must build and run docker container by running following commands from db directory:
docker build -t projectdb .
docker run --rm -p 5432:5432 musicapi

Compile program using:
mvn compile

Run unit tests using:
mvn test

Run program using:
mvn exec:java
