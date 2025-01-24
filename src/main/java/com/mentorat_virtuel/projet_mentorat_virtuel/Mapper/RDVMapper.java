package com.mentorat_virtuel.projet_mentorat_virtuel.Mapper;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RDVReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.RDVResDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface RDVMapper {

    RDV fromRDVReqDTO(RDVReqDTO rdvReqDTO);
    RDVResDTO fromRDV(RDV rdv);
}
