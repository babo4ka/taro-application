package taroapp.taro.threeCard;

import javafx.event.ActionEvent;
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
import javafx.scene.input.MouseEvent;
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

public class ThreeCardController implements Initializable {

    @FXML
    private MenuButton typeChoose;

    @FXML
    private MenuItem soloCardMenu;
    @FXML
    private MenuItem threeCardMenu;

    @FXML
    private MenuButton threeTypeChoose;

    @FXML
    private MenuItem ppfChoose;
    @FXML
    private MenuItem ynChoose;

    @FXML
    private Label typeLabel;

    @FXML
    private ImageView firstCard;
    @FXML
    private ImageView secondCard;
    @FXML
    private ImageView thirdCard;

    @FXML
    private Text cardDesc;

    @FXML
    private Button makePredBtn;

    private Iterator<Card> cardIterator;

    private int mode = 0;

    private CardsManager cardsManager;
    private List<Card> loadedCards;

    private File image_file;
    private Image image;


    @FXML
    private void resetCards() throws MalformedURLException {
        loadedCards = cardsManager.getCards();
        Collections.shuffle(loadedCards);

        cardIterator = loadedCards.iterator();

        image_file = new File("src/main/resources/cards_imgs/no_card.jpg");
        image = new Image(image_file.toURI().toURL().toString());
        firstCard.setImage(image);
        firstCard.setRotate(0);
        secondCard.setImage(image);
        secondCard.setRotate(0);
        thirdCard.setImage(image);
        thirdCard.setRotate(0);
        cardDesc.setText("Здесь будет описание карты");

        cardsInfos = new CardInfo[3];
    }


    private CardInfo [] cardsInfos = new CardInfo[3];
    @FXML
    private void makePreds() throws MalformedURLException {
        for(int i =0; i<cardsInfos.length; i++){
            if(cardIterator.hasNext()){
                Card card = cardIterator.next();
                boolean reverse = Math.random()>0.5;
                cardsInfos[i] = new CardInfo(card, reverse, false);
            }
        }

        image_file = new File("src/main/resources/cards_imgs/hidden_card.jpg");
        image = new Image(image_file.toURI().toURL().toString());
        firstCard.setImage(image);
        firstCard.setRotate(0);
        secondCard.setImage(image);
        secondCard.setRotate(0);
        thirdCard.setImage(image);
        thirdCard.setRotate(0);
        cardDesc.setText("Здесь будет описание карты");
    }


    @FXML
    private void openCard(MouseEvent event) throws MalformedURLException {
        ImageView target = (ImageView) event.getSource();
        int index = 0;
        if(target.getId().equals("firstCard"))index = 0;
        if(target.getId().equals("secondCard"))index = 1;
        if(target.getId().equals("thirdCard"))index = 2;

        if(!cardsInfos[index].opened){
            image_file = new File("src/main/resources/cards_imgs/" + cardsInfos[index].card.getName() + ".jpg");
            image = new Image(image_file.toURI().toURL().toString());
            target.setRotate(cardsInfos[index].reverse?180:0);
            target.setImage(image);
        }

        switch (mode){
            case 1 ->{
                cardDesc.setText(cardsInfos[index].card.getYn());
                target.setRotate(0);
            }

            case 0->{
                if(index == 0)
                    cardDesc.setText(cardsInfos[index].card.getPastMeaning(cardsInfos[index].reverse));

                if(index == 1)
                    cardDesc.setText(cardsInfos[index].card.getPresentMeaning(cardsInfos[index].reverse));

                if(index == 2)
                    cardDesc.setText(cardsInfos[index].card.getFutureMeaning(cardsInfos[index].reverse));
            }
        }

    }

    @FXML
    private void switchType(ActionEvent event) throws MalformedURLException {
        switch (((MenuItem)event.getSource()).getId()){
            case "ppfChoose" -> {
                mode = 0;
                typeLabel.setText("Прошлое - настоящее - будущее");
            }

            case "ynChoose" -> {
                mode = 1;
                typeLabel.setText("Да / Нет");
            }
        }
        resetCards();
    }

    @FXML
    private void openOneCardPage() throws IOException {
        Stage threeCardStage = new Stage();
        Parent root = FXMLLoader.load(TaroApplication.class.getResource("SoloCardPage.fxml"));
        threeCardStage.setTitle("Одна карта");
        threeCardStage.setScene(new Scene(root, 800, 500));
        threeCardStage.show();

        ((Stage)makePredBtn.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cardsManager = CardsManager.getInstance();
        typeLabel.setText("Прошлое - настоящее - будущее");

        try {
            resetCards();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private final class CardInfo{

        private Card card;
        private boolean reverse;
        private boolean opened;


        public CardInfo(Card card, boolean reverse, boolean opened) {
            this.card = card;
            this.reverse = reverse;
            this.opened = opened;
        }
    }
}
