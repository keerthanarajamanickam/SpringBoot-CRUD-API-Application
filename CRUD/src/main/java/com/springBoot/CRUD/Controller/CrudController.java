package com.springBoot.CRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.CRUD.Entity.CrudEntity;
import com.springBoot.CRUD.Service.CrudService;

@RestController
public class CrudController {
	
	@Autowired
	private CrudService crudService;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<CrudEntity> insert(@RequestBody CrudEntity crudentity) {
		return new ResponseEntity<CrudEntity>(crudService.insert(crudentity), HttpStatus.CREATED);
	}
	
	@GetMapping("/singleValue/{id}")
	public ResponseEntity<CrudEntity> retrieveSinlgle(@PathVariable("id") int empId) {
//		return ResponseEntity.ok(crudService.retrieveById(empId)); 
	
		return new ResponseEntity<CrudEntity>(crudService.retrieveById(empId), HttpStatus.FOUND); 
	}

	@PutMapping("/editEmployee/{id}")
	public ResponseEntity<CrudEntity> editValue(@PathVariable("id") int empId, @RequestBody CrudEntity crudentity) {
	crudentity.setId(empId);	
	CrudEntity editEntity =	crudService.editValue(empId, crudentity); 
	return ResponseEntity.ok(editEntity);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable("id") int empId) {
	return ResponseEntity.ok(crudService.deleteEmp(empId));	
	}
	
	@PostMapping("/listOfInput")
	public void listofInput(@RequestBody List<CrudEntity> entityList ) {
	crudService.ListOfInput(entityList); 	
	}
	
	@GetMapping("/listEmp")
	public ResponseEntity<List<CrudEntity>> entityList(){
	List<CrudEntity> getlist = crudService.entityList();
	return ResponseEntity.ok(getlist); 
	}
	
	@GetMapping("/count")
	public void count() {
		crudService.countValue();
	}
	

	@GetMapping("/exists/{id}")
	public void checking(@PathVariable("id") int empId) {
		crudService.checking(empId); 
	}

}
