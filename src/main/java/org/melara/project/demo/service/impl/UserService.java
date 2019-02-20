package org.melara.project.demo.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.melara.project.demo.entidad.UserRole;
import org.melara.project.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements UserDetailsService {

  @Autowired
  @Qualifier("userRepository")
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    org.melara.project.demo.entidad.User user = userRepository.findByUsername(username);
    List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
    return buildUser(user, authorities);
  }

  private User buildUser( org.melara.project.demo.entidad.User user, List<GrantedAuthority> authorities)
  {
    return new User(
      user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities
    );
  }

  private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRole)
  { 
    Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
    for (UserRole item : userRole) {
      auths.add(new SimpleGrantedAuthority(item.getRole()));
    }
    return new ArrayList<GrantedAuthority>(auths);
  }
}