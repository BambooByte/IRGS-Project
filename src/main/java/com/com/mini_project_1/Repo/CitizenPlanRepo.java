package com.com.mini_project_1.Repo;

import com.com.mini_project_1.Model.CitizenPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CitizenPlanRepo extends JpaRepository<CitizenPlan,Integer> {

    @Query("SELECT DISTINCT(e.planName) FROM CitizenPlan e")
    List<String> getPlanName();

    @Query("SELECT DISTINCT(e.planStatus) FROM CitizenPlan e")
    List<String> getPlanStatus();

}
