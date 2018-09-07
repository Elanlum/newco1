package com.andreitop.newco.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class TripDto implements Serializable {

    private static final long serialVersionUID = 5914366185889783660L;
    @Max(100)
    @NotNull
    private Long id;

    @Size(min = 2, max = 64)
    @NotNull
    private String origin;

    @Size(min = 2, max = 64)
    @NotNull
    private String destination;

    @NotNull
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
