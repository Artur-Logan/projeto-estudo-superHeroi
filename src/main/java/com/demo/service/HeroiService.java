package com.demo.service;

import com.demo.dto.HeroiRequest;
import com.demo.dto.HeroiResponse;
import com.demo.mappers.HeroiHeroiRequestMapper;
import com.demo.mappers.HeroiHeroiResponseMapper;
import com.demo.model.Heroi;
import com.demo.repositories.HeroiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroiService {

    private final HeroiRepository heroiRepository;
    private final HeroiHeroiResponseMapper heroiHeroiResponseMapper;
    private final HeroiHeroiRequestMapper heroiHeroiRequestMapper;

    public HeroiResponse salvarNovoHeroi(HeroiRequest heroiRequest) {
        Heroi heroi = heroiHeroiRequestMapper.toModels(heroiRequest);

        heroi.setDataDeCadastro(LocalDate.now());
        heroiRepository.save(heroi);

        return  heroiHeroiResponseMapper.toDto(heroi);
    }

    public List<HeroiResponse> listar(){
        List<Heroi> listaHerois = heroiRepository.findAll();

        List<HeroiResponse> listaHeroisResponse = new ArrayList<>();
        for (Heroi heroi: listaHerois){
            HeroiResponse heroiResponse = heroiHeroiResponseMapper.toDto(heroi);
            listaHeroisResponse.add(heroiResponse);
        }

        return listaHeroisResponse;
    }

    public void deletar(Long id){
        Heroi heroi = heroiRepository.getOne(id);

        heroiRepository.delete(heroi);
    }

    public HeroiResponse atualizar(HeroiRequest heroiRequest, Long id){
        Heroi heroi = heroiRepository.getOne(id);
        heroi.setNomeDoPessoal(heroi.getNomeDoPessoal());
        heroi.setNomeDoHeroi(heroiRequest.getNomeDoHeroi());
        heroi.setSuperPoder(heroiRequest.getSuperPoder());
        heroi.setIdade(heroi.getIdade());
        heroi.setEmprego(heroi.getEmprego());

        heroiRepository.save(heroi);

        return heroiHeroiResponseMapper.toDto(heroi);
    }

    public HeroiResponse obter(Long id){
        Heroi heroi = heroiRepository.getOne(id);

        return heroiHeroiResponseMapper.toDto(heroi);
    }
}
