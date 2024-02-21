package battleArena;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BattleArena {
	
	private Scanner sc;

    public BattleArena() {
        this.sc = new Scanner(System.in);
    }
	
	public void FightingP1(Character player1, Character player2) {
	
	System.out.println("Player 1 it´s your turn: ");
	System.out.println("What action do you choose? "
			+ " \n\t Attack "
			+ " \n\t activate special ability"
			+ " \n\t deactivate special ability");
	String move = sc.next().toLowerCase();
	switch(move) {
	
	case "attack":
		System.out.println("Character is attacking!");
		player1.attack(player2);
		System.out.println("Life Points of Player2: " + player2.getLifePoints());
	break;
	
	case "activate special ability":
		System.out.println("Character is using special ability!");
		player1.setSpecialAbility(true);
	break;
	
	case "deactivate special ability":
		System.out.println("Character is deactivating special ability!");
		player1.setSpecialAbility(false);
	break;
	
	default:
		System.out.println("Error!");
	break;
	 }
	}
	
	
	public void FightingP2(Character player1, Character player2) {
	
		System.out.println("Player 2 it´s your turn: ");
		System.out.println("What action do you choose? "
				+ " \n\t Attack "
				+ " \n\t activate speacial ability"
				+ " \n\t deactivate special ability");
		String move = sc.next().toLowerCase();
		switch(move) {
		
		case "attack":
			System.out.println("Character is attacking!");
			player2.attack(player1);
			System.out.println("Life Points of Player1: " + player1.getLifePoints());
		break;
		
		case "activate special ability":
			System.out.println("Character using special ability!");
			player2.setSpecialAbility(true);
		break;
		
		case "deactivate special ability":
			System.out.println("Character is deactivating special ability!");
			player2.setSpecialAbility(false);
		break;
		
		default:
			System.out.println("Error!");
		break;
		 }
		}
	
	public boolean decideWhoBeginns() {
		int i=ThreadLocalRandom.current().nextInt(1,10);
		if(i<=5) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkIfPlayerHasLifepoints(Character player) {
		if(player.getLifePoints()==0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void fight(Character player1, Character player2) {
		boolean checkLifePointsP1=true;
		boolean checkLifePointsP2=true;
		while (checkLifePointsP1 && checkLifePointsP2) {
			FightingP1(player1, player2);
			checkLifePointsP2=checkIfPlayerHasLifepoints(player2);
			if(checkLifePointsP2==false) {System.out.println(player1.getName() + " wins, Congratulations!");break;}
			FightingP2(player2, player1);
			checkLifePointsP1=checkIfPlayerHasLifepoints(player1);
			if(checkLifePointsP1==false) {System.out.println(player2.getName() + " wins, Congratulations!");break;}
		}sc.close();
	}
	
}
