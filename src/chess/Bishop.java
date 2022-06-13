package chess;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        int dLine = Math.abs(line - toLine);
        int dColumn = Math.abs(column - toColumn);

        if ((dLine != dColumn) || (dLine == 0)) {
            return false;
        }

        return chessBoard.isValidPath(this.color, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
