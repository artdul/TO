package hospital;

import hospital.hibernate.HibernateConnector;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import javax.persistence.Query;

public class PostgresqlMain {
    public static void main(String[] args) {
        Session session = HibernateConnector.getInstance().getSession();

       /* long start1 = System.nanoTime();
        Helper.generateRelationalDatabase(session);
        long end1 = System.nanoTime();
        System.out.println("Time in nt:" + (end1 - start1));*/



       long start1 = System.nanoTime();
        SQLQuery query = session.createSQLQuery("SELECT * FROM Departments WHERE id = 106");
        long end1 = System.nanoTime();
        System.out.println("Time in ns:" + (end1 - start1));
         System.out.println(query.list().size());

        long start2 = System.nanoTime();
        SQLQuery query2 = session.createSQLQuery("SELECT * FROM Departments WHERE id = 106");
        long end2 = System.nanoTime();
        System.out.println("Time in ns:" + (end2 - start2));
        System.out.println(query2.list().size());


        long start3 = System.nanoTime();
        SQLQuery query3 = session.createSQLQuery(" SELECT Departments.id, Departments.departmentname, Departments.numofbeds, Departments.doctor_id, Patients.id as asd, Patients.birthdate, Patients.drug, Patients.drugsreceived, Patients.hospitalizationdate, Patients.name, Patients.sex, Patients.department_id FROM Departments INNER JOIN Patients ON Departments.id = Patients.department_id WHERE Patients.drugsreceived = 4 AND Patients.sex = 'Female'");
        long end3 = System.nanoTime();
        System.out.println("Time in ns:" + (end3 - start3));
        System.out.println(query3.list().size());

        long start4 = System.nanoTime();
        SQLQuery query4 = session.createSQLQuery(" SELECT Departments.id, Departments.departmentname, Departments.numofbeds, Departments.doctor_id, Patients.id as asd, Patients.birthdate, Patients.drug, Patients.drugsreceived, Patients.hospitalizationdate, Patients.name, Patients.sex, Patients.department_id FROM Departments INNER JOIN Patients ON Departments.id = Patients.department_id WHERE Patients.drugsreceived = 4 AND Patients.sex = 'Female'");
        long end4 = System.nanoTime();
        System.out.println("Time in ns:" + (end4 - start4));
        System.out.println(query4.list().size());




        session.close();


    }
}