package org.riverless.core.troops.stats;



public class Stats {

    private final float maxHealth;

    private float health;
    private float damage;

    private boolean movable;

    public Stats(int maxHealth, boolean movable) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.movable = movable;
    }

    public float health() {
        return health;
    }

    public float damage() {
        return damage;
    }

    public float maxHealth() {
        return maxHealth;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }



}
