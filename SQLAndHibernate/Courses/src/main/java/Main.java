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
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT c.id, s.id " + "FROM PurchaseList p " +
                "INNER JOIN Courses AS c ON c.name = p.courseName " +
                "INNER JOIN Students AS s ON s.name = p.studentName";
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

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}