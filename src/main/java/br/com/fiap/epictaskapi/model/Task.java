package br.com.fiap.epictaskapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TASK")
@SequenceGenerator(name = "task", sequenceName = "SQ_TB_TASK", allocationSize = 1)
public class Task {
 
    @Id 
    @Column(name = "cd_task")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task")
    private Long id;
    
    @Column(name = "ds_titulo")
    private String title;

    @Column(name = "ds_descricao")
    private String description;

    @Column(name = "nr_pontos")
    private int score;

    @Column(name = "nr_status")
    private int status;
    
    public Task() {
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Task(String title, String description, int score) {
        this.title = title;
        this.description = description;
        this.score = score;
    }

    public Task(String title, String description, int score, int status) {
        this.title = title;
        this.description = description;
        this.score = score;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task [description=" + description + ", id=" + id + ", score=" + score + ", status=" + status
                + ", title=" + title + "]";
    }


}
