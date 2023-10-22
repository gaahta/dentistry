package br.com.dentistry.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.dentistry.datasource.model.Dentista;
import br.com.dentistry.exception.DentistaNotFoundException;
import br.com.dentistry.repository.DentistaRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/insert_dent_para_test_buscar_por_id.sql")
public class BuscarDentistaPorIdServiceImplTest {

  @Autowired
  private BuscarDentistaPorIdServiceImpl serviceImpl;

  @Autowired
  private DentistaRepository dentistaRepository;

  @Test
  public void buscarPorIdTest() throws DentistaNotFoundException {

    Dentista dentista = serviceImpl.buscarPorId(11L);

    assertEquals("123", dentista.getCodigoRegistro());
    assertEquals("123", String.valueOf(dentista.getId_paciente()));
    assertEquals("murilo", dentista.getNome());
  }

  @Test
  public void deletarPorIdTest() throws DentistaNotFoundException {
    serviceImpl.deletarPorId(11L);

    Optional<Dentista> optionalDentista = dentistaRepository.findById(11L);

    assertFalse(optionalDentista.isPresent());
  }

}