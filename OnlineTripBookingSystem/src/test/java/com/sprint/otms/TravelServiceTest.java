package com.sprint.otms;

import static org.assertj.core.api.Assertions.doesNotHave;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Travel;
import com.sprint.otms.models.TravelAgentName;
import com.sprint.otms.repositories.ITravelRepository;
import com.sprint.otms.services.TravelServiceImpl;
@SpringBootTest
class TravelServiceTest {

<<<<<<< HEAD
	@MockBean
	private ITravelRepository travelRepository;
	
	@Autowired
	private TravelServiceImpl travelServiceImpl;
	
	@Test
	public void testAddTravel() {
		Travel travel=new Travel();
		travel.setTravelAgentName(TravelAgentName.ORANGE);
		when(travelRepository.save(travel)).thenReturn(travel);
		assertEquals(travel, travelServiceImpl.addTravel(travel));
	}
	
	@Test
	public void testNotAddTravel() {
		Travel travel=new Travel();
		Travel travel2=new Travel();
		travel.setTravelAgentName(TravelAgentName.ORANGE);
		travel2.setTravelAgentName(TravelAgentName.ORANGE);
		when(travelRepository.save(travel)).thenReturn(travel);
		assertEquals(travel, travelServiceImpl.addTravel(travel2));
	}
	
	@Test
	void testGetAllTravels() {
		List<Travel>list = new ArrayList<>();
		Travel t = new Travel();
		t.setTravelAgentName(TravelAgentName.GREENLINE);
		Travel t1 = new Travel();
		t1.setTravelAgentName(TravelAgentName.GREENLINE);
		list.add(t);
		list.add(t1);
		when(travelRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), travelServiceImpl.getAllTravel().size());
	}
	

=======
	@Mock
	TravelServiceImpl travelService;

	@InjectMocks
	ITravelRepository travelRepository;
>>>>>>> 7d6e68e752165ed2ff64803dd6d28e8f0c176ded

	@Test
	void testNotGetAllTravels() {
		List<Travel>list = new ArrayList<>();
		Travel t = new Travel();
<<<<<<< HEAD
		t.setTravelAgentName(TravelAgentName.GREENLINE);
		Travel t1 = new Travel();
		t1.setTravelAgentName(TravelAgentName.GREENLINE);
		list.add(t);
		list.add(t1);
		when(travelRepository.findAll()).thenReturn(list);
		assertNotEquals(list.size(), travelServiceImpl.getAllTravel().size());
=======
		t.setTravelAgentName(TravelAgentName.ORANGE);
		when(travelRepository.save(t)).thenReturn(t);
		assertEquals(t, travelService.addTravel(t));
>>>>>>> 7d6e68e752165ed2ff64803dd6d28e8f0c176ded
	}
	
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
	//}
}
