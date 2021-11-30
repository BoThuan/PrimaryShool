package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RepoStudents extends JpaRepository<Students, String> {

    @Query("SELECT s From Students s where s.TenHS like ?1" )
    Optional<Students> findByName(String Name);

    @Query("SELECT s From Students s where s.GioiTinh = ?1 ")
    Optional<Students> findByMale(Boolean gioiTinh);

    @Query("SELECT count(s) From Students s  ")
    Integer countStudent();

    @Query("SELECT s From Students s where s.SDTPhuHuynh like ?1" )
    Optional<Students> findBySDT(String sdt);
}
