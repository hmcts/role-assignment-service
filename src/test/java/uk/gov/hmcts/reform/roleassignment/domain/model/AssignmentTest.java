package uk.gov.hmcts.reform.roleassignment.domain.model;

import org.junit.jupiter.api.Test;
import uk.gov.hmcts.reform.roleassignment.domain.model.enums.ActorIdType;
import uk.gov.hmcts.reform.roleassignment.domain.model.enums.Classification;
import uk.gov.hmcts.reform.roleassignment.domain.model.enums.GrantType;
import uk.gov.hmcts.reform.roleassignment.domain.model.enums.RoleCategory;
import uk.gov.hmcts.reform.roleassignment.domain.model.enums.RoleType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssignmentTest {

    @Test
    void log_when_log_notnull_and_message_not_null() {
        Assignment assignment = RoleAssignment.builder()
            .actorId("1234")
            .actorIdType(ActorIdType.IDAM)
            .classification(Classification.PUBLIC)
            .grantType(GrantType.STANDARD)
            .roleCategory(RoleCategory.JUDICIAL)
            .roleType(RoleType.ORGANISATION)
            .roleName("judge")
            .build();
        assignment.log("Hello");
        assertEquals(assignment.getLog(),"Hello");
        assignment.log("RAS");
        assertEquals(assignment.getLog(),"Hello" + "\n" + "RAS");
    }
}
