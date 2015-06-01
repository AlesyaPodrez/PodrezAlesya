package com.springapp.mvc.repository;

import com.springapp.mvc.domain.myType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TypeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addType(myType myType){
        this.sessionFactory.getCurrentSession().save(myType);
    }

    public List<myType> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from myType").list();
    }

    public void removeType(Integer iD){
        myType type = (myType)this.sessionFactory.getCurrentSession().load(myType.class, iD);
        if (null!=type){
            this.sessionFactory.getCurrentSession().delete(type);
        }
    }

    public myType findType(Integer iD){
        myType type = (myType)this.sessionFactory.getCurrentSession().get(myType.class, iD);
        if (null!=type){
            return type;
        }
        else return null;
    }

    public void updateType(myType type){
        this.sessionFactory.getCurrentSession().saveOrUpdate(type);
    }
}
