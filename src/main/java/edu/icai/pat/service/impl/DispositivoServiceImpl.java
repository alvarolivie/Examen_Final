package edu.icai.pat.service.impl;

import edu.icai.pat.join.DispositivoTipo;
import edu.icai.pat.repository.DispositivoRepo;
import edu.icai.pat.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DispositivoServiceImpl implements DispositivoService {
    @Autowired
    private DispositivoRepo dispositivoRepo;

    @Autowired
    private JdbcTemplate template;

    @Override
    public Iterable<DispositivoTipo> getAllDispositivos() {
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
        return dispositivoTipos;
    }

    @Override
    public Iterable<DispositivoTipo> getAllDispositivosTablet() {
        String query = "SELECT * FROM DISPOSITIVO INNER JOIN TIPO ON DISPOSITIVO.TIPO_ID = TIPO.TIPO_ID WHERE TIPO.TIPO_ID = 3";

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
        return dispositivoTipos;
    }
}
