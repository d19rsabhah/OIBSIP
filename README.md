# OIBSIP
# TASK 1
# Online Reservation System

## This project implements a simple Online Reservation System using Java and MySQL. The system allows users to interact with a MySQL database to perform operations such as inserting new reservation records, deleting existing records, and viewing all reservations. The project comprises two main classes:

### User Class:
#### Manages user authentication with a username and password.
#### Enables secure access to the MySQL database.

### PnrRecord Class:
#### Handles the creation of Passenger Name Record (PNR) entries.
#### Utilizes a random PNR number generator and user input for details such as passenger name, train number, class type, journey date, departure, and destination locations.

### Key Features:
#### User authentication for secure access.
#### Dynamic generation of PNR numbers.
#### CRUD operations (Create, Read, Update, Delete) on reservation records.
#### MySQL database integration for persistent data storage.
#### User-friendly console interface for easy interaction.

## How to Use:
#### Launch the program and enter your username and password.
#### Choose from options: Insert Record, Delete Record, Show All Records, or Exit.
#### Insert Record: Enter details to add a new reservation.
#### Delete Record: Specify the PNR number to delete a reservation.
#### Show All Records: View all reservations stored in the database.

### This project demonstrates fundamental concepts of Java programming, database connectivity, and user interaction in a console-based application. It is designed for educational purposes, showcasing a simplified implementation of a reservation system.

# TASK 2
# Number Guessing Game Documentation
### Overview
#### The Number Guessing Game is a Java-based project designed to run in the command line. It offers users an interactive experience to test their guessing skills by attempting to predict a randomly generated number between 1 and 100. The game provides a limited number of attempts per round, with each successful guess contributing to the player's overall score. The project aims to be a fun and educational exercise for Java programming enthusiasts.

## Features

### Random Number Generation:
#### The system generates a random number between 1 and 100 at the beginning of each round.

### Limited Attempts:
Users are allowed a maximum of five attempts to guess the correct number in each round.

### Scoring System:
#### A scoring mechanism is in place where successful guesses contribute to the player's score.
The score is calculated based on the number of attempts made.

### Interactive Feedback:
#### After each guess, the program provides feedback, indicating whether the guess is too high, too low, or correct.

### Multiple Rounds:
#### Users have the option to play the game in multiple rounds, with a new random number generated for each round.

## How to Play

### Run the Program:
#### Compile and run the Java program in a command-line environment.

### Guess the Number:
#### Enter your guess when prompted, aiming to correctly identify the randomly generated number.

### Feedback:
#### Receive feedback on each guess, guiding you to adjust your subsequent attempts.

### Limited Attempts:
#### Note that you have a maximum of five attempts per round.

### Score and Rounds:
#### Accumulate points based on successful guesses.
#### Choose to play additional rounds to further challenge yourself.

## Usage

### Compile:
#### Compile the Java file using a Java compiler.
#### bash
#### Copy code
#### javac NumberGuessingGame.java

### Run:
#### Run the compiled program.
#### bash
#### Copy code
#### java NumberGuessingGame

### Game Interaction:
#### Follow the on-screen prompts to enter your guesses and navigate through the game.

### Conclusion
#### The Number Guessing Game provides an enjoyable way to practice Java programming skills, offering a blend of interactivity and challenge. Whether you are a beginner looking to enhance your coding abilities or an enthusiast seeking a quick and entertaining project, this game is designed to deliver a rewarding experience.

