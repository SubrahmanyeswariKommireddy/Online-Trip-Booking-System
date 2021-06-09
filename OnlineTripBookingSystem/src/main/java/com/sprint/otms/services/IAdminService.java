package com.sprint.otms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Admin;

@Service
public interface IAdminService {
	
	public Admin addAdmin(Admin admin);
	
	public List<Admin> getAdmin();
	
	public Admin updateAdmin(Admin admin);
	
	public String deleteAdmin(Long id);
	
	public boolean changePassword(Long Id,String oldPassword, String newPassword);

}
