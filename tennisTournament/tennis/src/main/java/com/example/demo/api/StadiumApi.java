package com.example.demo.api;

import com.example.demo.entity.Stadium;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(StadiumApi.PATH)
public class StadiumApi {
    public static final String PATH ="/api/stadium";
    @Autowired
    private StadiumService stadiumService;

    @GetMapping()
    public List<Stadium> getAllStadium(){
        List<Stadium> stadiumList = stadiumService.getAll();
        return stadiumList;
    }

    @GetMapping("{id}")
    public ResponseEntity<Stadium>getStadiumById(@PathVariable(value="id") Integer stadiumId) throws ResourceNotFoundException{
    Stadium stadium = stadiumService.findStadiumById(stadiumId).orElseThrow(()-> new ResourceNotFoundException("Stadium not found on this " + stadiumId ));
    return ResponseEntity.ok().body(stadium);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stadium> update (@PathVariable(value = "id")Integer statidumId) throws ResourceNotFoundException


    @PostMapping()
    public void addStadium(@RequestBody Stadium stadium){
        stadiumService.saveStadium(stadium);
    }

    @DeleteMapping("/{id}")
    public void deleteStadium(@PathVariable Integer id) throws ResourceNotFoundException {
        Stadium stadium = stadiumService.findStadiumById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Stadium not found on this " + id ));
        stadiumService.deleteStadiumById(stadium.getStadiumId());
    }





}
