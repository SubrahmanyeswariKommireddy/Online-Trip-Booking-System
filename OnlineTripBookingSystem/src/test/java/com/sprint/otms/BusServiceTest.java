package com.sprint.otms;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.otms.models.Admin;
import com.sprint.otms.models.Booking;
import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Customer;
import com.sprint.otms.models.Payment;
import com.sprint.otms.repositories.IBusRepository;
import com.sprint.otms.repositories.ICustomerRepository;
import com.sprint.otms.services.BusServiceImpl;
import com.sprint.otms.services.CustomerServiceImpl;
@SpringBootTest
class BusServiceTest {
	@Mock
	IBusRepository busRepository;

	@InjectMocks
	BusServiceImpl busServiceImpl;

	@Test
	void testAddBus() {
		Bus b = new Bus(250F,60L);
//		b.setFare(250F);
//		b.setTotalCapacity(36L);
		busServiceImpl.addBus(b);
		when(busRepository.saveAndFlush(b)).thenReturn(b);
		assertEquals(250F, b.getFare());
		assertEquals(60L, b.getTotalCapacity());
	}
	
	
	@Test
	void testUpdateBus() {
		Bus b = new Bus();
		b.setFare(234F);
		when(busRepository.save(b)).thenReturn(b);
		busServiceImpl.updateBus(b);
		assertEquals(234F, b.getFare());
	}
	
	
	@Test
	void testGetAllBuses() {
		List<Bus> list = new ArrayList<>();
		list.add(new Bus(320F,32L));
		list.add(new Bus(432F,21L));
		when(busRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), busServiceImpl.getAllBuses().size());	
	}
	

	@Test
	void testDelete() {
		Bus bus = new Bus();
		bus.setBusId(5L);
		doNothing().when(busRepository).deleteById(5L);
		when(busRepository.getById(5L)).thenReturn(bus);
		assertEquals( "success", busServiceImpl.delete(12L));
	}
	
	@Test
	void testGetBusById() {
		Bus bus = new Bus();
		bus.setBusId(10L);
		when(busRepository.getById(bus.getBusId())).thenReturn(bus);
		Bus b = busServiceImpl.getBusById(10L);
		assertEquals(b,bus);
	}
	
	
//	@Test
//	void testNotGetBusById() {
//		Bus bus = new Bus();
//		bus.setBusId(10L);
//		when(busRepository.findById(10L)).thenReturn(Optional.of(bus));
//		Assertions.assertThrows(ObjectNotFoundException.class, () -> busService.getBusById(20L));
//	}

//	@Test
//	void testUpdateBus() {
//		Bus bus = new Bus();
//		bus.setBusId(1L);
//		when(busRepository.save(bus)).thenReturn(bus);
//		assertEquals(bus, busService.updateBus(bus));
//
//	}
}