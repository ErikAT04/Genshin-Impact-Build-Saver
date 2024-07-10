package at.dev.genshinbuildsaver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InitApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InitApplication.class.getResource("mainApp.fxml"));
        Image img = new Image(Objects.requireNonNull(InitApplication.class.getResourceAsStream("img/icon/favicon.png")));
        Scene scene = new Scene(fxmlLoader.load());
        stage.getIcons().add(img);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}