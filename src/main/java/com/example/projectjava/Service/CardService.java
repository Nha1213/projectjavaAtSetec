package com.example.projectjava.Service;

import com.example.projectjava.DTO.CardResponse;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public interface CardService {
    Page<CardResponse> list(Integer page, @Min(1) @Max(100) Integer size, Sort.Direction direction);
}
