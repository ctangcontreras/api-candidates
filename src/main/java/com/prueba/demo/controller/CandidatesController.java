package com.prueba.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.demo.service.CandidatesService;
import com.prueba.demo.support.dto.CandidateDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/candidates")
@Api(value = "HelloWorld Resource", description = "shows hello world")
public class CandidatesController {

    private static final Logger log = LoggerFactory.getLogger(CandidatesController.class);

	@Autowired
	private CandidatesService candidatesService;


    @ApiOperation(value = "save candidate")
	@RequestMapping(value = "/saveCandidate", method = RequestMethod.POST)
	public ResponseEntity<Object> saveCandidate(@RequestBody CandidateDto dto) {
		
		try {
			return ResponseEntity.ok(candidatesService.saveCandidate(dto));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.ok(e);
		}
	}

	@ApiOperation(value = "update candidate")
	@RequestMapping(value = "/updateCandidate", method = RequestMethod.POST)
	public ResponseEntity<Object> updateCandidate(@RequestBody CandidateDto dto) {
		
		try {
			return ResponseEntity.ok(candidatesService.updateCandidate(dto));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.ok(e);
		}
	}
    
	@ApiOperation(value = "get candidate")
	@RequestMapping(value = "/getCandidate/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCandidate(@PathVariable("id") Integer id) {
		
		try {
			return ResponseEntity.ok(candidatesService.getCandidate(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.ok(e);
		}
	}

	@ApiOperation(value = "delete candidate")
	@RequestMapping(value = "/deleteCandidate/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> deleteCandidate(@PathVariable("id") Integer id) {
		
		try {
			return ResponseEntity.ok(candidatesService.deleteCandidate(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.ok(e);
		}
	}
}
