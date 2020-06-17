package com.phototraveler.phototraveler.Model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Data
@Entity
@Table
@EqualsAndHashCode
@Builder
@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
@ToString
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String city;
    private Status status;

    @OneToOne
    @JoinColumn(name = "userID", nullable = false)
    private User orderer;

    public Quest() {
    }

    public Quest(String name, String city, Status status, User orderer) {
        this.name = name;
        this.city = city;
        this.status = status;
        this.orderer = orderer;
    }



//    public Quest(String name, Status status) {
//        this.name = name;
//        this.status = status;
//    }
}
