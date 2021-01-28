package uk.gov.hmcts.reform.roleassignment.domain.service.queryroles;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uk.gov.hmcts.reform.roleassignment.domain.model.Assignment;
import uk.gov.hmcts.reform.roleassignment.domain.model.QueryRequest;
import uk.gov.hmcts.reform.roleassignment.domain.model.RoleAssignmentResource;
import uk.gov.hmcts.reform.roleassignment.domain.service.common.PersistenceService;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class QueryRoleAssignmentOrchestrator {

    private final PersistenceService persistenceService;


    public  ResponseEntity<RoleAssignmentResource> retrieveRoleAssignmentsByQueryRequest(QueryRequest queryRequest,
                                                                                   Integer pageNumber,
                                                                        Integer size, String sort, String direction) {

        long startTime = System.currentTimeMillis();

        List<Assignment> assignmentList =
            persistenceService.retrieveRoleAssignmentsByQueryRequest(
                queryRequest,
                pageNumber,
                size,
                sort,
                direction,
                false
            );
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(
            "Total-Records",
            Long.toString(persistenceService.getTotalRecords())
        );
        log.info(">> Execution time of retrieveRoleAssignmentsByQueryRequest() : {} ms",
                 ((Math.subtractExact(System.currentTimeMillis(),startTime)))
        );
        return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(
            new RoleAssignmentResource(assignmentList));

    }
}
