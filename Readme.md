# Snake Game in Java

This project is a simple implementation of the classic Snake game using Java. The game features a snake that the player can control using keyboard inputs to collect apples and grow in size. The objective is to collect as many apples as possible without colliding with the walls or the snake's own body.

This project was created as the final project for COMP 170 at Loyola University Chicago.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installing](#installing)
- [Built With](#built-with)
- [Authors](#authors)
- [License](#license)
- [Sources](#sources)

## Features

- Simple and intuitive interface.
- Keyboard controls using arrow keys or WASD.
- "Game Over" scenario with the option to restart the game.
<!-- - Customizable game settings (e.g., board size, snake speed). -->

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK), version 8 or later.
    - [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- An Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or VS Code.

### Installing

1. **Clone the Repository:**
   
   ```bash
   git clone https://github.com/drewjordan414/java_snake.git
    ```

2. **Open the Project:**
    
    - **IntelliJ IDEA:** Open the project by selecting the `pom.xml` file.
    - **Eclipse:** Import the project as a Maven project.
    - **VS Code:** Open the project folder.

3. **Build the Project:**
    
    - **IntelliJ IDEA:** Build the project using the IDE.
    - **Eclipse:** Build the project using the IDE.
    - **VS Code:** Build the project using Maven.
    
    #### Build using Maven
    ```bash
    mvn clean install
    ```

4. **Run the Project:**
        
**IntelliJ IDEA:** Run the project using the IDE.
**Eclipse:** Run the project using the IDE.
 **VS Code:** Run the project using Maven.

#### Run using Maven
    mvn exec:java
    
#### Run using Java
    java -jar playsnake.jar

## Built With
* Java
* Maven

## Authors
* Drew Jordan

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Sources
* [Snake Game Tutorial](https://www.youtube.com/watch?v=bI6e6qjJ8JQ)
* [Snake Geeks For Geeks](https://www.geeksforgeeks.org/design-snake-game/)
* [Stack Exchange](https://codereview.stackexchange.com/questions/129719/java-snake-game)
