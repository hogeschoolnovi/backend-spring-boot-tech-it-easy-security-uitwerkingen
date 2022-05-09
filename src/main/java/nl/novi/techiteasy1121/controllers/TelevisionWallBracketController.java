package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.services.TelevisionWallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}