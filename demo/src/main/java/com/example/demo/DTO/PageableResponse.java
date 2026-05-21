package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageableResponse<T> {
    private List<T> content;
    private int page;
    private int size;
    private String sortBy;
    private String sortOrder;
}