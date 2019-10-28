package pl.javaleader.springsecurityrest.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserDto {

  public UserDto() {
  }

  String username;
  String password;
}
