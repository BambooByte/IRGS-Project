package com.com.mini_project_1.Service;

import com.com.mini_project_1.DTO.CitizenPlanDTO;
import com.com.mini_project_1.Model.CitizenPlan;
import com.com.mini_project_1.Repo.CitizenPlanRepo;
import com.com.mini_project_1.Utils.EmailUtils;
import com.com.mini_project_1.Utils.ExcelGenerator;
import com.com.mini_project_1.Utils.PdfGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class CitizenPlanServiceImpl implements CitizenPlanService {

    private CitizenPlanRepo citizenPlanRepo;
    
    @Autowired
    private EmailUtils emailUtils;
    
    @Autowired
    private ExcelGenerator excelGenerator;
    
    @Autowired
    private PdfGenerator generator;

    public CitizenPlanServiceImpl(CitizenPlanRepo citizenPlanRepo) {
        this.citizenPlanRepo = citizenPlanRepo;
    }

    @Override
    public List<String> getPlanName() {
     return  citizenPlanRepo.getPlanName();
    }

    @Override
    public List<String> getPlanStatus() {
        return citizenPlanRepo.getPlanStatus();
    }

    @Override
    public List<CitizenPlan> getAllPlanDetails() {
      //  log.info("Inside FindAll Method.....");
        return citizenPlanRepo.findAll();
    }

    @Override
    public List<CitizenPlan> getSelectedPlans(CitizenPlanDTO citizenPlanDTO) {

    	CitizenPlan citizenPlan= new CitizenPlan();
    	
    //	BeanUtils.copyProperties(citizenPlanDTO, citizenPlan);
    	
    	if(null != citizenPlanDTO.getPlanName() && "" != citizenPlanDTO.getPlanName()) {
    		
    		citizenPlan.setPlanName(citizenPlanDTO.getPlanName());
    	}
    	
    	if(null != citizenPlanDTO.getPlanStatus() && "" != citizenPlanDTO.getPlanStatus()) {
    		
    		citizenPlan.setPlanStatus(citizenPlanDTO.getPlanStatus());
    	}
    	
    	if(null != citizenPlanDTO.getGender() && "" != citizenPlanDTO.getGender()) {
	
    		citizenPlan.setGender(citizenPlanDTO.getGender());
    	}
    	
    	if(null != citizenPlanDTO.getPlanStartDate()) {
    		
    		citizenPlan.setPlanStartDate(citizenPlanDTO.getPlanStartDate());
    	}
    	
    	if(null != citizenPlanDTO.getPlanEndDate()) {
    		
    		citizenPlan.setPlanEndDate(citizenPlanDTO.getPlanEndDate());
    	}
    
    	List<CitizenPlan> selectedPlan=	citizenPlanRepo.findAll(Example.of(citizenPlan));
        
         return selectedPlan;
     }


    @Override
    public Boolean getExcelData(HttpServletResponse response) throws Exception{
    
    	List<CitizenPlan> all = citizenPlanRepo.findAll();
    	
    	File f= new File("plans.xls");
    	Boolean excelData = excelGenerator.getExcelData(response,all,f);
    	
    	String sub= "Test Mail";
    	String body= "Testing Purpose...";
    	String to= "gudupanda05@gmail.com";
    	
    	emailUtils.sendMail(sub, body, to, f);
    	
 	f.delete();
    	
    	return excelData;
    	
    }
    
    @Override
    public Boolean getPdfData(HttpServletResponse response) throws Exception {
    	
    	
    	List<CitizenPlan> all = citizenPlanRepo.findAll();
    	
    	File f= new File("plans.pdf");
    	Boolean pdfData = generator.getPdfData(response,all,f);    	
    	String sub= "Test Mail";
    	String body= "Testing Purpose...";
    	String to= "gudupanda05@gmail.com";
    	
    	emailUtils.sendMail(sub, body, to, f);
    	
    	f.delete();
    	
    	
    	return pdfData;
    }
    
    
    }



