import java.util.*;
import Chess.ChessGame;
import Chess.ChessLocation;

/**
 * The Application class is the application for chess,
 * which serves as a starting point for the chess game.
 */
public class Application {
    /**
     * Creates game and displays board.
     * Runs the game loop.
     * @param args Command line args.
     */
    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        chessGame.getChessBoard().displayBoard();
        runGameLoop(chessGame);
    }

    /**
     * Starts the game loop, where the application prompts the user for input.
     * It internperts the input and moves pieces.
     * @param chessGame The game to run game loop on.
     */
    private static void runGameLoop(ChessGame chessGame) {
        int row, col;
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        String input;

        while(!gameOver){
            System.out.println("Enter row, col to move. Enter Q to quit.");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q") || input.equalsIgnoreCase("QUIT")) {
                System.out.println("Game has ended");
                gameOver = true;
                continue;
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