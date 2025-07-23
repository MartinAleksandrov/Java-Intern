package com.HotelApp.HotelApp.JPQL;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    public static final EntityManagerFactory emf = Persistence.
            createEntityManagerFactory("hotel-unit");

    //Create new EntityManager instance
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    //Close EntityManger usually on ShutDown
    public static void close() {
        emf.close();
    }
}