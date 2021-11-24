package bspringsecuritydemo.repository;


import bspringsecuritydemo.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    Permission findById(int id);
}
