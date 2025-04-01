/*
3/4
Filling the board

Description
Have you noticed the issues in the last stage? When you click on a cell in the top row, it fills that particular cell even
 if the cells below are empty. In Connect Four, pieces are placed column by column.
 They are placed onto either the uppermost game piece in that column or, if the column is empty,
  onto the board bottom. In this stage, we will change the way players place the pieces. We need to designate a
  separate class that can check the first free cell in each column. The rest remains the same as in the previous stage.

Objectives
In this stage, your program should:

Fill the cells according to the rule above — not by the position of the click but by the column that was clicked on;
Continue to alternate between the X and O pieces after each click.
----------------------------------
4/4
Players Ready
 Report a typo
Description
In this stage, we will finalize our game to play it with a friend! For this, we need to come up with an algorithm to check
 if a player has connected four pieces in a row after every click. The check must be carried out in three directions: horizontal,
  vertical, and diagonal. When the algorithm detects a winning move, the program should highlight these four
   cells so that the players can easily see who's won.

We will also add the baseline background color for the cells from the start of the game and a distinct color for the cells
 that form a win condition.
 You can choose any colors that you want as long as the baseline and winning colors are different.

Ensure that your program processes invalid moves in the following way. A click on a filled column should do nothing,
and the player must be given another try.
Additionally, a click on any cell after a game has been finished should lead to nothing.

Finally, don't forget to add the reset button!

Objectives
In this stage, implement the following features:

Add the baseline color for all cells at the start of the application;

Add a reset button that extends the JButton named ButtonReset. The button should be enabled.
 Clicking on it should clear all cells and return them to their baseline color;

Check if either player has connected four in a row vertically, horizontally, or diagonally after each move;

Once a winner has been detected, change the color of the four winning cells to the winning color.
 The baseline color and the winning color should be two different colors;

A click on any board cell in any filled column must lead to nothing. The gameplay continues with the same player's turn;

A click on any board cell once a game is finished must lead to nothing.


 */

public class ApplicationRunner {
    public static void main(String[] args) {
        new ConnectFour();
    }
}