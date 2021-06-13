package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Admin;

/**
 * 
 * @author Susmitha
 *
 */
@Service
@Transactional
public interface IAdminService extends IUserService {

	/**
	 * 
	 * @param admin
	 * @return
	 */
	/**
	 * @param admin
	 * @return
	 */
	public Admin addAdmin(Admin admin);

	/**
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws ValidationException
	 */
	/**
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws ValidationException
	 */
	public Admin updateAdminPasswordById(Long id, String oldPassword, String newPassword) throws ValidationException;

	/**
	 * @param id
	 * @param oldMobileNo
	 * @param newMobileNo
	 * @return
	 * @throws ValidationException
	 */
	public Admin updateAdminMobileNoById(Long id, Long oldMobileNo, Long newMobileNo) throws ValidationException;

	/**
	 * @param id
	 * @param oldEmail
	 * @param newEmail
	 * @return
	 * @throws ValidationException
	 */
	public Admin updateAdminEmailById(Long id, String oldEmail, String newEmail) throws ValidationException;

	/**
	 * @return
	 */
	public List<Admin> getAdmin();

	/**
	 * @param admin
	 * @return
	 */
	public Admin updateAdmin(Admin admin);

	/**
	 * @param id
	 * @return
	 */
	public String deleteAdmin(Long id);

	/**
	 * @param Id
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	public boolean changePassword(Long Id, String oldPassword, String newPassword);

}
