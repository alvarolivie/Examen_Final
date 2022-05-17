package edu.icai.pat.join;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DispositivoTipo {
    private Long dispositivoId;
    private String dispositivo;
    private String tipo;

}
