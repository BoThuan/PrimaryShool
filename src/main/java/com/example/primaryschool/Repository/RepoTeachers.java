package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RepoTeachers extends JpaRepository<Teachers, String> {

    @Query("SELECT t From Teachers t where t.TenGV like %?1%" )
    Optional<Teachers> findByName(String tenGV);

    @Query("SELECT t From Teachers t where t.Email like %?1%" )
    Optional<Teachers> findByEmail(String email);

    @Query("SELECT t From Teachers t where t.SDT like %?1%" )
    Optional<Teachers> findBySDT(String sdt);

    @Query("SELECT count(t) From Teachers t  ")
    Integer countTeachers();
}
