package com.phototraveler.phototraveler.Model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_TABLE")
public class User {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "USER_LOGIN", nullable = false, length = 50, unique = true)
    private String login;

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

    public String getNazwisko() {
        return nazwisko;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public User(String login, String name, String nazwisko, String country, String city){
        this.login = login;
        this.name = name;
        this.nazwisko = nazwisko;
        this.country = country;
        this.city = city;
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

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (nazwisko != null ? !nazwisko.equals(user.nazwisko) : user.nazwisko != null) return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        return city != null ? city.equals(user.city) : user.city == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    //    @Column(name = "FULLNAME", nullable = false, length = 200)
//    private String fullName;
}
