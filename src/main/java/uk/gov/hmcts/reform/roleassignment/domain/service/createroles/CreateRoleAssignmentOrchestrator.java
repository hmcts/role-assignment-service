package uk.gov.hmcts.reform.roleassignment.domain.service.createroles;

import org.springframework.stereotype.Service;
import uk.gov.hmcts.reform.roleassignment.domain.model.RequestedRole;
import uk.gov.hmcts.reform.roleassignment.domain.model.AssignmentRequest;
import uk.gov.hmcts.reform.roleassignment.domain.model.enums.Status;
import uk.gov.hmcts.reform.roleassignment.domain.service.common.RetrieveDataService;
import uk.gov.hmcts.reform.roleassignment.domain.service.security.IdamRoleService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CreateRoleAssignmentOrchestrator {

    //1. call parse request service
    //2. Call persistence service to store the created records
    //3. Call retrieve Data service to fetch all required objects
    //4. Call Validation model service to create aggregation objects and apply drools validation rule
    //5. For Each: If success then call persistence service to update assignment record status
    //6. once all the assignment records are approved call persistence to update request status
    //7. Call persistence to move assignment records to Live status
    //8. Call the persistence to copy assignment records to RoleAssignmentLive table


    private IdamRoleService idamService;
    private RetrieveDataService retrieveDataService;


    public CreateRoleAssignmentOrchestrator(IdamRoleService idamService,
                                            RetrieveDataService retrieveDataService) {

        this.idamService = idamService;
        this.retrieveDataService = retrieveDataService;
    }


    public void addExistingRoleAssignments(AssignmentRequest assignmentRequest, List<Object> facts) throws Exception {
        Set<String> actorIds = new HashSet<>();
        actorIds.add(assignmentRequest.request.requestorId);
        actorIds.add(assignmentRequest.request.authenticatedUserId);
        for (RequestedRole requestedRole : assignmentRequest.requestedRoles) {
            actorIds.add(requestedRole.actorId.toString());
        }
        for (String actorId : actorIds) {
            facts.addAll(retrieveDataService.getRoleAssignmentsForActor(actorId));
            facts.addAll(idamService.getIdamRoleAssignmentsForActor(actorId));
        }
    }

    public void updateRequestStatus(AssignmentRequest assignmentRequest) {
        assignmentRequest.request.status = Status.APPROVED;
        for (RequestedRole requestedRole : assignmentRequest.requestedRoles) {
            if (!requestedRole.isApproved()) {
                assignmentRequest.request.status = Status.REJECTED;
            }
        }
    }

}
