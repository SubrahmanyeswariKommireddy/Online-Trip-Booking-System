package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sprint.otms.models.Travel;
import com.sprint.otms.models.TravelAgentName;
import com.sprint.otms.repositories.ITravelRepository;
import com.sprint.otms.services.BusServiceImpl;
import com.sprint.otms.services.TravelServiceImpl;

@SpringBootTest
class TravelServiceTest {

	@Mock
	ITravelRepository travelRepository;

	@InjectMocks
	TravelServiceImpl travelServiceImpl;
	@Autowired
	BusServiceImpl busServiceImpl;

	@Test
	public void testAddTravel() {
		Travel travel = new Travel(TravelAgentName.ORANGE);
		// travel.setTravelAgentName(TravelAgentName.ORANGE);
		when(travelRepository.save(travel)).thenReturn(travel);
		travelServiceImpl.addTravel(travel);
		assertEquals(TravelAgentName.ORANGE, travel.getTravelAgentName());
	}

	@Test
	void testGetAllTravels() {
		List<Travel> list = new ArrayList<>();
		Travel t = new Travel();
		t.setTravelAgentName(TravelAgentName.GREENLINE);
		Travel t1 = new Travel();
		t1.setTravelAgentName(TravelAgentName.GREENLINE);
		list.add(t);
		list.add(t1);
		when(travelRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), travelServiceImpl.getAllTravel().size());
	}

	@Test
	void testGetTravelById() {
		Travel travel = new Travel(10L);
		when(travelRepository.getById(travel.getTravelId())).thenReturn(travel);
		Travel t = travelServiceImpl.getTravelById(travel.getTravelId());
		assertEquals(t, travel);
	}

//	@Test
//	void testUpdateTravels() {
//		List<Bus> list = new ArrayList<>();
//		list.add(new Bus(234F));
//		list.add(new Bus(340F));
//		Travel t = new Travel();
//		when(travelRepository.save(t)).thenReturn(t);		
//		assertEquals(list, busServiceImpl.getAllBuses());
//	}

//	@Test
//	public void testNotAddTravel() {
//		Travel travel=new Travel();
//		Travel travel2=new Travel();
//		travel.setTravelAgentName(TravelAgentName.ORANGE);
//		travel2.setTravelAgentName(TravelAgentName.ORANGE);
//		when(travelRepository.save(travel)).thenReturn(travel);
//		assertEquals(travel, travelServiceImpl.addTravel(travel2));
//	}
//

//	@Test
//	void testNotGetAllTravels() {
//		List<Travel>list = new ArrayList<>();
//		Travel t = new Travel();
//
//		t.setTravelAgentName(TravelAgentName.GREENLINE);
//		Travel t1 = new Travel();
//		t1.setTravelAgentName(TravelAgentName.GREENLINE);
//		list.add(t);
//		list.add(t1);
//		when(travelRepository.findAll()).thenReturn(list);
//		assertNotEquals(list.size(), travelServiceImpl.getAllTravel().size());
//
//		t.setTravelAgentName(TravelAgentName.ORANGE);
//		when(travelRepository.save(t)).thenReturn(t);
//		assertEquals(t, travelServiceImpl.addTravel(t));
//
//	}

//	@Test
//	void testDelete() {
//		Travel t = new Travel();
//		t.setTravelId(1L);
//		doNothing().when(travelRepository).delete(t);
//		when(travelRepository.findOne(t)).thenReturn((List<Travel>) t);
//		assertEquals(t.getTravelAgentName(), travelServiceImpl.delete(t));
//		doNothing().when(travelRepository).deleteById(1);
//		when(travelRepository.findById(1)).thenReturn(Optional.of(t));
//		assertEquals("Hotel with id: "+t.getId()+" deleted!!", hotelServiceImpl.delete(1));
	// }
}