package com.springBoot.CRUD.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.springBoot.CRUD.Entity.CrudEntity;

public interface CrudEmpRepository extends JpaRepository<CrudEntity, Integer>{

}
