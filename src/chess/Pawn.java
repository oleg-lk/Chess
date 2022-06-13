package chess;

public class Pawn extends ChessPiece{
    public Pawn(String color) {
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

        int dLine = toLine - line;
        int dColumn = toColumn - column;
        if ((Math.abs(dLine) == 1)&&(Math.abs(dColumn) == 1)&& (chessBoard.board[toLine][toColumn] != null) &&
                !chessBoard.board[toLine][toColumn].getColor().equals(super.color)){
            return true;
        }

        if (column!=toColumn){
            return false;
        }

        if (color.equals("White")){
            if ( (dLine==1) ||
                 ((dLine==2) && (line==1))) {
                return chessBoard.isValidPath(null, line, column, toLine, toColumn);
            }
        }
        else{
            if ( (dLine==-1) ||
                 ((dLine==-2) && (line==6))) {
                return chessBoard.isValidPath("no color", line, column, toLine, toColumn);
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
