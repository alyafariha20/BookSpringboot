package id.ac.ub.filkom.contoh.service;

import id.ac.ub.filkom.contoh.entity.Anggota;
import id.ac.ub.filkom.contoh.repository.AnggotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/** Service: logika untuk fitur anggota. */
@Service
public class AnggotaService {

    private final AnggotaRepository anggotaRepository;

    public AnggotaService(AnggotaRepository anggotaRepository) {
        this.anggotaRepository = anggotaRepository;
    }

    public List<Anggota> lihatSemuaAnggota() {
        return anggotaRepository.findAll();
    }

    public Anggota tambahAnggota(String idAnggota, String nama, int batasPinjam) {
        if (batasPinjam < 1) {
            throw new IllegalArgumentException("Batas pinjam minimal 1");
        }
        if (anggotaRepository.existsById(idAnggota)) {
            throw new IllegalArgumentException("ID anggota sudah dipakai");
        }
        return anggotaRepository.save(new Anggota(idAnggota, nama, batasPinjam));
    }
}