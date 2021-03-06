package com.example.demo.api;

import com.example.demo.entity.Match;
import com.example.demo.entity.Round;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(RoundApi.PATH)
public class RoundApi {
    @Autowired
    private RoundService roundService;

    public static final String PATH = "/api/round";

    @GetMapping
    public ResponseEntity<List<Round>> getAll(){
        return ResponseEntity.ok(roundService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Round> getById(@PathVariable(value = "id")Integer id) throws ResourceNotFoundException {
        Round round = roundService.findRoundById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found:" + id));
        return ResponseEntity.ok(round);
    }

    @PostMapping
    public ResponseEntity<Round> create(@RequestBody Round round){
        Round createdRound = roundService.saveRound(round);
        return ResponseEntity.created((URI.create(RoundApi.PATH + "/" + createdRound.getRoundName()))).body(createdRound);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Round> update(@PathVariable(value = "id")Integer id,
                                        @RequestBody Round roundDetail) throws ResourceNotFoundException{
        Round round = roundService.findRoundById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id not found: " + id));
        round.setRoundName(roundDetail.getRoundName());
        round.setRoundType(roundDetail.getRoundType());

        Round roundUpdate = roundService.saveRound(round);
        return ResponseEntity.ok(roundUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id")Integer id) throws ResourceNotFoundException{
        Round round = roundService.findRoundById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id not found: " + id));
        roundService.deleteRoundById(id);
        return ResponseEntity.noContent().build();
    }
}
