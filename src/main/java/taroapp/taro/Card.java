package taroapp.taro;

public class Card {

    private final String name;

    private final String mainMeaning;
    private final String mainMeaningReverse;
    private final String yn;
    private final String pastMeaning;
    private final String pastMeaningReverse;
    private final String presentMeaning;
    private final String presentMeaningReverse;
    private final String futureMeaning;
    private final String futureMeaningReverse;


    public Card(String name,
                String mainMeaning, String mainMeaningReverse,
                String yn,
                String pastMeaning, String pastMeaningReverse,
                String presentMeaning, String presentMeaningReverse,
                String futureMeaning, String futureMeaningReverse) {
        this.name = name;
        this.mainMeaning = mainMeaning;
        this.mainMeaningReverse = mainMeaningReverse;
        this.yn = yn;
        this.pastMeaning = pastMeaning;
        this.pastMeaningReverse = pastMeaningReverse;
        this.presentMeaning = presentMeaning;
        this.presentMeaningReverse = presentMeaningReverse;
        this.futureMeaning = futureMeaning;
        this.futureMeaningReverse = futureMeaningReverse;
    }

    public String getName() {
        return name;
    }

    public String getMainMeaning(boolean reverse) {
        return reverse?this.mainMeaningReverse:this.mainMeaning;
    }

    public String getYn() {
        return yn;
    }

    public String getPastMeaning(boolean reverse) {
        return reverse?pastMeaningReverse:pastMeaning;
    }


    public String getPresentMeaning(boolean reverse) {
        return reverse?presentMeaningReverse:presentMeaning;
    }


    public String getFutureMeaning(boolean reverse) {
        return reverse?futureMeaningReverse:futureMeaning;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\n' +
                ", mainMeaning='" + mainMeaning + '\n' +
                ", mainMeaningReverse='" + mainMeaningReverse + '\n' +
                ", yn='" + yn + '\n' +
                ", pastMeaning='" + pastMeaning + '\n' +
                ", pastMeaningReverse='" + pastMeaningReverse + '\n' +
                ", presentMeaning='" + presentMeaning + '\n' +
                ", presentMeaningReverse='" + presentMeaningReverse + '\n' +
                ", futureMeaning='" + futureMeaning + '\n' +
                ", futureMeaningReverse='" + futureMeaningReverse + '\n' +
                '}';
    }
}
