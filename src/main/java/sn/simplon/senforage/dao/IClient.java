package sn.simplon.senforage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.simplon.senforage.entities.Client;
import sn.simplon.senforage.entities.Village;

@Repository
public interface IClient  extends JpaRepository<Client, Integer> {

}
