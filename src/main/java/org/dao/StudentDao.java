package org.dao;

import org.example.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;


public class StudentDao {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    //save student
    @Transactional
    public int insert (Student student){
        //insert
        Integer i = (Integer) this.hibernateTemplate.save(student);
        return i;
    }
}