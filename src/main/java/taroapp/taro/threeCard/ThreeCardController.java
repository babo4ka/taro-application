package taroapp.taro.threeCard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import taroapp.taro.TaroApplication;

import java.io.IOException;

public class ThreeCardController {

    @FXML
    private MenuButton typeChoose;

    @FXML
    private MenuItem soloCardMenu;
    @FXML
    private MenuItem threeCardMenu;

    @FXML
    private Label typeLabel;

    @FXML
    private Pane firstCard;
    @FXML
    private Pane secondCard;
    @FXML
    private Pane thirdCard;

    @FXML
    private Text cardDesc;

    @FXML
    private Button makePredBtn;

    @FXML
    private void openOneCardPage() throws IOException {
        Stage threeCardStage = new Stage();
        Parent root = FXMLLoader.load(TaroApplication.class.getResource("SoloCardPage.fxml"));
        threeCardStage.setTitle("Одна карта");
        threeCardStage.setScene(new Scene(root, 800, 500));
        threeCardStage.show();

        ((Stage)makePredBtn.getScene().getWindow()).close();
    }
}
