package application;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Program1 {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ganesh");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void save(Student std) {
		et.begin();
		em.persist(std);
		et.commit();
	}
   
	public void fetch(int id) {
		Student s = em.find(Student.class, id);
		System.out.println(s.getId() + " " + s.getName() + " " + s.getEmail());

	}

	public void update(Student std) {
//		Student s = em.find(Student.class); 
		et.begin();
		em.merge(std);
		et.commit();
	}

	public void delete(int id) {
		Student s = em.find(Student.class, id);
		et.begin();
		em.remove(s);
		et.commit();
	}

	public static void main(String[] args) {
//		new Program1().update(new Student(1,"nithin","ganeshnagam8566@gmail.com"));
		new Program1().update(new Student(2, "nithin", "ganeshnagam8566@gmail.com"));
// 		new Program1().fetch(1);
		new Program1().delete(1);

	}

}
