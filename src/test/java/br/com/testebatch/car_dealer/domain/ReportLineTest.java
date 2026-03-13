package br.com.testebatch.car_dealer.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ReportLineTest {

    @Test
    void shouldAddSaleCorrectly() {

        ReportLine line = new ReportLine("Dealer1", "Civic");

        line = line.addSale(new BigDecimal("30000"));
        line = line.addSale(new BigDecimal("20000"));

        assertEquals(2, line.unitsSold());
        assertEquals(new BigDecimal("50000"), line.revenueBrl());
    }
}