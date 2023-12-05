package taroapp.taro;

public class CardsTapeNode {

    private CardInfo value = null;
    private CardsTapeNode prev = null;
    private CardsTapeNode next = null;

    public CardsTapeNode(CardInfo value) {
        this.value = value;
    }

    public CardInfo getValue() {
        return value;
    }

    public void setValue(CardInfo value) {
        this.value = value;
    }

    public CardsTapeNode getPrev() {
        return prev;
    }

    public void setPrev(CardsTapeNode prev) {
        this.prev = prev;
    }

    public CardsTapeNode getNext() {
        return next;
    }

    public void setNext(CardsTapeNode next) {
        this.next = next;
    }

    public boolean hasNext(){
        return this.next != null;
    }

    public boolean hasPrev(){
        return this.prev != null;
    }
}
