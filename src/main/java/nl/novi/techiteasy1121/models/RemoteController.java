package nl.novi.techiteasy1121.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class RemoteController {

    @Id
    @GeneratedValue
    private Long id;

    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private Double price;
    private Integer originalStock;

    // Dit is de target kant van de relatie. Er staat niks in de database
    @OneToOne(mappedBy = "remoteController")
    Television television;

//    De constructors hoeven niet gemaakt te worden mag wel
//    public RemoteController() {
//    }
//
//    public RemoteController( String compatibleWith, String batteryType, String name, String brand, Double price, Integer originalStock) {
//        this.compatibleWith = compatibleWith;
//        this.batteryType = batteryType;
//        this.name = name;
//        this.brand = brand;
//        this.price = price;
//        this.originalStock = originalStock;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public Television getTelevision() {
        return television;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }
}
