package com.sana.s1.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
//Spring Security에서 사용하는 VO가 존재
//UserDetails 
//따로 생성 또는 구현
public class MemberVO implements UserDetails {

	private String username;
	
	private String password1;
	@Length(max = 10, min = 2)
	private String password;
	@NotEmpty
	private String name;
	@NotEmpty
	private String email;
	@NotEmpty
	private String phone;
	
	private boolean enabled;

	//Role
	private List<RoleVO> roles;

	//Role 저장
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for(RoleVO roleVO:this.roles) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}

		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

}
