package com.yui.gps.controllers;

import com.yui.gps.models.dto.PointOfInterestDTO;
import com.yui.gps.models.dto.Reference;
import com.yui.gps.models.entities.PointOfInterest;
import com.yui.gps.services.PointOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/point")
public class PointOfInterestController {
    @Autowired
    private PointOfInterestService service;

    @PostMapping
    public ResponseEntity<PointOfInterestDTO> save(@RequestBody PointOfInterestDTO dto){
        dto = service.save(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<PointOfInterestDTO>> getAll(){

        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping(value = "/proximity")
    public ResponseEntity<List<PointOfInterestDTO>> proximity(@RequestBody Reference ref){

        return ResponseEntity.ok().body(service.proximity(ref));
    }

}
