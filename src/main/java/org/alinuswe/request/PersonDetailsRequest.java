package org.alinuswe.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.alinuswe.enums.Gender;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDetailsRequest {

    private String firstName;
    private String lastName;
    private String address;
    private String age;
    private Gender gender;



}
