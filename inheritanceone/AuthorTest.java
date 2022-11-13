package inheritanceone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateannotations.Student;

public class AuthorTest {

	public static void main(String[] args) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Author.class);
		config.addAnnotatedClass(Book.class);
		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		Author author = new Author();
		Book book = new Book();
		
		book.setBook_name("How To Enjoy LIfe");
		book.setPublication_year(2022);
	
		author.setAuthor_name("Nagesh Kanade");
		book.setAuthor(author);
		author.setBook(book);
		session.persist(author);
		System.out.println(author.toString());
		
		
		session.getTransaction().commit();
		sessionfactory.close();
		session.close();
		 
	}

}
