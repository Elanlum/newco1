package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.error.TripNotFoundException;

import java.util.List;

public interface AbstractTripSerice <T extends TripDto>  {
    public List<T> findAll();

    public T findById(Long id) throws TripNotFoundException;

    public void save(T trip);

    public void delete(Long id) throws TripNotFoundException;

    public void update(T newTrip) throws TripNotFoundException;

}
