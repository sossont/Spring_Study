package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction ts = em.getTransaction();
        ts.begin();

        try {

            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getName() = " + findMember.getName());
            findMember.setName("MemberA");
            System.out.println("findMember.getName() = " + findMember.getName());

            ts.commit();
        } catch (Exception e) {
            ts.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
