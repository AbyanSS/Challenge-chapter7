package com.example.challenge_chapter_4.Service;

import com.example.challenge_chapter_4.Model.*;
import com.example.challenge_chapter_4.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionInterface transactionInterface;

    @Autowired
    JadwalInterface jadwalInterface;

    @Autowired
    StudioInterface studioInterface;

    @Autowired
    FilmInterface filmInterface;

    @Autowired
    UsersInterface usersInterface;

    @Autowired
    SeatsInterface seatsInterface;

    private UUID generateUuid() {
        return UUID.randomUUID();
    }
    public TransactionEntity addTransaction(TransactionEntity transactionEntity) {
        UsersEntity usersEntity = usersInterface.getReferenceById(transactionEntity.getId_user());
        FilmEntity filmEntity = filmInterface.getReferenceById(transactionEntity.getFilm_code());
        JadwalEntity jadwalEntity = jadwalInterface.getReferenceById(transactionEntity.getId_jadwal());
        SeatsEntity seatsEntity = seatsInterface.getReferenceById(transactionEntity.getNomor_kursi());
        StudioEntity studioEntity = studioInterface.getReferenceById(transactionEntity.getStudio_name());

        TransactionEntity transactionEntity1 = transactionInterface.getByStudioSeat(transactionEntity.getStudio_name(), transactionEntity.getNomor_kursi());
        if(transactionEntity1 != null){
            throw new RuntimeException("Studio name atau no kursi sudah ada");
        }
        TransactionEntity transactionEntity2 = transactionInterface.findById(transactionEntity.getUidTransaction()).orElse(null);
        if(transactionEntity2 == null){
            transactionEntity2 = new TransactionEntity();
            transactionEntity2.setUidTransaction(generateUuid());
            transactionEntity2.setId_user(usersEntity.getId_user());
            transactionEntity2.setId_jadwal(jadwalEntity.getId_jadwal());
            transactionEntity2.setUsername(usersEntity.getUsername());
            transactionEntity2.setFilm_name(filmEntity.getFilm_name());
            transactionEntity2.setFilm_code(filmEntity.getFilm_code());
            transactionEntity2.setTanggal_tayang(jadwalEntity.getTanggal_tayang());
            transactionEntity2.setNomor_kursi(seatsEntity.getNomor_kursi());
            transactionEntity2.setStudio_name(studioEntity.getStudio_name());
            transactionEntity2.setJam_mulai(jadwalEntity.getJam_mulai());
            transactionEntity2.setJam_selesai(jadwalEntity.getJam_selesai());
            transactionEntity2.setHarga_tiket(jadwalEntity.getHarga_tiket());
        }
        return transactionInterface.save(transactionEntity2);
    }

    public void truncate(){
        transactionInterface.deleteAll();
    }

}
