package br.com.testebatch.car_dealer.writer;

import br.com.testebatch.car_dealer.batch.writer.SalesReportWriter;
import br.com.testebatch.car_dealer.domain.SaleRecord;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.batch.infrastructure.item.Chunk;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.mock;

class SalesReportWriterTest {

    @Test
    void shouldWriteSales() {

        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);

        SalesReportWriter writer =
                new SalesReportWriter(jdbcTemplate, "test.csv");

        SaleRecord record = new SaleRecord(
                "D005",
                "2026,2,05",
                "Lume",
                "Consórcio",
                new BigDecimal("90000")
        );

        Chunk<SaleRecord> chunk = new Chunk<>(List.of(record));

        writer.write(chunk);
    }
}