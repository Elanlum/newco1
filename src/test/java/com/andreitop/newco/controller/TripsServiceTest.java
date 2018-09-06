package com.andreitop.newco.controller;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import com.andreitop.newco.service.TripService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TripService.class)
public class TripsServiceTest {

    @MockBean
    TripRepository tripRepository;
    @MockBean
    TripService tripService;

    @Before
    public void setUp() {
        tripService = new TripService(tripRepository);
    }

    @Test
    public void findAllTest() throws Exception {

        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        List<TripDto> allTrips = Collections.singletonList(tripDto);
        when(tripRepository.findAll()).thenReturn(allTrips);
        List<TripDto> recentTrips = tripService.findAll();

        assertEquals(recentTrips, allTrips);
    }

    @Test
    public void findByIdTest() {
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        when(tripRepository.findById(1L)).thenReturn(tripDto);
        TripDto recentTripDto = tripService.findById(1L);

        assertEquals(recentTripDto, tripDto);
    }

    @Test
    public void saveTest() {
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);
        tripService.save(tripDto);
        verify(tripRepository, times(1)).save(tripDto);
    }

    @Test
    public void deleteTest() {
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);
        tripService.delete(1L);
        verify(tripRepository, times(1)).delete(1L);
    }

    @Test
    public void updateTest() {
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);
        tripService.update(tripDto);
        verify(tripRepository, times(1)).update(tripDto);
    }
}
