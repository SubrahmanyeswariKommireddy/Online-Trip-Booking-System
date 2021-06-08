package com.sprint.otms;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


import com.sprint.otms.models.Admin;
import com.sprint.otms.repositories.IAdminRepository;
import com.sprint.otms.services.AdminServiceImpl;


//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

@SpringBootTest
class AdminServiceTest {
	@Mock

	private IAdminRepository adminRepository;




	@InjectMocks
	private AdminServiceImpl adminServiceImpl;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}


	

	@Test
	void testAddAdmin() {
		Admin admin = new Admin("susmitha", "123");
		when(adminRepository.save(admin)).thenReturn(admin);
		Assertions.assertEquals(admin, adminServiceImpl.addAdmin(admin));
	}
	
	@Test
	void testUpdateAdmin() {
		Admin admin = new Admin();
		admin.setId(222L);
		when(adminRepository.save(admin)).thenReturn(admin);
		Assertions.assertEquals(admin, adminServiceImpl.updateAdmin(admin));

	}
}
