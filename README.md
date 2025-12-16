# Clash-Pets 

## Project Overview

**Clash-Pets** is a Java-based virtual pet game inspired by characters from *Clash Royale*. In this program, users receive a randomly selected pet and can interact with it through different actions such as attacking, sleeping, running, or doing nothing. Each pet has unique traits and rarity levels, making every playthrough slightly different.

This project was created as a **group programming assignment** to practice object-oriented programming concepts in Java, including classes, inheritance, methods, and constructors.

---

## Features

*  **Random Pet Selection** based on rarity
*  **Object-Oriented Design** using parent and child classes
* **Interactive Gameplay** with user choices
* Multiple unique characters inspired by *Clash Royale*

---

## Class Diagram
https://drive.google.com/file/d/18-JBSaanW3MZyJ1g5wuSliI9PttRXkVl/view?usp=sharing 

---

## Pet Rarities

Each pet has a different chance of being selected:

* **Dart Goblin** – 50%
* **Hog Rider** – 35%
* **Berserker** – 14%
* **Pekka** – 1%

---

## Project Structure


Winter-Project-group-A-
│
├── main.java               # Runs the program and handles user interaction
├── Character.java          # Parent class for all pets
├── ClashRoyalePets.java    # Handles pet selection and game logic
│
├── DartGoblin.java         # Dart Goblin pet class
├── HogRider.java           # Hog Rider pet class
├── Berserker.java          # Berserker pet class
├── Pekka.java              # Pekka pet class
│
└── README.md               # Project documentation
```

---

## How It Works

1. The program starts in `main.java`.
2. A random number generator selects a pet based on rarity.
3. The selected pet is created using its class.
4. The user is prompted to choose actions for the pet.
5. Each action triggers different behaviors defined in the pet classes.

---

## How to Run the Program

1. Make sure you have **Java JDK** installed.
2. Clone or download the repository.
3. Open the project in an IDE (such as VS Code or IntelliJ).
4. Compile all `.java` files.
5. Run `main.java`.

---

## Learning Objectives

* Practice **inheritance and polymorphism**
* Understand **class relationships**
* Apply **randomization** in programs
* Work collaboratively using **GitHub**

---

## Contributors

* Nolan R
* Aiden N
* Matthew V
* Mateo M


---

## Future Improvements

* Add more characters and actions
* Improve user interface

---

**Thank you for checking out Clash-Pets!** 🎮
