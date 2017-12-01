package pkgEmpty;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.BookException;
import pkgLibrary.Catalog;

public class BookTest {

	@Test
	public void TestCatalog()
	{
		Catalog cat = Catalog.ReadXMLFile();
		System.out.println(cat.getId());
		System.out.println(cat.getBooks().size());
		Book b = new Book();
		b.setAuthor("Raquel J. Palacio");
		b.setTitle("Wonder");
		b.setGenre("Novel");
		b.setDescription("the incident could teach society a valuable lesson");
		b.setId("bk113");
	
		String inputString = "02-14-2012";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate = null;
		try {
			inputDate = dateFormat.parse(inputString);
		} catch (ParseException e) {
			fail("Exception raised");
		}
		b.setPublish_date(inputDate);
		b.setPrice(19.99);
		
		try {
			Book.addBook(cat, b);
		} catch (BookException e) {
			fail("Exception raised");
		}
		
		System.out.println(cat.getBooks().size());
		
		Book bookGet=null;
		try {
			 bookGet = Book.getBook(cat, b.getId());
		} catch (BookException e) {
			fail("Exception raised");
		}
		assertEquals(b.getId(), bookGet.getId());
	}

}
