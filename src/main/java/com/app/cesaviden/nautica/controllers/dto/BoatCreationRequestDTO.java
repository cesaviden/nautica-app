package com.app.cesaviden.nautica.controllers.dto;

public record BoatCreationRequestDTO(
    String name,
    String registrationNumber,
    Integer mooringNumber,
    Integer fee,
    Integer ownerId) {
    
}
