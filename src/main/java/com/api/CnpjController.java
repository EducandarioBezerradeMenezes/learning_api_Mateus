package com.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class CnpjController {
    
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ResponseEntity<String> index(HttpServletRequest info) {
    	Service service = new Service();
    	String erro = "Informe um CNPJ";
    	Request request = new Request(info.getRemoteAddr(), info.getHeader("User-Agent"), info.getProtocol(), info.getMethod(), "", erro);
    	service.storeRequestDB(request);
    	return new ResponseEntity<String>(erro,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{cnpj}", method=RequestMethod.GET)
    public ResponseEntity<Cnpj> isCnpjValid(@PathVariable("cnpj") String arg, HttpServletRequest info) {
    	Service service = new Service();
    	Cnpj cnpj = new Cnpj(arg);
    	Request request = new Request(info.getRemoteAddr(), info.getHeader("User-Agent"), info.getProtocol(), info.getMethod(), arg, String.valueOf(cnpj.getValid()));
    	service.storeRequestDB(request);
        return new ResponseEntity<Cnpj>(cnpj,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/Requests", method=RequestMethod.GET)
    public ResponseEntity<List<Request>> requestHistory() {
    	Service service = new Service();
    	
        return new ResponseEntity<List<Request>>(service.getRequests(),HttpStatus.OK);
    }
}
