package com.local.Controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.local.Model.Users;
import com.local.Repository.UserRepository;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/add")
    @ApiOperation("to add users")
    public Users   addUsers(@RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String role,
                           @RequestParam boolean activated) {
        Users users = new Users(email, password, role, activated);
        users.setEmail(email);
        String decodedpwd=password;
        users.setPassword(passwordEncoder().encode(password));
        users.setRole(role.toUpperCase(Locale.ROOT));
        users.setActivated(activated);
        System.out.println(decodedpwd);
        return this.userRepository.save(users);
    }
    
    @PutMapping("/update")
    public Users   enableUser(@RequestParam String email){
      List<Users> users= this.userRepository.findByEmail(email);
      if(users.size()>0){
          Users user=users.get(0);
          user.setActivated(true);
         this.userRepository.save(user);
      }
      return (Users) users;
    }
    
    @PutMapping("/updatePassword")
    @ApiOperation("to update user password")
    public Users  updatePassword(@RequestParam String email, @RequestParam String password, @RequestParam String newPassword) {
        List<Users> users = this.userRepository.findByEmail(email);
        if (users.size() <= 0) {
            System.out.println("User doesnt exist/check email and password");
        } else {
            Users user = users.get(0);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (email.equals(user.getEmail()) && encoder.matches(password, user.getPassword())) {
                user.setPassword(encoder.encode(newPassword));
                this.userRepository.save(user);
            }
        }
        return (Users) users;
    }    
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}