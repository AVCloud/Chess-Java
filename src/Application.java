import java.util.*;

public class Application {

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        ChessLocation location = new ChessLocation(0, 0);
        int row, col;

        chessGame.getChessBoard().displayBoard();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row,col to move to in this format: row,col. Enter 'Q' at anytime to stop.");
        String input = scanner.nextLine();

        while(!input.equalsIgnoreCase("Q")){
            try {
                row = Integer.parseInt(input.split(",")[0].trim());
                col =Integer.parseInt(input.split(",")[1].trim());

                System.out.println("Location selected: (" + row + " , " + col + ")");

                location.setRowAndCol(row, col);
                chessGame.getChessBoard().placePieceAt(chessGame.getPiece(), location);

                chessGame.getChessBoard().displayBoard();

            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Couldn't parse input, the format: row,col. Also 'Q' to quit.");
            } catch (NullPointerException e) {
                System.out.println("NullPointerException :(, GL Debugging");
                e.printStackTrace();
            }
            input = scanner.nextLine();
        }
        System.out.println("Game has ended");
    }
}