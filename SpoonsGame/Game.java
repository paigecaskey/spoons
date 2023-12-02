import java.util.LinkedList;
public class Game{
    private LinkedList<Card> m_discard = new LinkedList<Card>();
    private static int m_spoonsTotal;
    private static int m_playersTotal;
    private Dealer dealer = new Dealer();
    private Player[] Players;

    public Game(){
        m_spoonsTotal = 3;
        m_playersTotal = 4;
        Player Player1 = new Player(1, dealer);
        Player Player2 = new Player(2, dealer);
        Player Player3 = new Player(3, dealer);
        Player Player4 = new Player(4, dealer);
        Players = new Player[]{Player1, Player2, Player3, Player4};
    }

    public int getSpoons(){
        return m_spoonsTotal;
    }

    public void setSpoons(int s){
        m_spoonsTotal = s;
    }

    public int getPlayers(){
        int totalPlayers = Players.length;
        return totalPlayers;
    }

    public void playRound(){
        Card holds[] = new Card[m_playersTotal];
        for(int i = 0; i < Players.length; i++){
            Player player0 = Players[i];
            int player_num = player0.getNum();
            if(player_num == 1){
                holds[player_num-1] = player0.takeTurn(dealer.deal());
            }else if(player_num == 4){
                Card hold2 = player0.takeTurn(holds[player_num - 2]);
                m_discard.add(hold2);
            }else if(player_num == 2){
                Card hold1 = player0.takeTurn(holds[player_num - 2]);
                holds[player_num - 1] = hold1;
            }else if(player_num == 3){
                Card hold5 = player0.takeTurn(holds[player_num - 2]);
                holds[player_num - 1] = hold5;
            }
        }
    }

    public int check(){
        int count = 0;
        for(int i = 0; i < Players.length; i++){
            Player player0 = Players[i];
            boolean player_spoon = player0.getHasSpoon();
                if(player_spoon == true){
                count = count + 1;
                }
            }
        return count;
    }

    public void play(){
        int count = 0;
        while (count <= m_playersTotal - 2){
            if(m_spoonsTotal > 0){
            count = check();
            playRound();
        }
        }
        for(int i = 0; i < Players.length; i++){
            Player player3 = Players[i];
            boolean player_spoon = player3.getHasSpoon();
                if(player_spoon == false){
                    System.out.println("Player " + (i + 1) + " has lost!");
            }
        }
    }
}


