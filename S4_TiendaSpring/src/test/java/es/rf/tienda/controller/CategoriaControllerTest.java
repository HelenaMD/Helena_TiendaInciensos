package es.rf.tienda.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.services.ServicioCategoria;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CategoriaController.class)
//@WithMockUser
class CategoriaControllerTest {
	
	/*@Autowired
	private MockMcv mockMvc;*/
	
	@MockBean
	private ServicioCategoria scmock2;
	
	private static Categoria c;
	private static final int ID_CAT_EJEMPLO = 1234;
	private static final int LENGTH_0 = 0;
	private static ServicioCategoria scmock;
	
	@BeforeAll
	static void mockitoServiceCategoria() {
		scmock = Mockito.mock(ServicioCategoria.class);
	}
	
	@BeforeEach
	void crearCategoria() throws DomainException {
		c = new Categoria(1234, "Categoria defecto", "Es una categoria por defecto para pruebas.");
	}
	
	@Test
	void testLeerUno() {
		//ServicioCategoria scmock = Mockito.mock(ServicioCategoria.class);
		/*Mockito.when(scmock.leerUno(null)).thenReturn(c);
		Categoria result = scmock.leerUno(null);
		assertEquals(ID_CAT_EJEMPLO, result.getId_categoria());
		Mockito.verify(scmock).leerUno(null);*/
	}

	@Test
	void testLeerTodos() {
		/*Mockito.when(scmock.listAll()).thenReturn(new ArrayList<Categoria>());
		List<Categoria> result = scmock.listAll();
		assertEquals(LENGTH_0, result.size());
		Mockito.verify(scmock).listAll();*/
	}

	@Test
	void testAlta() {
		fail("Not yet implemented");
	}

	@Test
	void testModificacion() {
		fail("Not yet implemented");
	}

	@Test
	void testBorrarPorId() {
		fail("Not yet implemented");
	}

}
