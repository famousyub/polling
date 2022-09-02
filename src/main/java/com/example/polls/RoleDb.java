package com.example.polls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.polls.model.Role;
import com.example.polls.model.RoleName;
import com.example.polls.repository.RoleRepository;
@Component
public class RoleDb implements CommandLineRunner {
	
	@Autowired 
	RoleRepository rolerepo ;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		Role rol = new Role();
//		Role rol1 = new Role();
//		Role rol2 = new Role();
//		
//		rol.setName(RoleName.ROLE_INFINITY);
//		rol1.setName(RoleName.ROLE_LOGGER);
//		rol2.setName(RoleName.ROLE_SELlER);
//		
//		rolerepo.save(rol);
//		rolerepo.save(rol1);
//		rolerepo.save(rol2);
		
	}

}
