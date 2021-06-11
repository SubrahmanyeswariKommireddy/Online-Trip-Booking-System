package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Admin;

@Service
@Transactional
public interface IAdminService extends IUserService{
	
	public Admin addAdmin(Admin admin);
	
	public Admin updateAdminById(Long id,String oldPassword,String newPassword) throws ValidationException;
	
	public List<Admin> getAdmin();
	
	public Admin updateAdmin(Admin admin);
	
	public String deleteAdmin(Long id);
	
	public boolean changePassword(Long Id,String oldPassword, String newPassword);

}
