package com.app.cesaviden.nautica.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "members")
public class MemberEntity {

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
    @Pattern(regexp = "\\d{9}", message = "The phone number must have 9 digits")
    private String phone;

    @Column(nullable = false)
    @Email(message = "The email is not valid")
    @NotBlank(message = "The email is required")
    private String email;

    @OneToMany(mappedBy = "owner")
    private List<BoatEntity> boats;

}
