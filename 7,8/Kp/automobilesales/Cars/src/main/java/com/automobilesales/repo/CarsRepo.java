package com.automobilesales.repo;

import com.automobilesales.model.Cars;
import com.automobilesales.model.enums.BodyType;
import com.automobilesales.model.enums.CarStatus;
import com.automobilesales.model.enums.Fuel;
import com.automobilesales.model.enums.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepo extends JpaRepository<Cars, Long> {
    List<Cars> findAllByStatus(CarStatus status);

    List<Cars> findAllByStatusAndDescription_BodyTypeAndDescription_Transmission(CarStatus status, BodyType bodyType, Transmission transmission);
}
