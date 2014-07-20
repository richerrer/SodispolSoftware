/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.myuserdetail;

import com.sodispolSoftware.model.Doctor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author usuario
 */
public class MyUserDetails implements Serializable, UserDetails {

	private static final long serialVersionUID = 1L;
	private final String username;
        private Doctor doctor;
	
	public MyUserDetails(String username,Doctor doctor) {
		this.username=username;
                this.doctor = doctor;
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> l = new ArrayList<GrantedAuthority>();
		l.add( new GrantedAuthority() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public String getAuthority() {
                            String autority = doctor.getRoleuser().getDescripcion();
                            return autority;
			}
		});
		return l;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return username;
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