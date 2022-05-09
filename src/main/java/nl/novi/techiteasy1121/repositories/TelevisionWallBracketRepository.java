package nl.novi.techiteasy1121.repositories;

import nl.novi.techiteasy1121.models.TelevisionWallBracket;
import nl.novi.techiteasy1121.models.TelevisionWallBracketKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TelevisionWallBracketRepository extends JpaRepository<TelevisionWallBracket, TelevisionWallBracketKey> {
    Collection<TelevisionWallBracket> findAllByTelevisionId(Long televisionId);
    Collection<TelevisionWallBracket> findAllByWallBracketId(Long wallBracketId);
}
