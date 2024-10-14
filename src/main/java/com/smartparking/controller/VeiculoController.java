package com.smartparking.controller;

import com.smartparking.dto.VeiculoDTO;
import com.smartparking.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/veiculo")
@RequiredArgsConstructor
public class VeiculoController {

    @NonNull
    private final VeiculoService veiculoService;

    @Operation(description = "Retorna veículo cadastrado.")
    @GetMapping("/{placa}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable String placa) {
        return ResponseEntity.ok(veiculoService.findById(placa));
    }

    @Operation(description = "Cadastra um novo veiculo.")
    @PostMapping()
    public ResponseEntity<VeiculoDTO> save(@Valid @RequestBody VeiculoDTO veiculoDTO){
        return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.CREATED.value())).body(veiculoService.save(veiculoDTO));
    }

    @Operation(description = "Atualiza as informações de um veículo cadastrado.")
    @PutMapping("/{placa}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable String placa, @RequestBody VeiculoDTO veiculo){
        return ResponseEntity.ok(veiculoService.update(placa, veiculo));
    }

    @Operation(description = "Deleta veiculo cadastrado.")
    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> delete(@PathVariable String placa){
        veiculoService.delete(placa);
        return ResponseEntity.noContent().build();
    }
}
