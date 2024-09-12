package com.itb.inf2dm.pizzaria.repository;


import com.itb.inf2dm.pizzaria.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TelefoneRepository extends JpaRepository <Telefone, Long>{
}

