package org.riverless.core.troops.abilities;

import org.riverless.core.GameContext;
import org.riverless.core.actions.Action;
import org.riverless.core.troops.Troop;

import java.util.List;

public interface Ability {
    List<Action> computePossibleActions(Troop troop, GameContext ctx);
}
