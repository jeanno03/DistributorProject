package com.distributor.controls.converters;

import com.distributor.controls.motherclasses.DistributorManagerImpl;
import com.distributor.dtos.DistributorDto;
import com.distributor.dtos.DistributorLineDto;
import com.distributor.entities.Distributor;
import com.distributor.entities.DistributorLine;

import java.util.ArrayList;
import java.util.List;

public class DistributorConverter extends DistributorManagerImpl {

    private static DistributorDto distributorDto;
    private static DistributorLineDto distributorLineDto;
    private static List<DistributorLineDto> distributorLineDtos;
    private static List<DistributorLine> distributorLines;

    public DistributorConverter() {
    }

    public DistributorDto getDistributorDto(Distributor distributor) {
        distributorDto = new DistributorDto();
        distributorLineDtos = new ArrayList();

            distributorDto.setId(distributor.getId());
            distributorDto.setName(distributor.getName());

            distributorLines = (List<DistributorLine>) distributor.getDistributorLines();

                distributorLines.forEach(d->{
                    distributorLineDto = new DistributorLineDto();
                    distributorLineDto.setId(d.getId());
                    distributorLineDto.setAmount(d.getAmount());
                    distributorLineDto.setDrinkJson(d.getDrinkJson());
                    distributorLineDtos.add(distributorLineDto);
                    distributorDto.setDistributorLineDtos(distributorLineDtos);
        });

            distributorDto.setCoinJsonHashMap(distributor.getCoinJsonHashMap());

        return distributorDto;
    }
}

