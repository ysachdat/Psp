package com.automobilesales.controller.main;

import com.automobilesales.model.enums.*;
import org.springframework.ui.Model;

public class Attributes extends Main {

    protected void AddAttributes(Model model) {
        model.addAttribute("role", getRole());
        model.addAttribute("user", getUser());
    }

    protected void AddAttributesEnums(Model model) {
        model.addAttribute("bodyTypes", BodyType.values());
        model.addAttribute("fuels", Fuel.values());
        model.addAttribute("transmissions", Transmission.values());
    }

    protected void AddAttributesUsers(Model model) {
        AddAttributes(model);
        model.addAttribute("users", usersRepo.findAll());
        model.addAttribute("roles", Role.values());
    }

    protected void AddAttributesCar(Model model, Long id) {
        AddAttributes(model);
        model.addAttribute("car", carsRepo.getReferenceById(id));
    }

    protected void AddAttributesCarAdd(Model model) {
        AddAttributes(model);
        AddAttributesEnums(model);
    }

    protected void AddAttributesCarEdit(Model model, Long id) {
        AddAttributes(model);
        AddAttributesEnums(model);
        model.addAttribute("car", carsRepo.getReferenceById(id));
    }

    protected void AddAttributesIndex(Model model) {
        AddAttributes(model);
        AddAttributesEnums(model);
        model.addAttribute("cars", carsRepo.findAllByStatus(CarStatus.ACTIVE));
    }

    protected void AddAttributesCarMy(Model model) {
        AddAttributes(model);
        model.addAttribute("cars", getUser().getCars());
    }

    protected void AddAttributesCarApps(Model model) {
        AddAttributes(model);
        model.addAttribute("cars", carsRepo.findAllByStatus(CarStatus.WAITING));
    }

    protected void AddAttributesIndexSearch(Model model, BodyType bodyType, Transmission transmission) {
        AddAttributes(model);
        AddAttributesEnums(model);
        model.addAttribute("bSelect", bodyType);
        model.addAttribute("tSelect", transmission);
        model.addAttribute("cars", carsRepo.findAllByStatusAndDescription_BodyTypeAndDescription_Transmission(CarStatus.ACTIVE, bodyType, transmission));
    }

    protected void AddAttributesStats(Model model) {
        AddAttributes(model);
        model.addAttribute("waiting", carsRepo.findAllByStatus(CarStatus.WAITING).stream().reduce(0, (i, car) -> i + car.getPrice(), Integer::sum));
        model.addAttribute("active", carsRepo.findAllByStatus(CarStatus.ACTIVE).stream().reduce(0, (i, car) -> i + car.getPrice(), Integer::sum));
        model.addAttribute("sold", carsRepo.findAllByStatus(CarStatus.SOLD).stream().reduce(0, (i, car) -> i + car.getPrice(), Integer::sum));
    }
}
