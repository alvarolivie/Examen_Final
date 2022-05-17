package edu.icai.pat.controller;

import edu.icai.pat.join.DispositivoTipo;
import edu.icai.pat.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping("/devices")
    public ResponseEntity<Iterable<DispositivoTipo>> getDispositivos(){
        return ResponseEntity.ok().body(dispositivoService.getAllDispositivos());
    }
    @GetMapping("/devices/tablet")
    public ResponseEntity<Iterable<DispositivoTipo>> getDispositivosTablet(){
        return ResponseEntity.ok().body(dispositivoService.getAllDispositivosTablet());
    }
}
