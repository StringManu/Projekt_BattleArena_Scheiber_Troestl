package battleArena;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BattleArena {
	
	private Scanner sc;

    public BattleArena() {
        this.sc = new Scanner(System.in);
    }
	
    public void Fighting(Character attacker, Character defender) {
		System.out.println(attacker.getName() + ", it's your turn: ");
		System.out.println("What action do you choose? "
				+ "\n\t Attack"
				+ "\n\t Activate special ability"
				+ "\n\t Deactivate special ability");
		String move = sc.nextLine().toLowerCase();
		switch (move) {
			case "attack":
				System.out.println(attacker.getName() + " is attacking!");
				attacker.attack(defender);
				System.out.println("Life Points of " + defender.getName() + ": " + defender.getLifePoints());
				break;
			case "activate special ability":
				System.out.println(attacker.getName() + " is activating special ability!");
				attacker.setSpecialAbility(true);
				break;
			case "deactivate special ability":
				System.out.println(attacker.getName() + " is deactivating special ability!");
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
	            System.out.println(attacker.getName() + " wins! Congratulations!");
	            break;
	        }
	        Character temp = attacker;
	        attacker = defender;
	        defender = temp;
	    }
	    sc.close();
	}
	
}
