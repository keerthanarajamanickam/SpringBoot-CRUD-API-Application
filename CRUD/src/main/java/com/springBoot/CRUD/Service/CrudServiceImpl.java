package com.springBoot.CRUD.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.CRUD.Entity.CrudEntity;
import com.springBoot.CRUD.Repository.CrudEmpRepository;

@Service
public class CrudServiceImpl implements CrudService{
	
	@Autowired
	private CrudEmpRepository crudEmpRepository;

	@Override
	public CrudEntity insert(CrudEntity crudEntity) {
		// TODO Auto-generated method stub
		return crudEmpRepository.save(crudEntity);
	}

	@Override
	public CrudEntity retrieveById(int empId) {
		// TODO Auto-generated method stub
		return crudEmpRepository.findById(empId).get();
	}
//
	@Override
	public CrudEntity editValue(int empId, CrudEntity crudEntity) {
		// TODO Auto-generated method stub
		CrudEntity retrieveEntity =	crudEmpRepository.findById(empId).get();
		retrieveEntity.setId(crudEntity.getId());
		retrieveEntity.setName(crudEntity.getName());
		retrieveEntity.setAge(crudEntity.getAge());
		retrieveEntity.setAddress(crudEntity.getAddress()); 
		
		CrudEntity savedEntity = crudEmpRepository.save(retrieveEntity);
			
		return savedEntity;
	}

	@Override
	public String deleteEmp(int empId) {
		// TODO Auto-generated method stub
		crudEmpRepository.deleteById(empId);
		return "DELETED SUCCESSFULLY";
	}
//
	@Override
	public void ListOfInput(List<CrudEntity> entityList) {
		// TODO Auto-generated method stub
		for(CrudEntity empList : entityList) {
			System.out.println(empList.getId());
			System.out.println(empList.getName());
			System.out.println(empList.getAge());
			System.out.println(empList.getAddress()); 
		}
		
		crudEmpRepository.saveAll(entityList);
		
	}

	@Override
	public List<CrudEntity> entityList() {
		// TODO Auto-generated method stub
		return crudEmpRepository.findAll();
	}


	@Override
	public void countValue() {
		// TODO Auto-generated method stub
		long i=crudEmpRepository.count();
		System.out.println("COUNT = " +i);
		
	}

	@Override
	public void checking(int empId) {
		// TODO Auto-generated method stub
		
		boolean value = crudEmpRepository.existsById(empId);
		System.out.println("AVAILABLE = "+value);
		
	}

}
