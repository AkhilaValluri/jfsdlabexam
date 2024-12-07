package com.klef.jfsd.exam;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ClientDemo {

    public static void main(String[] args) {

        // Create SessionFactory
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        // Insert records manually or using persistent objects
        Transaction transaction = session.beginTransaction();
        try {
            // Adding projects
            Project project1 = new Project("Project A", 12, 50000, "John Doe");
            Project project2 = new Project("Project B", 6, 30000, "Jane Smith");
            Project project3 = new Project("Project C", 24, 100000, "Steve Johnson");

            session.save(project1);
            session.save(project2);
            session.save(project3);

            transaction.commit(); // Commit transaction

            System.out.println("Projects saved successfully!");
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        // Query for aggregate functions on Budget using Criteria API
        Criteria criteria = session.createCriteria(Project.class);

        // Count
        criteria.setProjection(Projections.rowCount());
        System.out.println("Number of projects: " + criteria.uniqueResult());

        // Max Budget
        criteria.setProjection(Projections.max("budget"));
        System.out.println("Maximum Budget: " + criteria.uniqueResult());

        // Min Budget
        criteria.setProjection(Projections.min("budget"));
        System.out.println("Minimum Budget: " + criteria.uniqueResult());

        // Sum of Budget
        criteria.setProjection(Projections.sum("budget"));
        System.out.println("Total Budget: " + criteria.uniqueResult());

        // Average Budget
        criteria.setProjection(Projections.avg("budget"));
        System.out.println("Average Budget: " + criteria.uniqueResult());

        // Close session
        session.close();
        factory.close();
    }
}
