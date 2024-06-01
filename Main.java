import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField directoryPathField;
    private TextField searchField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Ustawianie tytułu aplikacji
        primaryStage.setTitle("File Browser and Search");

        // Tworzenie pól tekstowych
        directoryPathField = new TextField();
        directoryPathField.setPromptText("Enter directory path");

        searchField = new TextField();
        searchField.setPromptText("Enter search phrase");

        // Tworzenie przycisków
        Button browseButton = new Button("Browse");
        browseButton.setOnAction(event -> browseDirectory());

        Button searchButton = new Button("Search");

        // Tworzenie układów
        HBox hBox = new HBox(10, directoryPathField, browseButton);
        VBox vBox = new VBox(10, hBox, searchField, searchButton);

        // Tworzenie sceny
        Scene scene = new Scene(vBox, 600, 200);

        // Ustawianie sceny i wyświetlanie aplikacji
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void browseDirectory() {
        // Tworzenie selektora katalogów
        FileChooser directoryChooser = new FileChooser();

        // Wyświetlanie selektora katalogów i pobieranie wybranego katalogu
        File selectedDirectory = directoryChooser.showDialog(null);

        // Sprawdzenie, czy wybrano katalog
        if (selectedDirectory != null) {
            // Ustawianie ścieżki absolutnej wybranego katalogu w polu tekstowym
            directoryPathField.setText(selectedDirectory.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
