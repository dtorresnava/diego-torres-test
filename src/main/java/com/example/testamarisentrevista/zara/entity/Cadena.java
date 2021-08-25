package com.example.testamarisentrevista.zara.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@ToString
@Setter
@Getter
public class Cadena implements Serializable {
    @Id
    private Integer id;
    private String name;
    private String description;
}
