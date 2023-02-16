package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidatorTest {

	/*Datos que van a probarse*/
	static final String[] ALFANUMERIC_CORRECT = {"abcde", "12345", "abcABC", "aBcDe1234", "n", "6", "con espacios"};
	static final String[] ALFANUMERIC_INCORRECT = {"", "hola!!", "@twitter", "-.-", "\\_/"};
	static final String[] VACIO_CORRECT = {"",  null};
	static final String[] VACIO_INCORRECT = {"hola",  "___", " "};
	static final String[] PHONENUMBER_CORRECT = {"34 666777888", "2 111 222 333"};
	static final String[] PHONENUMBER_INCORRECT = {"+(34)666777888", "2456", "          23"};
	static final String[] EMAIL_CORRECT = {"hola@adios.es", "of_courSe@hola-tio.com", "welcOme1@adiOs2.py", "a@e.es", "a.la@olo.com"};
	static final String[] EMAIL_INCORRECT = {"hola@adios.a", "@adios.com", "eje@.com", "to!!@egg.es", "ole@ole@ole.com"};
	static final String[] DNI_CORRECT = {"19.008.257-E", "91.927.521-V", "00.623.350-G"};
	static final String[] DNI_INCORRECT = {"2..456.789-H", "11111111111F", "A", "222222222222", "TYUIOPLKJHGF", "99.999.999-F"};
	static final String[] FECHAS_INCORRECT = {"10-12", "23D12M2020A", "2024_03", "jueves 29 de enero de 2023", "23-04-1999"};
	static final String FECHA_CORRECT = "23/04/1999";
	static final String[] PASS_CORRECT = {"aA12!@.", "aaAA1122!!@."};
	static final String[] PASS_INCORRECT = {"", "aaAA1122!!@@eeeeeeeee", "aaaaa", "aaaaAAAA", "aaAA22."};
	static final int[][] PARAMETROS_RANGO_INT_CORRECT = {{5, 1, 10}, {1, 1, 10}, {10, 1, 10}};
	static final int[][] PARAMETROS_RANGO_INT_INCORRECT = {{13, 1, 10}, {0, 1, 10}};
	static final double[][] PARAMETROS_RANGO_DOUBLE_CORRECT = {{5.87, 1, 10}, {1.33, 1, 10}, {9.07, 1, 10}};
	static final double[][] PARAMETROS_RANGO_DOUBLE_INCORRECT = {{10.56, 1, 10}, {0.99, 1, 10}};
	static final String[] PRODUCTO_CORRECT = {"AB102", "YZ999"};
	static final String[] PRODUCTO_INCORRECT = {"ab102", "aB111", "ABF02", "00BF2", "AF00098", "AF0"};
	static final String[] STRING_LONGMINMAX_CORRECT = {"Prueba och", "Prueba ocho", "Prueba ochoo"};
	static final String[] STRING_LONGMINMAX_INCORRECT = {"Prueba oc", "Prueba ochooo"};
	static final int[] LONGITUDES_MIN_CORRECT = {10, 11};
	static final int LONGITUD_MIN_INCORRECT = 12;
	static final int[] LONGITUDES_MAX_CORRECT = {11, 12};
	static final int LONGITUD_MAX_INCORRECT = 10;
	static final LocalDate FECHA_FIJA = LocalDate.of(2023, 1, 27);
	static final LocalDate FECHA_PASADA = LocalDate.of(2023, 1, 25);
	static final LocalDate FECHA_FUTURA = LocalDate.of(2023, 1, 30);
	static final LocalDate FECHA_NULA = null;
	
	/*Metodo que comprueba inputs string y confirma si son alfanumericos*/
	@RepeatedTest(value = 7, name = "Strings alfanumericas correctas {currentRepetition}/{totalRepetitions}")
	void testIsAlfanumericCorrect(RepetitionInfo repetitionInfo) {
		String str = ALFANUMERIC_CORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertTrue(Validator.isAlfanumeric(str));
	}
	
	/*Metodo que comprueba inputs string y confirma si NO son alfanumericos*/
	@RepeatedTest(value = 5, name = "Strings alfanumericas incorrectas {currentRepetition}/{totalRepetitions}")
	void testIsAlfanumericIncorrect(RepetitionInfo repetitionInfo) {
		String str = ALFANUMERIC_INCORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertFalse(Validator.isAlfanumeric(str));
	}

	/*Metodo que comprueba inputs string y confirma si estan vacios QUE NO ES LO MISMO DE NULL*/
	@RepeatedTest(value = 2, name = "Strings vacias correctas {currentRepetition}/{totalRepetitions}")
	void testIsVacioCorrect(RepetitionInfo repetitionInfo) {
		String str = VACIO_CORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertTrue(Validator.isVacio(str));
	}
	
	/*Metodo que comprueba inputs string y confirma si NO estan vacios QUE NO ES LO MISMO DE NULL*/
	@RepeatedTest(value = 2, name = "Strings vacias incorrectas {currentRepetition}/{totalRepetitions}")
	void testIsVacioIncorrect(RepetitionInfo repetitionInfo) {
		String str = VACIO_INCORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertFalse(Validator.isVacio(str));
	}

	/*Metodo que comprueba inputs string y confirma si encajan en el patron de numero de telefono*/
	@RepeatedTest(value = 2, name = "Strings phoneNumber correctas {currentRepetition}/{totalRepetitions}")
	void testCumplePhoneNumberCorrecto(RepetitionInfo repetitionInfo) {
		String str = PHONENUMBER_CORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertTrue(Validator.cumplePhoneNumber(str));
	}
	
	/*Metodo que comprueba inputs string y confirma si NO encajan en el patron de numero de telefono*/
	@RepeatedTest(value = 3, name = "Strings phoneNumber correctas {currentRepetition}/{totalRepetitions}")
	void testCumplePhoneNumberIncorrecto(RepetitionInfo repetitionInfo) {
		String str = PHONENUMBER_INCORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertFalse(Validator.cumplePhoneNumber(str));
	}

	/*Metodo que comprueba inputs string y confirma si encajan en el patron de email*/
	@RepeatedTest(value = 5, name = "Strings email correctas {currentRepetition}/{totalRepetitions}")
	void testIsEmailValidoCorrecto(RepetitionInfo repetitionInfo) {
		String str = EMAIL_CORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertTrue(Validator.isEmailValido(str));
	}
	
	/*Metodo que comprueba inputs string y confirma si NO encajan en el patron de email*/
	@RepeatedTest(value = 5, name = "Strings email incorrectas {currentRepetition}/{totalRepetitions}")
	void testIsEmailValidoIncorrecto(RepetitionInfo repetitionInfo) {
		String str = EMAIL_INCORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertFalse(Validator.isEmailValido(str));
	}
	
	/*Metodo que comprueba inputs string y confirma si encajan en el patron de DNI*/
	@RepeatedTest(value = 3, name = "Strings dni correctas {currentRepetition}/{totalRepetitions}")
	void testCumpleDNICorrecto(RepetitionInfo repetitionInfo) {
		String str = DNI_CORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertTrue(Validator.cumpleDNI(str));
	}
	
	/*Metodo que comprueba inputs string y confirma si NO encajan en el patron de DNI*/
	@RepeatedTest(value = 6, name = "Strings dni incorrectas {currentRepetition}/{totalRepetitions}")
	void testCumpleDNIIncorrecto(RepetitionInfo repetitionInfo) {
		String str = DNI_INCORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertFalse(Validator.cumpleDNI(str));
	}

	/*Metodo que comprueba con diferentes valores si uno de ellos encaja en un rango numerico*/
	@ParameterizedTest() //Cuando en cada pasada necesito mas de 2 datos distintos me conviene usar parameterized
	@MethodSource("parametrosRangoCorrectos") //Nombre del metodo que me pasa los parametros
	void testCumpleRangoIntIntIntCorrecto(List<Integer> value) { //Por parametros lo que me devuelve el metodo de parametros
		Integer[] params = value.stream() //Me interesa pasarlo a array basico...
				.toArray(Integer[]::new);
		assertTrue(Validator.cumpleRango(params[0], params[1], params[2])); //...Para poder elegir la posicion de cada uno
	}
	
	/*Metodo que comprueba con diferentes valores si uno de ellos NO encaja en un rango numerico*/
	@ParameterizedTest()
	@MethodSource("parametrosRangoIncorrectos")
	void testCumpleRangoIntIntIntIncorrecto(List<Integer> value) {
		Integer[] params = value.stream()
				.toArray(Integer[]::new);
		assertFalse(Validator.cumpleRango(params[0], params[1], params[2]));
	}
	
	/*Metodo que pasa los parametros a los parameterizedTest. Siempre es Stream<Arguments>
	 * siendo Arguments una interfaz*/
	static Stream<Arguments> parametrosRangoCorrectos() {
		return Stream.of(
		        Arguments.of(Arrays.asList( //Arguments.of solo admite Objects, he de pasar el array a una Coleccion
		        		PARAMETROS_RANGO_INT_CORRECT[0][0], 
		        		PARAMETROS_RANGO_INT_CORRECT[0][1], 
		        		PARAMETROS_RANGO_INT_CORRECT[0][2])),
		        Arguments.of(Arrays.asList(
		        		PARAMETROS_RANGO_INT_CORRECT[1][0], 
		        		PARAMETROS_RANGO_INT_CORRECT[1][1], 
		        		PARAMETROS_RANGO_INT_CORRECT[1][2])),
		        Arguments.of(Arrays.asList(
		        		PARAMETROS_RANGO_INT_CORRECT[2][0], 
		        		PARAMETROS_RANGO_INT_CORRECT[2][1], 
		        		PARAMETROS_RANGO_INT_CORRECT[2][2])));
	}
	
	/*Metodo que pasa los parametros a los parameterizedTest. Siempre es Stream<Arguments>
	 * siendo Arguments una interfaz*/
	static Stream<Arguments> parametrosRangoIncorrectos() {
		return Stream.of(
		        Arguments.of(Arrays.asList(
		        		PARAMETROS_RANGO_INT_INCORRECT[0][0], 
		        		PARAMETROS_RANGO_INT_INCORRECT[0][1], 
		        		PARAMETROS_RANGO_INT_INCORRECT[0][2])),
		        Arguments.of(Arrays.asList(
		        		PARAMETROS_RANGO_INT_INCORRECT[1][0], 
		        		PARAMETROS_RANGO_INT_INCORRECT[1][1], 
		        		PARAMETROS_RANGO_INT_INCORRECT[1][2])));
	}

	/*Metodo que comprueba con diferentes valores si uno de ellos NO encaja en un rango numerico*/
	@ParameterizedTest()
	@MethodSource("parametrosRangoDoubleCorrectos")
	void testCumpleRangoDoubleIntIntCorrecto(List<Double> value) {
		Double[] params = value.stream()
				.toArray(Double[]::new);
		assertTrue(Validator.cumpleRango(params[0], params[1].intValue(), params[2].intValue()));
	}
	
	/*Metodo que comprueba con diferentes valores si uno de ellos NO encaja en un rango numerico*/
	@ParameterizedTest()
	@MethodSource("parametrosRangoDoubleIncorrectos")
	void testCumpleRangoDoubleIntIntIncorrecto(List<Double> value) {
		Double[] params = value.stream()
				.toArray(Double[]::new);
		assertFalse(Validator.cumpleRango(params[0], params[1].intValue(), params[2].intValue()));
	}
	
	/*Metodo que pasa los parametros a los parameterizedTest. Siempre es Stream<Arguments>
	 * siendo Arguments una interfaz*/
	static Stream<Arguments> parametrosRangoDoubleCorrectos() {
		return Stream.of(
		        Arguments.of(Arrays.asList(
		        		PARAMETROS_RANGO_DOUBLE_CORRECT[0][0], 
		        		PARAMETROS_RANGO_DOUBLE_CORRECT[0][1], 
		        		PARAMETROS_RANGO_DOUBLE_CORRECT[0][2])),
		        Arguments.of(Arrays.asList(
		        		PARAMETROS_RANGO_DOUBLE_CORRECT[1][0], 
		        		PARAMETROS_RANGO_DOUBLE_CORRECT[1][1], 
		        		PARAMETROS_RANGO_DOUBLE_CORRECT[1][2])),
		        Arguments.of(Arrays.asList(
		        		PARAMETROS_RANGO_DOUBLE_CORRECT[2][0], 
		        		PARAMETROS_RANGO_DOUBLE_CORRECT[2][1], 
		        		PARAMETROS_RANGO_DOUBLE_CORRECT[2][2])));
	}
	
	/*Metodo que pasa los parametros a los parameterizedTest. Siempre es Stream<Arguments>
	 * siendo Arguments una interfaz*/
	static Stream<Arguments> parametrosRangoDoubleIncorrectos() {
		return Stream.of(
		        Arguments.of(Arrays.asList(
		        		PARAMETROS_RANGO_DOUBLE_INCORRECT[0][0], 
		        		PARAMETROS_RANGO_DOUBLE_INCORRECT[0][1], 
		        		PARAMETROS_RANGO_DOUBLE_INCORRECT[0][2])),
		        Arguments.of(Arrays.asList(
		        		PARAMETROS_RANGO_DOUBLE_INCORRECT[1][0], 
		        		PARAMETROS_RANGO_DOUBLE_INCORRECT[1][1], 
		        		PARAMETROS_RANGO_DOUBLE_INCORRECT[1][2])));
	}

	/* Metodo que comprueba inputs string y confirma si cumplen una longitud minima*/
	@RepeatedTest(value = 2, name = "Longitud minima correctas {currentRepetition}/{totalRepetitions}")
	void testCumpleLongitudMinCorrecto(RepetitionInfo repetitionInfo) {
		int i = LONGITUDES_MIN_CORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertTrue(Validator.cumpleLongitudMin(STRING_LONGMINMAX_CORRECT[1], i));
	}
	
	/* Metodo que comprueba inputs string y confirma si NO cumplen una longitud minima*/
	@Test
	void testCumpleLongitudMinIncorrecto() {
		assertFalse(Validator.cumpleLongitudMin(STRING_LONGMINMAX_CORRECT[1], LONGITUD_MIN_INCORRECT));
	}	
	
	/* Metodo que comprueba inputs string y confirma si cumplen una longitud maxima*/
	@RepeatedTest(value = 2, name = "Longitud maxima correctas {currentRepetition}/{totalRepetitions}")
	void testCumpleLongitudMaxCorrecto(RepetitionInfo repetitionInfo) {
		int i = LONGITUDES_MAX_CORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertTrue(Validator.cumpleLongitudMax(STRING_LONGMINMAX_CORRECT[1], i));
	}
	
	/* Metodo que comprueba inputs string y confirma si NO cumplen una longitud maxima*/
	@Test
	void testCumpleLongitudMaxIncorrecto() {
		assertFalse(Validator.cumpleLongitudMax(STRING_LONGMINMAX_CORRECT[1], LONGITUD_MAX_INCORRECT));
	}

	/* Metodo que comprueba inputs string y confirma si encaja en un rango de longitud*/
	@RepeatedTest(value = 3, name = "String rango longitud correcta {currentRepetition}/{totalRepetitions}")
	void testCumpleLongitudCorrecta(RepetitionInfo repetitionInfo) {
		String str = STRING_LONGMINMAX_CORRECT[repetitionInfo.getCurrentRepetition() - 1];
		
		assertTrue(Validator.cumpleLongitud(str, LONGITUD_MAX_INCORRECT, LONGITUD_MIN_INCORRECT));
		assertTrue(Validator.cumpleLongitud(str, LONGITUD_MAX_INCORRECT, LONGITUD_MIN_INCORRECT));
		assertTrue(Validator.cumpleLongitud(str, LONGITUD_MAX_INCORRECT, LONGITUD_MIN_INCORRECT));
	}
	
	/* Metodo que comprueba inputs string y confirma si NO encaja en un rango de longitud*/
	@RepeatedTest(value = 2, name = "String rango longitud incorrecta {currentRepetition}/{totalRepetitions}")
	void testCumpleLongitudIncorrecta(RepetitionInfo repetitionInfo) {
		String str = STRING_LONGMINMAX_INCORRECT[repetitionInfo.getCurrentRepetition() - 1];
		
		assertFalse(Validator.cumpleLongitud(str, LONGITUD_MAX_INCORRECT, LONGITUD_MIN_INCORRECT));
		assertFalse(Validator.cumpleLongitud(str, LONGITUD_MAX_INCORRECT, LONGITUD_MIN_INCORRECT));
	}

	/*Metodo que compara si una fecha es anterior a la fecha fija. Devuelve true si no es anterior*/
	@Test
	void testValDateMin() {
		assertTrue(Validator.valDateMin(FECHA_FIJA,FECHA_PASADA));
		assertTrue(Validator.valDateMin(FECHA_FIJA, FECHA_FIJA));
		assertFalse(Validator.valDateMin(FECHA_FIJA, FECHA_FUTURA));
	}

	/*Metodo que compara si una fecha es posterior a la fecha fija. Devuelve true si no es posterior*/
	@Test
	void testValDateMax() {
		assertTrue(Validator.valDateMax(FECHA_FIJA, FECHA_FUTURA));
		assertTrue(Validator.valDateMax(FECHA_FIJA, FECHA_FIJA));
		assertFalse(Validator.valDateMax(FECHA_FIJA, FECHA_PASADA));
	}

	/*Metodo que comprueba inputs string y confirma si NO es una fecha valida para parseo a LocalDate*/
	@RepeatedTest(value = 5, name = "Fechas validas erroneas {currentRepetition}/{totalRepetitions}")
	void testEsFechaValidaIncorrecto(RepetitionInfo repetitionInfo) {
		String fecha = FECHAS_INCORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertFalse(Validator.esFechaValida(fecha));
	}
	
	/*Metodo que comprueba inputs string y confirma si es una fecha valida para parseo a LocalDate*/
	@Test
	void testEsFechaValidaCorrecto() {
		assertTrue(Validator.esFechaValida(FECHA_CORRECT));
	}

	/*Metodo que comprueba inputs string y confirma si encaja en el patron de password*/
	@RepeatedTest(value = 2, name = "Passwords correctas {currentRepetition}/{totalRepetitions}")
	void testEsPasswordValidaCorrecto(RepetitionInfo repetitionInfo) {
		String str = PASS_CORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertTrue(Validator.esPasswordValida(str));
	}
	
	/*Metodo que comprueba inputs string y confirma si NO encaja en el patron de password*/
	@RepeatedTest(value = 5, name = "Passwords incorrectas {currentRepetition}/{totalRepetitions}")
	void testEsPasswordValidaIncorrecto(RepetitionInfo repetitionInfo) {
		String str = PASS_INCORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertFalse(Validator.esPasswordValida(str));
	}

	/*Metodo que comprueba inputs string y confirma si son nulos o no*/
	@Test
	void testComprobarNuloString() {
		assertTrue(Validator.comprobarNulo(VACIO_CORRECT[0]));
		assertTrue(Validator.comprobarNulo(VACIO_INCORRECT[2]));
		assertFalse(Validator.comprobarNulo(VACIO_CORRECT[1]));
	}

	/*Metodo que comprueba inputs LocalDate y confirma si son nulos o no*/
	@Test
	void testComprobarNuloLocalDate() {
		assertTrue(Validator.comprobarNulo(FECHA_FIJA));
		assertFalse(Validator.comprobarNulo(FECHA_NULA));
	}
	
	/*Metodo que comprueba inputs string y confirma si encaja en patron de producto*/
	@RepeatedTest(value = 2, name = "Productos correctos {currentRepetition}/{totalRepetitions}")
	void testEsProductoValidoCorrecto(RepetitionInfo repetitionInfo) {
		String str = PRODUCTO_CORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertTrue(Validator.esProductoValido(str));
	}
	
	/*Metodo que comprueba inputs string y confirma si NO encaja en patron de producto*/
	@RepeatedTest(value = 6, name = "Productos incorrectos {currentRepetition}/{totalRepetitions}")
	void testEsProductoValidoIncorrecto(RepetitionInfo repetitionInfo) {
		String str = PRODUCTO_INCORRECT[repetitionInfo.getCurrentRepetition() - 1];
		assertFalse(Validator.esProductoValido(str));
	}

}
