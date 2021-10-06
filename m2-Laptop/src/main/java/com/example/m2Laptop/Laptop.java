package com.example.m2Laptop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


    @Entity
    public class Laptop {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;
        private String fabricate;
        private Integer ram;
        private Double price;


        public Laptop() {
        }

        public Laptop(Long id, String fabricate, Integer ram, Double price) {
            this.id = id;
            this.fabricate = fabricate;
            this.ram = ram;
            this.price = price;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFabricate() {
            return fabricate;
        }

        public void setFabricate(String fabricate) {
            this.fabricate = fabricate;
        }

        public Integer getRam() {
            return ram;
        }

        public void setRam(Integer ram) {
            this.ram = ram;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Laptop{" +
                    "id=" + id +
                    ", fabricate='" + fabricate + '\'' +
                    ", ram=" + ram +
                    ", price=" + price +
                    '}';
        }
    }


