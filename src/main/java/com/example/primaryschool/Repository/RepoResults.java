package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepoResults extends JpaRepository<Results, String> {

    @Query("Select rs from Assignment assi inner join Results rs on assi.MaPC = rs.assignment inner join Subjects sj on sj.MaMon = assi.subjects where rs.students.MaHS like ?1" )
    List<Results> findBystudent(String mahs);
}
