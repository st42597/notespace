package com.example.server.note.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Note extends Date{
    @Id
    private String slug;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;
}
