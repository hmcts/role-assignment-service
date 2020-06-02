package uk.gov.hmcts.reform.roleassignment.domain.service.common;

import org.springframework.stereotype.Service;
import uk.gov.hmcts.reform.roleassignment.domain.model.ExistingRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RetrieveSupportingDataService {

    private Map<String, List<ExistingRole>> existingRolesByActorId = new HashMap<>();

    //Fetch all existing roles from  database

    public Collection<ExistingRole> getRoleAssignmentsForActor(String actorId) {
        List<ExistingRole> existingRolesForActor = existingRolesByActorId.get(actorId);
        return existingRolesForActor == null ? new ArrayList<>() : existingRolesForActor;
    }
}
