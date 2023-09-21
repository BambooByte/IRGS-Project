package com.com.mini_project_1.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.com.mini_project_1.Model.CitizenPlan;
import com.com.mini_project_1.Repo.CitizenPlanRepo;
import com.com.mini_project_1.Service.CitizenPlanService;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {
	

	public Boolean getPdfData(HttpServletResponse response, List<CitizenPlan> plans, File file) throws IOException {

		Document document= new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));
		
		document.open();
		
		Paragraph paragraph= new Paragraph("Citizen_Plans");
		document.add(paragraph);
		PdfPTable table= new PdfPTable(11);
		table.addCell("ID");
		table.addCell("citizenName");
		table.addCell("gender");
		table.addCell("planName");
		table.addCell("planStatus");
		table.addCell("planStartDate");
		table.addCell("planEndDate");
		table.addCell("benefitAmount");
		table.addCell("denialReason");
		table.addCell("terminatedDate");
		table.addCell("terminationReason");

		for (CitizenPlan citizenPlan : plans) {
			
			table.addCell(String.valueOf(citizenPlan.getCitizenId()));
			table.addCell(citizenPlan.getCitizenName());
			table.addCell(citizenPlan.getGender());
			table.addCell(citizenPlan.getPlanName());
			table.addCell(citizenPlan.getPlanStatus());
			table.addCell(citizenPlan.getPlanStartDate()+"");
			table.addCell(citizenPlan.getPlanEndDate()+"");
			if(null != citizenPlan.getBenefitAmount()) {
				table.addCell(String.valueOf(citizenPlan.getBenefitAmount()));}
				else {
					table.addCell("N/A");
				}
			
			table.addCell(citizenPlan.getDenialReason());
			if(null != citizenPlan.getTerminatedDate()) {
				table.addCell(citizenPlan.getTerminatedDate()+"");}
				else {
					table.addCell("N/A");
				}
			
			table.addCell(citizenPlan.getTerminationReason());
			
		}
		
		document.add(table);
		document.close();
			
			return true;
		}
}
