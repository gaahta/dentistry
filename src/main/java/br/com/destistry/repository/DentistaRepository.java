package br.com.dentistry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dentistry.datasource.model.Dentista;

public interface DentistaRepository extends JpaRepository<Dentista, Long> {

}
