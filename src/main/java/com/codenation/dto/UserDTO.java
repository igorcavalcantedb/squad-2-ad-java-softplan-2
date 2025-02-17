package com.codenation.dto;

import com.codenation.entity.Log;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.OneToMany;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.util.Collection;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class UserDTO implements UserDetails {

  @Null
  private Long id;

  private String name;
  private String email;
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;
  private Collection<GrantedAuthority> authorities;

  @Override
  public Collection<GrantedAuthority> getAuthorities() {
      return this.authorities;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
