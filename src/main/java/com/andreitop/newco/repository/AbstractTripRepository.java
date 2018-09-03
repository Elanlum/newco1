package com.andreitop.newco.repository;

import com.andreitop.newco.dto.TripDto;

import java.util.List;

public interface AbstractTripRepository <T extends TripDto>  {
    public List<T> findAll();

    public T findById(final Long id);

    public void save(final T trip);

    public void delete(final Long id);

    public void update(final T newTrip);

}
