import java.util.*;

public class Application {

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        ChessLocation location = new ChessLocation(0, 0);

        chessGame.getChessBoard().displayBoard();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the row you want to move to, followed by the column. Enter 'Q' at anytime to stop.");
        String row = input.nextLine();
        String col = input.nextLine();

        while(!row.equals("Q") && !col.equals("Q")){
            System.out.println("Location selected: (" + row + " , " + col + ")");

            location.setRowAndCol(Integer.parseInt(row), Integer.parseInt(col));
            chessGame.getChessBoard().placePieceAt(chessGame.getPiece(), location);

            chessGame.getChessBoard().displayBoard();

            row = input.nextLine();
            col = input.nextLine();
        }
        System.out.println("Game has ended");
    }
}