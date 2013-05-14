package com.appspot.gameclosureinsim.model;

import java.util.logging.Logger;

import javax.persistence.EntityManager;

import com.appspot.gameclosureinsim.databean.Deal;

public class DealService {
	private static Logger logger = Logger.getLogger(DealService.class.getName());
	/**
	 * create a deal
	 */
	public void createDeal(Deal c){
		logger.info("Entering createDeal");
		EntityManager em = EMF.get().createEntityManager();
		try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        logger.info("Exiting createDeal");
	}
	
	public void truncate(){
		EntityManager em = EMF.get().createEntityManager();
		try {
            em.getTransaction().begin();
            em.createNativeQuery("truncate table Deals").executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
	}
	
}
