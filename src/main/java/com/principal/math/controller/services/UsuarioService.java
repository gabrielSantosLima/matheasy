package com.principal.math.controller.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.principal.math.model.entity.Role;
import com.principal.math.model.entity.Usuario;
import com.principal.math.model.repository.RoleRepository;
import com.principal.math.model.repository.UsuarioRepository;

@Service
public class UsuarioService extends GenericService<Usuario, UsuarioRepository>{
	
	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private SecurityServiceImpl secService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPassowrdEncoder;
	
	public Usuario save(Usuario e, String roleName) throws HibernateException {
		e.setPassword(bCryptPassowrdEncoder.encode(e.getPassword()));
		e.setPontuacao(0);
		e.setRole(roleRepository.findByName(roleName).get());
		
		return repository.save(e);
	}
	
	public Optional<Usuario> findByUsername(String username) {
		return repository.findByUsername(username);
	}
	
	public List<Usuario> findTop10ByRoleOrderByPontuacaoDesc(String role) throws Exception{
		Optional<Role> papel = roleRepository.findByName(role);
		
		if(!papel.isPresent()) {
			throw new Exception("[usuario-service] Papel não existe!");
		}
		
		return repository.findTop10ByRoleOrderByPontuacaoDesc(papel.get());
	}
	
	public List<Usuario> findTop10ByOrderByPontuacaoDesc(){
		return repository.findTop10ByOrderByPontuacaoDesc();
	}
	
	public List<Usuario> findByRoleOrderByPontuacaoDesc(String role) throws Exception{
		Optional<Role> papel = roleRepository.findByName(role);
		
		if(!papel.isPresent()) {
			throw new Exception("[usuario-service] Papel não existe!");
		}
		
		return repository.findByRoleOrderByPontuacaoDesc(papel.get());
	}
	
	public List<Usuario> findContatosById(Integer id){
		return repository.findContatosById(id);
	}
	
	public Optional<Usuario> findByLoggedinUsername() throws Exception{
		Optional<Usuario> usuario = findByUsername(secService.findLoggedinUsername());
		
		System.out.println(usuario.get().getUsername());
		
		if(!usuario.isPresent()) {
			throw new Exception("[usuario-service] Não há usuário logado ou usuário inexistente!");
		}
		
		return usuario;
	}
	
	public Usuario addContato(Usuario usuario, Usuario contato) throws Exception {
		List<Usuario> contatos = usuario.getContatos();
		contatos.add(contato);
		usuario.setContatos(contatos);

		List<Usuario> contatos2 = contato.getContatos();
		contatos2.add(usuario);
		contato.setContatos(contatos2);
		
		update(contato.getId(), contato);
		return update(usuario.getId(), usuario);
	}

	public Usuario removeContato(Usuario usuario, Usuario contato) throws Exception {
		List<Usuario> contatos = usuario.getContatos();
		contatos.remove(contato);
		usuario.setContatos(contatos);
		
		List<Usuario> contatos2 = contato.getContatos();
		contatos2.remove(usuario);
		contato.setContatos(contatos2);
		
		update(contato.getId(), contato);
		return update(usuario.getId(), usuario);
	}
}
