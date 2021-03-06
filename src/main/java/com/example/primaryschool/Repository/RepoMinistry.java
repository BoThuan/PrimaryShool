package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Ministry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepoMinistry extends JpaRepository<Ministry, String> {

    @Query("SELECT m FROM Ministry m WHERE m.MaGiaoVu = (SELECT MAX(m.MaGiaoVu) FROM Ministry m)")
    Optional<Ministry> maxMaMinistry();

    @Query("SELECT m From Ministry m where m.SDT like ?1")
    Optional<Ministry> findBySDT(String SDT);

//    @Query("select m from Ministry m where m.ChucVu like '%' ?1 '%'")
//    Optional<Ministry> hieutruong(String hieutruong);

    @Query("select m from Ministry m where m.ChucVu like %?1%")
    Optional<Ministry> hieutruong(String hieutruong);
}
