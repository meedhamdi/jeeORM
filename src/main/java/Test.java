import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("template-persistence-unit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		boolean transactionOK = false;
		try {
			Emp emp = new Emp();
			emp.setName("Med");
			emp.setJob("Data engineer");
			// insert emp to database
			em.persist(emp);
			// remove emp from database
			//em.remove(emp);
			transactionOK = true;
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			
			if (transactionOK) {
				em.getTransaction().commit();
			} else {
				em.getTransaction().rollback();
			}
			
			em.close();
		}
	}
}
