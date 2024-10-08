package com.smartparking.controller;

import com.smartparking.dto.RegistroDTO;
import com.smartparking.dto.RegistroPutAndPostDTO;
import com.smartparking.service.RegistroService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/api/registro")
@RequiredArgsConstructor
public class RegistroController {

    @NonNull
    private RegistroService registroService;

    @Operation(description = "Retorna a lista de todos os registros de estacionamento.")
    @GetMapping
    public ResponseEntity<Collection<RegistroDTO>> findAll() {
        return ResponseEntity.ok(registroService.findAll());
    }

    @Operation(description = "Retorna o registro de estacionamento pelo ID.")
    @GetMapping("/{id}")
    public ResponseEntity<RegistroDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(registroService.findById(id));
    }

    @Operation(description = "Cria um novo registro de estacionamento.")
    @PostMapping
    public ResponseEntity<RegistroDTO> iniciarFluxoDeRegistro(@Valid @RequestBody RegistroPutAndPostDTO registroDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registroService.iniciarFluxoDeRegistro(registroDTO));
    }

    @Operation(description = "Atualiza o registro de estacionamento pelo ID.")
    @PutMapping("/{id}")
    public ResponseEntity<RegistroDTO> efetuarPagamento(@PathVariable String id, @Valid @RequestBody RegistroPutAndPostDTO registroDTO) {
        return ResponseEntity.ok(registroService.efetuarPagamento(id, registroDTO));
    }

    @Operation(description = "Exclui o registro de estacionamento pelo ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        registroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
