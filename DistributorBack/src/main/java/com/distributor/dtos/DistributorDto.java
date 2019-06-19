package com.distributor.dtos;

import com.distributor.models.CoinJsonHashMap;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Immutable
public class DistributorDto implements Serializable {

    private Long id;
    private String name;
    private CoinJsonHashMap coinJsonHashMap;
    private Collection<DistributorLineDto> distributorLineDtos;

    public DistributorDto() {
        distributorLineDtos = new ArrayList<>();
    }

    public DistributorDto(Long id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public DistributorDto(Long id, String name, CoinJsonHashMap coinJsonHashMap, Collection<DistributorLineDto> distributorLineDtos) {
        this();
        this.id = id;
        this.name = name;
        this.coinJsonHashMap = coinJsonHashMap;
        this.distributorLineDtos = distributorLineDtos;
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

    public CoinJsonHashMap getCoinJsonHashMap() {
        return coinJsonHashMap;
    }

    public void setCoinJsonHashMap(CoinJsonHashMap coinJsonHashMap) {
        this.coinJsonHashMap = coinJsonHashMap;
    }

    public Collection<DistributorLineDto> getDistributorLineDtos() {
        return distributorLineDtos;
    }

    public void setDistributorLineDtos(Collection<DistributorLineDto> distributorLineDtos) {
        this.distributorLineDtos = distributorLineDtos;
    }


}
