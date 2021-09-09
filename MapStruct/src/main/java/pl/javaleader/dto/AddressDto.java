package pl.javaleader.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddressDto {
    String street;
    String city;
    String state;
    String zipCode;
}
