package com.example.demo.controllers;


import com.example.demo.DTO.CreateSpecimenRequest;
import com.example.demo.DTO.GeneralResponse;
import com.example.demo.DTO.UpdateSpecimenRequest;
import com.example.demo.services.SpecimenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SpecimenController {
    private SpecimenService specimenService;

    @GetMapping("/get")
    public ResponseEntity<GeneralResponse> getAll
            (@RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "5") int size,
             @RequestParam(defaultValue = "id") String sortBy,
             @RequestParam(defaultValue = "asc") String sortOrder
            ){
        return buildResponse(
                "Todos",
                HttpStatus.OK,
                specimenService.getAllSpecimens(page,size,sortBy,sortOrder)
        );

    }

    @PostMapping("/post")
    public ResponseEntity<GeneralResponse> post(@RequestBody CreateSpecimenRequest request){
        return buildResponse(
                "Todos",
                HttpStatus.OK,
                specimenService.createSpecimen(request)
        );

    }

    @GetMapping("get/{id}")
    public ResponseEntity<GeneralResponse> getSpecieID(@PathVariable UUID id){
        return buildResponse(
                "Todos",
                HttpStatus.OK,
                specimenService.getSpecimenById(id)
        );

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralResponse> deleteSpecie(@PathVariable UUID id){
        return buildResponse(
                "Todos",
                HttpStatus.OK,
                specimenService.deleteSpecimen(id)
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GeneralResponse> updateProduct(@PathVariable UUID id, @RequestBody UpdateSpecimenRequest data){
        return buildResponse(
                "Todos",
                HttpStatus.OK,
                specimenService.updateSpecimen(id, data)
        );
    }


    public ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity
                .status(status)
                .body(GeneralResponse.builder()
                        .uri(uri)
                        .message(message)
                        .status(status.value())
                        .time(LocalDateTime.now())
                        .data(data)
                        .build()
                );
    }


}
