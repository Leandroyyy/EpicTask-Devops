package br.com.fiap.epictaskapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.epictaskapi.model.Task;
import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.repository.TaskRepository;
import br.com.fiap.epictaskapi.repository.UserRepository;
import br.com.fiap.epictaskapi.service.UserService;

@Configuration
@Profile("dev")
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        userService.save(
            new User(
                "admin",
                "admin@fiap.com.br",
                "administrador"
            )
        );

        taskRepository.saveAll(List.of(
                new Task("Modelar o Banco", "Modelagem das tabelas", 20),
                new Task("Bug", "Modelagem das tabelas", 50),
                new Task("Login", "Modelagem das tabelas", 12),
                new Task("Deploy", "Modelagem das tabelas", 98),
                new Task("Testes", "Modelagem das tabelas", 76),
                new Task("Autenticação", "Modelagem das tabelas", 10),
                new Task("Cadastro de usuário", "Modelagem das tabelas", 21),
                new Task("Consulta de tarefas", "Modelagem das tabelas", 18),
                new Task("Prototipo", "Protipar as telas", 9)));

    }

}
