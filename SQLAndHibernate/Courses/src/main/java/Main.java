import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
       session.beginTransaction();
      /*  String hql = "SELECT course_name, student_name FROM PurchaseList ";
        Query query = session.createQuery(hql);
        List<Object[]> rows = query.getResultList();

        for (Object[] row : rows) {
            LinkedPurchaseList LPL = new LinkedPurchaseList();
            LinkedPurchaseListKey key = new LinkedPurchaseListKey();
            Integer studentId = (Integer) row[0];
            Integer courseId = (Integer) row[1];
            key.setStudentId(studentId);
            key.setCourseId(courseId);

            LPL.setId(key);
            LPL.setCourseId(key.getCourseId());
            LPL.setStudentId(key.getStudentId());
            session.persist(LPL);
        }
*/
        List<PurchaseList> purchaseLists = session.createQuery("FROM PurchaseList").list();

        for(PurchaseList purchase : purchaseLists){

            Students students = (Students) session.createQuery("FROM Students s WHERE s.name = :studentName ")
                    .setParameter("studentName", purchase.getStudentName())
                    .uniqueResult();
            Courses courses = (Courses) session.createQuery("FROM Courses c WHERE c.name = :courseName ")
                    .setParameter("courseName", purchase.getCourseName())
                    .uniqueResult();
            LinkedPurchaseList LPL = new LinkedPurchaseList();
            LinkedPurchaseListKey key = new LinkedPurchaseListKey();

            key.setStudentId(students.getId());
            key.setCourseId(courses.getId());

            LPL.setId(key);
            LPL.setCourseId(key.getCourseId());
            LPL.setStudentId(key.getStudentId());
            session.persist(LPL);
        }
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}