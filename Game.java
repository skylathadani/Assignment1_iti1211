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
		boolean y = true;
		main.shuffle();
		hand =  main.deal(7);
		while(hand.size() > 0) {
			
			d.roll();
			if(main.size()!=0){
				System.out.println("Welcome to round " + round + " you rolled a " + d.getValue() + ".");

			}else{
				System.out.println("Welcome to round " + round); 
				if(main.size()==0){
					if(y == true){
					y = Utils.readYesOrNo("Do you have any melds to discard?");
				 	}
				

				hand.print();
				System.out.println("Please choose a card to discard");
				boolean b = false;
				while(b == false){
					Card c = Utils.readCard();
					b = hand.remove(c);
					if(b == false){
						System.out.println("This card is not in the deck please try again");
					}
				}
				round++;

				


			}

			}
			//System.out.println("Welcome to round " + round + " you rolled a " + d.getValue() + ".");

			

			
			if(d.getValue() == 1 && main.size() !=0){
				hand.print();
				System.out.println("Please choose a card to discard");
				boolean b = false;
				while(b == false){
					Card c = Utils.readCard();
					b = hand.remove(c);
					if(b == false){
						System.out.println("This card is not in the deck please try again");
					}
				}
				round++;
			}	
			else if(d.getValue() != 1 && main.size()!=0){
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
				while (contDiscard == true) {
					hand.print();
					boolean flag = false;
					contDiscard = Utils.readYesOrNo("Do you have any melds to discard?");

					if(contDiscard == false){
						flag = true;
					}

					while(flag == false) { 
						Deck s = Utils.readCards("Please enter cards to form a meld");
						if(hand.containsAll(s)){
							if(s.isKind() || s.isSeq()){
								hand.removeAll(s);
								flag = true;
							}	
							else{
								System.out.println("Invalid meld");
								contDiscard = Utils.readYesOrNo("Do you have any more melds to discard?");
								if(contDiscard == false){
									flag = true;
								}
							}	
						}
						else{
							System.out.println("Invalid meld");
							contDiscard = Utils.readYesOrNo("Do you have any more melds to discard?");
							if(contDiscard==false){
								flag = true;
							}
						}	
					}
					
				}
				round++;
			}
		}

		System.out.println("You have won the game in " + (round-1)+" rounds.");
	}
}