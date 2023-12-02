public class Card{
    private int m_Value;
    private int m_Suit;

    public static final int HEARTS = 0;
    public static final int SPADES = 1;
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;

    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;


    public Card(){
        m_Value = 14;
        m_Suit = 1;
    }

    public Card(int v, int s){
        m_Value = v;
        m_Suit = s;
    }

    public Card(Card cardToCopy){
        this.m_Value =  cardToCopy.m_Value;
        this.m_Suit = cardToCopy.m_Suit;
    }

    public String toString(){
        String str = "";
        if (m_Value <= 10){
            str += m_Value;
        }else if (m_Value == 11){
            str += "Jack";
        }else if (m_Value == 12){
            str += "Queen";
        }else if (m_Value == 13){
            str += "King";
        }else if (m_Value == 14){
            str += "Ace";
        }
        str += " of ";
        if (m_Suit == 0){
            str += "Hearts";
        }else if (m_Suit == 1){
            str += "Spades";
        }else if (m_Suit == 2){
            str += "Clubs";
        }else if (m_Suit == 3){
            str += "Diamonds";
        }
        return str;
    }

    public boolean equals (Object o){
        if (!(o instanceof Card)){
            return false;
        }
        Card c = (Card) o;

        return this.m_Value == c.m_Value && this.m_Suit == c.m_Suit;
    }

    public int getValue(){
        return m_Value;
    }

    public void setValue(int v){
        m_Value = v;
    }

    public int getSuit(){
        return m_Suit;
    }

    public void setSuit(int s){
        m_Suit = s;
    }
}