package bspringsecuritydemo.Service;


import bspringsecuritydemo.entity.Role;
import bspringsecuritydemo.entity.RolePermission;
import bspringsecuritydemo.entity.UserRole;
import bspringsecuritydemo.entity.Users;
import bspringsecuritydemo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder pw;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
        System.out.println("asdasdasdadas");
        if(users == null){
            throw new UsernameNotFoundException("用户名找不到了");
        }
        final List<UserRole> userRoles = userRoleRepository.findAllByUid(users.getId());
        final ArrayList<Role> roles = new ArrayList<>();
        final ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        getRolesAndAuthorities(userRoles, roles, authorities);
        final ArrayList<RolePermission> rolePermissions = new ArrayList<>();
        roles.forEach(role->{
            rolePermissions.addAll(rolePermissionRepository.findAllByRid(role.getId()));
        });
        rolePermissions.forEach(rolePermission -> authorities.
                add(permissionRepository.findById(rolePermission.getPid())));
        final HashSet<GrantedAuthority> grantedAuthorities = new HashSet<>(authorities);

        System.out.println(grantedAuthorities);

        return new User(users.getUsername(),pw.encode(users.getPassword()),
                grantedAuthorities);
    }

    private void getRolesAndAuthorities(List<UserRole> userRoles, ArrayList<Role> roles, ArrayList<GrantedAuthority> authorities) {
        userRoles.forEach(userRole -> {
            final Role role = roleRepository.findById(userRole.getRid());
            authorities.add(role);
            roles.add(role);
        });
    }
}
