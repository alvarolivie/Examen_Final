package edu.icai.pat.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Dispositivo {
    @Id
    private Long dispositivoId;
    private String dispositivo;
    private String description;
    private Long tipoId;
    private Long sku;
}
