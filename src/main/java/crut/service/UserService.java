package crut.service;

import crut.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(long id);
    public User getUserById(long id);
    public List<User> getAllUser();
}
