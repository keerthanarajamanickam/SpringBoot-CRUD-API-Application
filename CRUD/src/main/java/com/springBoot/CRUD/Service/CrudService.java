package com.springBoot.CRUD.Service;

import java.util.List;

import com.springBoot.CRUD.Entity.CrudEntity;

public interface CrudService {
	
	CrudEntity insert(CrudEntity crudEntity);
	
	CrudEntity retrieveById(int empId);
	
	CrudEntity editValue(int empId, CrudEntity crudEntity);
	
	String deleteEmp(int empId);
	
	void ListOfInput(List<CrudEntity> entityList);
	
	List<CrudEntity> entityList();
	
	void countValue();
	
	void checking(int empId);

}
