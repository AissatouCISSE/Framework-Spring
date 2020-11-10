package sn.simplon.senforage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.simplon.senforage.entities.User;
import sn.simplon.senforage.entities.Village;

@Repository
public interface IUser  extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.email=:email AND u.password=:password ")
	public User getUserByEmailAndPassword(@Param(value="email") String email, @Param(value="password" ) String password);
	
}
