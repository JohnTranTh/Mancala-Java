# Project Title

Recreation of the board game Mancala through a GUI.

## Description

This program allows two players to play the board game Mancala through a graphical user interface. The program keeps track of each players number of stones
in their stores, implements rules such as extra turn for having the last stone land in the player's store, and capturing the opposite pit's stones. The program
will also determine the winner for the player based on each player's number of stones in their stores. The program also allows for saving and loading games in progress,
saving user profiles for players, and switching between the Kalah and Ayo rulesets of Mancala.

## Getting Started

### Dependencies

* JDK 17
* Gradle

### Executing program

* How to build and run the program
* Step-by-step bullets
```
* gradle build
* java -jar build/libs/Mancala.jar
```
* See GUI for expected output. Output should look similar to the following text-representation:
----- Current Board ------
Player 2's Store: 0 stones
Pit 12: 4 stones    Pit 11: 4 stones    Pit 10: 4 stones    Pit 9: 4 stones     Pit 8: 4 stones     Pit 7: 4 stones
Player 1's Store: 0 Stones
Pit 1: 4 stones     Pit 2: 4 stones     Pit 3: 4 stones     Pit 4: 4 stones     Pit 5: 4 stones     Pit 6: 4 stones
*--------------------
Currently Player 1's turn.
Enter a Pit Number:

## Limitations

Program is complete. Inputting invalid moves cause exceptions to be generated.  

## Author Information

Name: John Tran
Email: jtran18@uoguelph.ca

## Development History

Keep a log of what things you accomplish when.  You can use git's tagging feature to tag the versions or you can reference commits.

* 1.0
    * Finished GUI implementation.
* 0.2
    * Finished refactoring methods
    * Finished javadocs documentation
* 0.1
    * first commit

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)
* [assignment-pdf] (https://moodle.socs.uoguelph.ca/mod/assign/view.php?id=10726)



