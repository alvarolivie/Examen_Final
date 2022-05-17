package edu.icai.pat.controller;

import edu.icai.pat.model.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping(
            path = "/api/v1/products/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok().body(
                List.of(
                    new Product(1L, "Fibra + Móvil + TV", "La ventaja de tenerlo todo en una tarifa"),
                    new Product(2L, "Solo Fibra", "Fibra a toda velocidad"),
                    new Product(2L, "Solo Móvil", "Habla y navega sin fin en tu móvil")
                ));
    }

}
