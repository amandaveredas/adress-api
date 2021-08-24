package com.github.amandaveredas.adressapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

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
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = { "dd/MM/yyyy", "dd.MM.yyyy", "dd-MM-yyyy" })
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthDate;


    public User(String name, String email, String cpf, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }
}
