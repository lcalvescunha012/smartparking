package com.smartparking.controller;

import com.smartparking.dto.VeiculoDTO;
import com.smartparking.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/candidatos")
@RequiredArgsConstructor
public class VeiculoController {
    private final VeiculoService veiculoService;

    @Operation(description = "Retorna o perfil do candidato cadastrado.")
    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> obterPerfilCandidato(@PathVariable String placa) {
        return ResponseEntity.ok(veiculoService.buscarVeiculo(placa));
    }

    @Operation(description = "Cadastra um novo veiculo.")
    @PostMapping()
    public ResponseEntity<VeiculoDTO> cadastraVeiculo(@Valid @RequestBody VeiculoDTO veiculo){
        return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.CREATED.value())).body(veiculoService.cadastrarVeiculo(veiculo));
    }

    @Operation(description = "Atualiza as informações de um veículo cadastrado.")
    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> atualizarVeiculo(@PathVariable String placa, @RequestBody VeiculoDTO veiculo){
        return ResponseEntity.ok(veiculoService.atualizarVeiculo(placa, veiculo));
    }

    @Operation(description = "Deleta veiculo cadastrado.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable String placa){
        veiculoService.deletarVeiculo(placa);
        return ResponseEntity.noContent().build();
    }
}
