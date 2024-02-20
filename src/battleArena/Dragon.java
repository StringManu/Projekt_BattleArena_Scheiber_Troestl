package battleArena;

import java.util.concurrent.ThreadLocalRandom;

public class Dragon extends Character{

	private int attackDamage;
	
	public Dragon(String name, int lifePoints, boolean specialAbility) {
		super(name);
		this.attackDamage = ThreadLocalRandom.current().nextInt(20,25);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * Method to calculate the attack damage that will be present during the next attack
	 * @return = the next damage that will be dealed
	 */
	private int calculateAttackDamage() {
		if(this.isSpecialAbility()==true) {
			this.attackDamage = ThreadLocalRandom.current().nextInt(20,25)-calculateMalus();
			return this.attackDamage;
		} else {
			this.attackDamage = ThreadLocalRandom.current().nextInt(20,25);
			return this.attackDamage;
		}
	}
	
	/**
	 * Method to calculate the malus 
	 * @return = the current malus
	 */
	private int calculateMalus() {
		int malus = ThreadLocalRandom.current().nextInt(5,10);
		return malus;
	}
	
	/**
	 * Method to actibate the Special Ability of the Dragon
	 * The ability weakens the dragons attack but he gains 10 health points
	 */
	public void activateSpecialAbilityFly() {
		if(!this.isSpecialAbility()==true) {
			int dmg = attackDamage - calculateMalus();
			int currentLifePoints = this.getLifePoints()+10;
			this.setSpecialAbility(true);
		} else {
			System.out.println("Special ability is already active!");
		}
	}
	
	/**
	 * Method to deactivate the Special Ability of the Dragon
	 * The dragon looses the 10 health points again
	 */
	public void deactivateSpecialAbilityFly() {
		if(!this.isSpecialAbility()==true) {
			attackDamage = ThreadLocalRandom.current().nextInt(20,25);
			int currentLifePoints = this.getLifePoints()-10;
			this.setSpecialAbility(true);
		} else {
			System.out.println("Special ability is already active!");
		}
	}
	
	
	/**
	 * Method to attack the enemy
	 */
	public void attack(Character enemy) {
		enemy.getDamage(calculateAttackDamage());
	}
	
	
}
