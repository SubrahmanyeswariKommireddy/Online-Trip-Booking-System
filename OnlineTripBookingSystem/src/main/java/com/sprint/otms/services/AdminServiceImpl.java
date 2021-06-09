package com.sprint.otms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Admin;
import com.sprint.otms.repositories.IAdminRepository;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private IAdminRepository adminRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.saveAndFlush(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.saveAndFlush(admin);
	}

	@Override
	public boolean changePassword(Long Id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Admin> getAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}
	
	@Override
	public String deleteAdmin(Long id) {
		 adminRepository.deleteById(id);
		 return "success";
	}
}
