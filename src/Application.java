import java.util.*;
import Chess.ChessGame;
import Chess.ChessLocation;
import GameEntities.GamePiece;

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
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        String input;

        ChessLocation newLocation;
        GamePiece currentPiece;

        System.out.println("Chess Game Menu:");
        while(!gameOver){
            try {
                System.out.println("Q - Quit Game");
                System.out.println("M - Move a piece");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("Q") || input.equalsIgnoreCase("QUIT")) {
                    gameOver = true;
                    continue;
                }

                currentPiece = getCurrentPiece(chessGame);
                newLocation = getNewLocation(chessGame);

                chessGame.getChessBoard().placePieceAt(currentPiece, newLocation);
                chessGame.getChessBoard().displayBoard();

            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Couldn't parse input.");
            } catch (NullPointerException e) {
                System.out.println("NullPointerException :(, GL Debugging");
                e.printStackTrace();
            }
        }
        System.out.println("Game has ended");
    }

    private static GamePiece getCurrentPiece(ChessGame chessGame) {
        Scanner scanner = new Scanner(System.in);
        String input;
        ChessLocation currentLocation;
        GamePiece currentPiece;

        while (true) {
            System.out.println("Enter row, col of piece to move.");
            input = scanner.nextLine();
            currentLocation = createChessLocation(input);
            if (!chessGame.getChessBoard().locationInBounds(currentLocation)) {
                System.out.println("Location not on board, try again.");
                continue;
            }
            currentPiece = chessGame.getChessBoard().getPieceAt(currentLocation);
            if (currentPiece == null) {
                System.out.println("Invalid piece selected, try again.");
            } else {
                return currentPiece;
            }
        }
    }

    private static ChessLocation getNewLocation(ChessGame chessGame) {
        Scanner scanner = new Scanner(System.in);
        String input;

        ChessLocation newLocation;

        while (true) {
            System.out.println("Enter row, col to move.");
            input = scanner.nextLine();
            newLocation = createChessLocation(input);
            if (!chessGame.getChessBoard().locationInBounds(newLocation)) {
               System.out.println("Location not on board, try again.");
            } else {
                return newLocation;
            }
        }
    }

    private static ChessLocation createChessLocation(String input) {
        int row = Integer.parseInt(input.split(",")[0].trim());
        int col = Integer.parseInt(input.split(",")[1].trim());
        System.out.println("Location selected: (" + row + " , " + col + ")");
        return new ChessLocation(row, col);
    }
}
