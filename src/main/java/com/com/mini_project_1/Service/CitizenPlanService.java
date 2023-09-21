package com.com.mini_project_1.Service;

import com.com.mini_project_1.DTO.CitizenPlanDTO;
import com.com.mini_project_1.Model.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface CitizenPlanService {

    List<String> getPlanName();

    List<String> getPlanStatus();

    List<CitizenPlan> getAllPlanDetails();

    List<CitizenPlan> getSelectedPlans(CitizenPlanDTO citizenPlanDTO);

    Boolean getExcelData(HttpServletResponse response) throws Exception;
    Boolean getPdfData(HttpServletResponse response) throws Exception ;
}
