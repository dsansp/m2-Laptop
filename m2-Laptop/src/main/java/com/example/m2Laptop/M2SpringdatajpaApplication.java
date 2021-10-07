
package com.example.m2Laptop;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@SpringBootApplication
public class M2SpringdatajpaApplication implements CommandLineRunner {

    @Autowired
    LaptopRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(M2SpringdatajpaApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {

        Scanner Scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bienvenido a l a App para la gestión de Laptops");
            System.out.println("0 - Salir  ");
            System.out.println(" 1 - Ver todos los equipos: ");
            System.out.println(" 2 - Ver un Ordenador por ID: ");
            System.out.println(" 3 - Crear un nuevo Ordenador: ");


            int opcion = Scanner.nextInt();

            if (opcion == 0) {
                System.out.println("Hasta la proxima");
                break;
            } else if (opcion == 1) {
                // buscar todos los ordenadores
                List<Laptop> ordenadores = repository.findAll();
                //comprobar si el repositorio esta vacio

                if (ordenadores.isEmpty()) {
                    System.out.println("No hay ordenadores disponibles");
                } else {
                    System.out.println(ordenadores);
                }

                System.out.println(ordenadores);
            } else if (opcion == 2) {
                //buscar elemento
                System.out.println(" Por favor introduzca el ID que desea ver: ");
                long idIn = Scanner.nextLong();
                repository.findById(idIn);

                //Optional evita devolver nulos
                Optional<Laptop> laptopOptional = repository.findById(idIn);
                if (laptopOptional.isPresent()) {
                    Laptop ordenador = laptopOptional.get();
                    System.out.println(ordenador);
                } else {
                    System.out.println(" no existe el ordenador solicitado");
                }
            }else if (opcion == 3) {
                //crear un nuevo ordenador
                System.out.println( "introduzca el nombre del fabricante: ");
                String manufacturer =Scanner.nextLine();
                System.out.println(" ha introducido el fabricante: " +manufacturer);
                System.out.println( "introduzca la cantidad de memoria Ram: ");
                Integer ram =Scanner.nextInt();
                Scanner.nextLine();
                System.out.println(" ha introducido " +ram +" de Ram: " );
                System.out.println( "introduzca el precio del equipo: ");
                Double price =Scanner.nextDouble();
                Scanner.nextLine();
                System.out.println(" ha introducido el precio: " +price);
                Laptop nuevo = new Laptop(null, manufacturer, ram, price);
                repository.save(nuevo);
                System.out.println("Ordenador creado correctamente");

                } else {

                    Laptop acer = new Laptop(null, "Acer", 32, 1599.99);
                    Laptop asus = new Laptop(null, "Asus", 16, 799.99);
                    //operaciones Crud

                    //guardar
                    repository.save(acer);
                    repository.save(asus);

                    //obterner todos los datos

                    List<Laptop> laptops = repository.findAll();

                    //actualizar un laptop

                    asus.setPrice(2000.50);
                    repository.save(asus);

                    //borrar un laptop

                    repository.delete(asus);

// showcount();
                }
            }

                //   public void showcount() {
                //           long numeroOrdenados = repository.count();
                //       System.out.println("el numero de ordernadores es " + numeroOrdenados);
            }
        }



