package chess;

public class Horse extends ChessPiece{
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)){
            return false;
        }

        int dLine = Math.abs(line-toLine);
        int dColumn = Math.abs(column-toColumn);
        if (((dLine==1) && (dColumn==2)) ||
            ((dLine==2) && (dColumn==1)) ){

            if ((chessBoard.board[toLine][toColumn] != null) && (chessBoard.board[toLine][toColumn].getColor()==this.color)){
                return false;
            }

            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
