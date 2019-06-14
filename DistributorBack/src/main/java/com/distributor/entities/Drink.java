package com.distributor.entities;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name="getAllDrinks",
                query="select d from Drink d"),
        @NamedQuery(name="getDrinkByCode",
                query="select d from Drink d where d.code = :paramCode")
})
@Entity
@Immutable
public class Drink implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;
    private String name;

    public Drink() {
    }

    public Drink(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Drink(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
