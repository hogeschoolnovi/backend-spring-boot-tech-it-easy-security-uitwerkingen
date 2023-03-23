package nl.novi.techiteasy1121.repositories;

import nl.novi.techiteasy1121.models.TelevisionWallBracket;
import nl.novi.techiteasy1121.models.TelevisionWallBracketKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface TelevisionWallBracketRepository extends JpaRepository<TelevisionWallBracket, TelevisionWallBracketKey> {
    List<TelevisionWallBracket> findAllByTelevisionId(Long televisionId);
    List<TelevisionWallBracket> findAllByWallBracketId(Long wallBracketId);
}
