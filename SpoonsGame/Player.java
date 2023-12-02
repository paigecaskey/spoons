import java.util.LinkedList;
public class Player{
    private int m_num;
    private LinkedList<Card> m_hand = new LinkedList<Card>();
    private boolean m_hasSpoon;

    public Player(int n, Dealer deck){
        m_num = n;
        m_hand = deck.deals(4);
        m_hasSpoon = false;
    }

    public int getNum(){
        return m_num;
    }

    public boolean getHasSpoon(){
        return m_hasSpoon;
    }

    private void stealSpoon(){
        Game game = new Game();
        int tSpoons = game.getSpoons();
        if (m_hasSpoon == false){
            if(tSpoons > 0){
                m_hasSpoon = true;
                game.setSpoons(tSpoons - 1);
            }
        }
    }
    
    public void checkSpoon(){
        Game game = new Game();
        int tSpoons = game.getSpoons();
        int tPlayers = game.getPlayers();
        int min = 1;
        int max = 3;
        int rand = (int)Math.floor(Math.random()*(max-min+1)+min);
        if(tSpoons < tPlayers - 1 && rand == 2){
            stealSpoon();
        }
    }

    private int[] getMatches(){
        int sMatches = 0;
        int hMatches = 0;
        int cMatches = 0;
        int dMatches = 0;
        int [] matches = new int[4];
        for(int i = 0; i < m_hand.size(); i++){
            for(int j = 0; j < m_hand.size(); j++){
                Card cardCompare = m_hand.get(i);
                Card cardCompare1 = m_hand.get(j);
                int suiteCompare = cardCompare.getSuit();
                int suiteCompare1 = cardCompare1.getSuit();
                if(suiteCompare == suiteCompare1 && i != j){
                    if(suiteCompare == 0){
                        hMatches += 1; // this meants hearts match
                        matches[0] = hMatches;
                    }else if (suiteCompare == 1){
                        sMatches += 1; // this means spades match
                        matches[1] = sMatches;
                    }else if (suiteCompare == 2){
                        cMatches += 1; // this meand clubs match
                        matches[2] = cMatches;
                    }else if (suiteCompare == 3){
                        dMatches += 1; // this means diamonds match
                        matches[3] = dMatches;
                    }
                }
            }

        }
        for(int i = 0; i < matches.length; i++){
            if(matches[i] == 12){
                stealSpoon();
            }
        }
        return matches; //ORDER IS: HEARTS, SPADES, CLUBS, DIAMONDS
        
    }

    // hearts = 0, spades = 1, clubs = 2, diamonds = 3, no matches = 4
    private int Suitetokeep(){
        int[] MATCHES = new int[4];
        MATCHES = getMatches();
        int KEEP = 4;
        int hMatches = MATCHES[0];
        int sMatches = MATCHES[1];
        int cMatches = MATCHES[2];
        int dMatches = MATCHES[3];
        if(hMatches == 0 && sMatches == 0 && cMatches == 0 && dMatches == 0){
            KEEP = 4;
        }else{
            for(int i = 0; i < MATCHES.length; i++){
                if(MATCHES[i] == 2){
                    KEEP = i;
                }
            }
            for(int i = 0; i < MATCHES.length; i++){
                if(MATCHES[i] == 6){
                    KEEP = i;
                }
            }
            for(int i = 0; i < MATCHES.length; i++){
                if(MATCHES[i] == 12){
                    KEEP = i;
                }
            }
        }
    return KEEP;
    }

    private Card Pass(){
        System.out.println("HAND BEFORE PASSING: " + m_hand);
        int min = 0;
        int max = m_hand.size() - 1;
        int rand = (int)Math.floor(Math.random()*(max-min+1)+min);
        LinkedList<Card> passing = new LinkedList<Card>();
        int keeping = Suitetokeep();
        if(keeping == 3){ // keeping diamonds 
            for(int i = 0; i < m_hand.size(); i++){
                Card x = m_hand.get(i);
                int asuit = x.getSuit();
                if(asuit != 3){
                    passing.add(x);
                }
            }
        }else if(keeping == 2){//keeping clubs
            for(int i = 0; i < m_hand.size(); i++){
                Card x = m_hand.get(i);
                int asuit = x.getSuit();
                if(asuit != 2){
                    passing.add(x);
                }
            }
        }else if(keeping == 1){
            for(int i = 0; i < 5; i++){
                Card x = m_hand.get(i);
                int asuit = x.getSuit();
                if(asuit != 1){
                    passing.add(x);
                }
            }
        }else if(keeping == 0){
            for(int i = 0; i < 5; i++){
                Card x = m_hand.get(i);
                int asuit = x.getSuit();
                if(asuit != 0){
                    passing.add(x);
                }
            }
        }
        if(passing.size() != 0){
            int min2 = 0;
            int max2 = passing.size() - 1;
            int rand2 = (int)Math.floor(Math.random()*(max2-min2+1)+min2);
            Card pass = new Card(passing.get(rand2));
            return pass;
        }else{
            Card pass = new Card(m_hand.get(rand));
            return pass;
        }
    }

    public Card takeTurn(Card card){
        m_hand.add(card);
        checkSpoon();
        Card PASS = Pass();
        System.out.println("PLAYER NUMBER: " + m_num);
        System.out.println("PLAYER HAS SPOON: " + m_hasSpoon);
        m_hand.remove(PASS);
        System.out.println("HAND AFTER PASSING: " + m_hand);
        return PASS;
    }

}

