package com.app.cesaviden.nautica.nauticaapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.app.cesaviden.nautica.controllers.BoatController;
import com.app.cesaviden.nautica.controllers.MemberController;
import com.app.cesaviden.nautica.controllers.TripController;
import com.app.cesaviden.nautica.entities.BoatEntity;
import com.app.cesaviden.nautica.services.implementation.BoatServiceImpl;
import com.app.cesaviden.nautica.services.implementation.MemberServiceImpl;
import com.app.cesaviden.nautica.services.implementation.TripServiceImpl;

@SpringBootTest
class NauticaAppApplicationTests {

	@InjectMocks
	private TripController tripController;

	@InjectMocks
	private MemberController memberController;

	@InjectMocks
	private BoatController boatController;

	@Mock
	private TripServiceImpl tripService;

	@Mock
	private MemberServiceImpl memberService;

	@Mock
	private BoatServiceImpl boatService;

	@SuppressWarnings("null")
	@Test
	@Rollback(false)
	public void testGetAllBoats() {
		// Crear una lista de barcos ficticia
		List<BoatEntity> boats = new ArrayList<>();
		boats.add(new BoatEntity());
		boats.add(new BoatEntity());

		// Configurar el comportamiento del servicio mock para devolver la lista
		// ficticia
		when(boatService.getAllBoats()).thenReturn(boats);

		// Llamar al método del controlador que devuelve la lista de barcos
		List<BoatEntity> returnedBoats = boatController.getAllBoats().getBody();

		// Verificar si la lista de barcos devuelta tiene más de 0 elementos
		assertTrue(returnedBoats.size() > 0);
	}
}
