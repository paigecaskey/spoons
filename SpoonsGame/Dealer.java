import java.util.LinkedList;
public class Dealer{
    public Deck m_deck = new Deck();

    public Dealer(){
        Deck m_deck = new Deck();
    }


    public LinkedList<Card> deals(int n){
        LinkedList<Card> dealt = new LinkedList<>();
        if (m_deck.size() == 0){
            return dealt;
        }else{
            for (int i = 0; i < n; i++){
                dealt.add(m_deck.deal());
            }
        }
        return dealt;
    }

    public Card deal(){
        Card dealCard = m_deck.deal();
        return dealCard;
    }


    public int size(){
        int size = 0;
        size = m_deck.size();
        return size;
    }

    public String toString(){
        String str = m_deck.toString();
        return str;
    }
}
