package pl.javaleader.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PersonDto {
    String username;
    String surname;
    String sex;
    AddressDto addressDto;
}
