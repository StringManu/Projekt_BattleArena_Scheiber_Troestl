package battleArena;

import java.util.Scanner;

public class BattleArena {
	
	public void beginFighting() {
	Scanner sc = new Scanner(System.in);
	String move = sc.nextLine();
	
	switch(move) {
	
	case "attack":
		System.out.println("Character is attacking!");
	break;
	
	case "activate special ability":
		System.out.println("Character is attacking!");
	break;
	
	case "deactivate special ability":
		System.out.println("Character is attacking!");
	break;
	}
	}
	
}
