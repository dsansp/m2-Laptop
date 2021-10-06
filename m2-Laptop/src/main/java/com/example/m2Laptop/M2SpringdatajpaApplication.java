
    package com.example.m2Laptop;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;


    @SpringBootApplication
    public class M2SpringdatajpaApplication implements CommandLineRunner {

        @Autowired
        LaptopRepository repository;

        public static void main(String[] args) {
            SpringApplication.run(M2SpringdatajpaApplication.class, args);






        }

        @Override
        public void run(String... args) throws Exception {
            Laptop acer = new Laptop(null, "Acer", 32, 1599.99);
            Laptop asus = new Laptop(null, "Asus", 16, 799.99);
       //operaciones Crud

            //guardar
            repository.save(acer);
            repository.save(asus);

            //obterner todos los datos

            List<Laptop> laptops = repository.findAll();

showcount();
        }

    public void showcount() {
            long numeroOrdenados = repository.count();
        System.out.println("el numero de ordernadores es " + numeroOrdenados);
        }
    }


