package com.example.testamarisentrevista.zara.repository;

import com.example.testamarisentrevista.zara.entity.Cadena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadenaRepository extends JpaRepository<Cadena, Integer> {
}
