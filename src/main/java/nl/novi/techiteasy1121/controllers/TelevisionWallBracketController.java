package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.services.TelevisionWallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tvwb")
public class TelevisionWallBracketController {
    private TelevisionWallBracketService televisionWallBracketService;

    @Autowired
    public TelevisionWallBracketController(TelevisionWallBracketService televisionWallBracketService) {
        this.televisionWallBracketService = televisionWallBracketService;
    }

    @PostMapping("/{televisionId}/{wallBracketId}")
    public void addTelevisionWallBracket(@PathVariable("televisionId") Long televisionId, @PathVariable("wallBracketId") Long wallbracketId) {
        televisionWallBracketService.addTelevisionWallBracket(televisionId, wallbracketId);
    }

    // Deze klasse gebruiken we alleen voor testen. De TelevisionWallbracket is een implementatiedetail, niet iets waar de gebruiker weet van hoeft te hebben.
//    @GetMapping("/televisionwallbrackets")
//    public ResponseEntity<Object> getall(){
//       return ResponseEntity.ok(televisionWallBracketService.getAllTelevisionWallBrackets());
//    }
}