import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {

    	//constructor without any parameters
        cards = new ArrayList<Card>();
    }

    public Deck(int range) {
    	//constructor with parameters
        cards = new ArrayList<Card>();
        //insert the cards into the arrayList
        for(int i = 0; i < 4; i++){
			for(int j = 0; j < range; j++){
				Card c = new Card(i,j);
				cards.add(c);
			}	
		}
	}

	public int size() {
		//return the number of cards in the deck
		return this.cards.size();
	}

	public boolean hasCards() {
		//return true if the deck is not empty
		if(this.cards.size() > 0){
			return true;
		}
		return false;
	}

	public Card get(int pos) {
		//returns the card at the indicated position
		return this.cards.get(pos);
	}

	public void add(Card card) {
		//add a specific card to the end of the deck
		this.cards.add(card);
	}

	public void addAll(Deck other) {
		//add a deck to this deck and clear the other deck
		this.cards.addAll(other.cards);
		other.cards.clear();
	}

	public Card removeLast() {
		//remove the last card in the deck
		Card temp = this.cards.get(this.cards.size()-1);
		this.cards.remove(this.cards.size()-1);
		return temp;
	}

	public Card removeFirst() {
		//remove the first card in the deck
		Card temp = this.cards.get(0);
		this.cards.remove(0);
		return temp;
	}

	public boolean remove(Card card) {
		//remove a specific card if it is in the deck
		if(this.cards.contains(card)){
			this.cards.remove(card);
			return true;
		}
		return false; 
	}

	public void removeAll(Deck other) {
		//remove all the cards that are inside another deck from this deck
		for (int i = 0; i < other.cards.size(); i++){
			if(this.cards.contains(other.cards.get(i))){
				this.cards.remove(other.cards.get(i));
			}
		}
	}

	public void shuffle() {
		//shuffle the deck
		Collections.shuffle(this.cards);
	}

	public Deck deal(int n) {
		//deal the new deck from this deck
		 Deck d = new Deck();
		 for(int i = 0; i < n; i++) {
		 	d.cards.add(this.cards.get(this.cards.size() -1));
		 	this.cards.remove(this.cards.size() - 1);
		 }
		 return d;
	}

	public boolean contains(Card card) {

		//see if the deck contains a specific card
		if(this.cards.contains(card)) {
			return true;
		}
		return false;
	}

	public boolean containsAll(Deck other) { 
		//see if the deck contains the other deck entirely 
		for(int i = 0; i < other.size(); i++) {
			if(this.cards.contains(other.get(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public boolean isKind(){
		//check if the deck is a "kind"
		if(this.cards.size() < 2){
			return false;
		}
		if(this.cards.size() > 1){
			for(int i = 0; i < this.cards.size()-1;i++){
				Card x1 = this.cards.get(i);
				Card x2 = this.cards.get(i+1);
				if(x1.rank != x2.rank){
					return false;
				}
			}
		}
		return true;
	}

	public boolean isSeq() {
		//check if the deck forms a sequence
		if(this.cards.size()<3){
			return false;
		}
		if(this.cards.size()>2){
			Deck x = this;
			x.sortByRank();
			for(int i = 0; i < x.cards.size()-1; i++){
				Card x1 = x.cards.get(i);
				Card x2 = x.cards.get(i+1);
				if(x1.suit != x2.suit){
					return false;
				}
				else{
					if(x2.rank-x1.rank != 1){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void sortBySuit() {
		//sort by the suits

		//use a custom comparator
		Collections.sort(this.cards, new Comparator<Card>(){
		@Override
			//compare the suits of the two cards
			public int compare(Card x1, Card x2){
				if(x1.suit > x2.suit){
					return 1;
				}
				if(x1.suit < x2.suit){
					return -1;
				}
				if(x1.suit == x2.suit) {
					if(x1.rank > x2.rank){
						return 1;
					}
					if(x1.rank < x2.rank){
						return -1;
					}
				}
				return 0;
			}
		});
		System.out.println(this.cards);
	}

	public void sortByRank() {
		//sort the deck by the ranks of the cards

		//use a custom comparator
		Collections.sort(this.cards, new Comparator<Card>(){
		@Override

			//compare the ranks of the two cards
			public int compare(Card x1, Card x2){
				if(x1.rank > x2.rank){
					return 1;
				}
				if(x1.rank < x2.rank){
					return -1;
				}
				return 0;
			}
		});
		System.out.println(this.cards);
	}

	public void print() {
		//print the deck in two ways: suit and then rank
		this.sortBySuit();
		this.sortByRank();
	}

	public String toString(){
		//print a string represenation of the deck
		String a = "";

		for(int i = 0; i < this.cards.size();i++){

			if(i != this.cards.size()-1){
				a = a + this.cards.get(i) + "," ;

			}else{
				a = a + this.cards.get(i);
			}

			

		}

		return a;

	}

	/*public static void main(String[] args) {
		Deck n = new Deck();
		Card a = new Card(1,3);
		Card b = new Card(1,4);
		Card c = new Card(1,5);

		n.add(a);
		n.add(b);
		n.add(c);

		Deck x = new Deck();
		Card e = new Card(1,3);
		Card f = new Card(2,3);
		Card g = new Card(3,3);	

		x.add(e);
		x.add(f);
		x.add(g);

		boolean h = n.isKind();
		boolean j =	x.isKind();

		System.out.println(h);
		System.out.println(j);
		System.out.println(n);
	}*/
}
