import java.util.*;
import Chess.*;
import GameEntities.*;

/**
 * The Application class is the application for chess,
 * which serves as a starting point for the chess game.
 */
public class Application {
    /**
     * Creates game and displays board.
     * Starts the game loop, where the application prompts the user for input.
     * @param args Command line args.
     */
    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        String input;

        ChessLocation newLocation;
        ChessPiece currentPiece;

        while(!gameOver){
            try {
                System.out.println(chessGame.getChessBoard().toString());
                System.out.println("M - Move a piece");
                System.out.println("Q - Quit game");
                System.out.println("R - Reset the game");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("Q") || input.equalsIgnoreCase("QUIT")) {
                    gameOver = true;
                    continue;
                } else if (input.equalsIgnoreCase("R") || input.equalsIgnoreCase("RESTART")) {
                    chessGame = new ChessGame();
                    System.out.println("===== GAME RESTARTED =====");
                    continue;
                } else if (input.equalsIgnoreCase("M") || input.equalsIgnoreCase("MOVE")) {
                    currentPiece = getCurrentPiece(chessGame);
                    newLocation = getNewLocation();

                    chessGame.getChessBoard().placePieceAt(currentPiece, newLocation);
                }
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Couldn't parse input.");
            } catch (NullPointerException e) {
                System.out.println("NullPointerException :(, GL Debugging");
                e.printStackTrace();
            }
        }
        System.out.println("===== GAME HAS ENDED =====");
    }

    private static ChessPiece getCurrentPiece(ChessGame chessGame) {
        Scanner scanner = new Scanner(System.in);
        String input;
        ChessLocation currentLocation;
        ChessPiece currentPiece;

        while (true) {
            System.out.println("Move from: row, col");
            input = scanner.nextLine();
            currentLocation = createChessLocation(input);
            if (!ChessBoard.locationInBounds(currentLocation)) {
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

    private static ChessLocation getNewLocation() {
        Scanner scanner = new Scanner(System.in);
        String input;

        ChessLocation newLocation;

        while (true) {
            System.out.println("Move to: row, col");
            input = scanner.nextLine();
            newLocation = createChessLocation(input);
            if (!ChessBoard.locationInBounds(newLocation)) {
               System.out.println("Location not on board, try again.");
            } else {
                return newLocation;
            }
        }
    }

    private static ChessLocation createChessLocation(String input) {
        int row = Integer.parseInt(input.split(",")[0].trim());
        int col = Integer.parseInt(input.split(",")[1].trim());
        return new ChessLocation(row, col);
    }
}
