package ua.lviv.lgs.service.impl;

import java.util.List;

import ua.lviv.lgs.dao.SubscriptionDao;
import ua.lviv.lgs.dao.impl.SubscriptionDaoImpl;
import ua.lviv.lgs.domain.Subscription;
import ua.lviv.lgs.service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService {

	private static SubscriptionService subscriptionServiceImpl;
	private SubscriptionDao subscriptionDao;

	private SubscriptionServiceImpl() {
		subscriptionDao = new SubscriptionDaoImpl();
	}
	
	public static SubscriptionService getSubscriptionService() {
		if(subscriptionServiceImpl == null) {
			subscriptionServiceImpl = new SubscriptionServiceImpl();
		}
		return subscriptionServiceImpl;
	}

	@Override
	public Subscription create(Subscription t) {
		return subscriptionDao.create(t);
	}

	@Override
	public Subscription read(Integer id) {
		return subscriptionDao.read(id);
	}

	@Override
	public Subscription update(Subscription t) {
		return subscriptionDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		subscriptionDao.delete(id);
	}

	@Override
	public List<Subscription> readAll() {
		return subscriptionDao.readAll();
	}

}
