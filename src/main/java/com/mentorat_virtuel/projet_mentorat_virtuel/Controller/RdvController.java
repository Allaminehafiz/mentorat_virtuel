package com.mentorat_virtuel.projet_mentorat_virtuel.Controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import com.mentorat_virtuel.projet_mentorat_virtuel.Service.RdvService;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RdvReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RdvRespDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RdvController {
    private final RdvService rdvService;

    public RdvController(RdvService rdvService) {
        this.rdvService = rdvService;
    }
    @PostMapping(path = "rdv/add")
    @ResponseBody
    public ResponseEntity<RdvRespDTO> addRdv(@RequestBody RdvReqDTO rdvReqDTO){

        RdvRespDTO rdvRespDTO = this.rdvService.addRdv(rdvReqDTO);
        return new ResponseEntity<>(rdvRespDTO, HttpStatus.CREATED);
    }
}
