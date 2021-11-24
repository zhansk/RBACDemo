package bspringsecuritydemo.repository;


import bspringsecuritydemo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    List<UserRole> findAllByUid(int uid);
}
