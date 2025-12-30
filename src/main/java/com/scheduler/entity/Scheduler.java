package com.scheduler.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedulers")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Scheduler extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String contentsName;
    @Column(nullable = false)
    private String contents;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String password;

    public Scheduler(String contentsName, String contents, String name, String password) {
        this.contentsName = contentsName;
        this.contents = contents;
        this.name = name;
        this.password = password;
    }

    public void update(String contentsName,String name) {
        this.contentsName = contentsName;
        this.name = name;

    }


}
