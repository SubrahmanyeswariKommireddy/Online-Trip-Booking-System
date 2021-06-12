package com.sprint.otms;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.otms.models.Bus;
import com.sprint.otms.repositories.IBusRepository;
import com.sprint.otms.services.BusServiceImpl;

@SpringBootTest
class BusServiceTest {

	@Mock
	IBusRepository busRepository;

	@InjectMocks
	BusServiceImpl busServiceImpl;

	@Test
	void testAddBus() {
		Bus b = new Bus(250F, 60L);
		busServiceImpl.addBus(b);
		when(busRepository.saveAndFlush(b)).thenReturn(b);
		assertEquals(250F, b.getFare());
	}

	@Test
	void testNotAddBus() {
		Bus bus1 = new Bus(250F, 60L);
		Bus bus2 = new Bus(276F, 50L);
		when(busRepository.save(bus1)).thenReturn(bus1);
		assertEquals(bus1, busServiceImpl.addBus(bus2));
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
	void testNotUpdateBus() {
		Bus b = new Bus();
		b.setFare(234F);
		when(busRepository.save(b)).thenReturn(b);
		busServiceImpl.updateBus(b);
		assertNotEquals(234F, b.getFare());
	}

	@Test
	void testGetAllBuses() {
		List<Bus> list = new ArrayList<>();
		list.add(new Bus(320F, 32L));
		list.add(new Bus(432F, 21L));
		when(busRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), busServiceImpl.getAllBuses().size());
	}

	@Test
	void testNotGetAllBuses() {
		List<Bus> list = new ArrayList<>();
		list.add(new Bus(320F, 32L));
		list.add(new Bus(432F, 21L));
		when(busRepository.findAll()).thenReturn(list);
		assertNotEquals(list.size(), busServiceImpl.getAllBuses().size());
	}

	@Test
	void testDelete() {
		Bus bus = new Bus();
		bus.setBusId(5L);
		doNothing().when(busRepository).deleteById(5L);
		when(busRepository.getById(5L)).thenReturn(bus);
		assertEquals("success", busServiceImpl.delete(12L));
	}

	@Test
	void testNotDelete() {
		Bus bus = new Bus();
		bus.setBusId(5L);
		doNothing().when(busRepository).deleteById(5L);
		when(busRepository.getById(5L)).thenReturn(bus);
		assertNotEquals("success", busServiceImpl.delete(12L));
	}

	@Test
	void testGetBusById() {
		Bus bus = new Bus();
		bus.setBusId(10L);
		when(busRepository.getById(bus.getBusId())).thenReturn(bus);
		Bus b = busServiceImpl.getBusById(10L);
		assertEquals(b, bus);
	}

	@Test
	void testNotGetBusById() {
		Bus bus = new Bus();
		bus.setBusId(10L);
		when(busRepository.getById(bus.getBusId())).thenReturn(bus);
		Bus b = busServiceImpl.getBusById(10L);
		assertNotEquals(b, bus);
	}
}