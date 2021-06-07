package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.otms.models.Bus;
import com.sprint.otms.repositories.IBusRepository;
import com.sprint.otms.services.BusServiceImpl;

class BusServiceTest {
	@Autowired
	BusServiceImpl busService;
	@MockBean
	IBusRepository busRepository;

	@Test
	void testAddBus() {
		Bus b = new Bus();
		b.setFare(250F);
		b.setTotalCapacity(36L);
		when(busRepository.save(b)).thenReturn(b);
		assertEquals(b, busService.addBus(b));
	}
}