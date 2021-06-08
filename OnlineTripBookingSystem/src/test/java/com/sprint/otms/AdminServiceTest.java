package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.otms.models.Admin;
import com.sprint.otms.models.Travel;
import com.sprint.otms.models.User_Type;
import com.sprint.otms.repositories.IAdminRepository;
import com.sprint.otms.services.AdminServiceImpl;

@SpringBootTest
class AdminServiceTest {
	@Mock
	private IAdminRepository adminRepository;
	
	@InjectMocks
	private AdminServiceImpl adminServiceImpl;
	
	@Test
	public void Test() {
		Admin admin=new Admin("sruthi","123");
	//	Admin admin1=new Admin("sruthi","123");
	 Mockito.when(adminRepository.save(null)).thenReturn(null);
	 assertNull(adminRepository.save(null));
	 //assertEquals(admin, adminServiceImpl.addAdmin(admin));
	
	}
}
