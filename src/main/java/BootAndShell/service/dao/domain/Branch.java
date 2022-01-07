package BootAndShell.service.dao.domain;

import lombok.*;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Branch {
    private long id;
    private String city;
    private int index;
    private int number;
    private String address;
}

