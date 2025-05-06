package org.dao;

import org.example.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    /// save student or create
    @Transactional
    public int insert (Student student){
        /// insert
        Integer i = (Integer) this.hibernateTemplate.save(student);
        return i;
    }

    /// get the single data (object) or read single
    public Student getStudent(int id){
        Student student = this.hibernateTemplate.get(Student.class, id);
        return student;
    }

    /// get all student details or read multiple data
    public List<Student> getAllStudents(){
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    /// updating data....
    ///
    /// @return
    @Transactional
    public Student updateStudent(Student student){
        this.hibernateTemplate.update(student);
        return student;
    }

    /// deleting the data
    @Transactional
    public void deleteStudent(int id){
        Student student = this.hibernateTemplate.get(Student.class, id);
        this.hibernateTemplate.delete(student);
    }

}