package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Sergey", "Saverchenko"
//                    , "IT", 500);
//            Detail detail = new Detail("Minsk", "+375445349548"
//                    , "sergey_saver@mail.ru");
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//
//            session.save(employee);
//            session.getTransaction().commit();
//
//            System.out.println("Done!");

            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee emp  = session.get(Employee.class, 3);
            session.delete(emp);

            session.getTransaction().commit();

            System.out.println("Done!");



        } finally {
            session.close();
            factory.close();
        }
    }
}
