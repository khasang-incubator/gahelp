package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.LogSheet;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class LogSheetControllerIntegrationTest {

    private static final String ROOT = "http://localhost:8080/logSheet";
    private static final String GET = "/get";
    private static final String DELETE = "/delete";
    private static final String ADD = "/add";
    private static final String ALL = "/all";
    private static final String UPDATE = "/update";

    @Test
    public void checkAddLogSheet() {
        LogSheet logSheet = createLogSheet();

        RestTemplate template = new RestTemplate();
        ResponseEntity<LogSheet> entity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                LogSheet.class,
                logSheet.getId()
        );
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        LogSheet receivedLogSheet = entity.getBody();
        assertNotNull(receivedLogSheet);

    }

    @Test
    public void checkAllLogSheets() {
        createLogSheet();

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<LogSheet>> entity = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<LogSheet>>() {
                }
        );
        List<LogSheet> logSheets = entity.getBody();
        assertNotNull(logSheets);
        assertNotEquals(logSheets.size(), 0);
    }

    @Test
    public void checkDelete() {
        LogSheet newLog = createLogSheet();
        long deletingID = newLog.getId();

        RestTemplate template = new RestTemplate();
        ResponseEntity<LogSheet> entity = template.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                LogSheet.class,
                deletingID
        );
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void checkUpdate() {
        // set proper id for updating
        int updateId = 50;

        LogSheet logSheet = updatedLogSheet();
        HttpEntity<LogSheet> httpEntity = new HttpEntity<>(logSheet, null);
        RestTemplate template = new RestTemplate();
        ResponseEntity<LogSheet> entity = template.exchange(
                ROOT + UPDATE + "/{id}",
                HttpMethod.PUT,
                httpEntity,
                LogSheet.class,
                updateId
        );
        assertNotNull(Objects.requireNonNull(entity.getBody()).getItems());
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(entity.getBody().getItems(), logSheet.getItems());
    }

    private LogSheet createLogSheet() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        LogSheet logSheet = preFillLogSheet();

        HttpEntity<LogSheet> entity = new HttpEntity<>(logSheet, headers);
        RestTemplate template = new RestTemplate();
        LogSheet createdLogSheet = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                LogSheet.class).getBody();
        assertNotNull(createdLogSheet);
        assertEquals("it", createdLogSheet.getItems());
        return createdLogSheet;
    }

    private LogSheet preFillLogSheet() {
        LogSheet logSheet = new LogSheet();
        logSheet.setAlive(true);
        logSheet.setGold(0);
        logSheet.setHitPoints(100);
        logSheet.setItems("it");
        logSheet.setLevel(10);
        logSheet.setParameters(123);
        return logSheet;
    }

    private LogSheet updatedLogSheet() {
        LogSheet logSheet = new LogSheet();
        logSheet.setAlive(false);
        logSheet.setGold(110);
        logSheet.setHitPoints(0);
        logSheet.setItems("ut");
        logSheet.setLevel(15);
        logSheet.setParameters(321);
        return logSheet;
    }
}
