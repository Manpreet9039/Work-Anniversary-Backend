
package com.work.service;

import com.work.email.EmailUtils;
import com.work.model.WorkAnniversaryModel;
import com.work.repository.WorkAnniversaryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WorkAnniversaryServiceImplTest {

    @Mock
    private WorkAnniversaryRepository workAnniversaryRepository;

    @Mock
    private EmailUtils emailUtils;
    
    @Mock
    private MultipartFile file; // Mock MultipartFile object

    @InjectMocks
    private WorkAnniversaryServiceImpl workAnniversaryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUploadEmployee() throws IOException {
        // Given
        Long empId = 1L;
        String empName = "John Doe";
        String empDesignation = "Software Engineer";
        String empDepartment = "IT";
        String email = "john.doe@example.com";
        LocalDate dateOfJoining = LocalDate.now();
        String filePath = "/path/to/file";

        // Mock behavior of MultipartFile object
        when(file.getOriginalFilename()).thenReturn("test.jpg");
        when(file.getInputStream()).thenReturn(new ByteArrayInputStream(new byte[0])); // Mock non-null input stream

        // Mock behavior of WorkAnniversaryRepository
        when(workAnniversaryRepository.save(any(WorkAnniversaryModel.class))).thenReturn(new WorkAnniversaryModel());

        // When
        String result = workAnniversaryService.uploadEmployee(empId, empName, empDesignation, empDepartment,
                email, dateOfJoining, filePath, file);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("uploaded successfully"));
        verify(workAnniversaryRepository, times(1)).save(any(WorkAnniversaryModel.class));
    }
    
//    @Test
//    public void testUploadEmployee() throws IOException {
//        // Given
//        Long empId = 1L;
//        String empName = "John Doe";
//        String empDesignation = "Software Engineer";
//        String empDepartment = "IT";
//        String email = "john.doe@example.com";
//        LocalDate dateOfJoining = LocalDate.now();
//        String filePath = "/path/to/file";
//        MultipartFile file = mock(MultipartFile.class);
//        when(file.getOriginalFilename()).thenReturn("test.jpg");
//        
//        // Mocking behavior to throw an exception when save is called
//        doThrow(new RuntimeException("Failed to save employee")).when(workAnniversaryRepository).save(any(WorkAnniversaryModel.class));
//
//        // When
//        String result = workAnniversaryService.uploadEmployee(empId, empName, empDesignation, empDepartment,
//                email, dateOfJoining, filePath, file);
//
//        // Then
//        assertNotNull(result);
//        assertTrue(result.contains("failed to upload"));
//        verify(workAnniversaryRepository, times(1)).save(any(WorkAnniversaryModel.class));
//    }


    @Test
    public void testGetImagePath() {
        // Given
        Long empId = 1L;
        WorkAnniversaryModel employee = new WorkAnniversaryModel();
        employee.setFilePath("/path/to/image.jpg");
        when(workAnniversaryRepository.findByEmpId(empId)).thenReturn(Optional.of(employee));

        // When
        String result = workAnniversaryService.getImagePath(empId);

        // Then
        assertNotNull(result);
        assertEquals("/path/to/image.jpg", result);
    }

    @Test
    public void testSentSampleMail() {
        // Given
        Long empId = 1L;
        String message = "Happy work anniversary!";
        WorkAnniversaryModel employee = new WorkAnniversaryModel();
        employee.setEmail("john.doe@example.com");
        when(workAnniversaryRepository.findByEmpId(empId)).thenReturn(Optional.of(employee));
        when(emailUtils.sendEmail(anyString(), anyString(), anyString())).thenReturn(true);

        // When
        boolean result = workAnniversaryService.sentSampleMail(empId, message);

        // Then
        assertTrue(result);
        verify(emailUtils, times(1)).sendEmail(eq("john.doe@example.com"), anyString(), eq("Dear john.doe@example.com,\n\nHappy work anniversary!"));
    }
}
