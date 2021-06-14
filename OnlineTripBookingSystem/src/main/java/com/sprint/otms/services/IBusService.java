package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Bus;

/**
 * 
 * @author Stephen
 *
 */
@Service
@Transactional
public interface IBusService {

	/**
	 * @param bus
	 * @return Bus
	 */
	public Bus addBus(Bus bus);

	/**
	 * @param bus
	 * @return Updated Bus
	 */
	public Bus updateBus(Bus bus);

	/**
	 * @param busId
	 */
	public String delete(Long busId);

	/**
	 * @param busId
	 * @return Bus By Bus Id
	 */
	public Bus getBusById(Long busId);

	/**
	 * @return
	 */
	public List<Bus> getAllBuses();

	/**
	 * @param id
	 * @param oldFare
	 * @param newFare
	 * @return Updated Fare For Bus
	 * @throws ValidationException
	 */
	public Bus updateFareById(Long id, Float oldFare, Float newFare) throws ValidationException;

}
