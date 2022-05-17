package edu.icai.pat.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Tipo {
    @Id
    private Long tipoId;
    private String tipo;
    private String description;
}

