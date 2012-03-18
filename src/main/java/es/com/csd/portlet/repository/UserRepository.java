package es.com.csd.portlet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.com.csd.portlet.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public List<User> findByUsernameLike(String username);
}