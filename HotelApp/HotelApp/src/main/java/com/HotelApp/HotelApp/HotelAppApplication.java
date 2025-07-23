package com.HotelApp.HotelApp;

import com.HotelApp.HotelApp.JPQL.JpaUtil;
import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class HotelAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelAppApplication.class, args);

		EntityManager em = JpaUtil.getEntityManager();

		em.getTransaction().begin();
		System.out.println("Successfully created EntityManager");

		em.getTransaction().commit();

		em.close();

	}
}