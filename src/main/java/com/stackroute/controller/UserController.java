package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /* create new resource -- post*/
    @PostMapping("/track")
    public ResponseEntity<?> saveUser(@RequestBody Track user){
        ResponseEntity responseEntity;
        try
        {
            userService.saveUser(user);
            responseEntity=new ResponseEntity<String>("successfully created", HttpStatus.CREATED);

        }
        catch (Exception e)
        {
            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    /*  Show that resource */

    @GetMapping("/track")
    public ResponseEntity<?> getAllUsers(){
        try {
            return new ResponseEntity<List<Track>>(userService.getAllUsers(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/track/{id}")
    public ResponseEntity<?> getUserById( @PathVariable int id) {

       try {
           return new ResponseEntity<Track>(userService.getUserByID(id), HttpStatus.OK);
       }
       catch (Exception e)
       {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
       }
    }

    /* update given  response */

    @PutMapping("/track/{id}/{comment}")
    public  ResponseEntity<?> updateUser(@PathVariable int id, @PathVariable String comment)
    {
        ResponseEntity responseEntity;
        try {
            return new ResponseEntity<Track>(userService.updateUser(id, comment), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }

    }
    /* Delete given  resource  */

    @DeleteMapping("/track")
    public ResponseEntity<?> deleteUser()
    {
        try {
            userService.deleteAllUsers();
            ResponseEntity responseEntity;
            responseEntity = new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
            return responseEntity;
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("/track/{id}")
    public String  deleteTrack(@PathVariable int id) {
        try {
            userService.deleteById(id);
            return "Successfully deleted";
        }
        catch (Exception e)
        {
             return e.getMessage();
        }
    }

}
