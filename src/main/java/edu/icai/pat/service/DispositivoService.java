package edu.icai.pat.service;

import edu.icai.pat.model.Dispositivo;
import edu.icai.pat.model.DispositivoTipo;

public interface DispositivoService {
    public Iterable<DispositivoTipo> getAllDispositivos();

    public Iterable<DispositivoTipo> getAllDispositivosTablet();

}
