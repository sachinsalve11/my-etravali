package com.etravelli.etraveli_apps.Service;

import com.etravelli.etraveli_apps.model.Rent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class RentalInfoServiceTest {

    @Autowired
    Rent rent;

    @Autowired
    RentalInfoService rentalInfoService;

    @BeforeEach
    public void setup(){

        rent.setUserPoints("500");
        rent.setTotalAmout("$100");


    }

    @Test
    void processStatement() {
    }

    @Test
    void processRent() {
        assertAll(
                ()-> assertNotNull(rentalInfoService.processStatement(rent))
            );
        }


    }

    @Test
    void testProcessRent() {
    }
}