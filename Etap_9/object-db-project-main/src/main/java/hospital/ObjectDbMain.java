package hospital;

import hospital.entity.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

public class ObjectDbMain {
    public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("$objectdb/db/hospital.odb");
        EntityManager em = emf.createEntityManager();

        /*long start1 = System.nanoTime();
         Helper.generateDateBase(em); // - do generowania bazy
        long end1 = System.nanoTime();
        System.out.println("Time in nt:" + (end1 - start1));*/


       long start1 = System.nanoTime();
        Query q1 = em.createQuery("SELECT d FROM Department d WHERE d.id = 101");
        long end1 = System.nanoTime();
        System.out.println("Time in nt:" + (end1 - start1));
        System.out.println("Total Points: " + q1.getResultList().size());

        long start2 = System.nanoTime();
        Query q2 = em.createQuery("SELECT d FROM Department d WHERE d.id = 101");
        long end2 = System.nanoTime();
        System.out.println("Time in nt:" + (end2 - start2));
        System.out.println("Total Points: " + q2.getResultList().size());

        long start3 = System.nanoTime();
        Query q3 = em.createQuery("SELECT d,p FROM Department d INNER JOIN d.patients p WHERE p.drugsReceived = 4 AND p.sex = 'Female'");
        long end3 = System.nanoTime();
        System.out.println("Time in nt:" + (end3 - start3));
        System.out.println("Total Points: " + q3.getResultList().size());

        long start4 = System.nanoTime();
        Query q4 = em.createQuery("SELECT d,p FROM Department d INNER JOIN d.patients p WHERE p.drugsReceived = 4 AND p.sex = 'Female'");
        long end4 = System.nanoTime();
        System.out.println("Time in nt:" + (end4 - start4));
        System.out.println("Total Points: " + q4.getResultList().size());


        em.close();
        emf.close();
    }
}