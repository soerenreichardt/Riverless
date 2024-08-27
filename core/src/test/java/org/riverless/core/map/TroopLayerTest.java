package org.riverless.core.map;

import org.junit.jupiter.api.Test;
import org.riverless.core.actions.MoveAction;
import org.riverless.core.troops.Troop;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class TroopLayerTest {

    @Test
    void shouldComputeAllowedActions() {
        var layer = new TroopLayer(10, 10);
        var troop = new Troop();
        layer.addTroop(troop, new Position(5, 5));

        assertThat(troop.allowedActions()).containsExactlyInAnyOrder(
                new MoveAction(troop, Direction.UP),
                new MoveAction(troop, Direction.DOWN),
                new MoveAction(troop, Direction.LEFT),
                new MoveAction(troop, Direction.RIGHT)
        );
    }

    @Test
    void shouldRestrictActionsIfTroopIsNextToOtherTroop() {
        var layer = new TroopLayer(10, 10);
        var troop1 = new Troop();
        var troop2 = new Troop();
        layer.addTroop(troop1, new Position(5, 5));
        layer.addTroop(troop2, new Position(5, 6));

        assertThat(troop1.allowedActions()).containsExactlyInAnyOrder(
                new MoveAction(troop1, Direction.LEFT),
                new MoveAction(troop1, Direction.RIGHT),
                new MoveAction(troop1, Direction.UP)
        );

        assertThat(troop2.allowedActions()).containsExactlyInAnyOrder(
                new MoveAction(troop2, Direction.LEFT),
                new MoveAction(troop2, Direction.RIGHT),
                new MoveAction(troop2, Direction.DOWN)
        );
    }

    @Test
    void shouldNotListMoveActionsWhenTroopIsOnAnEdgeOfTheMap() {
        var layer = new TroopLayer(10, 10);
        var troop = new Troop();
        layer.addTroop(troop, new Position(0, 0));

        assertThat(troop.allowedActions()).containsExactlyInAnyOrder(
                new MoveAction(troop, Direction.DOWN),
                new MoveAction(troop, Direction.RIGHT)
        );
    }

    @Test
    void shouldFindTroopPositionByInstance() {
        var layer = new TroopLayer(10, 10);
        var troop = new Troop();
        layer.addTroop(troop, new Position(5, 5));

        Optional<Position> position = layer.troopPosition(troop);
        assertThat(position).isPresent();
        assertThat(position.get()).isEqualTo(new Position(5, 5));
    }
}