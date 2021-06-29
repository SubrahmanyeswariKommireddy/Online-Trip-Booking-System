package com.sprint.otms.services;

import java.util.List;
import javax.transaction.Transactional;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Admin;
import com.sprint.otms.models.User;
import com.sprint.otms.models.User_Type;
import com.sprint.otms.repositories.IAdminRepository;
import com.sprint.otms.repositories.IUserRepository;

/**
 * 
 * @author Susmitha
 *
 */
@Service
@Transactional
public class AdminServiceImpl extends UserServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository adminRepository;
	
	@Autowired
	private IUserRepository userRepository;
	

	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
		
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

	@Override
	public Admin updateAdminPasswordById(Long id, String oldPassword, String newPassword) throws ValidationException {
		// TODO Auto-generated method stub
		java.util.Optional<Admin> admin = adminRepository.findById(id);
		if (admin != null) {
			if (admin.get().getPassword().equals(oldPassword)) {
				admin.get().setPassword(newPassword);
				return adminRepository.save(admin.get());
			} else {
				throw new ValidationException("Incorrect Password");
			}
		}
		return admin.get();
	}

	@Override
	public Admin updateAdminMobileNoById(Long id, Long oldMobileNo, Long newMobileNo) throws ValidationException {
		// TODO Auto-generated method stub
		java.util.Optional<Admin> admin = adminRepository.findById(id);
		if (admin != null) {
			if (admin.get().getMobileNumber().equals(oldMobileNo)) {
				admin.get().setMobileNumber(newMobileNo);
				return adminRepository.save(admin.get());
			} else {
				throw new ValidationException("Incorrect MobileNumber");
			}
		}
		return admin.get();
	}

	@Override
	public Admin updateAdminEmailById(Long id, String oldEmail, String newEmail) throws ValidationException {
		// TODO Auto-generated method stub
		java.util.Optional<Admin> admin = adminRepository.findById(id);
		if (admin != null) {
			if (admin.get().getEmail().equals(oldEmail)) {
				admin.get().setEmail(newEmail);

				return adminRepository.save(admin.get());
			} else {

				throw new ValidationException("Incorrect EmailId");
			}
		}
		return admin.get();
	}
}
