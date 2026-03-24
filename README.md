# Tic Tac Toe

A console-based two-player Tic Tac Toe game written in Java with input validation, win/draw detection, and a play again option.

## Requirements

- Java 8+

## Setup

```bash
javac TicTacToe.java
```

## Usage

```bash
java TicTacToe
```

Players take turns entering a row and column number (0–2) to place their mark. Player X always goes first.

## Gameplay

```
Welcome to Tic Tac Toe!
Enter row and column numbers (0-2) separated by space:
-------------
| - | - | - |
-------------
| - | - | - |
-------------
| - | - | - |
-------------
Player X's turn:
1 1
-------------
| - | - | - |
-------------
| - | X | - |
-------------
| - | - | - |
-------------
Player O's turn:
```

### Board Layout

Positions are entered as `row col` where both values are between 0 and 2:

```
(0,0) | (0,1) | (0,2)
(1,0) | (1,1) | (1,2)
(2,0) | (2,1) | (2,2)
```

## Features

- Two-player turn-based gameplay
- Win detection across rows, columns, and diagonals
- Draw detection when the board is full
- Input validation with error messages for invalid moves
- Play again prompt after each game

## Project Structure

```
tic-tac-toe/
├── TicTacToe.java
└── README.md
```
