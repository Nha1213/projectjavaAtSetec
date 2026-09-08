package com.example.projectjava.Service.Implement;

import com.example.projectjava.DTO.CardResponse;
import com.example.projectjava.Model.Card;
import com.example.projectjava.Repository.CardRepository;
import com.example.projectjava.Service.CardService;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CardServiceImpl implements CardService {

    private  final CardRepository cardRepository;



    @Override
    public Page<CardResponse> list(Integer page, Integer size, Sort.Direction direction) {
        PageRequest pageable = PageRequest.of(page - 1, size, Sort.by(direction, "id"));
        return cardRepository.findAll((root, query, cb)->{
            List<Predicate>  predicates = new ArrayList<>();
           return cb.and(predicates.toArray(new Predicate[0]));
        }, pageable).map(Card::toResponse);
    }
}
