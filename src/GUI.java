import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;

public class GUI extends Application{
    private ArrayList<CardPlayer> player = new ArrayList<CardPlayer>();
    private Deck deck;
    private static final int NUMBER_OF_CARDS_PER_PLAYER = 7;
    private static int NUMBER_OF_ROUND = 0;
    private HashMap<CardPlayer, ArrayList<Card>> playerDeck = new HashMap<CardPlayer, ArrayList<Card>>(); 
    private int numberOfPlayers, playerWithSelectedCard;
    private Text cardDisplay_1, cardDisplay_2, cardDisplay_3, cardDisplay_4;
    private ArrayList<Card> playerSelectedCard  = new ArrayList<Card>();
    private ArrayList<Text> playerScore_list;
    private Text gameRound_text;
    private Text winnerDisplay_txt ;
    @Override
    public void start(Stage primaryStage){
        BorderPane bp = new BorderPane();

        StackPane sp = new StackPane();
        gameRound_text = new Text();
        gameRound_text.setStyle("-fx-font: 24 arial");
        gameRound_text.setText("Round 1");
        sp.getChildren().add(gameRound_text);
        sp.setMinHeight(100);
        sp.setMinWidth(800);
        sp.setStyle("-fx-border-color: black;-fx-border-width: 2;");

        GridPane gp = new GridPane();

        //Player 1 box
        VBox vBox_1 = new VBox();
        vBox_1.setMinWidth(400);
        vBox_1.setMinHeight(200);
        TextField playerName_1 = new TextField("Default name 0");
        playerName_1.setMaxWidth(400);
        ToggleGroup tgroup_1 = new ToggleGroup();
        ArrayList<RadioButton> player1_cardSelection = new ArrayList<RadioButton>();
        for(int i = 1; i <= NUMBER_OF_CARDS_PER_PLAYER; i++){
            player1_cardSelection.add(new RadioButton("Card " + i));
        }
        cardDisplay_1 = new Text("");
        cardDisplay_1.setStyle("-fx-font: 12 arial");
        VBox.setMargin(playerName_1, new Insets(5));
        VBox.setMargin(cardDisplay_1, new Insets(5));
        vBox_1.getChildren().add(playerName_1);
        for (RadioButton player: player1_cardSelection){
            player.setToggleGroup(tgroup_1);
            VBox.setMargin(player, new Insets(5));
            vBox_1.getChildren().add(player);
        }
        vBox_1.getChildren().add(cardDisplay_1);
        vBox_1.setAlignment(Pos.CENTER);
        vBox_1.setStyle("-fx-border-color: black;-fx-border-width: 2;");

        //Player 2 box
        VBox vBox_2 = new VBox();
        vBox_2.setMinWidth(400);
        vBox_2.setMinHeight(200);
        TextField playerName_2 = new TextField("Default name 1");
        playerName_2.setMaxWidth(400);
        ArrayList<RadioButton> player2_cardSelection = new ArrayList<RadioButton>();
        for(int i = 1; i <= NUMBER_OF_CARDS_PER_PLAYER; i++){
            player2_cardSelection.add(new RadioButton("Card " + i));
        }
        ToggleGroup tgroup_2 = new ToggleGroup();
        cardDisplay_2 = new Text("");
        cardDisplay_2.setStyle("-fx-font: 12 arial");
        VBox.setMargin(playerName_2, new Insets(5));
        VBox.setMargin(cardDisplay_2, new Insets(5));
        vBox_2.getChildren().add(playerName_2);
        for (RadioButton player: player2_cardSelection){
            player.setToggleGroup(tgroup_2);
            VBox.setMargin(player, new Insets(5));
            vBox_2.getChildren().add(player);
        }
        vBox_2.getChildren().add(cardDisplay_2);
        vBox_2.setAlignment(Pos.CENTER);
        vBox_2.setStyle("-fx-border-color: black;-fx-border-width: 2;");

        //Player 3 box
        VBox vBox_3 = new VBox();
        vBox_3.setMinWidth(400);
        vBox_3.setMinHeight(200);
        TextField playerName_3 = new TextField("Default name 2");
        playerName_3.setMaxWidth(400);
        ArrayList<RadioButton> player3_cardSelection = new ArrayList<RadioButton>();
        for(int i = 1; i <= NUMBER_OF_CARDS_PER_PLAYER; i++){
            player3_cardSelection.add(new RadioButton("Card " + i));
        }
        ToggleGroup tgroup_3 = new ToggleGroup();
        cardDisplay_3 = new Text("");
        cardDisplay_3.setStyle("-fx-font: 12 arial");
        VBox.setMargin(playerName_3, new Insets(5));
        VBox.setMargin(cardDisplay_3, new Insets(5));
        vBox_3.getChildren().add(playerName_3);
        for (RadioButton player: player3_cardSelection){
            player.setToggleGroup(tgroup_3);
            VBox.setMargin(player, new Insets(5));
            vBox_3.getChildren().add(player);
        }
        vBox_3.getChildren().add(cardDisplay_3);
        vBox_3.setAlignment(Pos.CENTER);
        vBox_3.setStyle("-fx-border-color: black;-fx-border-width: 2;");

        //Player 4 box
        VBox vBox_4 = new VBox();
        vBox_4.setMinWidth(400);
        vBox_4.setMinHeight(200);
        TextField playerName_4 = new TextField("Default name 3");
        playerName_4.setMaxWidth(400);
        ArrayList<RadioButton> player4_cardSelection = new ArrayList<RadioButton>();
        for(int i = 1; i <= NUMBER_OF_CARDS_PER_PLAYER; i++){
            player4_cardSelection.add(new RadioButton("Card " + i));
        }
        ToggleGroup tgroup_4 = new ToggleGroup();
        cardDisplay_4 = new Text("");
        cardDisplay_4.setStyle("-fx-font: 12 arial");
        VBox.setMargin(playerName_4, new Insets(5));
        VBox.setMargin(cardDisplay_4, new Insets(5));
        vBox_4.getChildren().add(playerName_4);
        for (RadioButton player: player4_cardSelection){
            player.setToggleGroup(tgroup_4);
            VBox.setMargin(player, new Insets(5));
            vBox_4.getChildren().add(player);
        }
        vBox_4.getChildren().add(cardDisplay_4);
        vBox_4.setAlignment(Pos.CENTER);
        vBox_4.setStyle("-fx-border-color: black;-fx-border-width: 2;");

        gp.add(vBox_1, 0, 0);
        gp.add(vBox_2, 1, 0);
        gp.add(vBox_3, 0, 1);
        gp.add(vBox_4, 1, 1);

        HBox hbox = new HBox();
        hbox.setMinHeight(200);
        hbox.setMinWidth(800);
        //Number of player selection box
        BorderPane bp1 = new BorderPane();
        bp1.setStyle("-fx-border-color: black;-fx-border-width: 2;");
        bp1.setMinWidth(266);
        VBox vBox_numberOfPlayer = new VBox();
        ArrayList<RadioButton> numberOfPlayer_button = new ArrayList<RadioButton>();
        for (int i = 2;i <= 4; i++){
            numberOfPlayer_button.add(new RadioButton(i + ""));
        }
        vBox_numberOfPlayer.getChildren().addAll(numberOfPlayer_button.get(0), numberOfPlayer_button.get(1), numberOfPlayer_button.get(2));
        Text numberOfPlayer_txt = new Text("Number of player");
        numberOfPlayer_txt.setStyle("-fx-font: 16 arial");
        ToggleGroup tgroup_numberOfPlayer = new ToggleGroup();
        for (RadioButton btn: numberOfPlayer_button){
            btn.setToggleGroup(tgroup_numberOfPlayer);
            VBox.setMargin(btn, new Insets(15));
        }
        numberOfPlayer_button.get(2).setSelected(true);
        Button play = new Button("Play");
        //group player card selection into one arraylist
        ArrayList<ArrayList<RadioButton>> cardSelection = new ArrayList<ArrayList<RadioButton>>();
        cardSelection.add(player1_cardSelection);
        cardSelection.add(player2_cardSelection);
        cardSelection.add(player3_cardSelection);
        cardSelection.add(player4_cardSelection);
        setPlayingEnviroment(play, numberOfPlayer_button, cardSelection);
        BorderPane.setMargin(numberOfPlayer_txt, new Insets(20));
        BorderPane.setMargin(play, new Insets(0, 100, 0, 0));
        BorderPane.setAlignment(play, Pos.CENTER);
        bp1.setTop(numberOfPlayer_txt);
        bp1.setLeft(vBox_numberOfPlayer);
        bp1.setRight(play);

        //Score display box
        VBox vbox_score = new VBox();
        vbox_score.setStyle("-fx-border-color: black;-fx-border-width: 2;");
        playerScore_list = new ArrayList<Text>();
        for (int i = 1;  i <= 4; i++){
            playerScore_list.add(new Text("Default name " + (i - 1) + " score is 0" ));
        }
        for (Text playerScore: playerScore_list){
            playerScore.setStyle("-fx-font: 16 arial");
            vbox_score.getChildren().add(playerScore);
        }
        vbox_score.setMinWidth(266);
        vbox_score.setAlignment(Pos.CENTER);

        //Winner display box
        StackPane sp_winnerDisplay = new StackPane();
        sp_winnerDisplay.setMinWidth(270);
        sp_winnerDisplay.setStyle("-fx-border-color: black;-fx-border-width: 2;");
        winnerDisplay_txt = new Text("");
        sp_winnerDisplay.getChildren().add(winnerDisplay_txt);

        hbox.getChildren().addAll(bp1, vbox_score, sp_winnerDisplay);

        bp.setTop(sp);
        bp.setCenter(gp);
        bp.setBottom(hbox);

        Scene scene = new Scene(bp, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Card Game");
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
    public void setPlayingEnviroment(Button play, ArrayList<RadioButton> numberOfPlayer_button, ArrayList<ArrayList<RadioButton>> cardSelection){
        play.setOnAction(e -> {
            //Reset
            removeDisplayWinnerTxt();
            resetButtonEnable(cardSelection);
            resetplayerScore_list();
            gameRound_text.setText("Round " + NUMBER_OF_ROUND);
            for (int i = 0; i < numberOfPlayer_button.size();i++){
                if (numberOfPlayer_button.get(i).isSelected()){
                    this.numberOfPlayers = (i + 2);
                    break;
                }
            }
            removeUser(numberOfPlayers);
            player = new ArrayList<CardPlayer>();
            createUser(this.numberOfPlayers);
            this.deck = new Deck();
            setActivePlayer(cardSelection);
            distributeCardsOverPlayers(player);
            displayCard(cardSelection); //add event to each radio button to display the card          
        });
    }

    public void setActivePlayer(ArrayList<ArrayList<RadioButton>> cardSelection){
        if (this.numberOfPlayers == 2){
            for (int i = 0; i < NUMBER_OF_CARDS_PER_PLAYER; i++){
                cardSelection.get(0).get(i).setDisable(false);
                cardSelection.get(1).get(i).setDisable(false);
                cardSelection.get(2).get(i).setDisable(true);
                cardSelection.get(3).get(i).setDisable(true);
            }
        }else if (this.numberOfPlayers == 3){
            for (int i = 0; i < NUMBER_OF_CARDS_PER_PLAYER; i++){
                cardSelection.get(0).get(i).setDisable(false);
                cardSelection.get(1).get(i).setDisable(false);
                cardSelection.get(2).get(i).setDisable(false);
                cardSelection.get(3).get(i).setDisable(true);
            }
        }else if (this.numberOfPlayers == 4){
            for (int i = 0; i < NUMBER_OF_CARDS_PER_PLAYER; i++){
                cardSelection.get(0).get(i).setDisable(false);
                cardSelection.get(1).get(i).setDisable(false);
                cardSelection.get(2).get(i).setDisable(false);
                cardSelection.get(3).get(i).setDisable(false);
            }
        }
    }
    private void displayCard(ArrayList<ArrayList<RadioButton>> cardSelection){ //add event to each radio button to display the card
        for ( int i = 0; i < cardSelection.size(); i++){
            for (int j = 0; j < NUMBER_OF_CARDS_PER_PLAYER; j++){
                cardSelection.get(i).get(j).setOnAction(e -> {
                    for (int z = 0; z < cardSelection.size(); z++){
                        for (int k = 0; k < NUMBER_OF_CARDS_PER_PLAYER; k++){
                            if (e.getTarget() == cardSelection.get(z).get(k)){
                                cardSelection.get(z).get(k).setDisable(true);
                                //Display it
                                if (z == 0){
                                    Card card = playerDeck.get(player.get(0)).get(k);
                                    cardDisplay_1.setText(card.toString()); 
                                    playerSelectedCard.add(0, card);
                                    playerWithSelectedCard++;
                                }else if (z == 1){
                                    Card card = playerDeck.get(player.get(1)).get(k);
                                    cardDisplay_2.setText(card.toString()); 
                                    playerSelectedCard.add(1, card);
                                    playerWithSelectedCard++;
                                }else if (z == 2){
                                    Card card = playerDeck.get(player.get(2)).get(k);
                                    cardDisplay_3.setText(card.toString());
                                    playerSelectedCard.add(2, card);
                                    playerWithSelectedCard++;
                                }else if (z == 3){
                                    Card card = playerDeck.get(player.get(3)).get(k);
                                    cardDisplay_4.setText(card.toString()); 
                                    playerSelectedCard.add(3, card);
                                    playerWithSelectedCard++;
                                }
                                if (playerWithSelectedCard == this.numberOfPlayers){
                                    int playerWithLargestCard = checkLargestCard();
                                    player.get(playerWithLargestCard).increaseTotalPoint(); 
                                    playerScore_list.get(playerWithLargestCard).setText("Default name " + (playerWithLargestCard) + " score is "+player.get(playerWithLargestCard).getTotalPoints());
                                    NUMBER_OF_ROUND++;
                                    gameRound_text.setText("Round " + NUMBER_OF_ROUND);
                                    //Reset
                                    playerSelectedCard.clear();
                                    playerWithSelectedCard = 0;
                                    if (NUMBER_OF_ROUND == 7){ 
                                        //Display winner
                                        displayWinner();
                                        resetCardDisplay();
                                        NUMBER_OF_ROUND = 0;
                                    }
                                }
                            }
                        }
                    }
                });
            }
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
    private void resetCardDisplay(){
        cardDisplay_1.setText("");
        cardDisplay_2.setText("");
        cardDisplay_3.setText("");
        cardDisplay_4.setText("");
    }
    private void resetplayerScore_list(){
        for (int i = 1;  i <= 4; i++){
            playerScore_list.get(i - 1).setText("Default name " + (i - 1) + " score is 0");
        }
    } 
    private void resetButtonEnable(ArrayList<ArrayList<RadioButton>> cardSelection){
        for (int i = 0; i < NUMBER_OF_CARDS_PER_PLAYER; i++){
            cardSelection.get(0).get(i).setDisable(false);
            cardSelection.get(1).get(i).setDisable(false);
            cardSelection.get(2).get(i).setDisable(false);
            cardSelection.get(3).get(i).setDisable(false);
            cardSelection.get(0).get(i).setSelected(false);
            cardSelection.get(1).get(i).setSelected(false);
            cardSelection.get(2).get(i).setSelected(false);
            cardSelection.get(3).get(i).setSelected(false);
        }
    }
    private void distributeCardsOverPlayers(ArrayList<CardPlayer> player){
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
    private int checkLargestCard(){
        Card largestCard = new Card(-1, -1);
        int largestPlayerNo = -1;
        for (int i = 0; i < playerSelectedCard.size(); i++){
            if (largestCard.compareTo(playerSelectedCard.get(i)) == -1){
                largestCard = playerSelectedCard.get(i);
                largestPlayerNo = i;
            }
        }
        return largestPlayerNo;
    }
    private void displayWinner(){
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
            winnerDisplay_txt.setText("Winner -> " + winnerPlayer.getName() + " with score -> " + winnerPlayer.getTotalPoints());
        }else{
            String drawPlayer = "";
            for (int i = 0; i < otherHighestScorePlayer.size(); i++){
                drawPlayer+= (otherHighestScorePlayer.get(i).getName() + " ");
            }
            drawPlayer += "\n win the game with score: -> " + otherHighestScorePlayer.get(0).getTotalPoints();
            winnerDisplay_txt.setText("Draw \n" + winnerPlayer.getName() + drawPlayer);
        }
        otherHighestScorePlayer.clear();
    }
    private void removeDisplayWinnerTxt(){
        winnerDisplay_txt.setText("");
    }
}
