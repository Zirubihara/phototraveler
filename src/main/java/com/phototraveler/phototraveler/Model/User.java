package com.phototraveler.phototraveler.Model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;
import javax.validation.constraints.Email;
import java.time.Instant;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_TABLE")
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "USER_LOGIN", nullable = false, length = 50, unique = true)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FULLNAME", nullable = false, length = 200)
    private String name;

    @Column(name = "SECOND_NAME", nullable = false, length = 200)
    private String nazwisko;

    @Column(name = "COUNTRY", nullable = false, length = 50)
    private String country;

    @Column(name = "CITY", nullable = false, length = 50)
    private String city;

    @Column(name = "POINTS", nullable = false)
    private Long points;

    @Column(name = "CREATED")
    private Instant created;

    @Column(name = "ENABLED")
    private boolean enabled;

}
