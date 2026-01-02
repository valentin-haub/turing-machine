# Turing Machine Simulation

An interactive Java implementation of a **Turing machine**.
This project models the theoretical computing device with an infinite tape, a read/write head, and a state transition table.

To find out more about the Turing machine, you can read on Wikipedia:
[Turing machine](https://en.wikipedia.org/wiki/Turing_machine)

> This project was developed as part of a weekly lab assignment for the **Object-Oriented Programming** course during my university studies.

## Features

- **Flexible Logic Engine:** The core `TM` class allows for programmatic definition of any Turing machine using custom states and transition rules.

- **Dynamic Tape:** Simulates an infinite tape that expands automatically as the head moves.

- **Step-by-Step Execution:** Tracks every step of the machine, allowing for detailed debugging and visualization of the process.

- **Clean Architecture:** Strict separation between the machine logic, tape memory, and transition rules.

- **Interactive CLI:** A user-friendly command-line interface to test algorithms with custom inputs.

## Tech Stack

- **Language:** Java 25 (Compatible with Java 21+)

- **Build Tool:** Maven

## Usage

The heart of this project is the `TM` class. You can easily define and run your own Turing machine programmatically.

### Code Example

```java
import de.thm.mni.oop.*;

// 1. Initialize TM with an input and start state as string
TM tm = new TM("110", "q0");

// 2. Define transitions (The Rules)
// format: state, readChar, writeChar, moveDirection, nextState
tm.addTransition("q0", '0', '0', Move.RIGHT, "q0");
tm.addTransition("q0", '1', '1', Move.RIGHT, "q0");
tm.addTransition("q0", '_', '_', Move.LEFT,  "q1");

// 3. Run the machine
tm.run();

// 4. Inspect the result
System.out.println(tm);
```

To create a new Turing machine, you can use the constructor (`new`) as well as the static `init` method.
Both of them have the following arguments:

1. initial tape (String)
2. start state (String)
3. *tape placeholder (char)* - optionally

### Core methods


Here is an overview of the most important methods in `TM` class:

| Method | Description |
| :--- | :--- |
| `addTransition(...)` | Adds a new rule to the transition table. Defines what the machine does when reading a specific character in a specific state. |
| `step()` | Executes exactly **one** transition step. Returns `this` for chaining. |
| `run()` | Continuously calls `step()` until the machine reaches the `HALT` state or no valid transition is found. |
| `getTape()` | Returns the current content of the tape as a String. |
| `getStatus()` | Returns the current state (e.g., "q0" or "HALT"). |

And there are some important constants as well:

| Constant | Description |
| :--- | :--- |
| `EMPTY` | Instance variable of `TM`. Used as placeholder on the tape. |
| `Move.LEFT` | Constant of the enum `Move`. Navigates the head to the left direction. |
| `Move.RIGHT` | Constant of the enum `Move`. Navigates the head to the right direction |

## Pre-configured Algorithms

The static `BasicOperations` class contains pre-configured machines for the following tasks:

1.  **Binary Decrement:** Subtracts 1 from a binary number (e.g., `110` -> `101`).

2.  **Binary Increment:** Adds 1 to a binary number (e.g., `101` -> `110`). Handles carry-over logic.

3.  **Shift Ones:** Moves all `1`s to the right within a binary sequence.

## Interactive Demo

The project also includes a command-line application (TMApp) to test the logic interactively.

### Required Software

- Java SDK (21 or higher)
- Apache Maven

### How to Run

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="de.thm.mni.oop.TMApp"
```

Once started, the application will ask for a binary number. It then runs three different algorithms on that input.

## Project Structure

The project is organized into a clean package structure under `de.thm.mni.oop`:

- **`TM.java`**: The main controller class. It manages the current state, holds the tape and table, and executes the simulation steps.

- **`Tape.java`**: Represents the infinite memory band. It handles reading/writing characters and dynamic expansion of the memory as the head moves.

- **`Table.java`**: A data structure that stores the transition rules (mapping a `Trigger` to an `Action`).

- **`BasicOperations.java`**: A utility class containing static methods to configure Turing machines for specific algorithms (like binary decrement/increment).

- **`Step.java`**, **`Action.java`**, **`Trigger.java`**: Java Records used to model the state transitions and history in a concise and immutable way.

- **`TMApp.java`**: The CLI demo application

## License

This project is created for educational purposes. Feel free to use, modify, and learn from it!