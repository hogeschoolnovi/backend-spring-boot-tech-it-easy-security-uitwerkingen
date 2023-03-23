package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.WallBracketDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.WallBracket;
import nl.novi.techiteasy1121.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Deze klasse bevat de service methodes van de WallBracketController
@Service
public class WallBracketService {


    private WallBracketRepository wallBracketRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<WallBracketDto> getAllWallBrackets() {
        List<WallBracket> wallBracketList = wallBracketRepository.findAll();
        List<WallBracketDto> dtos = new ArrayList<>();
        for (WallBracket wb : wallBracketList) {
            dtos.add(transferToDto(wb));
        }
        return dtos;
    }

    public WallBracketDto getWallBracket(long id) {
        Optional<WallBracket> wallBracket = wallBracketRepository.findById(id);
        if(wallBracket.isPresent()) {
            WallBracketDto dto = transferToDto(wallBracket.get());
            return dto;
        } else {
            throw new RecordNotFoundException("No wallbracket found");
        }
    }

    public WallBracketDto addWallbracket(WallBracketDto wallBracketDto) {
        WallBracket wallBracket = transferToWallBracket(wallBracketDto);
        wallBracketRepository.save(wallBracket);
        return transferToDto(wallBracket);
    }

    public void deleteWallBracket(Long id) {
        wallBracketRepository.deleteById(id);
    }

    public WallBracketDto updateWallBracket(Long id, WallBracketDto wallBracketDto) {
        if(!wallBracketRepository.existsById(id)) {
            throw new RecordNotFoundException("No wallbracket found");
        }
        WallBracket storedWallBracket = wallBracketRepository.findById(id).orElse(null);
        storedWallBracket.setId(wallBracketDto.getId());
        storedWallBracket.setSize(wallBracketDto.getSize());
        storedWallBracket.setAdjustable(wallBracketDto.getAdjustable());
        storedWallBracket.setName(wallBracketDto.getName());
        storedWallBracket.setPrice(wallBracketDto.getPrice());
        return transferToDto(wallBracketRepository.save(storedWallBracket));
    }

    public WallBracketDto transferToDto(WallBracket wallBracket){
        var dto = new WallBracketDto();

        dto.setId(wallBracket.getId());
        dto.setName(wallBracket.getName());
        dto.setSize(wallBracket.getSize());
        dto.setAdjustable(wallBracket.getAdjustable());
        dto.setPrice(wallBracket.getPrice());

        return dto;
    }

    public WallBracket transferToWallBracket(WallBracketDto wallBracketDto){
        var wallBracket = new WallBracket();
        wallBracket.setId(wallBracketDto.getId());
        wallBracket.setName(wallBracketDto.getName());
        wallBracket.setSize(wallBracketDto.getSize());
        wallBracket.setAdjustable(wallBracketDto.getAdjustable());
        wallBracket.setPrice(wallBracketDto.getPrice());

        return wallBracket;
    }

}