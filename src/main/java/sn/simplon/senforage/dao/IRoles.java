package sn.simplon.senforage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.simplon.senforage.entities.Roles;
import sn.simplon.senforage.entities.Village;

@Repository
public interface IRoles extends JpaRepository<Roles, Integer> {

}
