package taroapp.taro.oneCard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import taroapp.taro.Card;
import taroapp.taro.CardsManager;
import taroapp.taro.TaroApplication;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

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


    private CardsManager cardsManager;
    private List<Card> loadedCards;

    private List<Card> currentCards = new ArrayList<>();
    private Iterator<Card> cardIterator;

    private File image_file;
    private Image image;

    @FXML
    private void resetCards() throws MalformedURLException {
        loadedCards = cardsManager.getCards();
        Collections.shuffle(loadedCards);

        currentCards = new ArrayList<>();
        cardIterator = loadedCards.iterator();

        image_file = new File("src/main/resources/cards_imgs/no_card.jpg");
        image = new Image(image_file.toURI().toURL().toString());
        imagePane.setImage(image);
        imagePane.setRotate(0);
        choosedCardDesc.setText("Здесь будет описание карты");
    }

    @FXML
    private void getNextCard() throws MalformedURLException {
        if(cardIterator.hasNext()){
            currentCards.add(cardIterator.next());

            Card card = currentCards.get(currentCards.size() - 1);
            boolean reverse = Math.random()>0.5;
            choosedCardDesc.setText(card.getMainMeaning(reverse));

            image_file = new File("src/main/resources/cards_imgs/" + card.getName() + ".jpg");
            image = new Image(image_file.toURI().toURL().toString());
            imagePane.setRotate(reverse?180:0);
            imagePane.setImage(image);
        }else{
            System.out.println("карты кончились");
        }
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
        cardsManager = CardsManager.getInstance();

        try {
            resetCards();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

