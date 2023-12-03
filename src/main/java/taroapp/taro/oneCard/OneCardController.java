package taroapp.taro.oneCard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import taroapp.taro.Card;
import taroapp.taro.CardsManager;
import taroapp.taro.TaroApplication;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class OneCardController implements Initializable {

    @FXML
    private MenuButton typeChoose;

    @FXML
    private MenuItem soloCardMenu;
    @FXML
    private MenuItem threeCardMenu;

    @FXML
    private Label typeLabel;

    @FXML
    private ImageView imagePane;

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


    private Stream<Card> cardsStream;

    private void getCardsStream(){
        CardsManager cm = CardsManager.getInstance();
        cardsStream = cm.getCardsAsStream();
    }

    @FXML
    private void getNextCard() throws MalformedURLException {
        Card card = cardsStream.findFirst().get();
        choosedCardDesc.setText(card.getMainMeaning(Math.random()>0.5));

        File image = new File("src/main/resources/cards_imgs/" + card.getName() + ".jpg");
        System.out.println(image.exists());
        Image img = new Image(image.toURI().toURL().toString());
        imagePane.setImage(img);
    }

    @FXML
    private void openThreeCardPage() throws IOException {
        Stage threeCardStage = new Stage();
        Parent root = FXMLLoader.load(TaroApplication.class.getResource("ThreeCardPage.fxml"));
        threeCardStage.setTitle("Три карты");
        threeCardStage.setScene(new Scene(root, 1000, 500));
        threeCardStage.show();

        ((Stage)prevCardBtn.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getCardsStream();
    }
}

