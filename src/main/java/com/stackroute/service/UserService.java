package com.stackroute.service;

import com.stackroute.domain.Track;

import java.util.List;

public interface UserService {
    public Track saveUser(Track user);

    public List<Track> getAllUsers();

    public Track getUserByID(int id);

    public Track updateUser(int id, String comment);

    public String deleteAllUsers();

    public String deleteById(int id);
}
