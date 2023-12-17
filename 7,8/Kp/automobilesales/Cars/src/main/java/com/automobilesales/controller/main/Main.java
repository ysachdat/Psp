package com.automobilesales.controller.main;

import com.automobilesales.model.Users;
import com.automobilesales.repo.CarDescriptionRepo;
import com.automobilesales.repo.CarsRepo;
import com.automobilesales.repo.CommentsRepo;
import com.automobilesales.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

public class Main {

    @Autowired
    protected UsersRepo usersRepo;
    @Autowired
    protected CarsRepo carsRepo;
    @Autowired
    protected CarDescriptionRepo carDescriptionRepo;
    @Autowired
    protected CommentsRepo commentsRepo;
    @Value("${upload.img}")
    protected String uploadImg;

    protected String DateNow() {
        return LocalDateTime.now().toString().substring(0, 10);
    }

    protected Users getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((!(auth instanceof AnonymousAuthenticationToken)) && auth != null) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            return usersRepo.findByUsername(userDetail.getUsername());
        }
        return null;
    }

    protected String getRole() {
        Users users = getUser();
        if (users == null) return "NOT";
        return users.getRole().toString();
    }
}