package com.com.mini_project_1.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.com.mini_project_1.Model.CitizenPlan;
import com.com.mini_project_1.Repo.CitizenPlanRepo;
import com.com.mini_project_1.Service.CitizenPlanService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {

	
	public Boolean getExcelData( HttpServletResponse response, List<CitizenPlan> citizenPlans, File file) throws IOException {
		
		Workbook workbook= new HSSFWorkbook();
		
		Sheet sheet = workbook.createSheet("plan_details");
		
		Row headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("citizenName");
		headerRow.createCell(2).setCellValue("gender");
		headerRow.createCell(3).setCellValue("planName");
		headerRow.createCell(4).setCellValue("planStatus");
		headerRow.createCell(5).setCellValue("planStartDate");
		headerRow.createCell(6).setCellValue("planEndDate");
		headerRow.createCell(7).setCellValue("benefitAmount");
		headerRow.createCell(8).setCellValue("denialReason");
		headerRow.createCell(9).setCellValue("terminatedDate");
		headerRow.createCell(10).setCellValue("terminationReason");
        
		
		Integer rowIndex= 1;
		
		
		for (CitizenPlan plan : citizenPlans) {
			
			Row createRow = sheet.createRow(rowIndex);
			
			createRow.createCell(0).setCellValue(plan.getCitizenId());
			createRow.createCell(1).setCellValue(plan.getCitizenName());
			createRow.createCell(2).setCellValue(plan.getGender());
			createRow.createCell(3).setCellValue(plan.getPlanName());
			createRow.createCell(4).setCellValue(plan.getPlanStatus());
			createRow.createCell(5).setCellValue(plan.getPlanStartDate()+"");
			createRow.createCell(6).setCellValue(plan.getPlanEndDate()+"");
			if(null != plan.getBenefitAmount()) {
			createRow.createCell(7).setCellValue(plan.getBenefitAmount());}
			else {
			createRow.createCell(7).setCellValue("N/A");
			}
			
			if(null != plan.getBenefitAmount()) {
				createRow.createCell(8).setCellValue(plan.getDenialReason());}
				else {
				createRow.createCell(7).setCellValue("N/A");
				}
			if(null != plan.getBenefitAmount()) {
				createRow.createCell(9).setCellValue(plan.getTerminatedDate());}
				else {
				createRow.createCell(7).setCellValue("N/A");
				}
			if(null != plan.getBenefitAmount()) {
				createRow.createCell(10).setCellValue(plan.getTerminationReason());}
				else {
				createRow.createCell(7).setCellValue("N/A");
				}
			
			

			rowIndex++ ;
			
		}
		
		FileOutputStream fileStream= new FileOutputStream(file);
		workbook.write(fileStream);
		fileStream.close();
		
		ServletOutputStream stream= response.getOutputStream();
		workbook.write(stream);
		workbook.close();
		
		return true;
	}

}
