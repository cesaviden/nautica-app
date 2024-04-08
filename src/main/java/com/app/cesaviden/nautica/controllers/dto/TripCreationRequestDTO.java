package com.app.cesaviden.nautica.controllers.dto;

public record TripCreationRequestDTO(
    Integer boatId,
    Integer patronId,
    String departureDateTime,
    String destination
) {
}
