package uk.gov.hmcts.reform.roleassignment.domain.model;

import org.junit.jupiter.api.Test;
import uk.gov.hmcts.reform.roleassignment.domain.model.enums.RoleType;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoleConfigConstraintTest {


    @Test
    @SuppressWarnings("unchecked")
    void matches_when_mandatory_true_values_notnull_value_notnull_and_contain_in_values() {
        RoleConfigConstraint roleConfigConstraint =
            new RoleConfigConstraint(Boolean.TRUE,
                                     new HashSet<>(Arrays.asList(RoleType.ORGANISATION)));
        assertTrue(roleConfigConstraint.matches(RoleType.ORGANISATION));
    }

    @Test
    @SuppressWarnings("unchecked")
    void matches_when_mandatory_true_values_notnull_value_notnull_and_not_contain_in_values() {
        RoleConfigConstraint roleConfigConstraint =
            new RoleConfigConstraint(Boolean.TRUE,
                                     new HashSet<>(Arrays.asList(RoleType.ORGANISATION)));
        assertFalse(roleConfigConstraint.matches(RoleType.CASE));
        assertFalse(roleConfigConstraint.matches("test"));
    }

    @Test
    @SuppressWarnings("unchecked")
    void matches_when_mandatory_true_values_notnull_value_null() {
        RoleConfigConstraint roleConfigConstraint =
            new RoleConfigConstraint(Boolean.TRUE,
                                     new HashSet<>(Arrays.asList(RoleType.ORGANISATION)));
        assertFalse(roleConfigConstraint.matches(null));
    }

    @Test
    @SuppressWarnings("unchecked")
    void matches_when_mandatory_true_values_null_value_notnull() {
        RoleConfigConstraint roleConfigConstraint =
            new RoleConfigConstraint(Boolean.TRUE,
                                     new HashSet<>());
        assertFalse(roleConfigConstraint.matches("test"));
    }

    @Test
    @SuppressWarnings("unchecked")
    void matches_when_mandatory_true_values_null_value_null() {
        RoleConfigConstraint roleConfigConstraint =
            new RoleConfigConstraint(Boolean.TRUE,
                                     new HashSet<>());
        assertFalse(roleConfigConstraint.matches(null));
    }

    @Test
    @SuppressWarnings("unchecked")
    void matches_when_mandatory_false_values_notnull_value_notnull_and_contain_in_values() {
        RoleConfigConstraint roleConfigConstraint =
            new RoleConfigConstraint(Boolean.FALSE,
                                     new HashSet<>(Arrays.asList(RoleType.ORGANISATION)));
        assertTrue(roleConfigConstraint.matches(RoleType.ORGANISATION));
    }

    @Test
    @SuppressWarnings("unchecked")
    void matches_when_mandatory_false_values_notnull_value_notnull_and_not_contain_in_values() {
        RoleConfigConstraint roleConfigConstraint =
            new RoleConfigConstraint(Boolean.FALSE,
                                     new HashSet<>(Arrays.asList(RoleType.ORGANISATION)));
        assertFalse(roleConfigConstraint.matches(RoleType.CASE));
        assertFalse(roleConfigConstraint.matches("test"));
    }

    @Test
    @SuppressWarnings("unchecked")
    void matches_when_mandatory_false_values_notnull_value_null() {
        RoleConfigConstraint roleConfigConstraint =
            new RoleConfigConstraint(Boolean.FALSE,
                                     new HashSet<>(Arrays.asList(RoleType.ORGANISATION)));
        assertTrue(roleConfigConstraint.matches(null));
    }

    @Test
    @SuppressWarnings("unchecked")
    void matches_when_mandatory_false_values_null_value_notnull() {
        RoleConfigConstraint roleConfigConstraint =
            new RoleConfigConstraint(Boolean.FALSE,
                                     new HashSet<>());
        assertFalse(roleConfigConstraint.matches("test"));
    }

    @Test
    @SuppressWarnings("unchecked")
    void matches_when_mandatory_false_values_null_value_null() {
        RoleConfigConstraint roleConfigConstraint =
            new RoleConfigConstraint(Boolean.FALSE,
                                     new HashSet<>());
        assertTrue(roleConfigConstraint.matches(null));
    }

}
