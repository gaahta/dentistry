package br.com.dentistry.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.dentistry.datasource.model.Dentista;
import br.com.dentistry.repository.DentistaRepository;
import br.com.dentistry.resource.model.DentistaResource;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/delete_dentistas.sql")
public class CadastroDentistaServiceImplTest {

  @Autowired
  private CadastroDentistaServiceImpl serviceImpl;

  @Autowired
  private DentistaRepository dentistaRepository;

  private DentistaResource resource;

  @Before
  public void setUp() {
    resource = new DentistaResource();
    resource.setCodigoRegistro("987654");
    resource.setIdade("1969-01-01");
    resource.setIdPaciente("9876543");
    resource.setNome("Jane");
  }

  @Test
  public void cadastroTest() {
    serviceImpl.cadastro(resource);

    Dentista dentista = dentistaRepository.findAll().stream()
        .filter(dent -> dent.getNome().equals("Jane")).findFirst().get();

    assertEquals("987654", dentista.getCodigoRegistro());
    assertEquals("Jane", dentista.getNome());
    assertEquals("9876543", String.valueOf(dentista.getId_paciente()));
    assertEquals("1969-01-01", String.valueOf(dentista.getIdade()));
  }

}
