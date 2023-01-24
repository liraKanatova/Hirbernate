package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.enums.OpertionSystem;
import org.example.model.Laptop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LaptopDaoImpl implements LaptopDao{
    private EntityManagerFactory entityManagerFactory = HibernateConfig.createEntityManagerFactory();
    public Laptop saveLaptop(Laptop laptop) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(laptop);
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptop;
    }

    public List<Laptop> saveAll(List<Laptop> laptops) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Laptop laptop : laptops) {
            entityManager.persist(laptop);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    public Laptop deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
       Laptop laptop = (Laptop) entityManager.createQuery("select l from Laptop l where l.id = :id").setParameter("id",id).getSingleResult();
       entityManager.remove(laptop);
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptop;
    }

    public void deleteAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Laptop> laptopList = entityManager.createQuery("select l from Laptop l",Laptop.class).getResultList();
        for (Laptop laptop : laptopList) {
            entityManager.remove(laptop);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(" Successfully deleted!");


    }

    public List<Laptop> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Laptop> laptopList = entityManager.createQuery("select l from Laptop l ",Laptop.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptopList;
    }

    public Laptop update(Long id, Laptop laptop) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
      Laptop laptop1 = entityManager.getReference(Laptop.class,id);
       laptop1.setBrand(laptop.getBrand());
       laptop1.setPrice(laptop.getPrice());
       laptop1.setDateOfIssue(laptop.getDateOfIssue());
       laptop1.setOpertionSystem(laptop.getOpertionSystem());
       entityManager.getTransaction().commit();
       entityManager.close();
        return laptop1;
    }

    public Map<OpertionSystem, List<Laptop>> groupBy() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
         Map<OpertionSystem, List<Laptop>> opertionSystemListMap = entityManager.createQuery("select l from Laptop l",Laptop.class)
                 .getResultStream().collect(Collectors.groupingBy(Laptop::getOpertionSystem));
         entityManager.getTransaction().commit();
         entityManager.close();
        return opertionSystemListMap;
    }

    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println("Select column : (id / brand / memory/ price");
        switch (column){
            case "id"-> {
                System.out.println("select command : (asc / desc)");
                switch (ascOrDesc){
                    case "asc"->{
                        return entityManager.createQuery("select l from Laptop l order by id").getResultList();
                    }
                    case "desc"->{
                        return entityManager.createQuery("select l from Laptop l order by id desc ").getResultList();
                    }
                }
            }
            case "brand"->{
                System.out.println("select command :(asc/ desc)");
                switch (ascOrDesc){
                    case "asc"->{
                        return entityManager.createQuery("select l from Laptop l order by brand").getResultList();
                    }
                    case "desc"->{
                        return entityManager.createQuery("select l from Laptop l order by brand desc ").getResultList();
                    }
                }
            }
            case "asc"->{
                return entityManager.createQuery("select l from Laptop l order by memory").getResultList();
            }
            case "desc"->{
                return entityManager.createQuery("select l from Laptop l order by memory desc ").getResultList();
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    return null;
    }
}
