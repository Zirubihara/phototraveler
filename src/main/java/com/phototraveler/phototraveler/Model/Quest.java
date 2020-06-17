package com.phototraveler.phototraveler.Model;
import java.time.Instant;
import lombok.*;
import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


@Data
@Entity
@Table(name = "QUEST")
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public Quest(String name, String city, Status status, User user) {
        this.name = name;
        this.city = city;
        this.status = status;
        this.user = user;
    }
}
