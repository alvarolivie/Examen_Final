package edu.icai.pat.Controller;

import edu.icai.pat.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void getTestOK() {

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/products/";

        ResponseEntity<Iterable<Product>> result = testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(List.of(
                new Product(1L, "Fibra + Móvil + TV", "La ventaja de tenerlo todo en una tarifa"),
                new Product(2L, "Solo Fibra", "Fibra a toda velocidad"),
                new Product(2L, "Solo Móvil", "Habla y navega sin fin en tu móvil")
        ));
    }
}
