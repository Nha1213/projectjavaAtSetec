package com.example.projectjava.Controller;

import com.example.projectjava.DTO.CardResponse;
import com.example.projectjava.Repository.CardRepository;
import com.example.projectjava.Service.CardService;
import com.example.projectjava.response.PaginationResponse;
import com.example.projectjava.util.ApiResponseUtil;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/card/v-3")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;


    @GetMapping
    public ResponseEntity<PaginationResponse<List<CardResponse>>> list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") @Min(1) @Max(100) Integer size,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction
    ) {
        return ResponseEntity.ok(ApiResponseUtil.pagination(HttpStatus.OK, cardService.list(page, size, direction)));
    }
}
