package com.codenation.repository;

import com.codenation.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	@Override
	void delete(Role role);

	Role findByName(String name);
}
