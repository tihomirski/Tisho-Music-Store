package com.tisho.music.store.dao.impl;

import com.tisho.music.store.dao.CustomerDao;
import com.tisho.music.store.model.Authorities;
import com.tisho.music.store.model.Cart;
import com.tisho.music.store.model.Customer;
import com.tisho.music.store.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Having @Transactional, hibernate will invoke this to interact with DB.
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        //This line is duplicating below but we need both. This line in particular will generate a customer ID.
        //We need this id below, before calling the second time the line.
        //There are a bit tricky initializations.
        //Before calling the line a second time, it has been modified and needs to be updated. So, call the method again...
        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(customer.getUsername());
        newAuthority.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public Customer getCustomerById(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerId);
    }

    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        return customerList;
    }

    public Customer getCustomerByUsername(String username) {
        //We create a query using the Hibernate sessionFactory and Hibernate SQL to query the DB.
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username=?");
        //This is the assignment of the first ? in the quesry.
        //We call setString() because the required ? is of type String. There is also for other types of the DB.
        query.setString(0, username);

        return (Customer) query.uniqueResult();
    }


}