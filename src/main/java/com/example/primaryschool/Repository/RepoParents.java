package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Parents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoParents extends JpaRepository<Parents, String> {
}
