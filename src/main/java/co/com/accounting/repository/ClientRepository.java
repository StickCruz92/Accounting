package co.com.accounting.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.accounting.model.Client;

@Repository
@Transactional
public interface ClientRepository extends JpaRepository<Client, Long>  {
}
