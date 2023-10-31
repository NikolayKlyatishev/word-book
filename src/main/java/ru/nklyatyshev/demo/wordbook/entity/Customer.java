package ru.nklyatyshev.demo.wordbook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private Instant createdAt;
    private Instant updatedAt;
    @Enumerated(EnumType.STRING)
    private Role role;
}
