package com.app.cesaviden.nautica.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "The name is required")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "The address is required")
    private String address;

    @Column(nullable = false)
    @NotBlank(message = "The phone is required")
    private String phone;

    @Column(nullable = false)
    @NotBlank(message = "The dni is required")
    private String dni;

    @Column(nullable = false)
    @NotBlank(message = "The email is required")
    @Email(message = "The email is not valid")
    private String email;

}
