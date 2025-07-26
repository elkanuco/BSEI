package com.github.elkanuco.fund_transfer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.elkanuco.fund_transfer.dtos.OperationDto;
import com.github.elkanuco.fund_transfer.exceptions.InsufficientBalanceException;
import com.github.elkanuco.fund_transfer.exceptions.InvalidDataException;
import com.github.elkanuco.fund_transfer.exceptions.NoDataFoundMatchingId;
import com.github.elkanuco.fund_transfer.services.OperationsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/operations")
@RequiredArgsConstructor
public class OperationsController {
	private final OperationsService service;
	
	@PostMapping
	public ResponseEntity<Void> process(@Valid @RequestBody OperationDto dto) throws InvalidDataException, NoDataFoundMatchingId, InsufficientBalanceException {
		service.process(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}
