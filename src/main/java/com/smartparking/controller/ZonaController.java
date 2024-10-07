package com.smartparking.controller;

import com.smartparking.dto.ZonaDTO;
import com.smartparking.service.ZonaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/api/zona")
@RequiredArgsConstructor
public class ZonaController {

    @NonNull
    private ZonaService zonaService;

    @Operation(description = "Retorna a lista de todas as zonas cadastradas.")
    @GetMapping
    public ResponseEntity<Collection<ZonaDTO>> findAll() {
        return ResponseEntity.ok(zonaService.finaAll());
    }

    @Operation(description = "Retorna a zona cadastrada.")
    @GetMapping("/{id}")
    public ResponseEntity<ZonaDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(zonaService.findById(id));
    }

    @Operation(description = "Cadastre uma nova zona.")
    @PostMapping
    public ResponseEntity<ZonaDTO> save(@Valid @RequestBody ZonaDTO zonaDTO) {
        return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.CREATED.value())).body(zonaService.save(zonaDTO));
    }

    @Operation(description = "Atualize a zona cadastrada.")
    @PutMapping("/{id}")
    public ResponseEntity<ZonaDTO> update(@PathVariable String id, @Valid @RequestBody ZonaDTO zonaDTO) {
        return ResponseEntity.ok(zonaService.update(id, zonaDTO));
    }

    @Operation(description = "Apaga a zona cadastrada.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        zonaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
