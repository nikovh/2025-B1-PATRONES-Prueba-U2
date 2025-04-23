/*
package cl.patrones.taller.u2.tienda.adapter;

import cl.patrones.taller.u2.clientes.Cliente;

public class UsuarioAnonimo extends Usuario {

	public UsuarioAnonimo() {
		super(
			new Cliente("", "Anónimo", "", "")
		);
	}
	
}
*/

package cl.patrones.taller.u2.tienda.adapter;

import java.util.Collection;
import java.util.Collections;

import cl.patrones.taller.u2.clientes.Cliente;

import org.springframework.security.core.GrantedAuthority;


public class UsuarioAnonimo extends Usuario {

	public UsuarioAnonimo() {
		super(
			new Cliente("", "Anónimo", "", "")
		);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}
	@Override
	public String getPassword() {
		return "";
	}
	@Override
	public String getUsername() {
		return "Anónimo";
	}
}
