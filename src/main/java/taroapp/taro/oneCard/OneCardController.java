package taroapp.taro.oneCard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import taroapp.taro.TaroApplication;

import java.io.IOException;

public class OneCardController {

    @FXML
    private MenuButton typeChoose;

    @FXML
    private MenuItem soloCardMenu;
    @FXML
    private MenuItem threeCardMenu;

    @FXML
    private Label typeLabel;

    @FXML
    private Pane imagePane;

    @FXML
    private Text choosedCardDesc;

    @FXML
    private Button prevCardBtn;
    @FXML
    private Button toTheEndBtn;
    @FXML
    private Button nextCardBtn;
    @FXML
    private Button resetBtn;


    @FXML
    private void openThreeCardPage() throws IOException {
        Stage threeCardStage = new Stage();
        Parent root = FXMLLoader.load(TaroApplication.class.getResource("ThreeCardPage.fxml"));
        threeCardStage.setTitle("Три карты");
        threeCardStage.setScene(new Scene(root, 1000, 500));
        threeCardStage.show();

        ((Stage)prevCardBtn.getScene().getWindow()).close();
    }
}

