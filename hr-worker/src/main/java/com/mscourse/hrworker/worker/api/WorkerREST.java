package com.mscourse.hrworker.worker.api;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mscourse.hrworker.worker.Worker;
import com.mscourse.hrworker.worker.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerREST {

	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Worker>> findById(@PathVariable Long id){
		return ResponseEntity.ok(repository.findById(id));
	}
}
