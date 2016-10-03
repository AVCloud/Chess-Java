import java.util.*;
import Chess.ChessGame;
import Chess.ChessLocation;

public class Application {

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        chessGame.getChessBoard().displayBoard();
        runGameLoop(chessGame);
    }

    private static void runGameLoop(ChessGame chessGame) {
        int row, col;
        Scanner scanner = new Scanner(System.in);
        String input;

        while(true){
            System.out.println("Enter row, col to move. Enter Q to quit.");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                System.out.println("Game has ended");
                return;
            }

            try {
                row = Integer.parseInt(input.split(",")[0].trim());
                col =Integer.parseInt(input.split(",")[1].trim());
                System.out.println("Location selected: (" + row + " , " + col + ")");

                chessGame.getChessBoard().placePieceAt(chessGame.getPiece(), new ChessLocation(row, col));
                chessGame.getChessBoard().displayBoard();

            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.print("Couldn't parse input. ");
            } catch (NullPointerException e) {
                System.out.println("NullPointerException :(, GL Debugging");
                e.printStackTrace();
            }
        }
    }
}