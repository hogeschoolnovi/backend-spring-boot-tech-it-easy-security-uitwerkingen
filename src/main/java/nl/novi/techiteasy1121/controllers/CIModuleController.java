package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.Dtos.CIModuleDto;
import nl.novi.techiteasy1121.Dtos.IdInputDto;
import nl.novi.techiteasy1121.models.CIModule;
import nl.novi.techiteasy1121.services.CIModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CIModuleController {


    private final CIModuleService ciModuleService;

    @Autowired
    public CIModuleController(CIModuleService ciModuleService){

        this.ciModuleService = ciModuleService;
    }


    @GetMapping(value = "/cimodules")
    @ResponseBody
    public ResponseEntity<Object> getCIModules(@RequestParam(defaultValue = "") String name){

        List<CIModuleDto> dto = ciModuleService.getAllCIModules();

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/cimodules/{id}")
    public ResponseEntity<Object> getCIModule(@PathVariable long id){

        CIModuleDto dto = ciModuleService.getCIModule(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/cimodules")
    public ResponseEntity<Object> postCIModule(@RequestBody CIModuleDto CIModuleDto){

        CIModuleDto dto = ciModuleService.addCIModule(CIModuleDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping("/cimodules/{id}")
    public ResponseEntity<Object> putCIModule(@PathVariable long id, @RequestBody CIModuleDto CIModuleDto){

        ciModuleService.updateCIModule(id, CIModuleDto);

        return ResponseEntity.noContent().build();
    }



    @DeleteMapping("/cimodules/{id}")
    public ResponseEntity<Object> deleteCIModule(@PathVariable long id){

        ciModuleService.deleteCIModule(id);

        return ResponseEntity.noContent().build();
    }
}
