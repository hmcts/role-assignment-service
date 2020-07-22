package uk.gov.hmcts.reform.roleassignment.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.nio.charset.Charset;
import java.util.HashMap;

@ActiveProfiles("integrationTest")
@RunWith(SpringIntegrationSerenityRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseTest {
    protected static final ObjectMapper mapper = new ObjectMapper();
    protected static final TypeReference STRING_NODE_TYPE = new TypeReference<HashMap<String, JsonNode>>() {};

    protected static final MediaType JSON_CONTENT_TYPE = new MediaType(
        MediaType.APPLICATION_JSON.getType(),
        MediaType.APPLICATION_JSON.getSubtype(),
        Charset.forName("utf8"));


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Inject
    protected DataSource db;


    @BeforeClass
    public static void init() {
        mapper.registerModule(new JavaTimeModule());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // Force re-initialisation of base types for each test suite
    }
}
