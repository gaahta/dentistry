package br.com.dentistry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dentistry.datasource.model.Dentista;
import br.com.dentistry.exception.DentistaNotFoundException;
import br.com.dentistry.resource.model.DentistaResource;
import br.com.dentistry.service.BuscarDentistaPorIdServiceImpl;
import br.com.dentistry.service.BuscarDentistasServiceImpl;
import br.com.dentistry.service.CadastroDentistaServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class DentistaController {

  @Autowired
  private BuscarDentistasServiceImpl serviceBuscar;

  @Autowired
  private CadastroDentistaServiceImpl serviceCadastro;

  @Autowired
  private BuscarDentistaPorIdServiceImpl serviceBuscarPorId;

  @GetMapping(path = "/dentistas")
  public List<Dentista> buscarDentistas() {
    return serviceBuscar.buscarTodosOsDentistas();
  }

  @GetMapping(path = "/dentista/id/{id}")
  public Dentista buscarDentistasPorId(
      @PathVariable(name = "id", required = true) Long id) throws DentistaNotFoundException {
    return serviceBuscarPorId.buscarPorId(id);
  }

  @PostMapping(path = "/dentista/save")
  public void salvarDentista(@RequestBody DentistaResource dentista) {
    serviceCadastro.cadastro(dentista);
  }

  @DeleteMapping(path = "/dentista/delete/{id}")
  public void deleteDentista(@PathVariable(name = "id", required = true) Long id)
      throws DentistaNotFoundException {
    serviceBuscarPorId.deletarPorId(id);
  }

}

