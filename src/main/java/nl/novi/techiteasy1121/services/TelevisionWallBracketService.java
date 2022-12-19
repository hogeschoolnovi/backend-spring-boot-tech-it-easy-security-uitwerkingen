package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.TelevisionDto;
import nl.novi.techiteasy1121.dtos.WallBracketDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.models.TelevisionWallBracket;
import nl.novi.techiteasy1121.models.TelevisionWallBracketKey;
import nl.novi.techiteasy1121.models.WallBracket;
import nl.novi.techiteasy1121.repositories.TelevisionRepository;
import nl.novi.techiteasy1121.repositories.TelevisionWallBracketRepository;
import nl.novi.techiteasy1121.repositories.WallBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
public class TelevisionWallBracketService{

    private final TelevisionRepository televisionRepository;

    private final WallBracketRepository wallBracketRepository;

    private final TelevisionWallBracketRepository televisionWallBracketRepository;

    public TelevisionWallBracketService(TelevisionRepository televisionRepository, WallBracketRepository wallBracketRepository, TelevisionWallBracketRepository televisionWallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.wallBracketRepository = wallBracketRepository;
        this.televisionWallBracketRepository = televisionWallBracketRepository;
    }

    public Collection<TelevisionDto> getTelevisionWallBracketsByWallBracketId(Long wallBracketId) {
        Collection<TelevisionDto> dtos = new HashSet<>();
        Collection<TelevisionWallBracket> televisionWallbrackets = televisionWallBracketRepository.findAllByWallBracketId(wallBracketId);
        for (TelevisionWallBracket televisionWallbracket : televisionWallbrackets) {
            Television television = televisionWallbracket.getTelevision();
            TelevisionDto dto = new TelevisionDto();

            television.setId(dto.getId());
            television.setType(dto.getType());
            television.setBrand(dto.getBrand());
            television.setName(dto.getName());
            television.setPrice(dto.getPrice());
            television.setAvailableSize(dto.getAvailableSize());
            television.setRefreshRate(dto.getRefreshRate());
            television.setScreenType(dto.getScreenType());
            television.setScreenQuality(dto.getScreenQuality());
            television.setSmartTv(dto.getSmartTv());
            television.setWifi(dto.getWifi());
            television.setVoiceControl(dto.getVoiceControl());
            television.setHdr(dto.getHdr());
            television.setBluetooth(dto.getBluetooth());
            television.setAmbiLight(dto.getAmbiLight());
            television.setOriginalStock(dto.getOriginalStock());
            television.setSold(dto.getSold());

            dtos.add(dto);
        }
        return dtos;
    }

    public Collection<WallBracketDto> getTelevisionWallBracketByTelevisionId(Long televisionId) {
        Collection<WallBracketDto> dtos = new HashSet<>();
        Collection<TelevisionWallBracket> televisionWallbrackets = televisionWallBracketRepository.findAllByTelevisionId(televisionId);
        for (TelevisionWallBracket televisionWallbracket : televisionWallbrackets) {
            WallBracket wallBracket = televisionWallbracket.getWallBracket();
            var dto = new WallBracketDto();

            dto.setId(wallBracket.getId());
            dto.setName(wallBracket.getName());
            dto.setSize(wallBracket.getSize());
            dto.setAdjustable(wallBracket.getAdjustable());
            dto.setPrice(wallBracket.getPrice());

            dtos.add(dto);
        }
        return dtos;
    }


    public TelevisionWallBracketKey addTelevisionWallBracket(Long televisionId, Long wallBracketId) {
        var televisionWallBracket = new TelevisionWallBracket();
        if (!televisionRepository.existsById(televisionId)) {throw new RecordNotFoundException();}
        Television television = televisionRepository.findById(televisionId).orElse(null);
        if (!wallBracketRepository.existsById(wallBracketId)) {throw new RecordNotFoundException();}
        WallBracket wallBracket = wallBracketRepository.findById(wallBracketId).orElse(null);
        televisionWallBracket.setTelevision(television);
        televisionWallBracket.setWallBracket(wallBracket);
        TelevisionWallBracketKey id = new TelevisionWallBracketKey(televisionId, wallBracketId);
        televisionWallBracket.setId(id);
        televisionWallBracketRepository.save(televisionWallBracket);
        return id;
    }

    public List<TelevisionWallBracket> getAllTelevisionWallBrackets(){
        return televisionWallBracketRepository.findAll();
    }
}
