package com.norin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.norin.exception.RecordNotFoundException;
import com.norin.models.EmployeeEntity;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@Service
public class EmployeeService {
	  
     
    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(builder.build());
        return sessionFactory;
    }    
    
    public List<EmployeeEntity> getAllEmployees()
    {
    	
    	  Session session = getSessionFactory().openSession();
          @SuppressWarnings("unchecked")
          List<EmployeeEntity> employees = session.createQuery("FROM EmployeeEntity").list();
          session.close();
          //System.out.println("Found " + employees.size() + " Employees");
          return employees;
          
    }
     
    public EmployeeEntity getEmployeeById(String id) throws RecordNotFoundException
    {
  	    Session session = getSessionFactory().openSession();
  	    EmployeeEntity e = (EmployeeEntity) session.load(EmployeeEntity.class, id);
        session.close();
        return e;
    	
    }
    
    public EmployeeEntity saveEmployee(EmployeeEntity entity) throws RecordNotFoundException
    {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + entity.toString()); 
        return entity;

    }    

    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException
    {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created/updated " + entity.toString()); 
        return entity;

    }
     
    public void deleteEmployeeById(String id) throws RecordNotFoundException
    {
    	
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        EmployeeEntity e = getEmployeeById(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + e.toString());    	
    	
    }
}