package com.wwwgomes.food.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.wwwgomes.food.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

    List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}
