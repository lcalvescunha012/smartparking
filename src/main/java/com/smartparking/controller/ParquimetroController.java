package com.smartparking.controller;

import com.smartparking.dto.ParquimetroDTO;
import com.smartparking.service.ParquimetroService;
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
@RequestMapping("/v1/api/parquimetro")
@RequiredArgsConstructor
public class ParquimetroController {
    @NonNull
    private ParquimetroService parquimetroService;

    @Operation(description = "Retorna a lista de todos os parquimetros cadastrados.")
    @GetMapping
    public ResponseEntity<Collection<ParquimetroDTO>> findAll() {
        return ResponseEntity.ok(parquimetroService.findAll());
    }

    @Operation(description = "Retorna um parquimetro cadastrado pelo id.")
    @GetMapping("/{id}")
    public ResponseEntity<ParquimetroDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(parquimetroService.findById(id));
    }

    @Operation(description = "Cadastra um novo parquimetro.")
    @PostMapping
    public ResponseEntity<ParquimetroDTO> save(@Valid @RequestBody ParquimetroDTO parquimetroDTO) {
        return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.CREATED.value())).body(parquimetroService.save(parquimetroDTO));
    }

    @Operation(description = "Atualiza um parquimetro cadastrado.")
    @PutMapping("/{id}")
    public ResponseEntity<ParquimetroDTO> update(@PathVariable String id, @Valid @RequestBody ParquimetroDTO parquimetroDTO) {
        return ResponseEntity.ok(parquimetroService.update(id, parquimetroDTO));
    }

    @Operation(description = "Apaga um parquimetro cadastrado pelo id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        parquimetroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
