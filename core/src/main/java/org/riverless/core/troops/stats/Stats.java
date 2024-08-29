package org.riverless.core.troops.stats;



public class Stats {

    private final int maxHealth;

    private int health;
    private int damage;

    private boolean movable;

    public Stats(int maxHealth, boolean movable) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.movable = movable;
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

    public boolean isMovable() {
        return movable;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }



}
