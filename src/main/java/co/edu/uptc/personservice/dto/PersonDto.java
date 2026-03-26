package co.edu.uptc.personservice.dto;

import lombok.Data;

@Data
public class PersonDto {
    private String name;
    private String lastName;
    private int age;
    private String ip;
    private String serverMessage;
}
