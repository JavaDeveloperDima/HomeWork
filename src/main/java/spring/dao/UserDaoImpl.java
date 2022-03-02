package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Override
    public List<User> getAllUser() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> list = entityManager.createNativeQuery("select * from users ",User.class).getResultList();
        entityManager.getTransaction().commit();
        return list;
    }

    @Override
    public void saveUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public User getUserFromId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class,id);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public void deleteUserFromId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }
}
