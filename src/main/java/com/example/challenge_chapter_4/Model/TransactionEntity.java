package com.example.challenge_chapter_4.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    private UUID uidTransaction;
    private int id_user;
    private int id_jadwal;
    @JsonIgnore
    private String username;
    @JsonIgnore
    private String film_name;
    private String film_code;
    @JsonIgnore
    private Date tanggal_tayang;
    private int nomor_kursi;
    private char studio_name;
    @JsonIgnore
    private Time jam_mulai;
    @JsonIgnore
    private Time jam_selesai;
    @JsonIgnore
    private int harga_tiket;
}
