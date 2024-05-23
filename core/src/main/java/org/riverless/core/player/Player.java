package org.riverless.core.player;

public class Player {
    private final Team team;
    private int turns;

    public Player(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }
}
