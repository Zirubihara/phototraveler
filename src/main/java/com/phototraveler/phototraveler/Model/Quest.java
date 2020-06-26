package com.phototraveler.phototraveler.Model;

import lombok.*;
import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "QUEST")
@EqualsAndHashCode

public class Quest {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "quest_seq")
    @SequenceGenerator(name = "quest_seq", sequenceName = "quest_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "FULLNAME", nullable = false)
    private String name;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "CREATED_DATE")
    private Instant createdDate;

}
