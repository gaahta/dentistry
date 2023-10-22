package br.com.dentistry.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dentistry.datasource.model.Dentista;
import br.com.dentistry.exception.DentistaNotFoundException;
import br.com.dentistry.repository.DentistaRepository;

@Service
public class BuscarDentistaPorIdServiceImpl {

  @Autowired
  private DentistaRepository dentistaRepository;

  public Dentista buscarPorId(Long id) throws DentistaNotFoundException {
    Optional<Dentista> optionalDentista = getOptional(id);
    Dentista dentista = null;
    if (!optionalDentista.isPresent()) {
      throw new DentistaNotFoundException("Dentista nao encontrado atraves do ID: " + id);
    } else {
      dentista = optionalDentista.get();
    }
    return dentista;
  }

  private Optional<Dentista> getOptional(Long id) {
    Optional<Dentista> optionalDentista = dentistaRepository.findById(id);
    return optionalDentista;
  }

  public void deletarPorId(Long id) throws DentistaNotFoundException {
    Optional<Dentista> optionalDentista = getOptional(id);
    if (!optionalDentista.isPresent()) {
      throw new DentistaNotFoundException("Dentista nao encontrado atraves do ID: " + id);
    } else {
      dentistaRepository.delete(optionalDentista.get());
    }

  }

}
