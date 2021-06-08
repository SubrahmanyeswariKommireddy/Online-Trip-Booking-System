package com.sprint.otms;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
<<<<<<< HEAD
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
=======
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
>>>>>>> 7d6e68e752165ed2ff64803dd6d28e8f0c176ded

import com.sprint.otms.models.Admin;
import com.sprint.otms.repositories.IAdminRepository;
import com.sprint.otms.services.AdminServiceImpl;

<<<<<<< HEAD
=======
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
>>>>>>> 7d6e68e752165ed2ff64803dd6d28e8f0c176ded
@SpringBootTest
class AdminServiceTest {
	@Mock
<<<<<<< HEAD
	private IAdminRepository adminRepository;
	
=======
	//@MockBean
	private IAdminRepository adminRepository;

>>>>>>> 7d6e68e752165ed2ff64803dd6d28e8f0c176ded
	@InjectMocks
	private AdminServiceImpl adminServiceImpl;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
<<<<<<< HEAD
	public void Test() {
		Admin admin=new Admin("sruthi","123");
	//	Admin admin1=new Admin("sruthi","123");
	 Mockito.when(adminRepository.save(null)).thenReturn(null);
	 assertNull(adminRepository.save(null));
	 //assertEquals(admin, adminServiceImpl.addAdmin(admin));
	
=======
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
>>>>>>> 7d6e68e752165ed2ff64803dd6d28e8f0c176ded
	}
}
