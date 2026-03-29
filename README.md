# Java Strategy Game: Digital Tic-Tac-Toe

## Project Overview:-
This project is a Java-based implementation of the classic Tic-Tac-Toe game. It is designed as a lightweight tool for cognitive engagement and social interaction. Unlike modern games that require high data usage, this tool runs locally on any system with a Java Runtime Environment (JRE).

## Features:-
- **Interactive CLI:** A simple, number-based grid system for easy input.
- **Robust Error Handling:** Uses `try-catch` blocks to handle non-numeric or out-of-bounds inputs.
- **Data Persistence:** Automatically logs game results and timestamps to `game_history.txt`.
- **Winning Logic:** Efficiently calculates 8 different winning scenarios and draw states.

## Concepts Used:-
- **Object-Oriented Logic:** Clean separation of game methods.
- **File I/O:** Using `FileWriter` for persistent data logging.
- **Data Structures:** 1D and 2D arrays for board management.
- **Exception Handling:** Managing user input errors.

## Setup & Execution:-
1. Install JDK (Java Development Kit).
2. Download `TicTacToe.java`.
3. Open your terminal/command prompt.
4. Compile the code:
   ```bash
   javac TicTacToe.java
