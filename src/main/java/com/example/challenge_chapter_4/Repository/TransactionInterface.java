package com.example.challenge_chapter_4.Repository;

import com.example.challenge_chapter_4.Model.SeatsEntity;
import com.example.challenge_chapter_4.Model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionInterface extends JpaRepository<TransactionEntity, UUID> {

    @Query("SELECT t FROM TransactionEntity t WHERE t.studio_name = :studio_name AND t.nomor_kursi = :nomor_kursi")
    TransactionEntity getByStudioSeat(@Param("studio_name") char studio_name, @Param("nomor_kursi") int nomor_kursi);

}
