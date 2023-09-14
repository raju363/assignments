package com.lvg.spsec.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lvg.spsec.Entity.Users;

public interface UsersRepository  extends JpaRepository<Users,String>
{
 Optional<Users> findByUsernameAndpassword(String password);
}
