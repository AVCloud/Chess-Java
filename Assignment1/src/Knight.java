public class Knight {
    private ChessGame chessGame;
    private String owner;
    private ChessLocation chessLocation;

    public Knight(String owner, ChessLocation initialLocation, ChessGame game) {
        this.owner = owner;
        chessGame = game;
    }

    public void moveTo(ChessLocation newLocation) {
        if (checkLocation(newLocation)) {
            chessLocation.setRowAndCol(newLocation.getRow(), newLocation.getCol());
        } else {
            System.out.println("Not a valid move.");
        }
    }

    private boolean checkLocation(ChessLocation location) {
        if(location.getRow() >= 0 && location.getRow() < 8 && location.getRow() >= 0 && location.getCol() < 8) {
            return true;
        }
        return false;
    }


}
