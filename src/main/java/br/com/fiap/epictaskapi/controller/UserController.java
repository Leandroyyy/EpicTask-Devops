package br.com.fiap.epictaskapi.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.epictaskapi.dto.UserDto;
import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserService service;

  @Autowired
  PasswordEncoder passwordEncoder;

  @GetMapping
  public Page<UserDto> index(@PageableDefault(size = 10) Pageable paginacao) {
    return service.listAll(paginacao).map(UserDto::fromEntity);
  }

  @PostMapping
  public ResponseEntity<User> create(@RequestBody User user) {

    user.setPassword(passwordEncoder.encode(user.getPassword()));
    service.save(user);

    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }

  @GetMapping("{id}")
  public ResponseEntity<UserDto> show(@PathVariable Long id) {
    var user = service.getById(id);
    if (user.isEmpty())
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    var dto = new UserDto(user.get().getId(), user.get().getName(), user.get().getEmail());
    return ResponseEntity.status(HttpStatus.OK).body(dto);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> destroy(@PathVariable Long id) {
    var optional = service.getById(id);

    if (optional.isEmpty())
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    service.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @PutMapping("{id}")
  public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto newUser) {
    // buscar a tarefa no BD
    var optional = service.getById(id);

    // verificar se existe
    if (optional.isEmpty())
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    // atualizar os valores
    var user = optional.get();

    user.setEmail(newUser.email());
    user.setName(newUser.name());
    user.setId(id);

    // salvar no BD
    service.save(user);

    var dto = new UserDto(user.getId(), user.getName(), user.getEmail());

    return ResponseEntity.ok(dto);
  }

}
