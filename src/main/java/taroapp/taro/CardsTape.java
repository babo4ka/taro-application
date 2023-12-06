package taroapp.taro;

public class CardsTape {

    private CardsTapeNode head = null;

    public CardsTape(){
    }

    public CardsTapeNode getHead(){
        return this.head;
    }

    public CardsTapeNode getLast(){
        CardsTapeNode last = this.head;
        if(last == null)return null;

        while(last.hasNext()){
            last = last.getNext();
        }

        return last;
    }

    public CardsTape insert(CardInfo data){
        CardsTapeNode new_node = new CardsTapeNode(data);

        if(this.head == null){
            this.head = new_node;
            return this;
        }

        CardsTapeNode last = this.head;

        while(last.hasNext()){
            last = last.getNext();
        }

        last.setNext(new_node);
        new_node.setPrev(last);
        return this;
    }

    public CardsTape clear(){
        head = null;
        return this;
    }
}
