import java.util.Collections;
import java.util.List;
//Store the cards
public class Card implements Comparable<Card> {	
	//variable
	private int cardNumber;
	private int cardType;

	//method
	//mix and shuffle
	public static void shuffleCards(List<Card> cards)
    {
            Collections.shuffle(cards);
    }	
	//constructor
	public Card(int cardNumber, int cardType) {
		super();
		this.cardNumber = cardNumber;
		this.cardType = cardType;
	}

	//getters
	public int getCardNumber() {
		return cardNumber;
	}
	
	public int getCardType() {
		return cardType;
	}

	//setters
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}


	//compare card number and card type 
	@Override
	public int compareTo(Card c) {
		if(this.cardNumber > c.cardNumber) {
			return 1;
		}
		else if(this.cardNumber < c.cardNumber) {
			return -1;
		}
		else {
			if(this.cardType > c.cardType) {
				return 1;
			}
			else if(this.cardType < c.cardType) {
				return -1;
			}
		}
		return 0;
	}


	//output the card
	@Override
	public String toString() {
		String cn="";
		String ct="";
		
		switch(this.cardNumber) {
			case 1: cn="2"; break;
			case 2: cn="3"; break;
			case 3: cn="4"; break;
			case 4: cn="5"; break;
			case 5: cn="6"; break;
			case 6: cn="7"; break;
			case 7: cn="8"; break;
			case 8: cn="9"; break;
			case 9: cn="10"; break;
			case 10: cn="J"; break;
			case 11: cn="Q"; break;
			case 12: cn="K"; break;
			case 13: cn="A"; break;
		}
		
		switch(this.cardType) {
			// case 1: ct="Club"; break;
			// case 2: ct="Diamond"; break;
			// case 3: ct="Heart"; break;
			// case 4: ct="Spade"; break;
			case 1: ct="Diamond"; break;
			case 2: ct="Club"; break;
			case 3: ct="Heart"; break;
			case 4: ct="Spade"; break;
		}
		return ("Card Number: " + cn + " , Card Type: " + ct);
	}
}
