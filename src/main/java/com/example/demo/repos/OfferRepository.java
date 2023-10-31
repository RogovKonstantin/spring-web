package com.example.demo.repos;



import com.example.demo.constants.Enums.VehicleTypesEnum;
import com.example.demo.models.Offer;

import com.example.demo.web.views.OfferMW;
import com.example.demo.web.views.OfferModelMW;
import com.example.demo.web.views.OfferUserMW;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {
    @Query(value = "SELECT new com.example.demo.web.views.OfferModelMW(o.description,  o.price, o.mileage, o.year, m.category, m.name ) FROM Offer o JOIN Model m ON o.model.id = m.id JOIN Brand b on m.brand.id=b.id WHERE b.name=:brandName AND m.category=:vehicleType ")
    List<OfferModelMW> getAllOffersByBrandAndVtype(@Param(value = "brandName") String brandName, @Param(value = "vehicleType") VehicleTypesEnum vehicleType);

    @Query(value = "SELECT new com.example.demo.web.views.OfferMW(o.description,  o.price, o.mileage, o.year)FROM Offer o WHERE price <:price and mileage<:mileage ORDER by o.year DESC  ")
    List<OfferMW> getOffersByPriceAndMileageLessDescYear(@Param(value = "price") Integer price, @Param(value = "mileage") Integer mileage);

    @Query(value = "SELECT new com.example.demo.web.views.OfferUserMW(u.username, o.description,  o.price, o.mileage, o.year, m.category, m.name ) " +
            "From Offer o JOIN o.model m JOIN o.seller u WHERE u.active=:bool")
    List<OfferUserMW> getAllOffersAndModelsByUserState(@Param(value = "bool") Boolean bool);


}
