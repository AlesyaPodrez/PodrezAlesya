package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Actor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ActorRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addActor(Actor actor){
        this.sessionFactory.getCurrentSession().save(actor);
    }

    public List<Actor> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Actor").list();
    }

    public void removeActor(Integer iD){
        Actor contact = (Actor)this.sessionFactory.getCurrentSession().load(Actor.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }
}
