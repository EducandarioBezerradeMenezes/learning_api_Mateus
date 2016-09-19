package com.api.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.api.model.Request;

public class ServiceRequestDb {

	private EntityManagerFactory emf;
	
	public ServiceRequestDb(){
		emf = Persistence.createEntityManagerFactory("JavaApi");
	}
	
	public int persistRequest(Request request){
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
}
