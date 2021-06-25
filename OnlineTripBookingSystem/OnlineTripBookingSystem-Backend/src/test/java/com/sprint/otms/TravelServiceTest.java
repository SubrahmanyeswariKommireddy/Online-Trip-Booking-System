package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Travel;
import com.sprint.otms.models.TravelAgentName;
import com.sprint.otms.repositories.IBusRepository;
import com.sprint.otms.repositories.ITravelRepository;
import com.sprint.otms.services.BusServiceImpl;
import com.sprint.otms.services.TravelServiceImpl;

/**
 * 
 * @author Subrahmanyeswari
 *
 */
@SpringBootTest
class TravelServiceTest {

	@Mock
	ITravelRepository travelRepository;

	@InjectMocks
	TravelServiceImpl travelServiceImpl;

	@Mock
	IBusRepository busRepository;

	@InjectMocks
	BusServiceImpl busServiceImpl;

	@Test
	public void testAddTravel() {
		Travel travel = new Travel(TravelAgentName.ORANGE);
		when(travelRepository.save(travel)).thenReturn(travel);
		travelServiceImpl.addTravel(travel);
		assertEquals(TravelAgentName.ORANGE, travel.getTravelAgentName());
	}

	@Test
	void testNotAddTravel() {
		Travel travel1 = new Travel(TravelAgentName.ORANGE);
		Travel travel2 = new Travel(TravelAgentName.GREENLINE);
		when(travelRepository.save(travel1)).thenReturn(travel1);
		assertEquals(travel1, travelServiceImpl.addTravel(travel2));
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
	void testGetTravelById() {
		Travel travel = new Travel(10L);
		when(travelRepository.getById(travel.getTravelId())).thenReturn(travel);
		Travel t = travelServiceImpl.getTravelById(travel.getTravelId());
		assertEquals(t, travel);
	}

	@Test
	void testNotGetTravelById() {
		Travel travel = new Travel(10L);
		when(travelRepository.getById(travel.getTravelId())).thenReturn(travel);
		Travel t = travelServiceImpl.getTravelById(travel.getTravelId());
		assertNotEquals(t, travel);
	}

	@Test
	void testDelete() {
		Travel obj = new Travel();
		obj.setTravelId(12L);
		doNothing().when(travelRepository).deleteById(12L);
		when(travelRepository.getById(12L)).thenReturn(obj);
		assertEquals("success", travelServiceImpl.delete(12L));
	}

	@Test
	void testNotDelete() {
		Travel obj = new Travel();
		obj.setTravelId(12L);
		doNothing().when(travelRepository).deleteById(12L);
		when(travelRepository.getById(12L)).thenReturn(obj);
		assertNotEquals("success", travelServiceImpl.delete(12L));
	}
}