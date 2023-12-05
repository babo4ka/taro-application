package taroapp.taro;

public class CardsTape {

    private CardsTapeNode head = null;

    public CardsTape(){
    }

    public CardsTapeNode getHead(){
        return this.head;
    }

    public CardsTape insert(CardsTapeNode node){
        if(head == null){
            head = node;
            return this;
        }

        head.setNext(node);
        node.setPrev(head);
        return this;
    }

    public CardsTape clear(){
        head = null;
        return this;
    }
}
