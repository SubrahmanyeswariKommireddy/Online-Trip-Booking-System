package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Travel;
import com.sprint.otms.models.TravelAgentName;
import com.sprint.otms.repositories.ITravelRepository;
import com.sprint.otms.services.TravelServiceImpl;

class TravelServiceTest {
	@Autowired
	TravelServiceImpl travelService;
	@MockBean
	ITravelRepository travelRepository;
    //List<Bus> buses=new ArrayList<Bus>();
  //  buses.add(25F,32L);
	@Test
	void testAddTravel() {
		Travel t = new Travel();
	    t.setTravelAgentName(TravelAgentName.ORANGE);
	   when(travelRepository.save(t)).thenReturn(t);
	   assertEquals(t, travelService.addTravel(t));
	}
}
