package nl.novi.techiteasy1121.models;

import jakarta.persistence.*;

@Entity
public class TelevisionWallBracket {

    // EmbeddedId zorgt dat er geen nieuwe Id wordt aangemaakt,
    // maar dat de variabelen met de @MapsId annotatie tot key worden gecombineerd.
    @EmbeddedId
    private TelevisionWallBracketKey id;

    // Dit is de owner kan van de relatie. Er staat een foreign key in de database
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("televisionId")
    @JoinColumn(name = "television_id")
    private Television television;

    // Dit is de owner kan van de relatie. Er staat een foreign key in de database
    @ManyToOne
    @MapsId("wallBracketId")
    @JoinColumn(name = "wall_bracket_id")
    private WallBracket wallBracket;

    public TelevisionWallBracketKey getId() {
        return id;
    }

    public Television getTelevision() {
        return television;
    }

    public WallBracket getWallBracket() {
        return wallBracket;
    }

    public void setId(TelevisionWallBracketKey id) {
        this.id = id;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }

    public void setWallBracket(WallBracket wallBracket) {
        this.wallBracket = wallBracket;
    }
}
