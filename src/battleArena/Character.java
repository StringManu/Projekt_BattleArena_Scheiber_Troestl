package battleArena;

public class Character {
	
	private String name;
	private int lifePoints;
	private boolean specialAbility;
	
	public Character(String name, int lifePoints, boolean specialAbility) {
		super();
		this.name = name;
		this.lifePoints = lifePoints;
		this.specialAbility = specialAbility;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	public boolean isSpecialAbility() {
		return specialAbility;
	}
	public void setSpecialAbility(boolean specialAbility) {
		this.specialAbility = specialAbility;
	}

	@Override
	public String toString() {
		return "Character: " + name 
				+ "/n" + "Life Points: " + lifePoints 
				+ "/n" + "Special Ability: " + specialAbility;
	}
	
	
	
}
