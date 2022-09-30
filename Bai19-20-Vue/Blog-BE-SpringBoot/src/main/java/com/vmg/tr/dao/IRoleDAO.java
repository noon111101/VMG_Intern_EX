package com.vmg.tr.dao;

import com.vmg.tr.models.pojo.ERole;
import com.vmg.tr.models.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleDAO extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}