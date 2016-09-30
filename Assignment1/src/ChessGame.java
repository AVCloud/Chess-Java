public class ChessGame {

    private ChessBoard chessBoard;
    // Temparay start location and piece for Assingment 1
    private ChessLocation location;
    private GamePiece firstPiece;

    public ChessGame() {
        chessBoard = new ChessBoard();
        location = new ChessLocation(0,0);
        firstPiece = new Knight("white", location, this);

        chessBoard.setupPieceAt(firstPiece, location);
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public GamePiece getPiece() {
        return firstPiece;
    }
}