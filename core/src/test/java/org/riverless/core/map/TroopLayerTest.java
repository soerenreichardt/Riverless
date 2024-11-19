package org.riverless.core.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.riverless.core.GameContext;
import org.riverless.core.actions.MoveAction;
import org.riverless.core.actions.RecruitActionParam;
import org.riverless.core.actions.RecuitAction;
import org.riverless.core.troops.Troop;
import org.riverless.core.troops.abilities.MoveAbility;
import org.riverless.core.troops.abilities.RecruitAbility;
import org.riverless.core.troops.effects.effects.CurseEffect;
import org.riverless.core.troops.effects.effects.HealEffect;
import org.riverless.core.troops.units.UnitType;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class TroopLayerTest {

    public static final int TEST_HEALTH = 100;

    private Troop troop;
    private GameContext ctx;
    private GameMap map;

    @BeforeEach
    void setup() {
        troop = new Troop(TEST_HEALTH);
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
        var troop2 = new Troop(TEST_HEALTH);
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
    void shouldApplyEffectsToTroops() {
        var layer = map.troopLayer();
        layer.addTroop(troop, new Position(5, 5));
        var effect = new CurseEffect(100, 10);
        assertThat(troop.effects().size()).isEqualTo(0);
        troop.addEffect(effect);
        assertThat(troop.effects().size()).isEqualTo(1);
        troop.update(50);
        assertThat(troop.effects().size()).isEqualTo(1);
        assertThat(troop.health()).isEqualTo(TEST_HEALTH);
        troop.update(60);
        assertThat(troop.effects().size()).isEqualTo(0);
        assertThat(troop.health()).isEqualTo(TEST_HEALTH - 10);

        var effect2 = new HealEffect(1000,10);
        assertThat(troop.effects().size()).isEqualTo(0);
        troop.addEffect(effect2);
        assertThat(troop.effects().size()).isEqualTo(1);
        troop.update(500);
        assertThat(troop.effects().size()).isEqualTo(1);
        assertThat(troop.health()).isGreaterThan(TEST_HEALTH-10);
        troop.update(501);
        assertThat(troop.effects().size()).isEqualTo(0);
        assertThat(troop.health()).isGreaterThan(TEST_HEALTH-2);

    }



    @Test
    void shouldRecruitUnits() {
        var layer = map.troopLayer();
        layer.addTroop(troop, new Position(5, 5));

        var action = new RecuitAction(troop, new RecruitActionParam());
        action.setParam(UnitType.SOLDIER,   3);
        troop.grantAction(action);
        action.execute(ctx);
        assertThat(troop.party().size()).isEqualTo(3);
        assertThat(troop.party().get(UnitType.SOLDIER,0).type()).isNotNull();
    }

    @Test
    void shouldNotRecruitIfNoParamsAreSet() {
        var layer = map.troopLayer();
        layer.addTroop(troop, new Position(5, 5));

        var action = new RecuitAction(troop, new RecruitActionParam());
        troop.grantAction(action);
        action.execute(ctx);
        assertThat(troop.party().size()).isEqualTo(0);
    }
}