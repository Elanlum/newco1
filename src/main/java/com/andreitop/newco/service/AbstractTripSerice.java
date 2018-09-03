package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;

import java.util.List;

public interface AbstractTripSerice <T extends TripDto>  {
    public List<T> findAll();

    public T findById(Long id);

    public void save(T trip);

    public void delete(Long id);

    public void update(T newTrip);

}
