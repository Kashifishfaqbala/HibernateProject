package com.kashif;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Student s1 = new Student();
//        s1.setRollno(104);
//        s1.setSname("Kashif Ishfaq Bala");
//        s1.setSage(22);
//
//        Student s2=null;

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("lenovo");
        l1.setModel("legion");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("hp");
        l2.setModel("omen");
        l2.setRam(8);


        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("MacBook");
        l3.setRam(32);




        Alien a1= new Alien();
        a1.setAid(101);
        a1.setAname("Kashif");
        a1.setTech("Java");
//        a1.setLaptop(l1);



        Alien a2= new Alien();
        a2.setAid(102);
        a2.setAname("Aliza");
        a2.setTech("Python");



        Alien a3= new Alien();
        a3.setAid(103);
        a3.setAname("Aizal");
        a3.setTech("AI");


        a1.setLaptops(Arrays.asList(l1,l2));
        a2.setLaptops(Arrays.asList(l2,l3));
        a3.setLaptops(Arrays.asList(l1));


        l1.setAliens(Arrays.asList(a1,a3));
        l2.setAliens(Arrays.asList(a1,a2));
        l3.setAliens(Arrays.asList(a2));



        SessionFactory sf =new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();


        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // For updation if it is unable to find that particular id it will simply add that entry
//        session.merge(s1);

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        // To delete we first need to find the id
//         s1=session.find(Student.class,103);
//
//        session.remove(s1);


//        session.persist(s1);

        tx.commit();
//        Alien a2 = session.find(Alien.class,101);
//        System.out.println(a2);

        // To get the data
//        s2=session.find(Student.class,101);




//        System.out.println(s1);


        session.close();
        sf.close();
    }
}
