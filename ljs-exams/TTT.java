import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TTT extends Application {

    // Indicate which player has a turn, initially it is the X player
    private char whoseTurn = 'X';

    // Create and initialize cell
    private Cell[][] cell = new Cell[3][3];

    // Create and initialize a status label
    private Label lblStatus = new Label("X's turn to play");

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Pane to hold cell
        GridPane pane = new GridPane();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                pane.add(cell[i][j] = new Cell(), j, i);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(lblStatus);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 200);
        primaryStage.setTitle("Tic Tac Toe"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /** Determine if the cell are all occupied */
    public boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (cell[i][j].getToken() == ' ')
                    return false;

        return true;
    }

    /** Determine if the player with the specified token wins */
    public boolean isWon(char token) {
        for (int i = 0; i < 3; i++)
            if (cell[i][0].getToken() == token && cell[i][1].getToken() == token && cell[i][2].getToken() == token) {
                return true;
            }

        for (int j = 0; j < 3; j++)
            if (cell[0][j].getToken() == token && cell[1][j].getToken() == token && cell[2][j].getToken() == token) {
                return true;
            }

        if (cell[0][0].getToken() == token && cell[1][1].getToken() == token && cell[2][2].getToken() == token) {
            return true;
        }

        if (cell[0][2].getToken() == token && cell[1][1].getToken() == token && cell[2][0].getToken() == token) {
            return true;
        }

        return false;
    }

    // An inner class for a cell
    public class Cell extends StackPane {
        // Token used for this cell
        private char token = ' ';

        // The original TTT.java given displays an ’X’ with two lines and an ’O’ as an
        // ellipse. In this problem
        // you will revise the given TTT.java in such a way that it will display ’X’s
        // and ’O’s as images [red
        // Xs and blue Os given in x.gif and o.gif in the [given] folder or on the
        // assignment dropbox. Once you
        // are done, it will look something like the following, which is also given as
        // Sample.png in the
        // [given] folder (or in the assignment dropbox):
        private ImageView xImage = new ImageView(new Image("file:x.gif"));
        private ImageView oImage = new ImageView(new Image("file:o.gif"));

        public Cell() {
            setStyle("-fx-border-color: black");
            this.setPrefSize(2000, 2000);
            this.setOnMouseClicked(e -> handleMouseClick());
        }

        /** Return token */
        public char getToken() {
            return token;
        }

        /** Set a new token */
        public void setToken(char c) {
            token = c;

            if (token == 'X') {
                // Add the image to the pane
                this.getChildren().add(xImage);

                // As you can see in Sample.png, the letters ’X’ and ’O’ are not centered in
                // each cell. Make them
                // appear in the center of each cell. They should stay in the center even if you
                // resize the window.
                StackPane.setAlignment(xImage, Pos.CENTER);
            } else if (token == 'O') {
                // Add the image to the pane
                this.getChildren().add(oImage);

                StackPane.setAlignment(oImage, Pos.CENTER);
            }
        }

        /* Handle a mouse click event */
        private void handleMouseClick() {
            // If cell is empty and game is not over
            if (token == ' ' && whoseTurn != ' ') {
                setToken(whoseTurn); // Set token in the cell

                // Check game status
                if (isWon(whoseTurn)) {
                    lblStatus.setText(whoseTurn + " won! The game is over");
                    whoseTurn = ' '; // Game is over
                } else if (isFull()) {
                    lblStatus.setText("Draw! The game is over");
                    whoseTurn = ' '; // Game is over
                } else {
                    // Change the turn
                    whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                    // Display whose turn
                    lblStatus.setText(whoseTurn + "'s turn");
                }
            }
        }
    }

    /**
     * The main method is only needed for the IDE with limited JavaFX support. Not
     * needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

}