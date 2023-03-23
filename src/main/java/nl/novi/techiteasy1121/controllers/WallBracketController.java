package nl.novi.techiteasy1121.controllers;


import nl.novi.techiteasy1121.dtos.TelevisionDto;
import nl.novi.techiteasy1121.dtos.WallBracketDto;
import nl.novi.techiteasy1121.services.TelevisionWallBracketService;
import nl.novi.techiteasy1121.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class WallBracketController {
    private final WallBracketService wallBracketService;
    private final TelevisionWallBracketService televisionWallBracketService;
    public WallBracketController(WallBracketService wallBracketService,
                                 TelevisionWallBracketService televisionWallBracketService) {
        this.wallBracketService = wallBracketService;
        this.televisionWallBracketService = televisionWallBracketService;
    }

    @GetMapping("/wallbrackets")
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {

        List<WallBracketDto> wallBrackets = wallBracketService.getAllWallBrackets();

        return ResponseEntity.ok(wallBrackets);
    }

    @GetMapping("/wallbrackets/{id}")
    public ResponseEntity<WallBracketDto> getWallBracket(@PathVariable("id") Long id) {

        WallBracketDto wallBracketDto = wallBracketService.getWallBracket(id);

        return ResponseEntity.ok(wallBracketDto);
    }

    @PostMapping("/wallbrackets")
    public ResponseEntity<WallBracketDto> addWallBracket(@RequestBody WallBracketDto dto) {
        WallBracketDto wallBracket = wallBracketService.addWallbracket(dto);
        return ResponseEntity.created(null).body(wallBracket);
    }

    @DeleteMapping("/wallbrackets/{id}")
    public ResponseEntity<Object> deleteWallBracket(@PathVariable("id") Long id) {
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/wallbrackets/{id}")
    public ResponseEntity<WallBracketDto> updateWallBracket(@PathVariable("id") Long id, @RequestBody WallBracketDto dto) {
       var returnDto = wallBracketService.updateWallBracket(id, dto);
        return ResponseEntity.ok(returnDto);
    }

    // Deze methode haalt alle televisies op die aan een bepaalde wallbracket gekoppeld zijn.
    // Deze methode maakt gebruikt van de televisionWallBracketService.
    @GetMapping("/wallbrackets/televisions/{wallBracketId}")
    public ResponseEntity<Collection<TelevisionDto>> getTelevisionsByWallBracketId(@PathVariable("wallBracketId") Long wallBracketId){
        return ResponseEntity.ok(televisionWallBracketService.getTelevisionsByWallBracketId(wallBracketId));
    }
}