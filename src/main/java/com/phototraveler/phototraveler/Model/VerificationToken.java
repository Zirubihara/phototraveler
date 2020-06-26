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
@Table(name = "TOKEN")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "token_seq", sequenceName = "token_seq", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TOKEN")
    private String token;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "EXPIRY_DATE")
    private Instant expiryDate;
}
