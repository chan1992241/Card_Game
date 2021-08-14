import java.util.ArrayList; 
public class CardPlayer extends Player {
    //Attribute to prevent create more than 4 player
    private static ArrayList<CardPlayer> restrictNumberOfPlayer = new ArrayList<CardPlayer>();
    static int totalNumberOfPlayer = restrictNumberOfPlayer.size();
    //Card Player attribute
    private int totalPoints = 0;
    private int cardHold = 0;
    //COnstructor
    public CardPlayer(String name){
        super(name);
    }
    public CardPlayer(){
        super();
        super.setName("Default Name " +  totalNumberOfPlayer);
    }
    //Card Player Method
    public void setCardHold(int card){
        this.cardHold = card;
    }
    public int getCardHold(){
        return this.cardHold;
    }
    //Compare card value (greater return 1, lesser return -1, equal return 0)
    public int compareCard(int card ){
        if (cardHold > card){
            return 1;
        }if(cardHold < card){
            return -1;
        }
        return 0;
    }
    public int getTotalPoints(){
        return this.totalPoints;
    }
    public void increaseTotalPoint(){
        this.totalPoints++;
    }

    //method to prevent more than 4 player object
    public static CardPlayer getInstance(){
        if (totalNumberOfPlayer < 4){
            // if (totalNumberOfPlayer != 4) totalNumberOfPlayer++;
            restrictNumberOfPlayer.add(new CardPlayer());
            totalNumberOfPlayer = restrictNumberOfPlayer.size();
        }
        if (totalNumberOfPlayer == 4){
            return restrictNumberOfPlayer.get(3);
        }
        //return newest created instance
        return restrictNumberOfPlayer.get(totalNumberOfPlayer - 1);
    }
    public static CardPlayer getInstance(String name){
        if (totalNumberOfPlayer < 4){
            // if (totalNumberOfPlayer != 4) totalNumberOfPlayer++;
            restrictNumberOfPlayer.add(new CardPlayer(name));
            totalNumberOfPlayer = restrictNumberOfPlayer.size();
        }
        if (totalNumberOfPlayer == 4){
            return restrictNumberOfPlayer.get(3);
        }
        return restrictNumberOfPlayer.get(totalNumberOfPlayer);
    }
    //method to remove player
    public static void removeInstance(){
        if (totalNumberOfPlayer >= 0){
            totalNumberOfPlayer = restrictNumberOfPlayer.size();
            restrictNumberOfPlayer.remove(restrictNumberOfPlayer.size() - 1);
        }
    }
}
