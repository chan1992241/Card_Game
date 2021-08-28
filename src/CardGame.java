import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CardGame {
    private ArrayList<CardPlayer> player = new ArrayList<CardPlayer>();
    private Deck deck;
    private static final int NUMBER_OF_CARDS_PER_PLAYER = 7;
    private static final int NUMBER_OF_ROUND = 7;
    private HashMap<CardPlayer, ArrayList<Card>> playerDeck = new HashMap<CardPlayer, ArrayList<Card>>(); 
    private int numberOfPlayers;
    
    public void playGame(int numberOfPlayers){
        removeUser(numberOfPlayers);
        player.clear();
        Card maxCard = null;
        CardPlayer maxCardPlayer = new CardPlayer();
        this.numberOfPlayers = numberOfPlayers;
        createUser(this.numberOfPlayers);
        this.deck = new Deck();
        distributeCardsOverPlayers(player);
        System.out.println("Game Started.....  \n");
        int playerCount_In_Game = 0, game_option;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < NUMBER_OF_ROUND; i++){
            System.out.println("Round: " + (i + 1));
            playerCount_In_Game = 0;
            while (playerCount_In_Game < player.size()){
                CardPlayer plyr = CardPlayer.restrictNumberOfPlayer.get(playerCount_In_Game); //we need to remove instance 
                System.out.println("1.Display Cards available");
                System.out.println("2.Stop Game");
                System.out.println("Chance for Player... " + plyr.getName());
                System.out.println("Please provide your option:  ");
                while (true){
                    try{
                        game_option = input.nextInt();
                        if (game_option != 1 && game_option != 2){
                            throw new Exception("Wrong command, command should be 1 or 2");
                        }else{
                            break;
                        }
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                if (game_option == 1){
                    displayCard(plyr);
                    System.out.println("Select your card number: ");
                    input = new Scanner(System.in);
                    int cardSelected = input.nextInt();
                    Card currCard = playerDeck.get(plyr).get(cardSelected - 1);
                    System.out.println(currCard.toString());
                    playerDeck.get(plyr).remove(cardSelected - 1);
                    if (maxCard == null){
                        maxCard = currCard;
                        maxCardPlayer = plyr;
                    }else{
                        if (maxCard.compareTo(currCard) < 0){
                            maxCard = currCard;
                            maxCardPlayer = plyr;
                        }
                    }
                }
                System.out.println("");
                playerCount_In_Game++;
            }
            if (maxCardPlayer != null){
                maxCardPlayer.increaseTotalPoint();
            };
            maxCard = null;
            maxCardPlayer = null;
            for (CardPlayer pl: player){
                displayScores(pl);
            }
            System.out.println("");
        }
    }
    public void displayScores(CardPlayer p){
        System.out.println("The score of " + p.getName() + " is -> " + p.getTotalPoints());
    }
    public void distributeCardsOverPlayers(ArrayList<CardPlayer> player){ //there are some problem why player 1 and player 2 card is same.
        int temp = 0;
        for (CardPlayer pl: player){
            ArrayList<Card> cards = new ArrayList<Card>();
            int cardLimit = temp + NUMBER_OF_CARDS_PER_PLAYER;
            for (int i = temp; i < cardLimit; i++){
                cards.add(deck.deck.get(i));
            }
            temp += NUMBER_OF_CARDS_PER_PLAYER;
            playerDeck.put(pl, cards);
        }
    }
    private void createUser(int numberOfUSer){
        for (int i = 0; i < numberOfUSer; i++){
            CardPlayer usr = CardPlayer.getInstance();
            player.add(usr);
        }
    }
    private  void removeUser(int numberOfUser){
        for (int i = 0; i < numberOfUser; i++){
            CardPlayer.removeInstance();
        }
    }
    private void displayCard(CardPlayer pl){
        int cards = playerDeck.get(pl).size();
        for (int i = 1; i <= cards;i++){
            System.out.print((i)+" ");
        }
    }
    public void displayWinner(){
        int maxScore = -1;
        CardPlayer winnerPlayer = new CardPlayer();
        ArrayList<CardPlayer> otherHighestScorePlayer = new ArrayList<CardPlayer>();
        for (CardPlayer pl : player){
            if (pl.getTotalPoints() >= maxScore){
                if (pl.getTotalPoints() > maxScore){
                    winnerPlayer = pl;
                    maxScore = pl.getTotalPoints();
                    continue;
                }
                if (pl.getTotalPoints() == maxScore ){
                    otherHighestScorePlayer.add(pl);
                }
            }
        }
        if (otherHighestScorePlayer.isEmpty()){
            System.out.println("Winner -> " + winnerPlayer.getName() + " with score -> " + winnerPlayer.getTotalPoints());
        }else{
            System.out.println("Draw");
            System.out.print(winnerPlayer.getName());
            for (int i = 0; i < otherHighestScorePlayer.size(); i++){
                System.out.print(", " + otherHighestScorePlayer.get(i).getName());
            }
            System.out.print(" win the game with score: -> " + maxScore);
            System.out.println("");
        }
    }
}
