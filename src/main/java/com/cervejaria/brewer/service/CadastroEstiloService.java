package com.cervejaria.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cervejaria.brewer.model.Estilo;
import com.cervejaria.brewer.repository.Estilos;
import com.cervejaria.brewer.service.excption.NomeEstiloJaCadastradoException;

@Service
public class CadastroEstiloService {

	@Autowired
	private Estilos estilos;
	
	@Transactional
	public void salvar(Estilo estilo){
		
		Optional<Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()) {
			throw new NomeEstiloJaCadastradoException("O nome já está cadastrado!");
		}
		
		estilos.save(estilo);
	}
	
}
