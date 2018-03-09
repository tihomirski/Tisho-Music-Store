package com.tisho.music.store.dao.impl;


import com.tisho.music.store.dao.CustomerOrderDao;
import com.tisho.music.store.model.CustomerOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }
}
