package battleArena;

import java.util.concurrent.ThreadLocalRandom;

public class Dwarf extends Character{

	private int attackDamage;
	
	public Dwarf(String name) {
		super(name);
		this.attackDamage = ThreadLocalRandom.current().nextInt(15,25);
	}
	
	public int getAttackDamage() {
		return attackDamage;
	}
	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}
	
	/**
	 * The Methode calculates the attack Damage for the special Ability
	 * and the normal attack Damage
	 * @return the attack Damage
	 */
	private int calculateAttackDamage() {
		if(this.isSpecialAbility()==false) {
		this.attackDamage=ThreadLocalRandom.current().nextInt(15,25);
		return this.attackDamage;
		} else {
			if(calculateProbabilityForSpecialAttack()) {
				this.attackDamage=ThreadLocalRandom.current().nextInt(15,25)*2;
				return this.attackDamage;
			} else {
				this.attackDamage=ThreadLocalRandom.current().nextInt(15,25)/2;
				return this.attackDamage;
			}
		}
	}

	/**
	 * the method calculates if the special Ability works or fails
	 * @return if it works or fails
	 */
	private boolean calculateProbabilityForSpecialAttack() {
		if(this.getLifePoints()<=10 && ThreadLocalRandom.current().nextInt(1,10)<8) {
			return true;
		} else {
			if(this.getLifePoints()<=20 && ThreadLocalRandom.current().nextInt(1,10)<6) {
				return true;
			} else {
				if(this.getLifePoints()<=50 && ThreadLocalRandom.current().nextInt(1,10)<4) {
					return true;
				}
			}
		} return false;
	}
	
	/**
	 * the method takes away the life points the attack does
	 */
	public void attack(Character enemy) {
		enemy.getDamage(calculateAttackDamage());
	}
	
	/**
	 * the method activates the special Ability
	 */
	public void acttivateSpecialAbilityHeadbutt() {
		if(this.isSpecialAbility()==false) {
			this.setSpecialAbility(true);
		}
	}
	
	/**
	 * the method deactivates the special Ability
	 */
	public void deacttivateSpecialAbilityHeadbutt() {
		if(this.isSpecialAbility()==true) {
			this.setSpecialAbility(false);
		}
	}
	
}
