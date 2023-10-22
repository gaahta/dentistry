package br.com.dentistry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dentistry.datasource.model.Dentista;
import br.com.dentistry.repository.DentistaRepository;

@Service
public class BuscarDentistasServiceImpl {

  @Autowired
  private DentistaRepository dentistaRepository;

  public List<Dentista> buscarTodosOsDentistas() {
    List<Dentista> listDentista = dentistaRepository.findAll();
    return listDentista;
  }
}
