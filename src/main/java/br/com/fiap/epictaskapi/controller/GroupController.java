package br.com.fiap.epictaskapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.epictaskapi.model.Student;

@RestController
@RequestMapping("/api/grupo")
public class GroupController {

  @GetMapping
  public List<Student> group(){

    var leandro = new Student("RM86721", "Leandro Cavallari", "2TDSR");
    var andre = new Student("RM84163", "Andre Beolchi", "2TDSR");
    var henrique = new Student("RM86866", "Henrique Akio", "2TDSR");
    var shim = new Student("RM88760", "Gabriel de Mello", "2TDSR");
    var karen = new Student("88429", "Karen Cristhine", "2TDSR");

    List<Student> students = new ArrayList<Student>();
    students.add(leandro);
    students.add(andre);
    students.add(henrique);
    students.add(shim);
    students.add(karen);
    return students;
  }
}
