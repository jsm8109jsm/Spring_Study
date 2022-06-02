package com.example.boardgame.entity;

import com.example.boardgame.entity.file.FileInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="board")
@Getter
@Setter

public class Board {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //게임이름
    @Column(nullable = false, length = 200)
    private String name;
    //유통사
    @Column(nullable = false, length = 200)
    private String distributor;
    //가격
    @Column(nullable = false)
    private int price;
    //최소인원
    @Column(nullable = false)
    private int min_person;
    //최대인원
    @Column(nullable = false)
    private int max_person;
    //추천인원
    @Column(nullable = false)
    private int recommend_person;
    //추천연령
    @Column(nullable = false)
    private int recommend_age;
    //게임난이도
    @Column(nullable = false)
    private float level;
    //플레이최소시간(분)
    @Column(nullable = false)
    private float play_time;
    //플레이최대시간(분)
    @Column(nullable = false)
    private int play_max_time;
    //성별
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "enum('ALL', 'FEMALE','MAEL')")
    private Sex sex;
    //멘트
    @Column
    private String ment;
    //설명시간(분)
    @Column(nullable = false)
    private int explain_time;
    //설명
    @Column
    private String description;
    //유튜브 동영상 url
    @Column( length = 200)
    private String media_url;
    //이미지정보s
    @Column
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name = "file_id")
    private List<FileInfo> fileInfo;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}

enum Sex {
    ALL,
    FEMALE,
    MALE
}