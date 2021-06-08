package com.sprint.otms;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
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
	
	@Test
	void testUpdateBus() {
		Bus b = new Bus();
		b.setBusId(234L);
		when(busRepository.save(b)).thenReturn(b);
		assertEquals(b, busService.updateBus(b));
	}
	
	@Test
	void testGetAllBuses() {
		List<Bus> list = new ArrayList<>();
		list.add(new Bus(320F,32L));
		list.add(new Bus(432F,21L));
		when(busRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), busService.getAllBuses().size());	
	}
	
//	@Test
//	void testDelete() {
//		Bus bus = new Bus();
//		bus.setBusId(5L);
//		doNothing().when(busRepository).deleteById(1);
//		when(busRepository.findById(5L).thenReturn(Optional.of(bus));
//		assertEquals("Customer with id: " + bus.getBusId() + " deleted!!", busService.delete(5L));
//	}
	
	@Test
	void testGetBusById() {
		Bus bus = new Bus();
		bus.setBusId(10L);
		when(busRepository.findById(10L)).thenReturn(Optional.of(bus));
		Optional<Bus> b = busService.getBusById(10L);
		assertEquals(bus.toString(), b.toString());
	}
	
	@Test
	void testNotGetBusById() {
		Bus bus = new Bus();
		bus.setBusId(10L);
		when(busRepository.findById(10L)).thenReturn(Optional.of(bus));
		Assertions.assertThrows(ObjectNotFoundException.class, () -> busService.getBusById(20L));
	}
}