package com.automobilesales.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Role implements GrantedAuthority {
    ADMIN("Владелец"),
    MANAGER("Сотрудник"),
    CLIENT("Покупатель");

    private final String name;

    @Override
    public String getAuthority() {
        return name();
    }
}

