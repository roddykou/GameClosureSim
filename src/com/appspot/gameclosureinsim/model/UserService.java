package com.appspot.gameclosureinsim.model;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.appspot.gameclosureinsim.databean.User;

/**
 * DAO for User bean
 *
 */
public class UserService {
	
	//@PersistenceUnit EntityManagerFactory emf;
	
	private static Logger logger = Logger.getLogger(UserService.class.getName());
	
	/**
	 * create a user - with persistencce
	 */
	public void createUser(User u){
		logger.info("Entering createUser:");
		EntityManager em = EMF.get().createEntityManager();
		try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        logger.info("Exiting createUser");
	}
	
	/**
     * Gets a User given an userid
     * @param id
     * @return User bean
     */
    public User getUser(int userid) {
        logger.info("Entering getUser[" + userid + "]");
        User result = null;
        EntityManager em = EMF.get().createEntityManager();
        try {
            result = em.find(User.class, userid);
        } finally {
            em.close();
        }
        if (result == null) {
            logger.warning("No Users returned");
        }
        logger.info("Exiting getUser");
        return result;
    }
    
    /**
     * Get a User given an email address
     */
    @SuppressWarnings("unchecked")
	public User getUserByEmail(String email) {
        logger.info("Entering getUserByEmail[" + email + "]");
        List<User> list;
        EntityManager em = EMF.get().createEntityManager();
        try {
            Query query = em.createNamedQuery("User.findByEmail");
            query.setParameter("email", email);
            //result = (User)query.getResultList().get(0);
            list = query.getResultList();
        } finally {
            em.close();
        }
        if(list == null || list.size() == 0){
        	return null;
        }else{
        	return (User)list.get(0);
        }
    }
    
    /**
     * truncate
     */
    public void truncate(){
		EntityManager em = EMF.get().createEntityManager();
		try {
            em.getTransaction().begin();
            em.createNativeQuery("truncate table Users").executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
	}
    
    /**
     * update money
     */
    public void updateMoney(int money, int userid){
		EntityManager em = EMF.get().createEntityManager();
		try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery("update Users set total = :new where userid = :id");
            q.setParameter("new", money);
            q.setParameter("id", userid);
            q.executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
	}
    /**
     * get all users
     */
    @SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
        logger.info("Entering getUserByEmail");
        List<User> list;
        EntityManager em = EMF.get().createEntityManager();
        try {
            Query query = em.createNamedQuery("User.findAll");
            list = (List<User>)query.getResultList();
        } finally {
            em.close();
        }
        return list;
    }
}
