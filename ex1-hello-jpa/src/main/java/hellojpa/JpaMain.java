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

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("Member1");
           // member.setTeam(team);
          //  member.changeTeam(team);
            em.persist(member);

            team.addMember(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());



            List<Member> members =  findMember.getTeam().getMembers();

            for(Member m : members){
                System.out.println("m = " + m.getUsername());
            }

            //Team findTeam = findMember.getTeam();
            //System.out.println("findTeam = " + findTeam.getName());

            ;

            //등록
           // Member member = new Member();
            //member.setId("ID_A");
            //member.setName("C");
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
            /*
           List<Member> results =  em.createQuery("select m from Member as m ", Member.class)
                   .setFirstResult(0)
                   .setMaxResults(1)
                   .getResultList();

            for(Member member:results)
            {
                System.out.println("member.name = " + member.getName());
            }

             */





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
