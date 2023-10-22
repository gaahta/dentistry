package br.com.dentistry.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dentistry.datasource.model.Dentista;
import br.com.dentistry.exception.DentistaResourceException;
import br.com.dentistry.repository.DentistaRepository;
import br.com.dentistry.resource.model.DentistaResource;

@Service
public class CadastroDentistaServiceImpl {

  private static final Logger LOG = Logger.getLogger(CadastroDentistaServiceImpl.class);

  @Autowired
  private DentistaRepository dentistaRepository;

  @Autowired
  private DentistaConversor service;

  public void cadastro(DentistaResource dentistaResource) {

    try {
      Dentista dentista = service.conversor(dentistaResource);
      dentistaRepository.saveAndFlush(dentista);
    } catch (DentistaResourceException e) {
      LOG.error("Erro ao salvar o dentista: " + e.getMessage(), e);
    }
  }

}
