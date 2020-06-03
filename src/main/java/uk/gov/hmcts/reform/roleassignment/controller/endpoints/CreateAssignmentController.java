
package uk.gov.hmcts.reform.roleassignment.controller.endpoints;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uk.gov.hmcts.reform.roleassignment.data.roleassignment.RoleAssignmentEntity;
import uk.gov.hmcts.reform.roleassignment.domain.model.RoleAssignmentRequest;
import uk.gov.hmcts.reform.roleassignment.domain.service.createroles.CreateRoleAssignmentOrchestrator;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Api(value = "roles")
@RestController
public class CreateAssignmentController {

    private CreateRoleAssignmentOrchestrator createRoleAssignmentService;

    @Autowired
    public CreateAssignmentController(CreateRoleAssignmentOrchestrator createRoleAssignmentService) {
        this.createRoleAssignmentService = createRoleAssignmentService;
    }

    //**************** Create Role Assignment  API ***************
    @PostMapping(
        path = "/role-assignment",
        produces = {"application/json"},
        consumes = {"object"}
    )
    @ApiOperation("creates a role/multiple role assignments")
    @ApiResponses({
        @ApiResponse(
            code = 201,
            message = "Created",
            response = String.class //maybe not the correct thing
        ),
        @ApiResponse(
            code = 404,
            message = "Resource Not Found"
        )
    })
    @ResponseBody //maybe not useful
    public ResponseEntity<Object> createRoleAssignment(
        @ApiParam(value = "Correlation identifier for the case document.", required = false)
        @RequestHeader(value = "correlationId", required = false) String correlationId,

        @ApiParam(value = "Correlation identifier for the case document.", required = true)
        @NotNull(message = "Provide Requestor Identification.")
        @RequestHeader(value = "requestorId") String requestorId,

        @ApiParam(value = "The logical business process requesting the resource creation.", required = true)
        @NotNull(message = "Please provide process.")
        @RequestHeader(value = "process") String process,

        @ApiParam(value = "The logical business process requesting the resource creation.", required = false)
        @RequestHeader(value = "reference") String reference,

        @ApiParam(value = "The logical business process requesting the resource creation.", required = false)
        @RequestHeader(value = "replaceExisting") Boolean replaceExisting,

        @Valid
        @NotNull(message = "Provide a role assignment body.")
        @RequestBody RoleAssignmentRequest createRolesAssignmentRequest

    ) {
        ResponseEntity<Object> responseEntity = createRoleAssignmentService.createRoleAssignment(createRolesAssignmentRequest);

        return responseEntity; //return the newly created id
    }
}
