package org.riverless.core.actions;

import org.junit.jupiter.api.Test;
import org.riverless.core.actions.blueprint.ParameterValidationException;
import org.riverless.core.troops.units.UnitType;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RecruitActionTest {

    @Test
    void shouldNotAllowEmptyAmount() {
        assertThatThrownBy(new RecruitAction.RecruitRequest(UnitType.ARCHER, 0)::validate)
                .isInstanceOf(ParameterValidationException.class)
                .hasMessageContaining("must be greater than 0");
    }
}