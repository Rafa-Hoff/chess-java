package chess;

import boardgame.Position;

public class ChessPosition {

    private char column;
    private int row;

    /**
     * Create another coordinate system for the board, accepting letters and numbers.
     * @param column is a letter(char).
     * @param row is a number.
     */
    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    /**
     * Converts the chess position input by the player to a normal position of the matrix.
     * @return new position.
     */
    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    /**
     * Converts the matrix position to a chess position.
     * @param position
     * @return new ChessPosition.
     */
    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
