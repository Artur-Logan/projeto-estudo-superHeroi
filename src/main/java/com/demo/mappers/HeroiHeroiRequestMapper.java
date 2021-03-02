package com.demo.mappers;

import com.demo.dto.HeroiRequest;
import com.demo.model.Heroi;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HeroiHeroiRequestMapper {
    HeroiRequest toDto(Heroi heroi);
    Heroi toModels(HeroiRequest heroiRequest);
}
