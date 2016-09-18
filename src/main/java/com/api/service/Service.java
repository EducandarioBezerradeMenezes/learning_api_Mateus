package com.api.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.api.model.Request;

public class Service {
	private EntityManagerFactory emf;
	File file;
	
	public Service(){
		emf = Persistence.createEntityManagerFactory("JavaApi");
	}

	public Service(String name){
		file = new File(name + ".txt");
		try{
			if (!file.exists()) {
				file.createNewFile();
			}
		}catch(IOException e){}
	}
	
	public int storeRequestDB(Request request){
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(request);
		em.getTransaction().commit();
		em.close();
		
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public List<Request> getRequests(){
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT r FROM Request r");
		List<Request> requests = query.getResultList();
		
		return requests;
	}
	
	public int storeRequestFile(Request request){
		try {

			String register = ("{\"Data\": \"" + request.getDate() + "\" ,"
							 + " \"IP\": \"" + request.getIp() + "\" ,"
							 + " \"Device\": \"" + request.getDevice() + "\" ,"
							 + " \"Protocolo\": \"" + request.getProtocol() + "\" ,"
							 + " \"Metodo\": \"" + request.getMethod() + "\" ,"	 
							 + " \"Parametro\": \"" + request.getParameter() + "\" ,"
							 + " \"Resposta\": \"" + request.getResponse() + "\"}");
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			

			if(file.length()!=0){
				bw.write(",");
				bw.newLine();
			}
			bw.write(register);
			bw.close();

		} catch (IOException e) {
			return 1;
		}

		return 0;
	}
	public String getRequestsFile(){
		String info = "";
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = br.readLine();
			
			while(line!=null){
				info += line;
				line = br.readLine();
			}
			br.close();
		}catch(IOException e){
			return "";
		}
		return info;
	}
}
