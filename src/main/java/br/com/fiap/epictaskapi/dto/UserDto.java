package br.com.fiap.epictaskapi.dto;

import br.com.fiap.epictaskapi.model.User;

public record UserDto(
  Long id,
  String name,
  String email
) {
  public static UserDto fromEntity(User user){
    return new UserDto(
            user.getId(),
            user.getName(),
            user.getEmail()
    );
}
}
