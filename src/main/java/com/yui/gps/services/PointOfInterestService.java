package com.yui.gps.services;

import com.yui.gps.models.dto.PointOfInterestDTO;
import com.yui.gps.models.dto.Reference;
import com.yui.gps.models.entities.PointOfInterest;
import com.yui.gps.repositories.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointOfInterestService {

    @Autowired
    private PointOfInterestRepository repository;


    public PointOfInterestDTO save(PointOfInterestDTO dto){
        PointOfInterest point =  new PointOfInterest();

        copy(dto, point);

        point = repository.save(point);

        return new PointOfInterestDTO(point);
    }

    public List<PointOfInterestDTO> getAll(){
       return repository.findAll().stream().map(x -> new PointOfInterestDTO(x)).toList();
    }

    public  List<PointOfInterestDTO>  proximity(Reference ref){
        List<PointOfInterest> list = repository.findAll();
        List<PointOfInterest> proximity = new ArrayList<>();
        for(PointOfInterest point : list){
            if(dmax(ref, point) <= 10){
                proximity.add(point);
            }
        }

        return  proximity.stream().map(x -> new PointOfInterestDTO(x)).toList();

    }

    private void copy(PointOfInterestDTO dto, PointOfInterest point){
        point.setName(dto.getName());

        if(dto.getX() < 0 || dto.getY() < 0)
            throw new IllegalArgumentException("O Valor não pode ser negativo");

        point.setX(dto.getX());
        point.setY(dto.getY());
    }

    private Double dmax(Reference ref, PointOfInterest point){
        return Math.sqrt(Math.pow(point.getX() - ref.getX(), 2) + Math.pow(point.getY() - ref.getY(), 2));

    }
}
