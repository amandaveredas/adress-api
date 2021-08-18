package com.github.amandaveredas.adressapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "{name.not.blank}")
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.email}")
    private String email;

    @Column(name = "cpf", unique = true, nullable = false)
    @NotBlank(message = "{cpf.not.blank}")
    @CPF(message = "{cpf.cpf}")
    private String cpf;

    @Column(name = "data_nascimento")
    @Past(message = "{birthDate.past}")
    private LocalDate birthDate;


    public User(String name, String email, String cpf, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }
}
