package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RoleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addRole(Role role){
        this.sessionFactory.getCurrentSession().save(role);
    }

    public List<Role> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Role").list();
    }

    public void removeRole(Integer iD){
        Role contact = (Role)this.sessionFactory.getCurrentSession().load(Role.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }
}
