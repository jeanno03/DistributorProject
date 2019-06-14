package com.distributor.entities;

import com.distributor.models.CoinJsonHashMap;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

//    @Mutable doit etre remplacé par @NaturalId dans hibernate

@Entity
@Immutable
@NamedQueries({
        @NamedQuery(name="getDistributorByName",
                query="select d from Distributor d where d.name = :paramName"),
        @NamedQuery(name="getAllDistributors",
                query="select d from Distributor d"),
        @NamedQuery(name="getAllDistributorsDesc",
                query="select d from Distributor d order by d.id desc")
})
@NamedNativeQueries(value={
        @NamedNativeQuery(name="native.query.selectJsonBDistributorTest",
                query="select * from distributor where " +
                        "CAST(coinjsonhashmap -> 'coinIntegerHashMap' ->> 'UN_EUROS' as integer) > 20", resultClass = Distributor.class),
        @NamedNativeQuery(name="native.query.selectJsonBJointureTest",
                query="select * from distributor d join distributorline l on d.id=l.distributor_id where" +
                        " CAST(coinjsonhashmap -> 'coinIntegerHashMap' ->> 'UN_EUROS' as integer) >= 99  and" +
                        " (drinkjson -> 'drink' ->> 'name') = 'Coca-Cola' and" +
                        " l.amount >=20", resultClass = Distributor.class),
        @NamedNativeQuery(name="native.query.selectDistributorIfCoinIfDrink",
                query="select * from distributor d join distributorline l on d.id=l.distributor_id where" +
                        " CAST(coinjsonhashmap -> 'coinIntegerHashMap' ->> :paramCoinName as integer) >= :paramCoinAmount  and" +
                        " (drinkjson -> 'drink' ->> 'name') = :paramDrinkName and" +
                        " l.amount >= :paramDrinkAmount", resultClass = Distributor.class)
})
public class Distributor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "distributor",cascade={CascadeType.ALL})
    private Collection<DistributorLine> distributorLines;

    @Column
    @Type(type = "CoinJsonType")
    private CoinJsonHashMap coinJsonHashMap;

    public Distributor() {
        super();
        distributorLines = new ArrayList();
    }

    public Distributor(String name) {
        this();
        this.name = name;
    }

    public Distributor(String name, Collection<DistributorLine> distributorLines, CoinJsonHashMap coinJsonHashMap) {
        this.name = name;
        this.distributorLines = distributorLines;
        this.coinJsonHashMap = coinJsonHashMap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<DistributorLine> getDistributorLines() {
        return distributorLines;
    }

    public void setDistributorLines(Collection<DistributorLine> distributorLines) {
        this.distributorLines = distributorLines;
    }

    public CoinJsonHashMap getCoinJsonHashMap() {
        return coinJsonHashMap;
    }

    public void setCoinJsonHashMap(CoinJsonHashMap coinJsonHashMap) {
        this.coinJsonHashMap = coinJsonHashMap;
    }

}
