package com.example.demo;

import com.example.demo.constants.Enums.EngineTypesEnum;
import com.example.demo.constants.Enums.Role;
import com.example.demo.constants.Enums.TransmissionTypesEnum;
import com.example.demo.constants.Enums.VehicleTypesEnum;
import com.example.demo.models.Brand;
import com.example.demo.models.Model;
import com.example.demo.models.User;
import com.example.demo.models.UserRole;
import com.example.demo.repos.*;
import com.example.demo.services.*;

import com.github.javafaker.Faker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private BrandService brandService;

    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private ModelService modelService;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private OfferService offerService;



    @Override
    public void run(String... args) throws Exception {
     /*   Faker faker = new Faker();
        Random random = new Random();

        UserRole userRole = new UserRole(Role.USER);
        UserRole adminRole = new UserRole(Role.ADMIN);
        userRoleRepository.save(userRole);
        userRoleRepository.save(adminRole);

        List<UserRoleDto> roles_dto = userRoleService.getAll();

        for (int i = 0; i < 100; i++) {
            UserDto userDto = new UserDto();
            userDto.setUsername(faker.name().username());
            userDto.setPassword(faker.internet().password());
            userDto.setFirstName(faker.name().firstName());
            userDto.setLastName(faker.name().lastName());
            userDto.setActive(random.nextBoolean());
            userDto.setImageUrl(faker.internet().image());
            userDto.setRole(roles_dto.get(random.nextInt(2)));
            userService.createUser(userDto);
        }

        List<UserDto> userListDto = userService.getAll();
        String[] carBrands = {"Toyota", "BMW", "Mercedes-Benz", "Ford", "Volkswagen", "Audi"};
        for (String brand : carBrands) {
            Brand br = new Brand(brand);
            brandRepository.save(br);

            if (brand.equals("BMW")) {
                Model model1 = new Model("3 Series", VehicleTypesEnum.CAR, "https://example.com/bmw3series.jpg", 2018, 2022, br);
                Model model2 = new Model("X5", VehicleTypesEnum.CAR, "https://example.com/bmwx5.jpg", 2019, 2022, br);
                Model model3 = new Model("7 Series", VehicleTypesEnum.CAR, "https://example.com/bmw7series.jpg", 2017, 2022, br);
                Model model4 = new Model("i8", VehicleTypesEnum.CAR, "https://example.com/bmwi8.jpg", 2014, 2021, br);
                Model model5 = new Model("X3", VehicleTypesEnum.CAR, "https://example.com/bmwx3.jpg", 2010, 2022, br);
                modelRepository.saveAll(Arrays.asList(model1, model2, model3, model4, model5));
            } else if (brand.equals("Audi")) {
                Model model6 = new Model("A4", VehicleTypesEnum.CAR, "https://example.com/audia4.jpg", 2015, 2022, br);
                Model model7 = new Model("Q5", VehicleTypesEnum.CAR, "https://example.com/audiq5.jpg", 2016, 2022, br);
                Model model8 = new Model("A7", VehicleTypesEnum.CAR, "https://example.com/audia7.jpg", 2018, 2022, br);
                Model model9 = new Model("Q3", VehicleTypesEnum.CAR, "https://example.com/audiq3.jpg", 2011, 2022, br);
                Model model10 = new Model("R8", VehicleTypesEnum.CAR, "https://example.com/audir8.jpg", 2010, 2022, br);
                modelRepository.saveAll(Arrays.asList(model6, model7, model8, model9, model10));
            } else if (brand.equals("Mercedes-Benz")) {
                Model model11 = new Model("C-Class", VehicleTypesEnum.CAR, "https://example.com/mercedesc.jpg", 2014, 2022, br);
                Model model12 = new Model("E-Class", VehicleTypesEnum.CAR, "https://example.com/mercedese.jpg", 2016, 2022, br);
                Model model13 = new Model("S-Class", VehicleTypesEnum.CAR, "https://example.com/mercedess.jpg", 2017, 2022, br);
                Model model14 = new Model("GLE", VehicleTypesEnum.CAR, "https://example.com/mercedesgle.jpg", 2019, 2022, br);
                Model model15 = new Model("GLA", VehicleTypesEnum.CAR, "https://example.com/mercedesgla.jpg", 2015, 2022, br);
                modelRepository.saveAll(Arrays.asList(model11, model12, model13, model14, model15));
            } else if (brand.equals("Toyota")) {
                Model model16 = new Model("Camry", VehicleTypesEnum.CAR, "https://example.com/toyotacamry.jpg", 2017, 2022, br);
                Model model17 = new Model("Corolla", VehicleTypesEnum.CAR, "https://example.com/toyotacorolla.jpg", 2018, 2022, br);
                Model model18 = new Model("RAV4", VehicleTypesEnum.CAR, "https://example.com/toyotarav4.jpg", 2016, 2022, br);
                Model model19 = new Model("Highlander", VehicleTypesEnum.CAR, "https://example.com/toyotahighlander.jpg", 2019, 2022, br);
                Model model20 = new Model("Tacoma", VehicleTypesEnum.TRUCK, "https://example.com/toyotatacoma.jpg", 2022, 2023, br);
                modelRepository.saveAll(Arrays.asList(model16, model17, model18, model19, model20));
            } else if (brand.equals("Ford")) {
                Model model21 = new Model("Mustang", VehicleTypesEnum.CAR, "https://example.com/fordmustang.jpg", 2015, 2022, br);
                Model model22 = new Model("F-150", VehicleTypesEnum.TRUCK, "https://example.com/fordf150.jpg", 2018, 2022, br);
                Model model23 = new Model("Explorer", VehicleTypesEnum.CAR, "https://example.com/fordexplorer.jpg", 2019, 2022, br);
                Model model24 = new Model("Edge", VehicleTypesEnum.CAR, "https://example.com/fordedge.jpg", 2016, 2022, br);
                Model model25 = new Model("Escape", VehicleTypesEnum.CAR, "https://example.com/fordescape.jpg", 2017, 2022, br);
                modelRepository.saveAll(Arrays.asList(model21, model22, model23, model24, model25));
            } else if (brand.equals("Volkswagen")) {
                Model model26 = new Model("Golf", VehicleTypesEnum.CAR, "https://example.com/vwgolf.jpg", 2014, 2022, br);
                Model model27 = new Model("Passat", VehicleTypesEnum.CAR, "https://example.com/vwpassat.jpg", 2016, 2022, br);
                Model model28 = new Model("Tiguan", VehicleTypesEnum.CAR, "https://example.co m/vwtiguan.jpg", 2017, 2022, br);
                Model model29 = new Model("Polo", VehicleTypesEnum.CAR, "https://example.com/vwpolo.jpg", 2018, 2022, br);
                Model model30 = new Model("Arteon", VehicleTypesEnum.CAR, "https://example.com/vwarteon.jpg", 2019, 2022, br);
                modelRepository.saveAll(Arrays.asList(model26, model27, model28, model29, model30));
            }
        }
        List<ModelDto> models = modelService.getAll();

        for (int i = 0; i < 100; i++) {
            OfferDto offerDto = new OfferDto();
            offerDto.setDescription(faker.lorem().sentence());
            offerDto.setEngine(EngineTypesEnum.values()[faker.random().nextInt(EngineTypesEnum.values().length)]);
            offerDto.setImageUrl(faker.internet().image());
            offerDto.setMileage(faker.random().nextInt(10000, 100000));
            offerDto.setPrice(faker.random().nextInt(1000, 10000));
            offerDto.setImageUrl(faker.internet().image());
            offerDto.setTransmission(TransmissionTypesEnum.values()[faker.random().nextInt(TransmissionTypesEnum.values().length)]);
            offerDto.setYear(faker.random().nextInt(2016, 2020));
            offerDto.setSeller(userListDto.get(random.nextInt(userListDto.size())));
            offerDto.setModel(models.get(random.nextInt(models.size())));
            offerService.createOffer(offerDto);
        }

        System.out.println(offerService.getOffersByPriceAndMileageLessDescYear(3000000, 100000));
        System.out.println(userService.getAllActiveClients());
        System.out.println(offerService.getAllOffersByBrandAndVtype("BMW", VehicleTypesEnum.CAR));
        System.out.println(brandService.getAllBrandModelsInOrderByCategory("BMW"));
        System.out.println(offerService.getAllOffersAndModelsByUserState(true));

        List<UserDto> userDtosList = userService.getAll();
        UUID userUuid = userDtosList.get(0).getId();
        userService.deleteUserById(userUuid);
        UserDto userDto1 = userDtosList.get(1);
        userService.deleteUser(userDto1);
        UserDto userDto2 = userDtosList.get(2);
        UserDto userDto3 = userDtosList.get(3);
        User user = modelMapper.map(userDto3, User.class);
        userRoleService.updateUserRole(user,userRole);
        userService.updateUsername(userDto2, "new username");
        System.out.println(userService.getAllActiveClients());
        List<BrandDto> brandDtoList = brandService.getAll();
        UUID brandUuid = brandDtoList.get(0).getId();
        brandService.deleteBrandById(brandUuid);
        BrandDto brandDto = brandDtoList.get(1);
        brandService.deleteBrand(brandDto);
        brandService.deleteByName("Audi");
        System.out.println(brandService.getAllBrandModelsInOrderByCategory("Ford"));
        List<OfferDto> offerDtoList = offerService.getAll();
        OfferDto offerDto1 = offerDtoList.get(0);
        offerService.deleteOffer(offerDto1);
        System.out.println(offerService.getAllOffersByBrandAndVtype("Mercedes-Benz", VehicleTypesEnum.CAR));
        System.out.println(offerService.getAllOffersAndModelsByUserState(true));
        System.out.println(offerService.getOffersByPriceAndMileageLessDescYear(3000000, 100000));
        OfferDto offerDto2 = offerDtoList.get(1);
        offerService.updatePrice(offerDto2, 400000);
        List<ModelDto> modelDtoList = modelService.getAll();
        UUID modelUuid = modelDtoList.get(0).getId();
        modelService.deleteModelById(modelUuid);
        ModelDto modelDto1 = modelDtoList.get(1);
        modelService.deleteModel(modelDto1);
        ModelDto modelDto2 = modelDtoList.get(2);
        modelService.updateEndYear(modelDto2, 3000);
        userRoleService.updateUserRole(user,userRole);
        userRoleService.updateUserRole(user,adminRole);
        userRoleService.updateUserRole(user,adminRole);




    }*/
}}



