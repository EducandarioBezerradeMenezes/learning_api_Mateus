package com.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.api.model.Cnpj;
import com.api.model.Request;
import com.api.service.ServiceRequestDb;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class CnpjController {
	private ServiceRequestDb service = new ServiceRequestDb();
	
	
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ResponseEntity<String> index(HttpServletRequest info) {
    	
    	String erro = "Informe um CNPJ";
    	Request request = new Request(info.getRemoteAddr(), info.getHeader("User-Agent"), info.getProtocol(), info.getMethod(), "", erro);
    	service.persistRequest(request);
    	return new ResponseEntity<String>(erro,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{cnpj}", method=RequestMethod.GET)
    public ResponseEntity<Cnpj> isCnpjValid(@PathVariable("cnpj") String arg, HttpServletRequest info) {
    	
    	Cnpj cnpj = new Cnpj(arg);
    	Request request = new Request(info.getRemoteAddr(), info.getHeader("User-Agent"), info.getProtocol(), info.getMethod(), arg, String.valueOf(cnpj.getValid()));
    	service.persistRequest(request);
        return new ResponseEntity<Cnpj>(cnpj,HttpStatus.OK);
    }
    
}
