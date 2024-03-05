package battleArena;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BattleArena {
	
	private Scanner sc;

    public BattleArena() {
        this.sc = new Scanner(System.in);
    }
	
    /**
     * Method to start a fight between two players
     * @param attacker
     * @param defender
     */
    public void Fighting(Character attacker, Character defender) {
		System.out.println(attacker.getName() + ", it's your turn: ");
		System.out.println("What action do you choose? (Type a number... 1-3)"
				+ "\n\t 1 = Attack "
				+ "\n\t 2 = Activate special ability"
				+ "\n\t 3 = Deactivate special ability");
		int move = sc.nextInt();
		switch (move) {
			case 1:
				attacker.attack(defender);
				System.out.println(attacker.getName() + " just attacked! ");
				System.out.println("Life Points of " + defender.getName() + ": " + defender.getLifePoints());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println(attacker.getName() + " is activating special ability!");
				System.out.println("---------------------------------");
				attacker.setSpecialAbility(true);
				break;
			case 3:
				System.out.println(attacker.getName() + " is deactivating special ability!");
				System.out.println("---------------------------------");
				attacker.setSpecialAbility(false);
				break;
			default:
				System.out.println("Invalid action!");
				break;
		}
	}
	
	/**
	 * Method to decide which player begins
	 * @return
	 */
	private boolean decideWhoBegins() {
		int i=ThreadLocalRandom.current().nextInt(1,10);
		if(i<=5) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method to check if a player still has life points
	 * @param player
	 * @return
	 */
	private boolean checkIfPlayerHasLifepoints(Character player) {
		if(player.getLifePoints()==0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Method to start the fight between two players
	 * @param player1
	 * @param player2
	 */
	public void fight(Character player1, Character player2) {
	    boolean player1Turn = decideWhoBegins();
	    Character attacker, defender;
	    if (player1Turn) {
	        attacker = player1;
	        defender = player2;
	    } else {
	        attacker = player2;
	        defender = player1;
	    }
	    while (checkIfPlayerHasLifepoints(player1) && checkIfPlayerHasLifepoints(player2)) {
	        Fighting(attacker, defender);
	        if (!checkIfPlayerHasLifepoints(defender)) {
	            System.out.println("\t" + attacker.getName() + " wins! Congratulations!");
	            System.out.println("           ________\r\n"
	            		+ "          /        \\\r\n"
	            		+ "         /          \\\r\n"
	            		+ "        /__ Winner __\\\r\n"
	            		+ "       /              \\\r\n"
	            		+ "      /________________\\\r\n"
	            		+ "     /                  \\\r\n"
	            		+ "    /____________________\\\r\n"
	            		+ "    |                    |\r\n"
	            		+ "    |      _...._        |\r\n"
	            		+ "   /|   .-'      '-.     |\\\r\n"
	            		+ "  / |  /            \\    | \\\r\n"
	            		+ " |  | |              |   |  |\r\n"
	            		+ " |  | |      1       |   |  |\r\n"
	            		+ " |  | |              |   |  |\r\n"
	            		+ " \\  |  \\            /    | /\r\n"
	            		+ "  \\ |   '-._    _.-'     |/\r\n"
	            		+ "    |       `--'         |\r\n"
	            		+ "    \\____________________/\r\n"
	            		+ "           |||||||\r\n"
	            		+ "          // ||| \\\\\r\n"
	            		+ "         //|||||||\\\\\r\n"
	            		+ "-------------------------------\r\n"
	            		+ "");
	            break;
	        }
	        Character temp = attacker;
	        attacker = defender;
	        defender = temp; 
	    }
	    sc.close();
	}
	
}
