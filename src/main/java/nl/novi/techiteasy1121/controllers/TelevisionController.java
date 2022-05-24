package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dtos.IdInputDto;
import nl.novi.techiteasy1121.dtos.TelevisionDto;
import nl.novi.techiteasy1121.dtos.TelevisionInputDto;
import nl.novi.techiteasy1121.dtos.WallBracketDto;
import nl.novi.techiteasy1121.services.TelevisionService;
import nl.novi.techiteasy1121.services.TelevisionWallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class TelevisionController {

    private final TelevisionService televisionService;

    private final TelevisionWallBracketService televisionWallBracketService;

    @Autowired
    public TelevisionController(TelevisionService televisionService,
                                TelevisionWallBracketService televisionWallBracketService){
        this.televisionService = televisionService;
        this.televisionWallBracketService = televisionWallBracketService;
    }

    @GetMapping("/televisions")
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions(@RequestParam(value = "brand", required = false) Optional<String> brand) {

        List<TelevisionDto> dtos;

        if (brand.isEmpty()){

            dtos = televisionService.getAllTelevisions();

        } else {

            dtos = televisionService.getAllTelevisionsByBrand(brand.get());

        }

        return ResponseEntity.ok().body(dtos);

    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable("id")Long id) {

        TelevisionDto television = televisionService.getTelevisionById(id);

            return ResponseEntity.ok().body(television);

    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> addTelevision(@RequestBody TelevisionInputDto televisionInputDto) {

        TelevisionDto dto = televisionService.addTelevision(televisionInputDto);

        return ResponseEntity.created(null).body(dto);

    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {

        televisionService.deleteTelevision(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto newTelevision) {

        TelevisionDto dto = televisionService.updateTelevision(id, newTelevision);

        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/televisions/{id}/remotecontroller")
    public void assignRemoteControllerToTelevision(@PathVariable("id") Long id, @RequestBody IdInputDto input) {
        televisionService.assignRemoteControllerToTelevision(id, input.id);
    }

    @PutMapping("/televisions/{id}/{ciModuleId}")
    public void assignCIModuleToTelevision(@PathVariable("id") Long id, @PathVariable("ciModuleId") Long ciModuleId) {
        televisionService.assignCIModuleToTelevision(id, ciModuleId);
    }

    @GetMapping("/televisions/wallBrackets/{televisionId}")
    public Collection<WallBracketDto> getWallBracketsByTelevisionId(@PathVariable("televisionId") Long televisionId){
        return televisionWallBracketService.getTelevisionWallBracketByTelevisionId(televisionId);
    }
}
