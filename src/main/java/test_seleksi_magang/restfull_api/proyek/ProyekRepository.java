package test_seleksi_magang.restfull_api.proyek;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test_seleksi_magang.restfull_api.lokasi.Lokasi;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, Integer> {
}
