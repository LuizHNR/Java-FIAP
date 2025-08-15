package br.com.fiap.api_rest.controller;

import br.com.fiap.api_rest.dto.FilialRequest;
import br.com.fiap.api_rest.dto.FilialResponse;
import br.com.fiap.api_rest.service.FilialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filial")
public class FilialController {
    @Autowired
    FilialService filialService;

    @PostMapping
    public ResponseEntity<FilialResponse> create(@Valid @RequestBody FilialRequest filialRequest) {
        return new ResponseEntity<>(filialService.create(filialRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FilialResponse>> findAll() {
        return new ResponseEntity<>(filialService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilialResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(filialService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilialResponse> update(@PathVariable Long id, @Valid @RequestBody FilialRequest filialRequest) {
        FilialResponse filialResponse = filialService.update(id, filialRequest);
        if (filialResponse == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(filialResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (filialService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
