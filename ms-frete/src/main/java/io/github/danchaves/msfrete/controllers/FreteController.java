package io.github.danchaves.msfrete.controllers;

import io.github.danchaves.msfrete.dtos.FreteRequestDto;
import io.github.danchaves.msfrete.dtos.FreteResponseDto;
import io.github.danchaves.msfrete.service.FreteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fretes")
public class FreteController {

    private final FreteService service;

    public FreteController(FreteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FreteResponseDto> insert(@RequestBody FreteRequestDto requestDto){
        FreteResponseDto responseDto = service.insert(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
