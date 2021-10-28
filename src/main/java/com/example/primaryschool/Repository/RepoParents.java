package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Parents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RepoParents extends JpaRepository<Parents, String> {
    @Query("select p from Parents p where p.TenPH like ?1")
    Optional<Parents> findByName(String tenPH);

    @Query("select p from Parents p where p.Sdt like ?1")
    Optional<Parents> findByPhone(String Sdt);
}
