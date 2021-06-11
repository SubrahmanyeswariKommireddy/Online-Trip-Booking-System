package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Admin;
import com.sprint.otms.models.Customer;

@Service
@Transactional
public interface IAdminService extends IUserService{
	
	public Admin addAdmin(Admin admin);
	
	public Admin updateAdminPasswordById(Long id, String oldPassword, String newPassword) throws ValidationException;
	
	public Admin updateAdminMobileNoById(Long id, Long oldMobileNo, Long newMobileNo) throws ValidationException;
	
	public Admin updateAdminEmailById(Long id, String oldEmail, String newEmail) throws ValidationException;
	
	public List<Admin> getAdmin();
	
	public Admin updateAdmin(Admin admin);
	
	public String deleteAdmin(Long id);
	
	public boolean changePassword(Long Id,String oldPassword, String newPassword);

}
