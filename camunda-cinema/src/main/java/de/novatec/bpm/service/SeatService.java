package de.novatec.bpm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {

    Logger logger = LoggerFactory.getLogger(SeatService.class);

    public void reserveSeats(List<String> seats) {
        for (String seat : seats) {
            logger.info("Seat reserved: {}", seat);
        }
    }

    public boolean seatsAvailable(List<String> seats) {
        for (String seat : seats) {
            if (!seatAvailable()) {
                logger.warn("Seat {} is already taken!", seat);
                return false;
            }
        }
        return true;
    }

    private boolean seatAvailable() {
        return Math.random() > 0.15;  // in 15% of cases, seats are no longer available;
    }

    public List<String> getAlternativeSeats(List<String> seats) {
        List<String> alternativeSeats = new ArrayList<>();
        int index = 12;
        for (int i = 0; i < seats.size(); i++) {
            alternativeSeats.add("C" + index);
            index++;
        }
        return alternativeSeats;
    }

    public void releaseSeats(List<String> seats) {
        for (String seat : seats) {
            logger.info("Seat released: {}", seat);
        }
    }
}
