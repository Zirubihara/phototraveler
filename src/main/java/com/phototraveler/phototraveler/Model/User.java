package com.phototraveler.phototraveler.Model;

import javax.persistence.*;

import java.util.Objects;

@Entity

public class User {

    @Id
    @GeneratedValue
    private Long id;

//    @Column(name = "USER_LOGIN", nullable = false, length = 50, unique = true)
    private String login;
    private String name;
    private String nazwisko;

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }


    public String getName() {
        return name;
    }

    public void setName(String imie) {
        this.name = imie;
    }

    public User() {
    }

    public User(String login, String name, String nazwisko){
        this.login = login;this.name = name;
//        this.nazwisko = nazwisko;
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
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", imie='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, name);
    }

    //    @Column(name = "FULLNAME", nullable = false, length = 200)
//    private String fullName;
}
