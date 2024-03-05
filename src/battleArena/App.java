package battleArena;

import java.util.Scanner;

public class App {
	
	static Scanner sc = new Scanner(System.in);
	
	private static String chooseName() {
		System.out.println("Please type in your name!");
		return sc.nextLine();
	}
	
	private static Character chooseCharacter() {
		Character p1 = new Dragon(chooseName());
		Character p2 = new Dwarf(p1.getName());
		System.out.println("Choose your Charakter!");
		String character = sc.nextLine();
		switch(character) {
		
			case "Dragon" :
				return p1;
			case "Dwarf" :
				return p2;
			default:
				System.out.println("Error, please type again!");
				chooseCharacter();
				break;
		} return null;
	}
	
	
	public static void main(String[] args) {
		
		
		
		BattleArena b1 =new BattleArena();
		
		b1.fight(chooseCharacter(), chooseCharacter());

		sc.close();
	}

}
