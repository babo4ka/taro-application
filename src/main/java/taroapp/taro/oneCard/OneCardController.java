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
import taroapp.taro.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
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
    private Label cardsEndInfo;

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

    private CardsTape tape = new CardsTape();
    private CardsTapeNode currentNode;

    @FXML
    private void resetCards() throws MalformedURLException, URISyntaxException {
        loadedCards = cardsManager.getCards();
        Collections.shuffle(loadedCards);

        currentCards = new ArrayList<>();
        cardIterator = loadedCards.iterator();

        image_file = new File(getClass().getResource("/taroapp/taro/cards_imgs/no_card.jpg").toURI());
        image = new Image(image_file.toURI().toURL().toString());
        imagePane.setImage(image);
        imagePane.setRotate(0);
        choosedCardDesc.setText("Здесь будет описание карты");

        tape.clear();
        currentNode = tape.getLast();
        cardsEndInfo.setText("");
    }

    @FXML
    private void getNextCard() throws MalformedURLException {
        if(cardIterator.hasNext()){
            currentCards.add(cardIterator.next());

            Card card = currentCards.get(currentCards.size() - 1);
            boolean reverse = Math.random()>0.5;
            choosedCardDesc.setText(card.getMainMeaning(reverse));

            image = card.getImage();
            imagePane.setRotate(reverse?180:0);
            imagePane.setImage(image);

            CardInfo ci = new CardInfo(card, reverse, false);
            tape.insert(ci);
            currentNode = tape.getLast();
            cardsEndInfo.setText("");
        }else{
            cardsEndInfo.setText("Карты кончились");
        }
    }

    @FXML
    private void showPrevCard() throws MalformedURLException {
        if(currentNode != null){
            if(currentNode.hasPrev()){
                currentNode = currentNode.getPrev();
                Card card = currentNode.getValue().getCard();
                boolean reverse = currentNode.getValue().isReverse();

                choosedCardDesc.setText(card.getMainMeaning(reverse));

                image = card.getImage();
                imagePane.setRotate(reverse?180:0);
                imagePane.setImage(image);
                cardsEndInfo.setText("");
            }else{
                cardsEndInfo.setText("Карт больше не было");
            }
        }
    }

    @FXML
    private void showLastCard() throws MalformedURLException, URISyntaxException {
        currentNode = tape.getLast();
        if(currentNode != null){
            Card card = currentNode.getValue().getCard();
            boolean reverse = currentNode.getValue().isReverse();

            choosedCardDesc.setText(card.getMainMeaning(reverse));

            image_file = new File(getClass().getResource("/taroapp/taro/cards_imgs/" + card.getName() + ".jpg").toURI());
            image = new Image(image_file.toURI().toURL().toString());
            imagePane.setRotate(reverse?180:0);
            imagePane.setImage(image);
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
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

