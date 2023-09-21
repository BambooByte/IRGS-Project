package com.com.mini_project_1.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "citizen_plans_info")
public class CitizenPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer citizenId;

    private String  citizenName;

    private String gender;

    private String planName;

    private String planStatus;

    private LocalDate planStartDate;

    private LocalDate planEndDate;

    private Double benefitAmount;

    private String denialReason;

    private LocalDate terminatedDate;

    private String terminationReason;

	public Integer getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(Integer citizenId) {
		this.citizenId = citizenId;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

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

	public Double getBenefitAmount() {
		return benefitAmount;
	}

	public void setBenefitAmount(Double benefitAmount) {
		this.benefitAmount = benefitAmount;
	}

	public String getDenialReason() {
		return denialReason;
	}

	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}

	public LocalDate getTerminatedDate() {
		return terminatedDate;
	}

	public void setTerminatedDate(LocalDate terminatedDate) {
		this.terminatedDate = terminatedDate;
	}

	public String getTerminationReason() {
		return terminationReason;
	}

	public void setTerminationReason(String terminationReason) {
		this.terminationReason = terminationReason;
	}

	public CitizenPlan(Integer citizenId, String citizenName, String gender, String planName, String planStatus,
			LocalDate planStartDate, LocalDate planEndDate, Double benefitAmount, String denialReason,
			LocalDate terminatedDate, String terminationReason) {
		super();
		this.citizenId = citizenId;
		this.citizenName = citizenName;
		this.gender = gender;
		this.planName = planName;
		this.planStatus = planStatus;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
		this.benefitAmount = benefitAmount;
		this.denialReason = denialReason;
		this.terminatedDate = terminatedDate;
		this.terminationReason = terminationReason;
	}

	public CitizenPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CitizenPlan [citizenId=" + citizenId + ", citizenName=" + citizenName + ", gender=" + gender
				+ ", planName=" + planName + ", planStatus=" + planStatus + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", benefitAmount=" + benefitAmount + ", denialReason=" + denialReason
				+ ", terminatedDate=" + terminatedDate + ", terminationReason=" + terminationReason + "]";
	}
    
    
}
