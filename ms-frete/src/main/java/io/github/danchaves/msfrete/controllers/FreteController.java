package io.github.danchaves.msfrete.controllers;

import io.github.danchaves.msfrete.dtos.FreteRequestDto;
import io.github.danchaves.msfrete.dtos.FreteResponseDto;
import io.github.danchaves.msfrete.service.FreteService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
        return ResponseEntity.created(URI.create("/fretes/" + responseDto.getId())).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<FreteResponseDto>> findAllPage(@RequestParam int pagina, @RequestParam int itens){
        Page<FreteResponseDto> pageResponseDto = service.findAll(pagina, itens);
        return ResponseEntity.ok(pageResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
