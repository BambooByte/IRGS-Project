package com.com.mini_project_1.DTO;

import lombok.*;

import java.time.LocalDate;


@Builder
public class CitizenPlanDTO {

    private String planName;

    private String planStatus;

    private String gender;

    private LocalDate planStartDate;

    private LocalDate planEndDate;

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public CitizenPlanDTO(String planName, String planStatus, String gender, LocalDate planStartDate,
			LocalDate planEndDate) {
		super();
		this.planName = planName;
		this.planStatus = planStatus;
		this.gender = gender;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
	}

	public CitizenPlanDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CitizenPlanDTO [planName=" + planName + ", planStatus=" + planStatus + ", gender=" + gender
				+ ", planStartDate=" + planStartDate + ", planEndDate=" + planEndDate + "]";
	}

}
