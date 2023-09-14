package com.lvg.spsec.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lvg.spsec.Entity.Users;
import com.lvg.spsec.Repository.UsersRepository;



@Service
public class UserService {
 @Autowired
 UsersRepository usersRepository;
 
 @Transactional(readOnly=true)
 public Users getByUsername(String username) {
	Optional<Users> ol= usersRepository.findById(username);
	if(ol.isPresent())
	return ol.get();
	return null;  
 }
 @Transactional
  public boolean insertorModify(Users users)
  {
	Users user=usersRepository.save(users);
	return users!=null; 
  }
  public boolean delete(String username)
  {
	  long count= usersRepository.count();
	  usersRepository.deleteById(username);
		return  count> usersRepository.count();
	  
  }
}
