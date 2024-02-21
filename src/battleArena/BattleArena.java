package battleArena;

import java.util.Scanner;

public class BattleArena {
	
	public void FightingP1(Character player1, Character player2) {
	Scanner sc = new Scanner(System.in);
	String move = sc.nextLine();
	
	switch(move) {
	
	case "attack":
		System.out.println("Character is attacking!");
		player1.attack(player2);
	break;
	
	case "activate special ability":
		System.out.println("Character is attacking!");
		player1.setSpecialAbility(true);
	break;
	
	case "deactivate special ability":
		System.out.println("Character is attacking!");
		player1.setSpecialAbility(false);
	break;
	
	default:
		System.out.println("Error!");
	break;
	 }
	sc.close();
	}
	
	
	public void FightingP2(Character player1, Character player2) {
		Scanner sc = new Scanner(System.in);
		String move = sc.nextLine();
		
		switch(move) {
		
		case "attack":
			System.out.println("Character is attacking!");
			player2.attack(player1);
		break;
		
		case "activate special ability":
			System.out.println("Character is attacking!");
			player2.setSpecialAbility(true);
		break;
		
		case "deactivate special ability":
			System.out.println("Character is attacking!");
			player2.setSpecialAbility(false);
		break;
		
		default:
			System.out.println("Error!");
		break;
		 }
		sc.close();
		}
	
}
