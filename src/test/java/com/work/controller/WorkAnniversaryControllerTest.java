//package com.work.controller; // Ensure the correct package declaration
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.work.model.WorkAnniversaryModel;
//import com.work.service.WorkAnniversaryService;
//
//public class WorkAnniversaryControllerTest {
//
//    @Mock
//    private WorkAnniversaryService workAnniversaryService;
//
//    @InjectMocks
//    private WorkAnniversaryController workAnniversaryController;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testUploadEmployee_Success() throws IOException {
//        // Given
//        Long empId = 1L;
//        String empName = "John Doe";
//        String empDesignation = "Software Engineer";
//        String empDepartment = "IT";
//        String email = "john.doe@example.com";
//        LocalDate dateOfJoining = LocalDate.now();
//        String filePath = "/path/to/file";
//        MultipartFile file = mock(MultipartFile.class);
//        when(workAnniversaryService.uploadEmployee(empId, empName, empDesignation, empDepartment, email, dateOfJoining, filePath, file)).thenReturn("Employee uploaded successfully");
//
//        // When
//        ResponseEntity<?> response = workAnniversaryController.uploadEmployee(empId, empName, empDesignation, empDepartment, email, dateOfJoining, filePath, file);
//
//        // Then
//        assertNotNull(response);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertTrue(response.getBody().toString().contains("uploaded successfully"));
//    }
//
//    @Test
//    public void testUploadEmployee_Failure() throws IOException {
//        // Given
//        Long empId = 1L;
//        String empName = "John Doe";
//        String empDesignation = "Software Engineer";
//        String empDepartment = "IT";
//        String email = "john.doe@example.com";
//        LocalDate dateOfJoining = LocalDate.now();
//        String filePath = "/path/to/file";
//        MultipartFile file = mock(MultipartFile.class);
//        when(workAnniversaryService.uploadEmployee(empId, empName, empDesignation, empDepartment, email, dateOfJoining, filePath, file)).thenReturn(null);
//
//        // When
//        ResponseEntity<?> response = workAnniversaryController.uploadEmployee(empId, empName, empDesignation, empDepartment, email, dateOfJoining, filePath, file);
//
//        // Then
//        assertNotNull(response);
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
//        assertTrue(response.getBody().toString().contains("Failed to upload"));
//    }
//
//    // Add more tests for other controller methods
//}








package com.work.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.work.model.WorkAnniversaryModel;
import com.work.service.WorkAnniversaryService;

public class WorkAnniversaryControllerTest {

    @Mock
    private WorkAnniversaryService workAnniversaryService;

    @InjectMocks
    private WorkAnniversaryController workAnniversaryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_uploadEmployee_Success() throws IOException {
        // Given
        Long empId = 1L;
        String empName = "John Doe";
        String empDesignation = "Software Engineer";
        String empDepartment = "IT";
        String email = "john.doe@example.com";
        LocalDate dateOfJoining = LocalDate.now();
        String filePath = "/path/to/file";
        MultipartFile file = mock(MultipartFile.class);
        when(workAnniversaryService.uploadEmployee(empId, empName, empDesignation, empDepartment, email, dateOfJoining, filePath, file)).thenReturn("Employee uploaded successfully");

        // When
        ResponseEntity<?> response = workAnniversaryController.uploadEmployee(empId, empName, empDesignation, empDepartment, email, dateOfJoining, filePath, file);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().toString().contains("uploaded successfully"));
    }

    @Test
    public void test_uploadEmployee_Failure() throws IOException {
        // Given
        Long empId = 1L;
        String empName = "John Doe";
        String empDesignation = "Software Engineer";
        String empDepartment = "IT";
        String email = "john.doe@example.com";
        LocalDate dateOfJoining = LocalDate.now();
        String filePath = "/path/to/file";
        MultipartFile file = mock(MultipartFile.class);
        when(workAnniversaryService.uploadEmployee(empId, empName, empDesignation, empDepartment, email, dateOfJoining, filePath, file)).thenReturn(null);

        // When
        ResponseEntity<?> response = workAnniversaryController.uploadEmployee(empId, empName, empDesignation, empDepartment, email, dateOfJoining, filePath, file);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertTrue(response.getBody().toString().contains("Failed to upload"));
    }

    @Test
    public void test_getAllEmployee() {
        // Given
        List<WorkAnniversaryModel> employees = new ArrayList<>();
        employees.add(new WorkAnniversaryModel(0, 1L, "John Doe", "Software Engineer", "IT", null, null, null, null, null));
        when(workAnniversaryService.getAllEmployee()).thenReturn(employees);

        // When
        ResponseEntity<List<WorkAnniversaryModel>> response = workAnniversaryController.getAllEmployee();

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employees, response.getBody());
    }

    @Test
    public void test_getImagePath_Exists() {
        // Given
        Long empId = 1L;
        String imagePath = "/path/to/image.jpg";
        when(workAnniversaryService.getImagePath(empId)).thenReturn(imagePath);

        // When
        ResponseEntity<String> response = workAnniversaryController.getImagePath(empId);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(imagePath, response.getBody());
    }

    @Test
    public void test_getImagePath_NotExists() {
        // Given
        Long empId = 1L;
        when(workAnniversaryService.getImagePath(empId)).thenReturn(null);

        // When
        ResponseEntity<String> response = workAnniversaryController.getImagePath(empId);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void test_sendMail_Success() {
        // Given
        Long empId = 1L;
        String message = "Happy Work Anniversary!";
        when(workAnniversaryService.sentSampleMail(empId, message)).thenReturn(true);

        // When
        ResponseEntity<?> response = workAnniversaryController.sendMail(empId, message);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void test_sendMail_NoMessage() {
        // Given
        Long empId = 1L;
        String message = null;

        // When
        ResponseEntity<?> response = workAnniversaryController.sendMail(empId, message);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Assert that message is false in response data
        assertFalse(((boolean) ((java.util.Map<?, ?>) response.getBody()).get("isMessage")));
    }
}
