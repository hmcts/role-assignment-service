package uk.gov.hmcts.reform.roleassignment.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.hmcts.reform.roleassignment.domain.model.enums.RequestType;
import uk.gov.hmcts.reform.roleassignment.domain.model.enums.Status;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private UUID id; //this will be generated by application while saving request entity.
    private String clientId; // this will be retrieved by app using s2s token
    private String authenticatedUserId; // this will be retrieved by app from user-token.
    private String correlationId;//If it is empty then need to be generated by app.
    private String assignerId;
    private RequestType requestType;
    private String process;
    private String reference;
    private boolean replaceExisting;
    private UUID roleAssignmentId;
    private Status status; //this will be set by app default = created
    private ZonedDateTime created; //this will be set by app
    private String log; //this will be set app based on drool validation rule name on individual assignments.
    private boolean byPassOrgDroolRule;
}
