package org.upb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upb.data.Role;

public interface IRole extends JpaRepository<Role, Integer>{
    public Role findBylibelleRole(String role);
}
