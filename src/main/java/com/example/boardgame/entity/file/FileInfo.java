package com.example.boardgame.entity.file;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="file_info")
@Getter
@Setter
public class FileInfo {
    @Id
    @Column(name = "file.id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String url;
}
