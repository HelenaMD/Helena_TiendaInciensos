package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.rf.tienda.exception.DomainException;

class CategoriaTest {
	
	static Categoria c;
	static Categoria errc;
	static final int ID_CATEG_PRINCIPAL = 1234;
	static final int ID_CATEG_ALTER = 9876;
	static final int ID_0 = 0;
	static final int LENGTH_3 = 3;
	static final int LENGTH_200 = 200;
	static final String NOMBRE_CATEG_PRINCIPAL = "Productos Frescos";
	static final String NOMBRE_CATEG_ALTER = "ALTERNATIVO";
	static final String DESC_CATEG_PRINCIPAL = "Van en la nevera";
	static final String NOMBRE_CATEG_ERR_CORTO = "ola";
	static final String ASSERT_FUERA_LIMITES_MIN = "Se te ha colado un nombre menor del limite minimo de caracteres.";
	static final String NOMBRE_CATEG_ERR_LARGO = "Se te ha colado un nombre menor del limite minimo de caracteres.Se te ha colado un nombre menor del limite minimo de caracteres.Se te ha colado un nombre menor del limite minimo de caracteres.Se te ha colado un nombre menor del limite minimo de caracteres.Se te ha colado un nombre menor del limite minimo de caracteres.Se te ha colado un nombre menor del limite minimo de caracteres.Se te ha colado un nombre menor del limite minimo de caracteres.Se te ha colado un nombre menor del limite minimo de caracteres.";
	static final String ASSERT_FUERA_LIMITES_MAX = "Se te ha colado un nombre mayor del limite maximo de caracteres.";
	static final String VACIO = "";
	
	@BeforeEach
	void createCategoria() throws DomainException {
		c = new Categoria(ID_CATEG_PRINCIPAL, NOMBRE_CATEG_PRINCIPAL, DESC_CATEG_PRINCIPAL);
		errc = new Categoria();
	}

	@Test
	void testIsValidInsert() {
		assertTrue(c.isValidInsert());
		assertFalse(errc.isValidInsert());
	}

	@Test
	void testIsValidUpdate() {
		assertTrue(c.isValidUpdate());
		assertFalse(errc.isValidUpdate());
		errc.setId_categoria(0);
		assertFalse(errc.isValidUpdate());
	}

	@Test
	void testGetId_categoria() {
		assertEquals(ID_CATEG_PRINCIPAL, c.getId_categoria());
		assertEquals(ID_0, errc.getId_categoria());
	}

	@Test
	void testSetId_categoria() {
		c.setId_categoria(ID_CATEG_ALTER);
		assertEquals(ID_CATEG_ALTER, c.getId_categoria());
	}

	@Test
	void testGetCat_nombre() {
		assertEquals(NOMBRE_CATEG_PRINCIPAL, c.getCat_nombre());
		assertNull(errc.getCat_nombre());
	}

	@Test
	void testSetCat_nombre() throws DomainException {
		//NOMBRE_CATEG_ALTER
		c.setCat_nombre(NOMBRE_CATEG_ALTER);
		assertEquals(NOMBRE_CATEG_ALTER, c.getCat_nombre());
		assertThrows(DomainException.class, () ->  c.setCat_nombre(NOMBRE_CATEG_ERR_CORTO),
				ASSERT_FUERA_LIMITES_MIN);
		assertThrows(DomainException.class, () ->  c.setCat_nombre(NOMBRE_CATEG_ERR_LARGO),
				ASSERT_FUERA_LIMITES_MAX);
	}

	@Test
	void testGetCat_descripcion() {
		assertEquals(DESC_CATEG_PRINCIPAL, c.getCat_descripcion());
		assertNull(errc.getCat_descripcion());
	}

	@Test
	void testSetCat_descripcion() {
		errc.setCat_descripcion(VACIO);
		assertEquals(VACIO, errc.getCat_descripcion());
		c.setCat_descripcion(NOMBRE_CATEG_ERR_CORTO);
		assertEquals(LENGTH_3, c.getCat_descripcion().length());
		c.setCat_descripcion(NOMBRE_CATEG_ERR_LARGO);
		assertEquals(LENGTH_200, c.getCat_descripcion().length());
	}

	@Test
	void testEqualsObject() throws DomainException {
		Categoria cCopy = new Categoria(c.getId_categoria(), c.getCat_nombre(), c.getCat_descripcion());
		
		assertTrue(c.equals(cCopy));
		assertFalse(c.equals(errc));
	}

}
