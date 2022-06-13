package chess;

public class Queen extends ChessPiece{
    public Queen(String color) {
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
        if ((dLine==0) && (dColumn==0)){
            return false;
        }

        if ((dLine==dColumn) || (dLine==0) || (dColumn==0) ){
            return chessBoard.isValidPath(this.color, line, column, toLine, toColumn);
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
