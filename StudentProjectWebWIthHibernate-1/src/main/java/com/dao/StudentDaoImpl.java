package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Student;
import com.utility.HibernateUtility;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void addStudent(Student student) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();

		} catch (Exception e) {
			System.out.println("StudentDaoImpl.AddStudent "+e);
			if (tx != null)
				tx.rollback();
			throw e;
			

		} finally {
			session.close();
		}

	}

	@Override
	public void updateStudent(Student student) {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(student);
			tx.commit();

		} catch (Exception e) {
			System.out.println("StudentDaoImpl.updateStudent "+e);
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public void deleteStudent(Student student) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(student);
			tx.commit();
		} catch (Exception e) {
			System.out.println("StudentDaoImpl.deleteStudent "+e);
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public void deleteStudentById(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Student student = new Student();
		student.setId(id);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(student);
			tx.commit();
		} catch (Exception e) {
			System.out.println("StudentDaoImpl.deleteStudentById "+e);
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public Student getStudentById(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Student student = null;
		try {
			// student = (Student) session.get(Student.class, id);
			student = (Student) session.load(Student.class, id);
			student.getName();
			return student;
		} catch (Exception e) {
			System.out.println("StudentDaoImpl.getStudentById "+e);
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Student> getAllStudent() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		String hql = "from Student s";
		Query<Student> query = session.createQuery(hql);
		return query.list();
	}

}