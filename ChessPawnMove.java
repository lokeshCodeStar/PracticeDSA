package org.example;

import java.util.Scanner;

/*
* square chess 8*8  positioning a pawn to a starting square,
*  you need to find out where it will be the end square after moving it R times (rows) vertically to the top and
* C times (columns) horizontally to the right. If during the moves the pawn reaches the end of the board,
*  it will start again from the opposite direction like in the example below : input string startPosition number rows number
* columns output  string endPosition  example 1
* Input startPosition : 2b,rows: 3 columns:2  output 5d  example 2 startPosition : 5h,rows:11,columns :25 output : 8a  in java
 * */

public class ChessPawnMove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: startPosition, rows, columns
        System.out.print("Input startPosition (e.g., 2b): ");
        String startPosition = scanner.next();

        System.out.print("Input number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Input number of columns: ");
        int columns = scanner.nextInt();

        // Output: endPosition
        String endPosition = calculateEndPosition(startPosition, rows, columns);

        System.out.println("Output endPosition: " + endPosition);
    }

    private static String calculateEndPosition(String startPosition, int rows, int columns) {
        /*int startRow = 8 - Character.getNumericValue(startPosition.charAt(0));
        int startCol = startPosition.charAt(1) - 'a';

        int endRow = (startRow + rows) % 8;
        int endCol = (startCol + columns) % 8;

        if (endRow == 0) {
            endRow = 8; // Adjust to 8 if it reaches 0
        }

        if (endCol == 0) {
            endCol = 8; // Adjust to 8 if it reaches 0
        }

        // Convert back to chess notation
        char endColChar = (char) ('a' + endCol - 1);
        String endPosition = "" + endRow + endColChar;

        return endPosition;*/

        char startColumn = startPosition.charAt(1);
        int startRow = startPosition.charAt(0) - '0';
       // int startRow = Character.getNumericValue(startPosition.charAt(0));

        // Calculate new column after moving horizontally
        int newColumn = (startColumn - 'a' + columns) % 8 + 'a';

        // Calculate new row after moving vertically
        int newRow = (startRow + rows - 1) % 8 + 1;

        // Construct the end position string
        return "" + newRow + (char) newColumn;
    }
}
