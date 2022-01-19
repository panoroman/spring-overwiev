package com.example.library.Model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "books")
@EntityListeners(AuditingEntityListener.class)
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author", nullable = false, length = 255)
    private String author;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "issueData")
    @CreatedDate
    private Instant issueData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instant getIssueData() {
        return issueData;
    }

    public void setIssueData(Instant issueData) {
        this.issueData = issueData;
    }
}
