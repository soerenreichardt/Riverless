package org.riverless.core.troops.stats;



public class Stats {

    private final int maxHealth;

    private int health;
    private int damage;

    private boolean moveable;


    public Stats(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public int health() {
        return health;
    }

    public int damage() {
        return damage;
    }

    public int maxHealth() {
        return maxHealth;
    }

    public boolean isMoveable() {
        return moveable;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }



}
