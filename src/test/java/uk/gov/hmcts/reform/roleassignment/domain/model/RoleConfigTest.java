package uk.gov.hmcts.reform.roleassignment.domain.model;

import org.junit.jupiter.api.Test;
import uk.gov.hmcts.reform.roleassignment.domain.model.enums.RoleCategory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoleConfigTest {

    @Test
    void valid_role_pattern_role_name_and_role_category() {
        RoleConfig roleConfig = RoleConfig.getRoleConfig();
        RoleConfigRole roleConfigRole = roleConfig.get("judge");
        assertTrue(roleConfigRole.getPatterns().stream().findFirst().get().getRoleCategory() == RoleCategory.JUDICIAL);
        assertTrue(roleConfigRole.getPatterns().stream().findFirst().get().getRoleName().equals("judge"));
    }

    @Test
    void invalid_role_name_and_role_category() {
        RoleConfig roleConfig = RoleConfig.getRoleConfig();
        RoleConfigRole roleConfigRole = roleConfig.get("judge");
        assertFalse(roleConfigRole.getPatterns().stream().findFirst().get().getRoleCategory() == RoleCategory.STAFF);
        assertFalse(roleConfigRole.getPatterns().stream().findFirst().get().getRoleName().equals("judge1"));
    }

    @Test
    void getRoleConfig() {
        RoleConfig roleConfig = RoleConfig.getRoleConfig();
        //RoleConfigRole roleConfigRole = roleConfig.get("judge1");
        assertTrue(roleConfig.get("judge1") == null);
    }
}
