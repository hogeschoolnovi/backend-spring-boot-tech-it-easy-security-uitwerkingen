package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.CIModuleDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.CIModule;
import nl.novi.techiteasy1121.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Deze klasse bevat de service methodes van de CIModuleController

@Service
public class CIModuleService  {


    private CIModuleRepository ciModuleRepository;

    public CIModuleService(CIModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CIModuleDto> getAllCIModules() {
        List<CIModule> ciModules = ciModuleRepository.findAll();
        List<CIModuleDto> dtos = new ArrayList<>();
        for (CIModule ci : ciModules) {
            dtos.add(transferToDto(ci));
        }
        return dtos;
    }

    public CIModuleDto getCIModule(long id) {
        Optional<CIModule> ciModule = ciModuleRepository.findById(id);
        if(ciModule.isPresent()) {
            CIModuleDto ci = transferToDto(ciModule.get());
            return ci;
        } else {
            throw new RecordNotFoundException("No ci-module found");
        }
    }

    public CIModuleDto addCIModule(CIModuleDto ciModuleDto) {
        ciModuleRepository.save(transferToCIModule(ciModuleDto));
        return ciModuleDto;
    }

    public void deleteCIModule(Long id) {
        ciModuleRepository.deleteById(id);
    }

    public void updateCIModule(Long id, CIModuleDto ciModuleDto) {
        if(!ciModuleRepository.existsById(id)) {
            throw new RecordNotFoundException("No ci-module found");
        }
        CIModule storedCIModule = ciModuleRepository.findById(id).orElse(null);
        storedCIModule.setId(ciModuleDto.getId());
        storedCIModule.setType(ciModuleDto.getType());
        storedCIModule.setName(ciModuleDto.getName());
        storedCIModule.setPrice(ciModuleDto.getPrice());
        ciModuleRepository.save(storedCIModule);
    }

    public CIModule transferToCIModule(CIModuleDto dto){
        CIModule ciModule = new CIModule();

        ciModule.setId(dto.getId());
        ciModule.setName(dto.getName());
        ciModule.setType(dto.getType());
        ciModule.setPrice(dto.getPrice());

        return ciModule;
    }

    public static CIModuleDto transferToDto(CIModule ciModule){
        var dto = new CIModuleDto();

        dto.id = ciModule.getId();
        dto.name = ciModule.getName();
        dto.type = ciModule.getType();
        dto.price = ciModule.getPrice();

        return dto;
    }
}
