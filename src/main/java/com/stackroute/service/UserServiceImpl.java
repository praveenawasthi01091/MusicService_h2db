package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Track saveUser(Track user) {
        Track savedUser= userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<Track> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Track getUserByID(int id)
    {
       return (userRepository.findById(id).get());
    }

    @Override
    public Track updateUser(int id, String comment)
    {
        Track updatedUser=getUserByID(id);
        updatedUser.setComments(comment);
        return updatedUser;
    }

    @Override
    public String deleteAllUsers()
    {

            userRepository.deleteAll();
            return "successfully deleted";

    }

    @Override
    public String deleteById(int id)
    {

            userRepository.delete(userRepository.findById(id).get());
            return "successfully deleted";

    }
}