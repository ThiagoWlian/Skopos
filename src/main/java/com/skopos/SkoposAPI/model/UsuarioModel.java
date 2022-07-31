package com.skopos.SkoposAPI.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "USUARIO")
public class UsuarioModel implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String senha;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "PERMISSAO_USUARIO",
			joinColumns = @JoinColumn(name = "USUARIO_ID"),
			inverseJoinColumns = @JoinColumn(name = "PERMISSAO_ID")
	)
	private List<PermissaoModel> permissoes = new LinkedList<PermissaoModel>(); 
	
	public UsuarioModel() {}

	public UsuarioModel(String nome, String senha) {
		this.nome = nome;
		this.senha = new BCryptPasswordEncoder().encode(senha);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<PermissaoModel> getPerfis() {
		return permissoes;
	}

	public void setPerfis(PermissaoModel perfil) {
		permissoes.add(perfil);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permissoes;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return nome;
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
