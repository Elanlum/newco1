package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.error.TripNotFoundException;
import com.andreitop.newco.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TripService <T extends TripDto>  implements AbstractTripSerice {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<T> findAll() {
        return tripRepository.findAll();
    }

    public T findById(Long id) throws TripNotFoundException {
        return (T) tripRepository.findById(id);
    }

    public void save(TripDto trip) {
        tripRepository.save(trip);
    }

    public void delete(Long id) throws TripNotFoundException {
        tripRepository.delete(id);
    }

    public void update(TripDto newTrip) throws TripNotFoundException {
        tripRepository.update(newTrip);
    }
}
