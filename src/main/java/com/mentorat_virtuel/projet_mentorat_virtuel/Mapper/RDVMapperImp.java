package com.mentorat_virtuel.projet_mentorat_virtuel.Mapper;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.EtatRdv;
import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RDVReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RDVResDTO;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2024-12-21T11:51:15+0100",
        comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)

@Component
public class RDVMapperImp implements RDVMapper {


    @Override
    public RDV fromRDVReqDTO(RDVReqDTO rdvReqDTO) {
        if (rdvReqDTO == null) {
            return null;
        }
        RDV rdv = new RDV();
      //  rdv.setDebutduRDV(rdvReqDTO.getDebutduRDV());
        //rdv.setDebutduRDV(rdvReqDTO.getDebutduRDV());
        //rdv.setVisioconference(rdvReqDTO.getVisioconference());
        //rdv.setDuree(rdvReqDTO.getDuree());
        return rdv;

    }
    @Override
    public RDVResDTO fromRDV(RDV rdv){
        if (rdv==null){
            return null;
        }

        String debutduRDV=null;
        String visioconference=null;
        String duree=null;
        EtatRdv etatRdv=null;


RDVResDTO rdvResDTO=new RDVResDTO(debutduRDV,visioconference,etatRdv,duree);
    return rdvResDTO;
    }

    }
