package com.phototraveler.phototraveler.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    @SequenceGenerator(name = "comment_seq", sequenceName = "comment_seq")
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "TEXT", nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "QUEST_ID")
    private Quest quest;

    @Column(name = "CREATE_DATE")
    private Instant createdDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;


}
