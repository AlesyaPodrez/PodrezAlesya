package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProjectRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProject(Project project){
        this.sessionFactory.getCurrentSession().save(project);
    }

    public List<Project> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Project").list();
    }

    public void removeProject(Integer iD){
        Project contact = (Project)this.sessionFactory.getCurrentSession().load(Project.class, iD);
        if (null!=contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }
}