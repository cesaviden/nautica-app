package com.app.cesaviden.nautica.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "trips")
public class TripEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "boat_id", nullable = false)
    @JsonBackReference
    private BoatEntity boat;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "The departure date and time is required")
    @PastOrPresent(message = "The departure date and time must be in the past or present")
    private LocalDateTime departureDateTime;

    @Column(nullable = false)
    @NotBlank(message = "The destination is required")
    @Size(max = 255, message = "The destination cannot have more than 255 characters")
    private String destination;

    @ManyToOne
    @JoinColumn(name = "patron_id", nullable = false)
    @JsonBackReference
    private PatronEntity patron;
}
