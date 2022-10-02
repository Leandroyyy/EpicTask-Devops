package br.com.fiap.epictaskapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "TB_ROLE")
@SequenceGenerator(name = "role", sequenceName = "SQ_TB_ROLE", allocationSize = 1)
public class Role implements GrantedAuthority {

    @Id 
    @Column(name = "cd_role")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role")
    private Long id;

    @Column(name = "ds_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }


}
