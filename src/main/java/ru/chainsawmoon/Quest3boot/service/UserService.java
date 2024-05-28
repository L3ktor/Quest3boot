package ru.chainsawmoon.Quest3boot.service;


import ru.chainsawmoon.Quest3boot.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUserById(Long id);

    void editUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

}
