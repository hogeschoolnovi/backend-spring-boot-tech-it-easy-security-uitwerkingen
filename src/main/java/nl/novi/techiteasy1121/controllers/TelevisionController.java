package nl.novi.techiteasy1121.controllers;


import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TelevisionController {

    private final TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionController(TelevisionRepository televisionRepository){
        this.televisionRepository = televisionRepository;
    }

    @GetMapping("/televisions")
    public ResponseEntity<List<Television>> getAllTelevisions(@RequestParam(value = "brand", required = false) String brand) {

        List<Television> televisions;

        if (brand == null){

            televisions = televisionRepository.findAll();

            return ResponseEntity.ok().body(televisions);

        } else {

            televisions = televisionRepository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        }

        return ResponseEntity.ok().body(televisions);

    }





    @GetMapping("/televisions/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable("id") Long id) {

        Optional<Television> television = televisionRepository.findById(id);

        if (television.isEmpty()){

            throw new RecordNotFoundException("No television found with id: " + id );

        } else {

            Television television1 = television.get();

            return ResponseEntity.ok().body(television1);
        }

    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> addTelevision(@RequestBody Television television) {

        televisionRepository.save(television);

        return ResponseEntity.created(null).body(television);

    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable("id") Long id) {

        televisionRepository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable Long id, @RequestBody Television newTelevision) {

        Optional<Television> television = televisionRepository.findById(id);

        if (television.isEmpty()){

            throw new RecordNotFoundException("No television found with id: " + id);

        }else {
            Television television1 = television.get();
            television1.setId(television1.getId());
            television1.setAmbiLight(newTelevision.getAmbiLight());
            television1.setAvailableSize(newTelevision.getAvailableSize());
            television1.setAmbiLight(newTelevision.getAmbiLight());
            television1.setBluetooth(newTelevision.getBluetooth());
            television1.setBrand(newTelevision.getBrand());
            television1.setHdr(newTelevision.getHdr());
            television1.setName(newTelevision.getName());
            television1.setOriginalStock(newTelevision.getOriginalStock());
            television1.setPrice(newTelevision.getPrice());
            television1.setRefreshRate(newTelevision.getRefreshRate());
            television1.setScreenQuality(newTelevision.getScreenQuality());
            television1.setScreenType(newTelevision.getScreenType());
            television1.setSmartTv(newTelevision.getSmartTv());
            television1.setSold(newTelevision.getSold());
            television1.setType(newTelevision.getType());
            television1.setVoiceControl(newTelevision.getVoiceControl());
            television1.setWifi(newTelevision.getWifi());
            televisionRepository.save(television1);
            return ResponseEntity.ok().body(television1);
        }

    }

}
