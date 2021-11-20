package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Ministry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepoMinistry extends JpaRepository<Ministry, String> {

    @Query("SELECT MAX(m.MaGiaoVu) FROM Ministry m")
    String maxMaMinistry();
}
