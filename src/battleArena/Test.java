package battleArena;

public class Test {

	public static void main(String[] args) {
		
		
		
		BattleArena b1 =new BattleArena();
		
		Character p1 = new Dragon("Kamil");
		Character p2 = new Dwarf("Hans");
		b1.fight(p1, p2);

	}

}
