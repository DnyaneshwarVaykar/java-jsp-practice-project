package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.entity.Movie;
import com.utility.HibernateUtility;

public class MovieDaoImpl implements MovieDao{



	@Override
	public void addMovie(Movie movie) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(movie);
			tx.commit();

		} catch (Exception e) {
			System.out.println("MovieDaoImpl.AddBook "+e);
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public void updateMovie(Movie movie) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(movie);
			tx.commit();

		} catch (Exception e) {
			System.out.println("MovieDaoImpl.UpdateMovie "+e);
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public void deleteMovie(Movie movie) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(movie);
			tx.commit();

		} catch (Exception e) {
			System.out.println("MovieDaoImpl.deleteMovie "+e);
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public void deleteMovieById(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(id);
			tx.commit();

		} catch (Exception e) {
			System.out.println("MovieDaoImpl.AddBook "+e);
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public Movie getMovieById(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Movie movie = null;
		try {
			// student = (Student) session.get(Student.class, id);
			movie = (Movie) session.get(Movie.class, id);
			
			return movie;
		} catch (Exception e) {
			System.out.println("StudentDaoImpl.getStudentById "+e);
			throw e;
		} finally {
			session.close();
		}
	}
	@Override
	public List<Movie> getAllMovie() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		String hql = "from Movie s";
		Query<Movie> query = session.createQuery(hql);
		return query.list();
	}

}
