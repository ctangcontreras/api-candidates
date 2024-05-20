package com.prueba.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.demo.service.CandidatesService;
import com.prueba.demo.support.dto.CandidateDto;
import com.prueba.demo.support.dto.Respuesta;

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
		Respuesta<?> respuesta = null;
		try {
			respuesta = candidatesService.saveCandidate(dto);

			if (respuesta.isSuccess()) {
				return ResponseEntity.ok(respuesta);
			} else {
				return new org.springframework.http.ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new org.springframework.http.ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "update candidate")
	@RequestMapping(value = "/updateCandidate", method = RequestMethod.POST)
	public ResponseEntity<Object> updateCandidate(@RequestBody CandidateDto dto) {
		Respuesta<?> respuesta = null;
		try {
			respuesta = candidatesService.updateCandidate(dto);

			if (respuesta.isSuccess()) {
				return ResponseEntity.ok(respuesta);
			} else {
				return new org.springframework.http.ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new org.springframework.http.ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "get candidate")
	@RequestMapping(value = "/getCandidate/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCandidate(@PathVariable("id") Integer id) {
		Respuesta<?> respuesta = null;
		try {
			respuesta = candidatesService.getCandidate(id);

			if (respuesta.isSuccess()) {
				return ResponseEntity.ok(respuesta);
			} else {
				return new org.springframework.http.ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new org.springframework.http.ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "delete candidate")
	@RequestMapping(value = "/deleteCandidate/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> deleteCandidate(@PathVariable("id") Integer id) {
		Respuesta<?> respuesta = null;
		try {
			respuesta = candidatesService.deleteCandidate(id);

			if (respuesta.isSuccess()) {
				return ResponseEntity.ok(respuesta);
			} else {
				return new org.springframework.http.ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new org.springframework.http.ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}
}
