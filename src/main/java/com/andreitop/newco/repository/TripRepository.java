package com.andreitop.newco.repository;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.error.TripNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TripRepository<T extends TripDto> implements AbstractTripRepository {

    private final List<T> trips = new ArrayList<>();

    public List<T> findAll() {
        return trips;
    }

    public TripDto findById(final Long id) throws TripNotFoundException {
        T trip = trips.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
        if (trip != null){
        return trip;
        } else throw new TripNotFoundException("Trip with current ID is not found");
    }

    public void save(final TripDto trip) {
        trip.setId((long) (trips.size() + 1));
        trips.add((T) trip);
    }

    public void delete(final Long id) throws TripNotFoundException{
        trips.stream().filter(t -> t.getId().equals(id)).findFirst().ifPresent(trips::remove);
    }

    public void update(final TripDto newTrip) throws TripNotFoundException{
        trips.stream().filter(t -> t.getId().equals(newTrip.getId())).findFirst().ifPresent(t -> trips.set(trips
                .indexOf(t), (T) newTrip));
    }
}
