package br.com.dentistry.service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import br.com.dentistry.datasource.model.Dentista;
import br.com.dentistry.exception.DentistaResourceException;
import br.com.dentistry.resource.model.DentistaResource;

@Component
public class DentistaConversor {

  public Dentista conversor(DentistaResource dentistaResource)
      throws DentistaResourceException {

    try {
      Dentista dentista = new Dentista();
      Long idPaciente = checkIdPaciente(dentistaResource.getIdPaciente());

      LocalDate idade = checkIdade(dentistaResource.getIdade());
      dentista.setId_paciente(idPaciente);
      dentista.setIdade(idade);
      dentista.setCodigoRegistro(dentistaResource.getCodigoRegistro());
      dentista.setNome(dentistaResource.getNome());
      return dentista;

    } catch (Exception e) {
      throw new DentistaResourceException(
          "Falha ao converter o resource para entidade, resouce: " + dentistaResource);
    }

  }

  private Long checkIdPaciente(String idPaciente) {
    return Long.parseLong(idPaciente);
  }

  private LocalDate checkIdade(String idade) {
    return LocalDate.parse(idade);
  }

}
