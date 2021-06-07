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
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.otms.models.Admin;
import com.sprint.otms.models.Travel;
import com.sprint.otms.models.User_Type;
import com.sprint.otms.repositories.IAdminRepository;
import com.sprint.otms.services.AdminServiceImpl;

class AdminServiceTest {
	
	@Mock
	//@MockBean
	private IAdminRepository adminRepository = org.mockito.Mockito.mock(IAdminRepository.class);

	@InjectMocks
	private AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
    
/*	List<Travel> travelList;
	Travel t1,t2,t3;
	t1 = new Travel(432L,travel.setTravelAgentName(TravelAgentName.ORANGE));*/
	
//	@Test
//	void testAddAdmin() {
//		Admin a = new Admin();
//		a.setId(5L);
//		a.setUserName("xyz");
//		a.setEmail("xyz@gmail.com");
//		a.setMobileNumber(46548769845L);
//		a.setPassword("42524");
//		a.setUserType(User_Type.ADMIN);
//		when(adminRepository.save(a)).thenReturn(a);
//		Assertions.assertEquals(a, adminServiceImpl.addAdmin(a));
//	}
	
	@Test
	void testAddAdmin() {
		User_Type u = User_Type.ADMIN;
		Admin a = new Admin(111L, "xyz", "rwgf", "abc@gmail.com", 356342454L, u);
		Admin a1 = new Admin(222L, "abc", "gvs", "xyz@gmail.com", 4653763572L, u);
		when(adminRepository.save(a)).thenReturn(a1);
		Admin res = adminServiceImpl.addAdmin(a);
		assertEquals(res,a1);
	}
}
