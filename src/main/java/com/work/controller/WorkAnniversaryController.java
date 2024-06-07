//
//
//package com.work.controller;
//
//
//import java.io.File;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Map;
//
//import java.util.HashMap;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.work.model.WorkAnniversaryModel;
//import com.work.service.WorkAnniversaryService;
//
//
//@CrossOrigin
//@RestController
//@RequestMapping("/api/work-anniversary")
//public class WorkAnniversaryController {
//
//    @Autowired
//    private WorkAnniversaryService workAnniversaryService;
//
//  
//        @PostMapping("/upload")
//        public ResponseEntity<?> uploadEmployee(
//                @RequestParam("empId") Long empId,
//                @RequestParam("empName") String empName,
//                @RequestParam("empDesignation") String empDesignation,
//                @RequestParam("empDepartment") String empDepartment,
//                @RequestParam("email") String email,
//                @RequestParam("dateOfJoining") LocalDate dateOfJoining,
//                @RequestParam("filePath") String filePath,
//                @RequestParam("image") MultipartFile file) {
//
//            try {
//                // Call the service method to handle both employee details and image
//                String result = workAnniversaryService.uploadEmployee(empId, empName, empDesignation, empDepartment, email, dateOfJoining, filePath, file);
//
//                if (result != null) {
//                    // Upload successful
//                    return ResponseEntity.ok(result);
//                } else {
//                    // Upload failed
//                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                            .body("Failed to upload employee details with image");
//                }
//            } catch (IOException e) {
//                // Handle IO exception
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                        .body("Error during upload: " + e.getMessage());
//            }
//        }
//    
//
//
//		
//		@GetMapping("/getall")
//		
//		public ResponseEntity<List<WorkAnniversaryModel>> getAllEmployee(){
//			
//			List<WorkAnniversaryModel> allEmployees= workAnniversaryService.getAllEmployee();
//			
//			return ResponseEntity.ok(allEmployees);
//		}
//		
//		
//		
//		
//		@GetMapping("/getImagePath/{empId}")
//	    public ResponseEntity<String> getImagePath(@PathVariable Long empId) {
//	        String imagePath = workAnniversaryService.getImagePath(empId);
//	
//	        if (imagePath != null) {
//	            return ResponseEntity.ok(imagePath);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
//
//	
//
//		
//		@GetMapping("/send_wish")
//		public ResponseEntity<?> sendMail(
//		        @RequestParam("empId") Long empId,
//		        @RequestParam("message") String message) {
//			
//			Map<String,Object>responseData=new HashMap<>();
//			boolean isMessage;
//			
//			if(message.length()==0 && message!=null) {
//				isMessage=false;
//				responseData.put("data", message);
//				responseData.put("isMessage", isMessage);
//				responseData.put("empId",empId );
//			}
//			else {
//				isMessage=true;
//				responseData.put("data", message);
//				responseData.put("isMessage", isMessage);
//				responseData.put("empId",empId );
//				
//				
//			}
//	
//		    boolean result = workAnniversaryService.sentSampleMail(empId, message);
//		    
//		    System.out.print(result+"result");
//		    
//		    responseData.put("result", result);
//		    
//		    return ResponseEntity.ok(responseData);
//	
//		} 
//	
//
//		
//}
//	
//	
//	






package com.work.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.work.model.WorkAnniversaryModel;
import com.work.service.WorkAnniversaryService;

@CrossOrigin
@RestController
@RequestMapping("/api/work-anniversary")
public class WorkAnniversaryController {

    @Autowired
    private WorkAnniversaryService workAnniversaryService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadEmployee(
            @RequestParam("empId") Long empId,
            @RequestParam("empName") String empName,
            @RequestParam("empDesignation") String empDesignation,
            @RequestParam("empDepartment") String empDepartment,
            @RequestParam("email") String email,
            @RequestParam("dateOfJoining") LocalDate dateOfJoining,
            @RequestParam("filePath") String filePath,
            @RequestParam("file") MultipartFile file) {

        try {
            // Call the service method to handle both employee details and image
            String result = workAnniversaryService.uploadEmployee(empId, empName, empDesignation, empDepartment, email, dateOfJoining, filePath, file);

            if (result != null) {
                // Upload successful
                return ResponseEntity.ok(result);
            } else {
                // Upload failed
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to upload employee details with image");
            }
        } catch (IOException e) {
            // Handle IO exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during upload: " + e.getMessage());
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<List<WorkAnniversaryModel>> getAllEmployee() {
        List<WorkAnniversaryModel> allEmployees = workAnniversaryService.getAllEmployee();
        return ResponseEntity.ok(allEmployees);
    }

    @GetMapping("/getImagePath/{empId}")
    public ResponseEntity<String> getImagePath(@PathVariable Long empId) {
        String imagePath = workAnniversaryService.getImagePath(empId);
        if (imagePath != null) {
            return ResponseEntity.ok(imagePath);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/send_wish")
    public ResponseEntity<?> sendMail(
            @RequestParam("empId") Long empId,
            @RequestParam("message") String message) {
        Map<String, Object> responseData = new HashMap<>();
        boolean isMessage;

        if (message == null || message.isEmpty()) {
            isMessage = false;
        } else {
            isMessage = true;
        }

        responseData.put("data", message);
        responseData.put("isMessage", isMessage);
        responseData.put("empId", empId);

        boolean result = workAnniversaryService.sentSampleMail(empId, message);
        responseData.put("result", result);

        return ResponseEntity.ok(responseData);
    }
}
