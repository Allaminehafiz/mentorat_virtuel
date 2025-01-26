package com.mentorat_virtuel.projet_mentorat_virtuel.mapper;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RdvReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RdvRespDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
public interface RdvMapper {
    RDV fromRdvReqDTO(RdvReqDTO rdvReqDTO);
    RdvRespDTO fromRdv(RDV rdv);
}
