package sn.simplon.senforage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import sn.simplon.senforage.dao.IRoles;
import sn.simplon.senforage.dao.IUser;
import sn.simplon.senforage.entities.Roles;
import sn.simplon.senforage.entities.User;

@SpringBootApplication
public class SenforageSpring1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SenforageSpring1Application.class, args);
		
		
	}

}
