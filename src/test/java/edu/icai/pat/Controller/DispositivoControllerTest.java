package edu.icai.pat.Controller;

import edu.icai.pat.join.DispositivoTipo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DispositivoControllerTest {
    @Autowired
    private JdbcTemplate template;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void getDevicesOK() {
        String query = "SELECT * FROM DISPOSITIVO INNER JOIN TIPO ON DISPOSITIVO.TIPO_ID = TIPO.TIPO_ID";

        Iterable<DispositivoTipo> dispositivoTipos = template.query(
                query,
                (data, rowNum) -> {
                    return new DispositivoTipo(
                            data.getLong("DISPOSITIVO.DISPOSITIVO_ID"),
                            data.getString("DISPOSITIVO.DISPOSITIVO"),
                            data.getString("TIPO.TIPO")
                    );
                }
        );

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/devices";

        ResponseEntity<Iterable<DispositivoTipo>> result = testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(dispositivoTipos);
    }

    @Test
    public void getDevicesTabletOK() {
        String query = "SELECT * FROM DISPOSITIVO INNER JOIN TIPO ON DISPOSITIVO.TIPO_ID = TIPO.TIPO_ID  WHERE TIPO.TIPO_ID = 3";

        Iterable<DispositivoTipo> dispositivoTipos = template.query(
                query,
                (data, rowNum) -> {
                    return new DispositivoTipo(
                            data.getLong("DISPOSITIVO.DISPOSITIVO_ID"),
                            data.getString("DISPOSITIVO.DISPOSITIVO"),
                            data.getString("TIPO.TIPO")
                    );
                }
        );

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/devices/tablet";

        ResponseEntity<Iterable<DispositivoTipo>> result = testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(dispositivoTipos);
    }

}
