package org.riverless.core.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.riverless.core.GameContext;
import org.riverless.core.actions.MoveAction;
import org.riverless.core.troops.Troop;
import org.riverless.core.troops.abilities.MoveAbility;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class TroopLayerTest {

    private Troop troop;
    private GameContext ctx;
    private GameMap map;

    @BeforeEach
    void setup() {
        troop = new Troop();
        troop.addAbility(new MoveAbility());
        ctx = new GameContext();
        map = new GameMap(10, 10);
        ctx.registerResource(map);
    }

    @Test
    void shouldComputeAllowedActions() {
        var layer = map.troopLayer();
        layer.addTroop(troop, new Position(5, 5));
        layer.updateTroopActions(ctx);

        assertThat(troop.allowedActions()).containsExactlyInAnyOrder(
                new MoveAction(troop, Direction.UP),
                new MoveAction(troop, Direction.DOWN),
                new MoveAction(troop, Direction.LEFT),
                new MoveAction(troop, Direction.RIGHT)
        );
    }

    @Test
    void shouldRestrictActionsIfTroopIsNextToOtherTroop() {
        var layer = map.troopLayer();
        var troop2 = new Troop();
        troop2.addAbility(new MoveAbility());
        layer.addTroop(troop, new Position(5, 5));
        layer.addTroop(troop2, new Position(5, 6));
        layer.updateTroopActions(ctx);

        assertThat(troop.allowedActions()).containsExactlyInAnyOrder(
                new MoveAction(troop, Direction.LEFT),
                new MoveAction(troop, Direction.RIGHT),
                new MoveAction(troop, Direction.UP)
        );

        assertThat(troop2.allowedActions()).containsExactlyInAnyOrder(
                new MoveAction(troop2, Direction.LEFT),
                new MoveAction(troop2, Direction.RIGHT),
                new MoveAction(troop2, Direction.DOWN)
        );
    }

    @Test
    void shouldNotListMoveActionsWhenTroopIsOnAnEdgeOfTheMap() {
        var layer = map.troopLayer();
        layer.addTroop(troop, new Position(0, 0));
        layer.updateTroopActions(ctx);

        assertThat(troop.allowedActions()).containsExactlyInAnyOrder(
                new MoveAction(troop, Direction.DOWN),
                new MoveAction(troop, Direction.RIGHT)
        );
    }

    @Test
    void shouldFindTroopPositionByInstance() {
        var layer = map.troopLayer();
        layer.addTroop(troop, new Position(5, 5));

        Optional<Position> position = layer.troopPosition(troop);
        assertThat(position).isPresent();
        assertThat(position.get()).isEqualTo(new Position(5, 5));
    }
}