package org.example;

import org.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class App {
    public static void main( String[] args ) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while (go){
            System.out.println("Press 1 for add new student");
            System.out.println("Press 2 for display all students");
            System.out.println("Press 3 to get details of single student");
            System.out.println("Press 4 for delete student");
            System.out.println("Press 5 for update student");
            System.out.println("Press 6 for exit");
            System.out.println("-------------------------------");

            try {
                int input = Integer.parseInt(br.readLine());

                switch (input){
                    case 1:
                        /// add a new student
                        /// taking inputs from users
                        System.out.println("Enter user Id : ");
                        int uId = Integer.parseInt(br.readLine());

                        System.out.println("Enter user Name : ");
                        String uName = br.readLine();

                        System.out.println("Enter user City : ");
                        String uCity = br.readLine();

                        /// creating student object and setting values
                        Student s  = new Student();
                        s.setId(uId);
                        s.setName(uName);
                        s.setCity(uCity);

                        /// saving student object to database by calling insert of student dao
                        int r = studentDao.insert(s);
                        System.out.println(r + " student added");
                        System.out.println("****************************");
                        System.out.println();
                        break;

                    case 2:
                        /// display all students
                        System.out.println();
                        List<Student> allStudents = studentDao.getAllStudents();
                        for (Student st : allStudents){
                            System.out.println("Id : " + st.getId());
                            System.out.println("Name : " + st.getName());
                            System.out.println("City : " + st.getCity());
                            System.out.println("-------------------------------");
                        }
                        break;

                    case 3:
                        /// get single student data
                        System.out.println("Enter user Id : ");
                        int userId = Integer.parseInt(br.readLine());
                        Student student = studentDao.getStudent(userId);
                        System.out.println("Id : " + student.getId());
                        System.out.println("Name : " + student.getName());
                        System.out.println("City : " + student.getCity());
                        System.out.println("-------------------------------");
                        break;

                    case 4:
                        /// delete student
                        System.out.println("Enter user Id : ");
                        int id = Integer.parseInt(br.readLine());
                        studentDao.deleteStudent(id);
                        System.out.println();
                        break;

                    case 5:
                        /// update student
                        System.out.println("Enter user Id : ");
                        int uId1 = Integer.parseInt(br.readLine());

                        System.out.println("Enter user Name : ");
                        String uName1 = br.readLine();

                        System.out.println("Enter user City : ");
                        String uCity1 = br.readLine();

                        /// creating student object and setting values
                        Student st  = new Student();
                        st.setId(uId1);
                        st.setName(uName1);
                        st.setCity(uCity1);

                        /// saving student object to database by calling insert of student dao
                        Student updateStudent = studentDao.updateStudent(st);
                        System.out.println(updateStudent + " student updated");
                        System.out.println("****************************");
                        System.out.println();
                        break;

                    case 6:
                        /// exit application
                        go = false;
                        break;
                }

            }catch (Exception e){
                System.out.println("Invalid Input ! Try with another one !!");
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thank you for using my application");
        System.out.println("See you soon !");
    }
}