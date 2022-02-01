package nl.novi.techiteasy1121.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionController {

    @GetMapping("/televisions")
    public ResponseEntity<Object> getAllTelevisions() {

        return ResponseEntity.ok();

    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Object> getTelevision() {

        return ResponseEntity.ok();

    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> addTelevision(@RequestBody String television) {

        return ResponseEntity.created();

    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {

        return ResponseEntity.noContent();

    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String television) {

        return ResponseEntity.noContent();

    }

    @GetMapping("/televisions?branch={branch}")
    public ResponseEntity<Object> getAllTelevisions(@RequestParam String brand) {

        return ResponseEntity.ok();

    }

}
