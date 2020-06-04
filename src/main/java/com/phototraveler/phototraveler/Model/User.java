package com.phototraveler.phototraveler.Model;

import lombok.*;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity

public class User {

    @Id
    @GeneratedValue
    private Long id;

//    @Column(name = "USER_LOGIN", nullable = false, length = 50, unique = true)
    private String login;

    public User() {
    }

    public User(String login){
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }

    //    @Column(name = "FULLNAME", nullable = false, length = 200)
//    private String fullName;
}
