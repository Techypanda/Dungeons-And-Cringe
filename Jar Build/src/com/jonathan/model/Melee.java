package com.jonathan.model;

import java.util.Random;

/**
 * Purpose: Melee Weapon implementation
 * Author: Jonathan Wright
 * Date: 23/05/2020
 */
public class Melee extends Item implements Weapon {
    private String damageType;
    private String weaponType;

    /**
     * Alternate constructor for melee.
     * @param inName name of melee
     * @param inCost cost of melee
     * @param inMinEffect min effect of melee
     * @param inMaxEffect max effect of melee
     * @param damageType damage type of melee
     * @param weaponType type of weapon of melee
     */
    public Melee(String inName, int inCost, int inMinEffect, int inMaxEffect, String damageType, String weaponType) {
        super(inName, inCost, inMinEffect, inMaxEffect);
        this.damageType = damageType;
        this.weaponType = weaponType;
    }

    /**
     * Copy construcot for melee
     * @param inWeapon weapon to copy.
     */
    public Melee(Melee inWeapon) {
        super(inWeapon.getName(), inWeapon.getCost(), inWeapon.getMin(), inWeapon.getMax());
        damageType = inWeapon.damageType;
        weaponType = inWeapon.weaponType;
    }

    /**
     * String detailing the weapon.
     * @return a string detailing the weapon.
     */
    @Override
    public String toString() {
        return String.format("%s, Weapon Type: %s, Damage Type: %s, Cost: %d, Damage: %d - %d, Enchantments: ", name, weaponType, damageType, cost,
        minimumEffect, maxEffect);
    }

    /**
     * Calculates the effect of the melee.
     * @return the calculated effect of the melee.
     */
    @Override
    public int getEffect() {
        Random rand = new Random();
        return rand.nextInt((maxEffect - minimumEffect) + 1) + minimumEffect;
    }

    /**
     * Decorators append to this, it returns "" for melee, this will after running through each decorator return each
     * enchantment's name.
     * @return appended string or ""
     */
    @Override
    public String getEnchantments() {
        return ""; /* The Decorators will append to this. */
    }

    /**
     * Compare two objects
     * @param inObject object to compare to
     * @return whether objects are equal or not.
     */
    @Override
    public boolean equals(Object inObject) {
        boolean isEquals = false;
        if (inObject instanceof Melee) {
            Melee inMelee = (Melee)inObject;
            if (inMelee.damageType.toUpperCase().equals(this.damageType.toUpperCase()))
                if (this.maxEffect == inMelee.maxEffect)
                    if (this.minimumEffect == inMelee.minimumEffect)
                        if (this.name.toUpperCase().equals(inMelee.name.toUpperCase()))
                            if (this.cost == inMelee.cost)
                                isEquals = true;
        }
        return isEquals;
    }

    /**
     * Returns the damage type
     * @return damagetype string
     */
    @Override
    public String getDamageType() {
        return this.damageType;
    }

    /**
     * name getter.
     * @return the name of melee.
     */
    @Override
    public String getMeleeTitle() {
        return this.name;
    }
}
