/**
* @author: Gregory Mitchell
* Student number: 300053307
* Course: ITI 1121-A00
* Assignment: 1

* @author: Skyla Thadani
* Student number: 300055455
* Course: ITI 1121-C00
* Assignment: 1
*/
public class Card{
	/**
     * Creates a Card Object
     *
     * @param s an integer;
     * @param r an integer;
     * @param object an object of type Card;
     * @return a new Card object with different properties
     */
	//create the variables that card objects hold
	int suit;
	int rank;
	public static final int DIAMOND = 0;
	public static final int CLUB = 1;
	public static final int HEART = 2;
	public static final int SPADE = 3;



	public Card(int s,int r){
		//this is the constructor that assigns the card variables their values
		 suit = s;
		 rank = r;
	}
	public int getSuit(){
		//return the suit
		return suit;
	}
	public int getRank(){
		//return the rank
		return rank;
	}
	public boolean equals(Object object){
		//"object" is the thingy you want to compare with "this" object

		//check if "object" is in fact "this"
		if(object == this){
			return true;
		}

		//if "object" is not of type Card then you know that it will not be equal to "this"
		if (!(object instanceof Card)){
			return false;
		}

		//after passing the above tests, turn "object" into a workable variable -> other (other is of type Card and you've gotta do this in java in order to compare)
		//going to use "other" to do the rest of the testing

		Card other;
		other = (Card) object;

		//if "other" has the same rank and suit as "this" then the two objects are equal so return true

		if(other.rank == this.rank && other.suit == this.suit){
			return true;
		}else{
			return false;
		}

		
	}
	public String toString(){
		// string representation of this -> {suit,rank}
			String result = "{"+this.suit+","+this.rank + "}";

			return result;
		}

		//testing

	// public static void main(String[] args) {
	// 	Card a,b,c;

	// 	a= new Card(2,7);
	// 	b = new Card(2,7);
	// 	c = new Card(0,9);
	// 	System.out.println(a);
	// 	System.out.println(a.equals(b));
	// 	System.out.println(a.equals(c));
	// }
}