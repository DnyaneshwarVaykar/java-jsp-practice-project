package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Book;

import com.utility.HibernateUtility;

public class BookDaoImpl implements BookDao{

	@Override
	public void addBook(Book book) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(book);
			tx.commit();

		} catch (Exception e) {
			System.out.println("BookDaoImpl.AddBook "+e);
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateBook(Book book) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(book);
			tx.commit();

		} catch (Exception e) {
			System.out.println("BookDaoImpl.updateBook "+e);
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public void deleteBook(Book book) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(book);
			tx.commit();

		} catch (Exception e) {
			System.out.println("BookDaoImpl.AddBook "+e);
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteBookById(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(id);
			tx.commit();

		} catch (Exception e) {
			System.out.println("BookDaoImpl.AddBook "+e);
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public Book getBookById(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Book book = null;
		try {
			// student = (Student) session.get(Student.class, id);
			book = (Book) session.get(Book.class, id);
			
			return book;
		} catch (Exception e) {
			System.out.println("StudentDaoImpl.getStudentById "+e);
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Book> getAllBooks() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		String hql = "from Book s";
		Query<Book> query = session.createQuery(hql);
		return query.list();
	}

}
