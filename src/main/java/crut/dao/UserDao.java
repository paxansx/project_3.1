package crut.dao;

import crut.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(long id);
    public User getUserById(long id);
    public List<User> getAllUser();

}
