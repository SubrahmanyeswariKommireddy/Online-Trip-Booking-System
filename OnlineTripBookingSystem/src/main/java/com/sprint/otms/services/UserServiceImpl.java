package com.sprint.otms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sprint.otms.exceptions.AdminNotFoundException;
import com.sprint.otms.exceptions.CustomerNotFoundException;
import com.sprint.otms.exceptions.DuplicateRecordException;
import com.sprint.otms.models.Admin;
import com.sprint.otms.models.Customer;
import com.sprint.otms.models.User;
import com.sprint.otms.models.User_Type;
import com.sprint.otms.repositories.IAdminRepository;
import com.sprint.otms.repositories.ICustomerRepository;
import com.sprint.otms.repositories.IUserRepository;

/**
 * 
 * @author Subrahmanyeswari
 *
 */
@Service
@Transactional
@Primary
public class UserServiceImpl implements IUserService {

	@Autowired
	private IAdminRepository adminRepository;

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
    @Autowired
    private PasswordEncoder bcryptEncoder;

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
//		if (user.getUserType() == User_Type.ADMIN) {
//			Admin adm = new Admin();
//			adm.setEmail(user.getEmail());
//			adm.setMobileNumber(user.getMobileNumber());
//			adm.setUserName(user.getUserName());
//			adm.setPassword(user.getPassword());
//			adm.setUserType(User_Type.ADMIN);
//			adm.setPassword(user.getUserName());
//			adm = adminRepository.save(adm);
//			adm= userRepository.save(adm);
//		} else {
//			Customer customer = new Customer();
//			customer.setEmail(user.getEmail());
//			customer.setMobileNumber(user.getMobileNumber());
//			customer.setUserName(user.getUserName());
//			customer.setPassword(user.getPassword());
//			customer.setUserType(User_Type.CUSTOMER);
//			customer.setPassword(user.getUserName());
//			customer = customerRepository.save(customer);
//			customer=userRepository.save(customer);
//		}
//		return user
		if(user.getUserType() == User_Type.ADMIN)
		{
			List<User> u=userRepository.findByEmail(user.getEmail());
			if(u.size()==0) {
			Admin admin =  adminRepository.findByEmail(user.getEmail());
			if(admin == null)
			{
				Admin adm = new Admin();
				adm.setEmail(user.getEmail());
				adm.setMobileNumber(user.getMobileNumber());
				adm.setUserName(user.getUserName());
				adm.setPassword(bcryptEncoder.encode(user.getPassword()));
				adm.setUserType(User_Type.ADMIN);
				user.setPassword(bcryptEncoder.encode(user.getPassword()));
				userRepository.save(user);
				return adminRepository.save(adm);
			}
			else
			{
				throw new AdminNotFoundException("User Already Exists");
			}
		}
		}
		
//		else if(user.getUserType() == User_Type.CUSTOMER)
//		{
//			
//			Customer c = new Customer();
//			c.setEmail(user.getEmail());
//			c.setMobileNumber(user.getMobileNumber());
//			c.setUserName(user.getUserName());
//			c.setPassword(bcryptEncoder.encode(user.getPassword()));
//			c.setUserType(user.getUserType());
//			Customer customer =  customerRepository.findByEmail(user.getEmail());
//			if(customer == null)
//			{
//				user.setPassword(bcryptEncoder.encode(user.getPassword()));
//				userRepository.save(user);
//				return customerRepository.save(c);
//			}
//			else
//			{
//				throw new CustomerNotFoundException("User Already Exists");
//			}
//		}
			else if(user.getUserType() == User_Type.CUSTOMER)
			{
				List<User> us=userRepository.findByEmail(user.getEmail());
				if(us.size()==0) {
				Customer customer =  customerRepository.findByEmail(user.getEmail());
				if(customer == null)
				{
					Customer cus = new Customer();
					cus.setEmail(user.getEmail());
					cus.setMobileNumber(user.getMobileNumber());
					cus.setUserName(user.getUserName());
					cus.setPassword(bcryptEncoder.encode(user.getPassword()));
					cus.setUserType(User_Type.CUSTOMER);
					user.setPassword(bcryptEncoder.encode(user.getPassword()));
					userRepository.save(user);
					return customerRepository.save(cus);
				}
				else
				{
					throw new CustomerNotFoundException("User Already Exists");
				}
			}
			}
			
		throw new DuplicateRecordException("duplicate record found");
	}
	
//	@Override
//	public User Login(String emailId, String password, Role role) {
//		// TODO Auto-generated method stub
//		if (role == Role.ADMIN) {
//			Admin admin = adminRepository.findByEmailId(emailId);
//			return admin;
//
//		} else if (role == Role.GUARD) {
//			Guard guard = guardRepository.findByEmailId(emailId);
//			return guard;
//
//		} else if (role == Role.FLATOWNER) {
//			Owner owner = ownerRepository.findByEmailId(emailId);
//			return owner;
//		}
//		return null;
//	}
	@Override
	public User Login(String emailId, String password, User_Type userType) {
	
		if(userType == User_Type.ADMIN)
		{
			Admin admin = adminRepository.findByEmail(emailId);
				return admin;
			
		}
		else if(userType == User_Type.CUSTOMER)
		{
			Customer customer = customerRepository.findByEmail(emailId);
				return customer;
			
		}
		return null;
	}

	@Override
	public User Logout(String emailId, String password, User_Type userType) {
		// TODO Auto-generated method stub
//		if (userType == User_Type.ADMIN) {
//			Admin admin = (Admin) adminRepository.findByEmail(emailId);
//			if (admin.getPassword() == password) {
//				return admin;
//			}
//		} else {
//			Customer customer = customerRepository.findByEmail(emailId);
//			if (customer.getPassword() == password) {
//				return customer;
//			}
//		}
//		return null;
		if(userType == User_Type.ADMIN)
		{
			Admin admin = (Admin) adminRepository.findByEmail(emailId);
			return admin;
		}
		else if(userType==User_Type.CUSTOMER)
		{
			Customer customer = customerRepository.findByEmail(emailId);
			return customer;
		}
		return null;
	}
	

    @Autowired
    private IUserRepository repo;

 

    
    @Override
    public Optional<User> deleteUser(long id) {
        // TODO Auto-generated method stub
         repo.deleteById(id);
         return repo.findById(id);
    }

 

    @Override
    public User deleteUser(User c) {
        // TODO Auto-generated method stub
         repo.delete(c);
         return c;
    }

 

    @Override
    public User updateUser(User c) {
        // TODO Auto-generated method stub
        return repo.save(c);
    }

 

    @Override
    public List<User> listAllUsers() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

 

    @Override
    public Optional<User> listUserById(long id) {
        // TODO Auto-generated method stub
        return repo.findById(id);
    }

 

    
        public User findUser(User user) {
            
            User dbUser =  repo.findByEmail(user.getEmail()).get(0);
            System.out.println("db user " +dbUser);
            if(dbUser==null)
                throw new RuntimeException("user does nt exist");
            if(!dbUser.getPassword().contentEquals(user.getPassword())) {
                throw new RuntimeException("password mismatch");}
            System.out.println("returning dbuser");
            return dbUser;
            }

 

           
          public User addUser(User user) {
            User newuser = new User();
            User byEmail = repo.findByEmail(user.getEmail()).get(0);
            if (byEmail!=null) {
                throw new RuntimeException("User already registered. Please use different email.");
            }
            newuser.setEmail(user.getEmail());
            newuser.setPassword(user.getPassword());
            repo.save(user);
            return newuser;
        }
}
