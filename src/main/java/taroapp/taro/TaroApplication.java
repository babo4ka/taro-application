package taroapp.taro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class TaroApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        CardsManager cm = CardsManager.getInstance();
        cm.loadCards();

        FXMLLoader fxmlLoader = new FXMLLoader(TaroApplication.class.getResource("SoloCardPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Одна карта");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}