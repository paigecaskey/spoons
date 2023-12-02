import java.util.LinkedList;  
public class Deck{
    private LinkedList<Card> m_cards = new LinkedList<Card>();

    public Deck(){
        for (int j = 2; j < 15; ++j){
         int p = 0;
         Card card = new Card(j, p);
         m_cards.add(card);
        }
       for (int j = 2; j < 15; ++j){
        int p = 1;
        Card card = new Card(j, p);
        m_cards.add(card);
        }
        for (int j = 2; j < 15; ++j){
        int p = 2;
        Card card = new Card(j, p);
        m_cards.add(card);
        }
        for (int j = 2; j < 15; ++j){
        int p = 3;
        Card card = new Card(j, p);
        m_cards.add(card);
        }
    }
    public Deck(Deck deckToCopy){
        this.m_cards = deckToCopy.m_cards;
        }

    public String toString(){
        String str = m_cards.toString();
        return str;
    }

    public int size(){
        int size = 0;
        size = m_cards.size();
        return size;
    }

    public Card deal(){
        int min = 1;
        int max = m_cards.size() - 1;
        int rand = (int)Math.floor(Math.random()*(max-min+1)+min);
        Card dealCard = m_cards.get(rand);
        m_cards.remove(rand);
        return dealCard;
    }
}