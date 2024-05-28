package ru.chainsawmoon.Quest3boot.repository.imp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.chainsawmoon.Quest3boot.model.User;
import ru.chainsawmoon.Quest3boot.repository.UserRepository;

import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {
    @PersistenceContext
    private EntityManager eM;

    @Override
    public void addUser(User user) {
        eM.persist(user);
    }

    @Override
    public void deleteUserById(Long id) {
        eM
                .createQuery("delete from User u where u.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void editUser(User user) {
        eM.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        return eM.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return eM.createQuery("from User").getResultList();
    }
}
