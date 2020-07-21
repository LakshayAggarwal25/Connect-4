package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Connect4.fxml"));
        GridPane rootGridPane = loader.load();

        controller = loader.getController();
        controller.createPlayground();


        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);


        Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    private MenuBar createMenu() {
        //File Menu
        Menu fileMenu = new Menu("File");
        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(e -> controller.resetGame());


        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(e -> controller.resetGame());
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit Game");
        exitGame.setOnAction(e -> exitGame());
        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);

        //Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutGame = new MenuItem("About Game");
        aboutGame.setOnAction(e -> aboutConnect4());
        MenuItem aboutMe = new MenuItem("About Developer");
        aboutMe.setOnAction(e -> aboutMe());
        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
        helpMenu.getItems().addAll(aboutGame, separatorMenuItem1, aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Lakshay Aggarwal");
        alert.setContentText("This application is developed by Lakshay Aggarwal");
        alert.show();
    }

    private void aboutConnect4() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How to play?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color" +
                " and then take turns dropping colored discs from the top into a seven-column, six-row vertically " +
                "suspended grid. The pieces fall straight down, occupying the next available space within the column." +
                "The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of " +
                "four of one's own discs. Connect Four is a solved game. The first player can always win by playing " +
                "the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }
}