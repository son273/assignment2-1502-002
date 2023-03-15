package mru.store.testmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mru.store.model.Figures;

class FiguresTest {

	@Test
	public void testConstructorAndGetters() {
		Figures figure = new Figures(1234567899, "GenericName", "GenericBrand", 19.99f, 10, 3, "Action");

		assertEquals(1234567899, figure.getSerialNumber());
		assertEquals("GenericName", figure.getName());
		assertEquals("GenericBrand", figure.getBrand());
		assertEquals(19.99f, figure.getPrice(), 0.01f);
		assertEquals(10, figure.getAvalibleCount());
		assertEquals(3, figure.getAgeAppropriate());
		assertEquals("Action", figure.getClassification());
	}

	@Test
	public void testSetters() {
		Figures figure = new Figures(0, null, null, 0, 0, 0, null);

		figure.setSerialNumber(987654321);
		assertEquals(987654321, figure.getSerialNumber());

		figure.setName("CoolName");
		assertEquals("CoolName", figure.getName());

		figure.setBrand("BlahBlah");
		assertEquals("BlahBlah", figure.getBrand());

		figure.setPrice(24.99f);
		assertEquals(24.99f, figure.getPrice(), 0.01f);

		figure.setAvalibleCount(5);
		assertEquals(5, figure.getAvalibleCount());

		figure.setAgeAppropriate(4);
		assertEquals(4, figure.getAgeAppropriate());

		figure.setClassification("Doll");
		assertEquals("Doll", figure.getClassification());
	}

	@Test
	public void testFormat() {
		Figures figure = new Figures(1234567899, "GenericName", "GenericBrand", 19.99f, 10, 3, "Action");

		String expected = "01234567899;GenericName;GenericBrand;19.99;10;3;Action";
		assertEquals(expected, figure.format());
	}

	@Test
	public void testToString() {
		Figures figure = new Figures(1234567899, "GenericName", "GenericBrand", 19.99f, 10, 3, "Action");

		String expected = "Category: Figures, Serial Number: 01234567899, Name: GenericName, Brand: GenericBrand, Price: 19.99, Availible Stock: 10, Minimum Age: 3, Classification: Action";
		assertEquals(expected, figure.toString());
	}
}