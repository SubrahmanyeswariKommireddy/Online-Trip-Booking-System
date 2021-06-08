package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.sprint.otms.models.Admin;
import com.sprint.otms.repositories.IAdminRepository;
import com.sprint.otms.services.AdminServiceImpl;

@SpringBootTest
class AdminServiceTest {
	
	@Mock
	private IAdminRepository adminRepository;

	@InjectMocks
	private AdminServiceImpl adminServiceImpl;

	@Test
	void testAddAdmin() {
		Admin admin = new Admin("John", "123");
		when(adminRepository.save(admin)).thenReturn(admin);
		adminServiceImpl.addAdmin(admin);
		assertEquals("John",admin.getUserName());
		assertEquals("123",admin.getPassword());
	}

	@Test
	void testUpdateAdmin() {
		Admin admin = new Admin();
		admin.setUserName("John");
		when(adminRepository.save(admin)).thenReturn(admin);
		adminServiceImpl.updateAdmin(admin);
		assertEquals("John", admin.getUserName());

	}
}
