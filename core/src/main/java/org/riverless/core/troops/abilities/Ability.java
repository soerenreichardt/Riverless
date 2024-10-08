package org.riverless.core.troops.abilities;

import org.riverless.core.GameContext;
import org.riverless.core.actions.Action;
import org.riverless.core.troops.Troop;

import java.util.List;

/**
 * Defines an ability that a troop can inherit.
 */
public interface Ability {
    AbilityType type();

    /**
     * Compute the possible actions that a troop can perform in the current state of the game.
     */
    List<Action> computePossibleActions(Troop troop, GameContext ctx);
}
