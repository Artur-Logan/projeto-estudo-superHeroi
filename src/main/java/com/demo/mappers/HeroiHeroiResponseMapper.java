package com.demo.mappers;

import com.demo.dto.HeroiResponse;
import com.demo.model.Heroi;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HeroiHeroiResponseMapper {
    HeroiResponse toDto(Heroi heroi);
    Heroi toModel(HeroiResponse heroiResponse);
}
