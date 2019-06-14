package com.distributor.entities;

import com.distributor.models.DrinkJson;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;
import javax.persistence.*;

@Entity
@Immutable
public class DistributorLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int amount;

    @Column
    @Type(type="DrinkJsonType")
    private DrinkJson drinkJson;

   @ManyToOne()
   @JoinColumn(name="distributor_id")
   private Distributor distributor;

    public DistributorLine() {
        super();
    }

    public DistributorLine(int amount, DrinkJson drinkJson) {
        this.amount = amount;
        this.drinkJson = drinkJson;
    }

    public DistributorLine(int amount, DrinkJson drinkJson, Distributor distributor) {
        this.amount = amount;
        this.drinkJson = drinkJson;
        this.distributor = distributor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public DrinkJson getDrinkJson() {
        return drinkJson;
    }

    public void setDrinkJson(DrinkJson drinkJson) {
        this.drinkJson = drinkJson;
    }
}
