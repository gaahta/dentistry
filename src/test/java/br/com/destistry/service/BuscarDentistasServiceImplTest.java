package br.com.dentistry.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Objects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.dentistry.datasource.model.Dentista;
import br.com.dentistry.repository.DentistaRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/insert_dent_buscar_todos_os_dent.sql")
public class BuscarDentistasServiceImplTest {

  @Autowired
  private BuscarDentistasServiceImpl serviceImpl;

  @Autowired
  private DentistaRepository dentistaRepository;

  @Test
  public void buscarTodosOsDentistasTest() {
    List<Dentista> listaDentistas = serviceImpl.buscarTodosOsDentistas();

    List<Dentista> listaDentistasDatabase = dentistaRepository.findAll();

    Dentista dentistaService = listaDentistas.stream()
        .filter(dent -> dent.getNome().equals("Flavio")).findFirst().get();

    Dentista dentistaDatabase = listaDentistasDatabase.stream()
        .filter(dent -> dent.getNome().equals("Flavio")).findFirst().get();

    assertNotNull(Objects.nonNull(listaDentistas));
    assertEquals(dentistaDatabase.getNome(), dentistaService.getNome());
    assertEquals(dentistaDatabase.getCodigoRegistro(),
        dentistaService.getCodigoRegistro());
    assertEquals(dentistaDatabase.getId_paciente(), dentistaService.getId_paciente());
    assertEquals(dentistaDatabase.getIdade(), dentistaService.getIdade());
    assertEquals(listaDentistas.size(), listaDentistasDatabase.size());

  }

}

