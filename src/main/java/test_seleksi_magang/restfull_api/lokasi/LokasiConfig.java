package test_seleksi_magang.restfull_api.lokasi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;

@Configuration
public class LokasiConfig {

    @Bean
    CommandLineRunner commandLineRunner(LokasiRepository lokasiRepository) {
        return args -> {
            Lokasi jakarta = new Lokasi(
                    1,
                    "Kantor",
                    "Indonesia",
                    "Jawa Barat",
                    "Jakarta",
                    new Timestamp(System.currentTimeMillis()) // Set the current timestamp
            );
            lokasiRepository.save(jakarta);
        };
    }
}
