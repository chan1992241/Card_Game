import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public ArrayList<Card> deck = new ArrayList<Card>();
    public Deck(){
        for (int type = 1; type <= 4; type++ ){
            for (int value = 1; value <= 13; value++){
                deck.add(new Card(value, type));
            }
        }
        shuffle();
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
}
