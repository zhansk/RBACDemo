package bspringsecuritydemo.repository;


import bspringsecuritydemo.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolePermissionRepository extends JpaRepository<RolePermission,Integer> {
        List<RolePermission> findAllByRid(int rid);
}