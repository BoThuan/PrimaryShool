package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Ministry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepoMinistry extends JpaRepository<Ministry, String> {

    @Query("SELECT m FROM Ministry m WHERE m.MaGiaoVu = (SELECT MAX(m.MaGiaoVu) FROM Ministry m)")
    List<Ministry> maxMaMinistry();
}
