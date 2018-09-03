package com.andreitop.newco.controller;

import com.andreitop.newco.dto.TripDto;

import java.util.List;

public interface AbstractTripsController <T extends TripDto>  {
    public List<T> findAll();

    public T findById(Long id);

    public void create(T trip);

    public void delete(Long id);

    public void update(T newTrip);
}
