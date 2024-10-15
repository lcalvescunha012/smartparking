package com.smartparking.controller;

import com.smartparking.dto.PagamentoDTO;
import com.smartparking.service.PagamentosService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/pagamentos")
@RequiredArgsConstructor
public class PagamentosController {

    @NonNull
    private final PagamentosService service;

    @GetMapping
    public ResponseEntity<PagedModel<PagamentoDTO>> getAllByPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(service.getAllByPagination(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
