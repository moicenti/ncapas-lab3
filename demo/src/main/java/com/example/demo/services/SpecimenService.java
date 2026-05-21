package com.example.demo.services;

import com.example.demo.DTO.CreateSpecimenRequest;
import com.example.demo.DTO.PageableResponse;
import com.example.demo.DTO.SpecimenResponse;
import com.example.demo.DTO.UpdateSpecimenRequest;
import com.example.demo.model.Specimen;

import java.util.List;
import java.util.UUID;

public interface SpecimenService {

    SpecimenResponse createSpecimen(CreateSpecimenRequest request);
    PageableResponse<SpecimenResponse> getAllSpecimens(int page, int size, String sortBy, String sortOrder);
    SpecimenResponse getSpecimenById(UUID id);
    SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);
    SpecimenResponse deleteSpecimen(UUID id);

}
