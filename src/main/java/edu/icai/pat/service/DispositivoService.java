package edu.icai.pat.service;

import edu.icai.pat.join.DispositivoTipo;

public interface DispositivoService {
    public Iterable<DispositivoTipo> getAllDispositivos();

    public Iterable<DispositivoTipo> getAllDispositivosTablet();

}
