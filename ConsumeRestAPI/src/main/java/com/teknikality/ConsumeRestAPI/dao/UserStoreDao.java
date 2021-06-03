package com.teknikality.ConsumeRestAPI.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.teknikality.ConsumeRestAPI.Entities.User;

@Transactional
@Repository
public class UserStoreDao implements IUserStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * This method is responsible to get all users available in database and return it as List<User>
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		
		String hql = "FROM User as atcl ORDER BY atcl.userId";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}

	
	/**
	 * This method is responsible to get a particular user detail by given  UserId 
	 */
	@Override
	public User getUser(int userId) {
	
		return entityManager.find(User.class, userId);
	}

	@Override
	public boolean deleteUser(int userId) {
		User user = getUser(userId);
		entityManager.remove(user);
		
		//we are checking here that whether entityManager contains earlier deleted user or not
		// if contains then user is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(user);
		if(status){
			return false;
		}
		return true;
	}

	/**
	 * This method is responsible to save new user in database
	 */

	@Override
	public void saveUser(User user) {
		
		entityManager.persist(user);
//		User v = getLastSavedUser();
//		return v;
	}
	
	private User getLastSavedUser() {
		String hql = "from User order by userId DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		User user = (User)query.getSingleResult();
		return user;
		
	}

}
