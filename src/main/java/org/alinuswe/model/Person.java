package org.alinuswe.model;

import jakarta.persistence.*;
import lombok.Data;
import org.alinuswe.enums.Gender;
@Entity(name ="Person" )
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
