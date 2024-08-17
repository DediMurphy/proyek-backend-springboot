package test_seleksi_magang.restfull_api.proyek;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test_seleksi_magang.restfull_api.lokasi.LokasiRepository;
import test_seleksi_magang.restfull_api.lokasi.LokasiService;

import java.util.List;
import java.util.Optional;

@Service
public class ProyekService {

    private final ProyekRepository proyekRepository;
    private final LokasiRepository lokasiRepository;

    @Autowired
    public ProyekService(ProyekRepository proyekRepository, LokasiRepository lokasiRepository) {
        this.proyekRepository = proyekRepository;
        this.lokasiRepository = lokasiRepository;
    }

    public Proyek saveProyek(Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    public Optional<Proyek> findById(Integer id) {
        return proyekRepository.findById(id);
    }

    public Proyek updateProyek(Integer id, Proyek proyekDetails) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proyek not found for this id :: " + id));

        proyek.setNamaProyek(proyekDetails.getNamaProyek());
        proyek.setClient(proyekDetails.getClient());
        proyek.setTglMulai(proyekDetails.getTglMulai());
        proyek.setTglSelesai(proyekDetails.getTglSelesai());
        proyek.setPimpinanProyek(proyekDetails.getPimpinanProyek());
        proyek.setKeterangan(proyekDetails.getKeterangan());

        return proyekRepository.save(proyek);
    }

    public void deleteProyek(Integer id) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proyek not found for this id :: " + id));
        proyekRepository.delete(proyek);
    }
}
