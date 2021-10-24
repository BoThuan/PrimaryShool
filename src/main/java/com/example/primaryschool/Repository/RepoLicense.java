package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoLicense extends JpaRepository<License, String> {
}
