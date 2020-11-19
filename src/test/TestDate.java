package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Date;

class TestDate {
	
	Date d;
	
	@Test
	void testvaliditeDate() {
		
		d = new Date(-10, 2, 2000);
		assertThrows(ArithmeticException.class, () -> d.validiteDate(), "Jour doit etre entre 1 et 31.");
	
		d = new Date(33, 12, 2001);
		assertThrows(ArithmeticException.class, () -> d.validiteDate(), "Jour doit etre entre 1 et 31.");
	
		d = new Date(2, 0, 1999);
		assertThrows(ArithmeticException.class, () -> d.validiteDate(), "Mois doit etre entre 1 et 12.");
	
		d = new Date(3, 14, 1997);
		assertThrows(ArithmeticException.class, () -> d.validiteDate(), "Mois doit etre entre 1 et 12.");

		d = new Date(1, 1, 100);
		assertThrows(ArithmeticException.class, () -> d.validiteDate(), "Annee doit etre entre 1000 et 3000.");

		d = new Date(1, 1, 4000);
		assertThrows(ArithmeticException.class, () -> d.validiteDate(), "Annee doit etre entre 1000 et 3000.");
		
		d = new Date(29,2,2018);
		assertThrows(ArithmeticException.class, () -> d.validiteDate(), "Fevrier n'a que 28 jours.");
		
		d = new Date(30,2,2020);
		assertThrows(ArithmeticException.class, () -> d.validiteDate(), "Annee Bissextile Fevrier n'a que 29 jours.");
		
		d = new Date(31,11,2020);
		assertThrows(ArithmeticException.class, () -> d.validiteDate(), "ce mois n'a que 30 jours.");
	}
	
	@Test
	void testlendemain() throws Exception {
		d = new Date(14, 7, 2008);
		assertEquals("15/7/2008", d.lendemain().getDate());
		
		d = new Date(31, 7, 2008);
		assertEquals("1/8/2008", d.lendemain().getDate());
		
		d = new Date(29, 12, 1997);
		assertEquals("30/12/1997", d.lendemain().getDate());
		
		d = new Date(30, 4, 2000);
		assertEquals("1/5/2000", d.lendemain().getDate());
		
		d = new Date(31, 12, 1999);
		assertEquals("1/1/2000", d.lendemain().getDate());
		
		d = new Date(30, 12, 1999);
		assertEquals("31/12/1999", d.lendemain().getDate());
		
		d = new Date(28, 2, 2019);
		assertEquals("1/3/2019", d.lendemain().getDate());
		
		d = new Date(28, 2, 2000);
		assertEquals("29/2/2000", d.lendemain().getDate());
		
		d = new Date(29, 2, 2020);
		assertEquals("1/3/2020", d.lendemain().getDate());
		
		d = new Date(30, 6, 2020);
		assertEquals("1/7/2020", d.lendemain().getDate());
	}
	
	@Test
	void testanneeBisextile() {
		
		d = new Date(1, 1, 2000);
		assertEquals(true, d.anneeBisextile());
		
		d = new Date(1, 1, 2020);
		assertEquals(true, d.anneeBisextile());
		
		d = new Date(1, 1, 2019);
		assertEquals(false, d.anneeBisextile());
		
	}

}
