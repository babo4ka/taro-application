package taroapp.taro;

public class CardInfo {

    private Card card;
    private boolean reverse;
    private boolean opened;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public CardInfo(Card card, boolean reverse, boolean opened) {
        this.card = card;
        this.reverse = reverse;
        this.opened = opened;
    }
}
