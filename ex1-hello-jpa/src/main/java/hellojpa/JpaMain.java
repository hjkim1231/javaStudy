package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
       EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try {

            //등록
            //Member member = new Member();
            //member.setId(2L);
            //member.setName("helloB");
            //em.persist(member);


           //Member findMember =  em.find(Member.class, primaryKey: 1L);
            //Member findMember = em.find(Member.class, 1L);

            //조회
            //System.out.println("findMember.Id = " + findMember.getId());
            //System.out.println("findMember.Name = " + findMember.getName());

            //수정
            //findMember.setName("helloJPA");

            //삭제
            //em.remove(findMember);

           List<Member> results =  em.createQuery("select m from Member as m ", Member.class)
                   .setFirstResult(0)
                   .setMaxResults(1)
                   .getResultList();

            for(Member member:results)
            {
                System.out.println("member.name = " + member.getName());
            }





            tx.commit();
        }catch (Exception e)
        {
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();


    }
}
