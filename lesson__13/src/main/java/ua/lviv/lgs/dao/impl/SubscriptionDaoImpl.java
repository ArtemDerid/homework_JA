package ua.lviv.lgs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ua.lviv.lgs.dao.SubscriptionDao;
import ua.lviv.lgs.domain.Subscription;
import ua.lviv.lgs.shared.FactoryManager;

public class SubscriptionDaoImpl implements SubscriptionDao {

	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Subscription create(Subscription subscription) {
		try {
			em.getTransaction().begin();
			em.persist(subscription);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return subscription;
	}

	@Override
	public Subscription read(Integer id) {
		Subscription subscription = null;
		try {
			subscription = em.find(Subscription.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return subscription;
	}

	@Override
	public Subscription update(Subscription t) {
		throw new IllegalStateException("there is no update for bucket");
	}

	@Override
	public void delete(Integer id) {
		try {
			Subscription subscription = read(id);
			em.getTransaction().begin();
			em.remove(subscription);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subscription> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Subscription e");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
