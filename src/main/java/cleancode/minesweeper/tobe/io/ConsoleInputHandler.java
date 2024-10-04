package cleancode.minesweeper.tobe.io;

import java.util.Scanner;

import cleancode.minesweeper.tobe.BoardIndexConverter;
import cleancode.minesweeper.tobe.position.CellPosition;

public class ConsoleInputHandler implements InputHandler {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

    @Override
    public CellPosition getCellPositionFromUser() {
        String userInput = SCANNER.nextLine();
        int colIndex = boardIndexConverter.getSelectedColIndex(userInput);
        int rowIndex = boardIndexConverter.getSelectedRowIndex(userInput);
        return CellPosition.of(rowIndex, colIndex);
    }

    @Override
    public String getUserInput() {
        return SCANNER.nextLine();
    }

}
