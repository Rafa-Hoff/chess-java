package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

/**
 * manages chess pieces.
 */
public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void increaseMoveCount() {
        moveCount++;
    }

    public void decreaseMoveCount() {
        moveCount--;
    }

    /**
     * @return chess piece position.
     */
    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    /**
     * Checks if there is an opponent piece in the position.
     * @param position row and column.
     * @return boolean.
     */
    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
}
