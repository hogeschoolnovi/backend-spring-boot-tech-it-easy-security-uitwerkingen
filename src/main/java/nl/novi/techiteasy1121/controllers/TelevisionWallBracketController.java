package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.models.TelevisionWallBracketKey;
import nl.novi.techiteasy1121.services.TelevisionWallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Deze controller is voor de "tussenklasse" TelevisionWallBracket. Het bevat enkel een POST-method om een WallBracket
// aan een Television toe te voegen. We hoeven geen GET-Method te maken voor een TelevisionWallBracket, omdat deze
// klasse in principe alleen een backend implementatie van een many-to-many relatie is en niet interessant is voor de gebruiker.
@RestController
// Door een RequestMapping boven je classe te zetten, maak je een "basepath" die voor elk endpoint komt te staan.
@RequestMapping("/tvwb")
public class TelevisionWallBracketController {
    private TelevisionWallBracketService televisionWallBracketService;

    public TelevisionWallBracketController(TelevisionWallBracketService televisionWallBracketService) {
        this.televisionWallBracketService = televisionWallBracketService;
    }

    @PostMapping("/{televisionId}/{wallBracketId}")
    public ResponseEntity<TelevisionWallBracketKey> addTelevisionWallBracket(@PathVariable("televisionId") Long televisionId, @PathVariable("wallBracketId") Long wallbracketId) {
        TelevisionWallBracketKey key = televisionWallBracketService.addTelevisionWallBracket(televisionId, wallbracketId);
        return ResponseEntity.created(null).body(key);
    }
}