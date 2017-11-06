package com.fjd.fchat.api.v1.service;

import com.fjd.fchat.bo.User;
import com.fjd.fchat.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value={"/Users"})
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    String create (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        userRepository.save(user);
        return "Saved";
    }


    @RequestMapping ( method= RequestMethod.GET)
    public @ResponseBody
    List<User> list() {
        // This returns a JSON or XML with the users
        return (List<User>)userRepository.findAll();
    }
}