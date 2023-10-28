/*package com.example.demo.models.factories;

import com.example.demo.models.*;
import com.example.demo.models.Enums.*;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OfferFactory {
    Faker faker = new Faker();

    public LocalDateTime created() {
        return faker.date()
                .past(20 * 365, 12 * 365, TimeUnit.DAYS)
                .toInstant()
                .atOffset(ZoneOffset.UTC)
                .toLocalDateTime();
    }

    public LocalDateTime bound() {
        return faker.date()
                .past(10 * 365, TimeUnit.DAYS)
                .toInstant()
                .atOffset(ZoneOffset.UTC)
                .toLocalDateTime();
    }

    public LocalDateTime modified() {
        Date date1 = Date.from(created().toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date date2 = Date.from(bound().toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        return faker.date().between(date1, date2).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime();
    }

    public VehicleTypesEnum vehicleTypesRandom() {
        int pick = new Random().nextInt(VehicleTypesEnum.values().length);
        return VehicleTypesEnum.values()[pick];
    }

    public EngineTypesEnum engineTypesRandom() {
        int pick = new Random().nextInt(EngineTypesEnum.values().length);
        return EngineTypesEnum.values()[pick];
    }

    public TransmissionTypesEnum transmissionTypesRandom() {
        int pick = new Random().nextInt(TransmissionTypesEnum.values().length);
        return TransmissionTypesEnum.values()[pick];
    }

    public UserRoleTypesEnum roleTypesRandom() {
        int pick = new Random().nextInt(UserRoleTypesEnum.values().length);
        return UserRoleTypesEnum.values()[pick];
    }

    public VehicleBrandsEnum vehicleBrandsEnum() {
        int pick = new Random().nextInt(VehicleBrandsEnum.values().length);
        return VehicleBrandsEnum.values()[pick];
    }


    public String name() {
        return faker.music().chord();
    }

    public String imageUrl() {
        return faker.internet().image();
    }

    public String description() {
        return faker.superhero().descriptor();
    }

    public Integer startYear() {
        return faker.random().nextInt(2000, 2010);
    }

    public String username() {
        return faker.superhero().prefix() + faker.animal().name() + faker.address().buildingNumber();
    }

    public String password() {
        return faker.internet().password();

    }

    public String firstname() {
        return faker.name().firstName();
    }

    public String lastname() {
        return faker.name().lastName();
    }


    public Integer endYear() {
        return faker.random().nextInt(2010, 2020);
    }


    public Integer price() {
        return faker.random().nextInt(500000, 5000000);
    }

    public Integer mileage() {
        return faker.random().nextInt(7, 300000);
    }

    public Brand brand() {
        return new Brand(vehicleBrandsEnum().name());
    }

    public Model model() {
        return new Model(name(), vehicleTypesRandom(), imageUrl(), startYear(), endYear(), brand());
    }

    public User user() {
        return new User(imageUrl(), username(), password(), firstname(), lastname(), faker.random().nextBoolean(), role());
    }

    public UserRole role() {
        return new UserRole(roleTypesRandom());
    }


    final Offer make(UnaryOperator<Offer>... offers) {
        final Offer result = new Offer(description(), engineTypesRandom(), mileage(), price(), imageUrl(), transmissionTypesRandom(), endYear(), user(), model());
        Stream.of(offers).forEach(v -> v.apply(result));
        return result;
    }

    public OfferFactory.OffersListDtoFactory listBuilder() {
        return new OffersListDtoFactory();
    }

    public class OffersListDtoFactory {
        public List<Offer> offers(int min, int max, UnaryOperator<Offer>... offers) {
            return IntStream.range(0, faker.number().numberBetween(min, max))
                    .mapToObj(i -> OfferFactory.this.make(offers))
                    .collect(Collectors.toList());
        }
    }
}*/


