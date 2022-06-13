package chess;

public class King extends ChessPiece {
    public King(String color) {
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
        if ((dLine == 0) && (dColumn == 0)) {
            return false;
        }

        if ((dLine <= 1) && (dColumn <= 1)) {
            if ((chessBoard.board[toLine][toColumn] != null) && (chessBoard.board[toLine][toColumn].getColor()==this.color)){
                return false;
            }
            if (isUnderAttack(chessBoard, toLine, toColumn)) {
                return false;
            }
            return true;
        }

        return false;
    }

    boolean isUnderAttack(ChessBoard chessBoard, int toLine, int toColumn) {
        for (int i = 0; i < chessBoard.board.length; i++) {
            for (int j = 0; j < chessBoard.board[i].length; j++) {
                if (chessBoard.board[i][j] == null) {
                    continue;
                }
                if (chessBoard.board[i][j].getColor() == super.color) {
                    continue;
                }
                if (chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, toLine, toColumn)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
