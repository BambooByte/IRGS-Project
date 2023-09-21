package com.com.mini_project_1.Cont;

import com.com.mini_project_1.DTO.CitizenPlanDTO;
import com.com.mini_project_1.Model.CitizenPlan;
import com.com.mini_project_1.Service.CitizenPlanService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class CitizenPlanController {

	@Autowired
    private CitizenPlanService service;

  

    
    @GetMapping("/Appp")
    public String getCitizens(@ModelAttribute("citizen") CitizenPlanDTO citizen, Model model) {
    	//model.addAttribute("citizenPlanDTO", new CitizenPlanDTO());
      init(model);
  
      return "App";
    }

	private void init(Model model) {
		
		model.addAttribute("planNames", service.getPlanName());
		  model.addAttribute("planStatuses", service.getPlanStatus());
	}
     
    
    @PostMapping("/citizen-details/search")
    public String searchCitizenDetails(@ModelAttribute("citizen") CitizenPlanDTO citizen,Model model) {
    	
    	model.addAttribute("citizenPlanDTO", new CitizenPlanDTO());
    	
    	List<CitizenPlan> citizens= service.getSelectedPlans(citizen);
    	
    	if (citizens.isEmpty()) {
    		
            model.addAttribute("message", "No Records Found");
            
        } else {
        	
        	model.addAttribute("citizens", citizens);       
       	}
    	 
    	  
    	  
          init(model);

    				
    	return "App";
    }
    
   
    
    
    @GetMapping("/excel")
    public void excelExport( HttpServletResponse response) throws Exception {
    	
    	response.setContentType("application/octet-stream");
    	response.addHeader("Content-Disposition", "attachment;filename= plans.xls");
    	
    	service.getExcelData(response);
    }
    
    
    @GetMapping("/pdf")
    public void pdfExport(HttpServletResponse response) throws Exception {
    	
    	response.setContentType("application/pdf");
    	response.addHeader("Content-Disposition", "attachment;filename= plans.pdf");
    	
    	service.getPdfData(response);
    }
    
    
    
    
}
