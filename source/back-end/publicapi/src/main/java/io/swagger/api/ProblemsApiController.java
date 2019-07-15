package io.swagger.api;

import io.swagger.model.BasicResponse;
import io.swagger.model.ProblemInfo;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-07-15T03:10:29.413Z[GMT]")
@Controller
public class ProblemsApiController implements ProblemsApi {

    private static final Logger log = LoggerFactory.getLogger(ProblemsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProblemsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<BasicResponse> addProblems(@ApiParam(value = ""  )  @Valid @RequestBody ProblemInfo body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BasicResponse>(objectMapper.readValue("{\n" +
                        "  \"status\" : \"ok\"\n" +
                        "}", BasicResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BasicResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BasicResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BasicResponse> problemsDelete(@ApiParam(value = "题库id" ,required=true) @RequestHeader(value="X-tiku-poolId", required=true) UUID xTikuPoolId,@ApiParam(value = "授权码" ,required=true) @RequestHeader(value="X-tiku-token", required=true) UUID xTikuToken,@NotNull @ApiParam(value = "待删除的问题", required = true) @Valid @RequestParam(value = "problemId", required = true) String problemId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BasicResponse>(objectMapper.readValue("{\n" +
                        "  \"status\" : \"ok\"\n" +
                        "}", BasicResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BasicResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BasicResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
