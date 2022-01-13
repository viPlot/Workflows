package MVC.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


public enum Position implements GrantedAuthority {
    director,
    headOfDepartment,
    departmentSpecialist;

    @Override
    public String getAuthority() {
        return name();
    }
}
