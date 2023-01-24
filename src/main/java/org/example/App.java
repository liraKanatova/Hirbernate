package org.example;

import org.example.config.HibernateConfig;
import org.example.enums.OpertionSystem;
import org.example.model.Laptop;
import org.example.service.LaptopService;
import org.example.service.LaptopServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HibernateConfig.createEntityManagerFactory();
        LaptopService laptopService = new LaptopServiceImpl();

      // laptopService.saveLaptop(new Laptop(OpertionSystem.WINDOWS,"HP",8,4000, LocalDate.of(2022,5,20)));
     //  laptopService.saveLaptop(new Laptop(OpertionSystem.MACOS,"Air 13",64,80000,LocalDate.of(2021,12,3)));
      // laptopService.saveLaptop(new Laptop(OpertionSystem.WINDOWS,"Lenevo",8,35000,LocalDate.of(2018,8,10)));


//        List<Laptop> laptopList = new ArrayList<>(Arrays.asList( laptopService.saveLaptop(new Laptop(OpertionSystem.WINDOWS,"HP",8,4000, LocalDate.of(2022,5,20))),
//          laptopService.saveLaptop(new Laptop(OpertionSystem.MACOS,"Air 13",64,80000,LocalDate.of(2021,12,3))),
//         laptopService.saveLaptop(new Laptop(OpertionSystem.WINDOWS,"Lenevo",8,35000,LocalDate.of(2018,8,10)))));
//        laptopService.saveAll(laptopList).forEach(System.out::println);

//        System.out.print("Write the  id: ");
//        long id = new Scanner(System.in).nextLong();
//        laptopService.deleteById(id);

//        laptopService.deleteAll();

//       laptopService.findAll().forEach(System.out::println);

//        System.out.print("Write the id and that which you want to change: ");
//        long id = new Scanner(System.in).nextLong();
//        System.out.print("Write the operationSystem: ");
//        String operationSystem = new Scanner(System.in).next();
//        System.out.print("Write the brand: ");
//        String brand = new Scanner(System.in).next();
//        System.out.print("Write the memory: ");
//        String memory = new Scanner(System.in).nextLine();
//        System.out.print("Write the price: ");
//        double price = new Scanner(System.in).nextDouble();
//        System.out.println("Write the dateOfIssue");
//        LocalDate dateOfIssue = LocalDate.parse(new Scanner(System.in).next());
//        int laptopId = new Scanner(System.in).nextInt();
//        laptopService.update(id, new Laptop(OpertionSystem.LINUX,"Asus",32,5999,LocalDate.of(2022,05,06)));

//        System.out.println(laptopService.sortByDifferentColumn("id", "asc"));
    }
}
