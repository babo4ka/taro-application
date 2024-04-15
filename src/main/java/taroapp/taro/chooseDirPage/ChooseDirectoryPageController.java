package taroapp.taro.chooseDirPage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import taroapp.taro.CardsManager;
import taroapp.taro.TaroApplication;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseDirectoryPageController implements Initializable {

    @FXML
    private Button chooseDirectory;

    private final FileChooser fileChooser = new FileChooser();
    private final DirectoryChooser directoryChooser = new DirectoryChooser();


    private void openOneCardPage() throws IOException {
        Stage threeCardStage = new Stage();
        Parent root = FXMLLoader.load(TaroApplication.class.getResource("SoloCardPage.fxml"));
        threeCardStage.setTitle("Одна карта");
        threeCardStage.setScene(new Scene(root, 800, 500));
        threeCardStage.show();

        ((Stage)chooseDirectory.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        chooseDirectory.setOnAction(event -> {
            directoryChooser.setInitialDirectory(new File("C:\\"));
            directoryChooser.setTitle("Выбрать папку");

            File dir = directoryChooser.showDialog(chooseDirectory.getScene().getWindow());

            CardsManager.setCardsInfoDirectory(dir);
            try {
                CardsManager.getInstance().loadCards();
                openOneCardPage();
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
