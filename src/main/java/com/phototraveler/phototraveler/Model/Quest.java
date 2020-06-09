package com.phototraveler.phototraveler.Model;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Table
@ToString
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Status status;

//    public Quest(String name, Status status) {
//        this.name = name;
//        this.status = status;
//    }
}
