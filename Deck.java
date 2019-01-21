import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
    }

    public Deck(int range) {
        cards = new ArrayList<Card>();
        for(int i = 0; i < 4; i++){
			for(int j = 0; j < range; j++){
				Card c = new Card(i,j);
				cards.add(c);
			}	
		}
	}

	public int size() {
		return this.cards.size();
	}

	public boolean hasCards() {
		if(this.cards.size() > 0){
			return true;
		}
		return false;
	}

	public Card get(int pos) {
		return this.cards.get(pos);
	}

	public void add(Card card) {
		this.cards.add(card);
	}

	public void addAll(Deck other) {
		this.cards.addAll(other.cards);
		other.cards.clear();
	}

	public Card removeLast() {
		Card temp = this.cards.get(this.cards.size()-1);
		this.cards.remove(this.cards.size()-1);
		return temp;
	}

	public Card removeFirst() {
		Card temp = this.cards.get(0);
		this.cards.remove(0);
		return temp;
	}

	public boolean remove(Card card) {
		if(this.cards.contains(card)){
			this.cards.remove(card);
			return true;
		}
		return false; 
	}

	public void removeAll(Deck other) {
		for (int i = 0; i < other.cards.size(); i++){
			if(this.cards.contains(other.cards.get(i))){
				this.cards.remove(other.cards.get(i));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(this.cards);
	}

	public Deck deal(int n) {
		 Deck d = new Deck();
		 for(int i = 0; i < n; i++) {
		 	d.cards.add(this.cards.get(this.cards.size() -1));
		 	this.cards.remove(this.cards.size() - 1);
		 }
		 return d;
	}

	public boolean contains(Card card) {
		if(this.cards.contains(card)) {
			return true;
		}
		return false;
	}

	public boolean containsAll(Deck other) { 
		for(int i = 0; i < other.size(); i++) {
			if(this.cards.contains(other.get(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public boolean isKind(){
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
		Collections.sort(this.cards, new Comparator<Card>(){
		@Override

			public int compare(Card x1, Card x2){
				if(x1.suit > x2.suit){
					return 1;
				}
				if(x1.suit < x2.suit){
					return -1;
				}
				return 0;
			}
		});
		System.out.println(this.cards);
	}

	public void sortByRank() {
		Collections.sort(this.cards, new Comparator<Card>(){
		@Override

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
		this.sortBySuit();
		this.sortByRank();
	}

	public String toString(){
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

	public static void main(String[] args) {
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
	}
}
