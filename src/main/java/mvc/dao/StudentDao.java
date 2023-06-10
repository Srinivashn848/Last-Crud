package mvc.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import mvc.dto.Student;
@Repository
public class StudentDao {
@Autowired
EntityManager manager;


public void save(Student student) {
	{
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(student);
		transaction.commit();
	}
}

public List<Student>fetchAll() {
	return manager.createQuery("select x from Student x").getResultList();
	
}

public List<Student> fetchByName(String name) {
	return manager.createQuery("select x from Student x where name=?1").setParameter(1,name).getResultList();
	
}
public void delete(int id)
{
	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	manager.remove(manager.find(Student.class, id));
	transaction.commit();
}

public Student fetchById(int id) {

	return manager.find(Student.class, id);
}

}
