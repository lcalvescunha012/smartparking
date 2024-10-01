package com.smartparking.controller;

import com.smartparking.dto.PagamentosDTO;
import com.smartparking.service.PagamentosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/v1/api/pagamentos")
@RequiredArgsConstructor
public class PagamentosController {

    private final PagamentosService service;

    @GetMapping
    public ResponseEntity<Page<PagamentosDTO>> getAllByPagination(
            @RequestParam(defaultValue = "0")  int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(service.getAllByPagination(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentosDTO> findById(
        @PathVariable ObjectId id
    ){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PagamentosDTO> save(@Valid @RequestBody PagamentosDTO requestBody) throws URISyntaxException {
        var response = service.save(requestBody);
        var path = "/v1/api/pagamentos/" + response.id();
        return ResponseEntity.created(new URI(path)).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentosDTO> update(@PathVariable ObjectId id, @Valid @RequestBody PagamentosDTO requestBody) {
        return ResponseEntity.ok(service.update(id, requestBody));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ObjectId id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        service.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
