package com.work.model;
import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity 
@Table(name="work_anniversary")
public class WorkAnniversaryModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="emp_id")
	private Long empId;
	
	@Column(name="emp_name")
	private String empName;
	

	@Column(name="emp_designation")
	private String empDesignation;
	
	@Column(name="emp_Department")
	private String empDepartment;
	
	
	@Column(name="img_name")
	private String imgName;
	
	private String email;
	
	@Column(name="date_of_joining")
	private LocalDate dateOfJoining;
	
    
    @Column(name="filePath")
    private String filePath;
    
	
	
	
	//private String message;
	
	
	

	
	

	@JsonIgnore
    @Transient
    private MultipartFile file;
	
	
	
//	@Lob
//	@Column(name="img_data", columnDefinition="LONGBLOB")
//	
//	private byte[] imgData;
//	
	
	
	public WorkAnniversaryModel() {
		
	}



	public WorkAnniversaryModel(int id, Long empId, String empName, String empDesignation, String empDepartment,
			 String imgName, String email, LocalDate dateOfJoining, String filePath, MultipartFile file ) {
		super();
		this.id = id;
		this.empId = empId;
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.empDepartment = empDepartment;
		this.imgName = imgName;
		this.email = email;
		this.dateOfJoining = dateOfJoining;
		this.filePath = filePath;
		this.file = file;
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Long getEmpId() {
		return empId;
	}



	public void setEmpId(Long empId) {
		this.empId = empId;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public String getEmpDesignation() {
		return empDesignation;
	}



	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}



	public String getEmpDepartment() {
		return empDepartment;
	}



	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}



	



	public String getImgName() {
		return imgName;
	}



	public void setImgName(String imgName) {
		this.imgName = imgName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}



	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	

	

	public String getFilePath() {
		return filePath;
	}





	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}





	public MultipartFile getFile() {
		return file;
	}





	public void setFile(MultipartFile file) {
		this.file = file;
	}



    
	
	

	
}
