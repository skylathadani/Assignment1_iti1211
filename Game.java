import java.util.Scanner;

public class Game {

	private Deck main;
	private Deck hand;
	private Die d;

	public Game(int numRanks) {
		this.main = new Deck(numRanks);
		this.d = new Die();
	}

	public void play() {
		int round = 1;
		main.shuffle();
		hand =  main.deal(7);
		while(hand.size() < 0) {
			d.roll();
			hand.print();
			if(d.getValue() == 1){
				System.out.println("Please choose a card to discard");
				boolean b = false;
				while(b == false){
					Card c = Utils.readCard();
					b = hand.remove(c);
					if(b == false){
						System.out.println("This card is not in the deck please try again");
					}
				}
				d.roll();
				round++;
			}	
			else{
				if(d.getValue() < main.size()){
					for(int i = 0; i < d.getValue(); i++) {
						Card temp = main.get(main.size() - 1);
						hand.add(temp);
						main.remove(temp);
					}
				}
				else{
					hand.addAll(main);
				}
				boolean contDiscard = true;
				boolean flag = false;
				while (contDiscard = true) {
					while(flag == false) { 
						Deck s = Utils.readCards("Please enter cards to form a meld");
						if(hand.containsAll(s)){
							if(s.isKind() || s.isSeq()){
								hand.removeAll(s);
								flag = true;
							}	
							else{
								System.out.println("Invalid meld");
							}	
						}
						else{
							System.out.println("Invalid meld");
						}	
					}
					contDiscard = Utils.readYesOrNo("Do you have any more melds to discard?");
				}
				round++;
			}
		}
	}
}