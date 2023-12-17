package com.automobilesales.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CarStatus {
    WAITING("Ожидание"),
    ACTIVE("Активно"),
    SOLD("Продано"),
    REFUSED("Отказано");
    private final String name;
}

