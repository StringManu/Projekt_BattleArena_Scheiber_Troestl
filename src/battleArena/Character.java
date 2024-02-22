package battleArena;

public abstract class Character {
	
	private String name;
	private int lifePoints;
	private boolean specialAbility;
	
	public Character(String name) {
		super();
		this.name = name;
		this.lifePoints = 100;
		this.specialAbility = false;
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
				+ "/n" + "Special AbilitSy: " + specialAbility;
	}
	
	/**
	 * Method to give a player some damage
	 * @param points
	 */
	public void getDamage(int points) {
		this.lifePoints = this.lifePoints - points;
		if(this.lifePoints < 0) {
			this.lifePoints = 0;
		}
	}
	
	public abstract void attack(Character enemy);
		
}
