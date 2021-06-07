package com.sprint.otms.services;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Admin;

@Service
public interface IAdminService {
	
	public Admin addAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin);
	
	public boolean changePassword(Long Id,String oldPassword, String newPassword);

}
