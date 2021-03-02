package com.demo.controllers;

import com.demo.dto.HeroiRequest;
import com.demo.dto.HeroiResponse;
import com.demo.model.Heroi;
import com.demo.service.HeroiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroi")
@RequiredArgsConstructor
public class HeroiController {

    private final HeroiService heroiService;

    @PostMapping
    public ResponseEntity<HeroiResponse> salvarHeroi(@RequestBody HeroiRequest heroiRequest){
        HeroiResponse heroiResponse = heroiService.salvarNovoHeroi(heroiRequest);

        return ResponseEntity.ok(heroiResponse);
    }

    @GetMapping
    public ResponseEntity<List<HeroiResponse>> listarTodosOsHerois(){
        List<HeroiResponse> heroiResponses = heroiService.listar();

        return ResponseEntity.ok(heroiResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroiResponse> buscarHeroi(@PathVariable Long id){
        HeroiResponse heroiResponse = heroiService.obter(id);

        return ResponseEntity.ok(heroiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HeroiResponse> deletarHerois(@PathVariable Long id){
        heroiService.deletar(id);

       return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HeroiResponse> atualizarHeroi(@PathVariable Long id, @RequestBody HeroiRequest heroiRequest){
        HeroiResponse heroiResponse = heroiService.atualizar(heroiRequest, id);

        return ResponseEntity.ok(heroiResponse);
    }
}