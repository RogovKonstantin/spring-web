package com.example.demo;

import com.example.demo.models.Offer;




import com.example.demo.repos.UserRepository;
import com.example.demo.services.BrandService;
import com.example.demo.services.OfferService;
import com.example.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@SpringBootApplication


public class DealerShipApplication {

    public static void main(String[] args) {
        SpringApplication.run(DealerShipApplication.class, args);

    }
    

}


