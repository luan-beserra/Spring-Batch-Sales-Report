package br.com.testebatch.car_dealer.processor;

import br.com.testebatch.car_dealer.batch.processor.SaleRecordProcessor;
import br.com.testebatch.car_dealer.domain.SaleRecord;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaleRecordProcessorTest {

    @Test
    void shouldTrimAndUpperCaseModel() {

        SaleRecordProcessor processor = new SaleRecordProcessor();

        SaleRecord input = new SaleRecord(
                "D001",
                "2026-01-10",
                " eon ",
                "Cartão",
                new BigDecimal("90000")
        );

        SaleRecord result = processor.process(input);

        assertEquals("EON", result.model());
    }

    @Test
    void shouldTrimPaymentType(){
        SaleRecordProcessor processor = new SaleRecordProcessor();

        SaleRecord input = new SaleRecord(
                "D001",
                "2026-01-10",
                "EON",
                "Cartão ",
                new BigDecimal("90000")
        );

        SaleRecord result = processor.process(input);

        assertEquals("Cartão", result.paymentType());
    }
}