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


import java.util.Scanner;

public class Game {
	/**
     * Runs the logic of the Rummy Game. Rolls a die and asks the user to discard cards
     * if the discard card/meld is invalid, user is asked if they have a valid meld and 
     * they must provide a valid meld
     * Objective of the game is to discard all cards
     * 
     *@param numRanks an integer;
     */



//initial variables
	private Deck main;
	private Deck hand;
	private Die d;

	public Game(int numRanks) {
		//this is the constructor
		this.main = new Deck(numRanks);
		this.d = new Die();
	}

	public void play() {
		//round counter
		int round = 1;
		boolean y = true;
		//shuffle the main deck
		main.shuffle();
		//deal 7 cards from main deck to the hand
		hand =  main.deal(7);

		//main part of the game
		while(hand.size() > 0) {
			//roll the die
			d.roll();
			if(main.size()!=0) {
				System.out.println("Welcome to round " + round + " you rolled a " + d.getValue() + ".");
			}
			else{
				System.out.println("Welcome to round " + round); 
				if(main.size()==0) {
					if(y == true) {
					y = Utils.readYesOrNo("Do you have any melds to discard?");
				 	}
					hand.print();
					System.out.println("Please choose a card to discard");
					boolean b = false;
					while(b == false) {
						Card c = Utils.readCard();
						b = hand.remove(c);
						if(b == false) {
							System.out.println("This card is not in the deck please try again");
						}
					}
					round++;
				}
			}

			//if user rolled a 1
			if(d.getValue() == 1 && main.size() !=0){
				hand.print();
				//remove a card
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
			//if user didnt roll a 1
			else if(d.getValue() != 1 && main.size()!=0){
				//add cards to the hand from the deck
				if(d.getValue() < main.size()) {
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

				//ask if user can get rid of cards
				while (contDiscard == true) {
					hand.print();
					boolean flag = false;
					contDiscard = Utils.readYesOrNo("Do you have any melds to discard?");

					if(contDiscard == false) {
						flag = true;
					}

					while(flag == false) { 
						Deck s = new Deck();
						s = Utils.readCards("Please enter cards to form a meld");
						//see if the meld is valid -> remove the meld if it is
						if(hand.containsAll(s)) {
							if(s.isKind()){
								hand.removeAll(s);
								flag = true;
							}else if(s.isSeq()) {
								
								hand.removeAll(s);
								flag = true;
							}	
							else{
								System.out.println("Invalid meld");
								contDiscard = Utils.readYesOrNo("Do you have any more melds to discard?");
								if(contDiscard == false) {
									flag = true;
								}
							}	
						}
						else{
							System.out.println("Invalid meld");
							contDiscard = Utils.readYesOrNo("Do you have any more melds to discard?");
							if(contDiscard==false) {
								flag = true;
							}
						}	
					}
					
				}
				round++;
			}
		}

		//end the game
		System.out.println("You have won the game in " + (round-1)+" rounds.");
	}
}