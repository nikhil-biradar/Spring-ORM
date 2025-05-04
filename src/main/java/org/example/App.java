package org.example;

import org.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);


        Student student = new Student(101, "Nikhil", "Pune");
        int r = studentDao.insert(student);
        System.out.println("Done " + r);

    }
}