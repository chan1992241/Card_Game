import java.util.ArrayList; 
public class CardPlayer extends Player {
    //Attribute to prevent create more than 4 player
    static ArrayList<CardPlayer> restrictNumberOfPlayer = new ArrayList<CardPlayer>();
    static int totalNumberOfPlayer = restrictNumberOfPlayer.size();
    //Card Player attribute
    private int totalPoints = 0;
    //COnstructor
    public CardPlayer(String name){
        super(name);
    }
    public CardPlayer(){
        super();
        super.setName("Default Name " +  (totalNumberOfPlayer));
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
        if (totalNumberOfPlayer > 0){
            restrictNumberOfPlayer.remove(restrictNumberOfPlayer.size() - 1);
            totalNumberOfPlayer = restrictNumberOfPlayer.size();
        }
    }
}
