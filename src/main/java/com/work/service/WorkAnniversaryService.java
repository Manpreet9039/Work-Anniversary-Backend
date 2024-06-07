package com.work.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.work.model.WorkAnniversaryModel;

public interface WorkAnniversaryService {
	
	/**
	 * 
	 * @param empId - 
	 * @param empName
	 * @param empDesignation
	 * @param empDepartment
	 * @param email
	 * @param dateOfJoining
	 * @param filePath
	 * @param file
	 * @return
	 * @throws IOException
	 */

    String uploadEmployee(Long empId, String empName, String empDesignation, String empDepartment,
                          String email, LocalDate dateOfJoining, String filePath, MultipartFile file) throws IOException;
    
    /**
     * 
     * @param empId
     * @return
     */

    String getImagePath(Long empId);
    
    /**
     * 
     * @return
     */

    List<WorkAnniversaryModel> getAllEmployee();
    
    /**
     * 
     * @param empId
     * @param message
     * @return
     */

    boolean sentSampleMail(Long empId, String message);
    
    /**
     * 
     * @param to
     * @param message
     * @return
     */

    boolean sentSampleMail(String to, String message);
}
