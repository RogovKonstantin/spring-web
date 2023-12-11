/*

package com.example.demo;

import com.example.demo.constants.Enums.EngineTypesEnum;
import com.example.demo.constants.Enums.Role;
import com.example.demo.constants.Enums.TransmissionTypesEnum;
import com.example.demo.constants.Enums.VehicleTypesEnum;
import com.example.demo.models.*;
import com.example.demo.repos.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private OfferRepository offerRepository;


    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        UserRole userRole = new UserRole(Role.USER);
        UserRole adminRole = new UserRole(Role.ADMIN);
        userRoleRepository.save(userRole);
        userRoleRepository.save(adminRole);

        List<UserRole> roles = userRoleRepository.findAll();

        for (int i = 0; i < 200; i++) {
            User user = new User();
            user.setUsername(faker.name().username());
            user.setPassword(faker.internet().password());
            user.setFirstName(faker.name().firstName());
            user.setLastName(faker.name().lastName());
            user.setActive(random.nextBoolean());
            user.setImageUrl(faker.internet().image());
            user.setRole(roles.get(random.nextInt(2)));
            userRepository.saveAndFlush(user);
        }

        List<User> users = userRepository.findAll();
        String[] carBrands = {"Toyota", "BMW", "Mercedes-Benz", "Ford", "Volkswagen", "Audi", "Honda", "Chevrolet", "Volvo"};
        for (String brand : carBrands) {
            Brand br = new Brand(brand);
            brandRepository.save(br);

            switch (brand) {
                case "BMW" -> {
                    Model model1 = new Model("3 Series", VehicleTypesEnum.CAR, "https://example.com/bmw3series.jpg", 2018, 2022, br);
                    Model model2 = new Model("X5", VehicleTypesEnum.CAR, "https://example.com/bmwx5.jpg", 2019, 2022, br);
                    Model model3 = new Model("7 Series", VehicleTypesEnum.CAR, "https://example.com/bmw7series.jpg", 2017, 2022, br);
                    Model model4 = new Model("i8", VehicleTypesEnum.CAR, "https://example.com/bmwi8.jpg", 2014, 2021, br);
                    Model model5 = new Model("X3", VehicleTypesEnum.CAR, "https://example.com/bmwx3.jpg", 2010, 2022, br);
                    modelRepository.saveAll(Arrays.asList(model1, model2, model3, model4, model5));
                }
                case "Audi" -> {
                    Model model6 = new Model("A4", VehicleTypesEnum.CAR, "https://example.com/audia4.jpg", 2015, 2022, br);
                    Model model7 = new Model("Q5", VehicleTypesEnum.CAR, "https://example.com/audiq5.jpg", 2016, 2022, br);
                    Model model8 = new Model("A7", VehicleTypesEnum.CAR, "https://example.com/audia7.jpg", 2018, 2022, br);
                    Model model9 = new Model("Q3", VehicleTypesEnum.CAR, "https://example.com/audiq3.jpg", 2011, 2022, br);
                    Model model10 = new Model("R8", VehicleTypesEnum.CAR, "https://example.com/audir8.jpg", 2010, 2022, br);
                    modelRepository.saveAll(Arrays.asList(model6, model7, model8, model9, model10));
                }
                case "Mercedes-Benz" -> {
                    Model model11 = new Model("C-Class", VehicleTypesEnum.CAR, "https://example.com/mercedesc.jpg", 2014, 2022, br);
                    Model model12 = new Model("E-Class", VehicleTypesEnum.CAR, "https://example.com/mercedese.jpg", 2016, 2022, br);
                    Model model13 = new Model("S-Class", VehicleTypesEnum.CAR, "https://example.com/mercedess.jpg", 2017, 2022, br);
                    Model model14 = new Model("GLE", VehicleTypesEnum.CAR, "https://example.com/mercedesgle.jpg", 2019, 2022, br);
                    Model model15 = new Model("GLA", VehicleTypesEnum.CAR, "https://example.com/mercedesgla.jpg", 2015, 2022, br);
                    modelRepository.saveAll(Arrays.asList(model11, model12, model13, model14, model15));
                }
                case "Toyota" -> {
                    Model model16 = new Model("Camry", VehicleTypesEnum.CAR, "https://example.com/toyotacamry.jpg", 2017, 2022, br);
                    Model model17 = new Model("Corolla", VehicleTypesEnum.CAR, "https://example.com/toyotacorolla.jpg", 2018, 2022, br);
                    Model model18 = new Model("RAV4", VehicleTypesEnum.CAR, "https://example.com/toyotarav4.jpg", 2016, 2022, br);
                    Model model19 = new Model("Highlander", VehicleTypesEnum.CAR, "https://example.com/toyotahighlander.jpg", 2019, 2022, br);
                    Model model20 = new Model("Tacoma", VehicleTypesEnum.TRUCK, "https://example.com/toyotatacoma.jpg", 2022, 2023, br);
                    modelRepository.saveAll(Arrays.asList(model16, model17, model18, model19, model20));
                }
                case "Ford" -> {
                    Model model21 = new Model("Mustang", VehicleTypesEnum.CAR, "https://example.com/fordmustang.jpg", 2015, 2022, br);
                    Model model22 = new Model("F-150", VehicleTypesEnum.TRUCK, "https://example.com/fordf150.jpg", 2018, 2022, br);
                    Model model23 = new Model("Explorer", VehicleTypesEnum.CAR, "https://example.com/fordexplorer.jpg", 2019, 2022, br);
                    Model model24 = new Model("Edge", VehicleTypesEnum.CAR, "https://example.com/fordedge.jpg", 2016, 2022, br);
                    Model model25 = new Model("Escape", VehicleTypesEnum.CAR, "https://example.com/fordescape.jpg", 2017, 2022, br);
                    modelRepository.saveAll(Arrays.asList(model21, model22, model23, model24, model25));
                }
                case "Volkswagen" -> {
                    Model model26 = new Model("Golf", VehicleTypesEnum.CAR, "https://example.com/vwgolf.jpg", 2014, 2022, br);
                    Model model27 = new Model("Passat", VehicleTypesEnum.CAR, "https://example.com/vwpassat.jpg", 2016, 2022, br);
                    Model model28 = new Model("Tiguan", VehicleTypesEnum.CAR, "https://example.co m/vwtiguan.jpg", 2017, 2022, br);
                    Model model29 = new Model("Polo", VehicleTypesEnum.CAR, "https://example.com/vwpolo.jpg", 2018, 2022, br);
                    Model model30 = new Model("Arteon", VehicleTypesEnum.CAR, "https://example.com/vwarteon.jpg", 2019, 2022, br);
                    modelRepository.saveAll(Arrays.asList(model26, model27, model28, model29, model30));
                }
                case "Honda" -> {
                    Model model31 = new Model("CBR500R", VehicleTypesEnum.MOTORCYCLE, "https://example.com/hondacbr500r.jpg", 2019, 2022, br);
                    Model model32 = new Model("CRF250L", VehicleTypesEnum.MOTORCYCLE, "https://example.com/hondacrf250l.jpg", 2018, 2022, br);
                    Model model33 = new Model("CB300R", VehicleTypesEnum.MOTORCYCLE, "https://example.com/hondacb300r.jpg", 2017, 2022, br);
                    Model model34 = new Model("Ridgeline", VehicleTypesEnum.TRUCK, "https://example.com/hondaridgeline.jpg", 2019, 2022, br);
                    Model model35 = new Model("CR-V", VehicleTypesEnum.CAR, "https://example.com/hondacrv.jpg", 2016, 2022, br);
                    modelRepository.saveAll(Arrays.asList(model31, model32, model33, model34, model35));
                }
                case "Chevrolet" -> {
                    Model model36 = new Model("Silverado 1500", VehicleTypesEnum.TRUCK, "https://example.com/chevroletsilverado1500.jpg", 2017, 2022, br);
                    Model model37 = new Model("Cruze", VehicleTypesEnum.CAR, "https://example.com/chevroletcruze.jpg", 2018, 2022, br);
                    Model model38 = new Model("Equinox", VehicleTypesEnum.CAR, "https://example.com/chevroletequinox.jpg", 2016, 2022, br);
                    Model model39 = new Model("Spark", VehicleTypesEnum.CAR, "https://example.com/chevroletspark.jpg", 2019, 2022, br);
                    Model model40 = new Model("Trailblazer", VehicleTypesEnum.CAR, "https://example.com/chevrolettrailblazer.jpg", 2020, 2022, br);
                    modelRepository.saveAll(Arrays.asList(model36, model37, model38, model39, model40));
                }
                case "Volvo" -> {
                    Model model41 = new Model("8700", VehicleTypesEnum.BUS, "https://example.com/volvo8700.jpg", 2018, 2022, br);
                    Model model42 = new Model("9700", VehicleTypesEnum.BUS, "https://example.com/volvo9700.jpg", 2019, 2022, br);
                    Model model43 = new Model("9900", VehicleTypesEnum.BUS, "https://example.com/volvo9900.jpg", 2017, 2022, br);
                    Model model44 = new Model("Sunsundegui Sideral", VehicleTypesEnum.BUS, "https://example.com/sunsundeguisideral.jpg", 2019, 2022, br);
                    Model model45 = new Model("Irizar i8", VehicleTypesEnum.BUS, "https://example.com/irizari8.jpg", 2020, 2022, br);
                    modelRepository.saveAll(Arrays.asList(model41, model42, model43, model44, model45));
                }
            }
        }
        List<Model> models = modelRepository.findAll();

        for (int i = 0; i < 500; i++) {
            Offer offer = new Offer();
            offer.setDescription(faker.lorem().sentence());
            offer.setEngine(EngineTypesEnum.values()[faker.random().nextInt(EngineTypesEnum.values().length)]);
            offer.setImageUrl(faker.internet().image());
            offer.setMileage(faker.random().nextInt(10000, 100000));
            offer.setPrice(faker.random().nextInt(1000, 10000));
            offer.setImageUrl(faker.internet().image());
            offer.setTransmission(TransmissionTypesEnum.values()[faker.random().nextInt(TransmissionTypesEnum.values().length)]);
            offer.setYear(faker.random().nextInt(2016, 2020));
            offer.setSeller(users.get(random.nextInt(users.size())));
            offer.setModel(models.get(random.nextInt(models.size())));
            offerRepository.saveAndFlush(offer);
        }







    }
}




*/
