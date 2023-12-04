package taroapp.taro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CardsManager {

    private static CardsManager instance;

    private CardsManager(){}

    public static CardsManager getInstance(){
        if(instance == null){
            instance = new CardsManager();
        }

        return instance;
    }

    public void loadCards() throws IOException {
        File descsDir = new File("src/main/resources/cards_descs");

        for(File f : descsDir.listFiles()){
            createCard(f);
        }
    }

    private void createCard(File descriptionFile) throws IOException {
        FileReader fr = new FileReader(descriptionFile);
        BufferedReader br = new BufferedReader(fr);

        String line;
        String name = "";
        String mm = "", mmr = "", yn = "", pam = "", pamr = "", prm = "", prmr = "", fm = "", fmr = "";
        int i = 0;
        while((line = br.readLine()) != null){
            if(!line.equals("===")){
                switch (i){
                    case 0 -> name = line;
                    case 1 -> mm = line;
                    case 2 -> mmr = line;
                    case 3 -> yn = line;
                    case 4 -> pam = line;
                    case 5 -> pamr = line;
                    case 6 -> prm = line;
                    case 7 -> prmr = line;
                    case 8 -> fm = line;
                    case 9 -> fmr = line;
                }
                i++;
            }
        }

        cardsLsit.add(new Card(name, mm, mmr, yn, pam, pamr, prm, prmr, fm, fmr));
    }



    private List<Card> cardsLsit = new ArrayList<>();

    public List<Card> getCards(){
        return cardsLsit;
    }
}
