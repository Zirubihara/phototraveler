package com.phototraveler.phototraveler.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_seq")
    @SequenceGenerator(name = "vote_seq", sequenceName = "vote_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name="VOTETYPE", nullable = false)
    private VoteType voteType;

    @ManyToOne
    @JoinColumn(name = "QUEST_ID")
    private Quest quest;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;





}
