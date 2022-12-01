package com.teamS.API.controller;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.teamS.API.data.*;
import com.teamS.API.models.User.Users;
import com.teamS.API.repository.IDeviceRepository;
import com.teamS.API.repository.IUsersRepository;
import com.teamS.API.services.FirebaseMessagingService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private final FirebaseMessagingService firebaseMessagingService;
    private final IUsersRepository userRepo;
    private final IDeviceRepository deviceRepo;

    public Controller(FirebaseMessagingService firebaseMessagingService, IUsersRepository userRepo, IDeviceRepository deviceRepo) {
        this.firebaseMessagingService = firebaseMessagingService;
        this.userRepo = userRepo;
        this.deviceRepo = deviceRepo;
    }

    @Description("Simple string response to check if server is running")
    @ApiResponses(value = {
            @ApiResponse(description = "Hello world", responseCode = "200"),
    })
    @RequestMapping(method = RequestMethod.GET, value = "/", name="Hello world")
    public ResponseEntity<String> Controller(){
        return ResponseEntity.ok("Hello world");
    }

    @Description("Send a notification to a specific token/device")
    @ApiResponses(value = {
            @ApiResponse(description = "Information regarding the delivery of the notification", responseCode = "200"),
    })
    @RequestMapping(method = RequestMethod.GET,value = "/notification")
    @ResponseBody
    public String sendNotification(@RequestBody Note note,
                                   @RequestParam String id) throws FirebaseMessagingException {
        // translate internal id to firebase token
        String token = id;
        return firebaseMessagingService.sendNotification(note, token);
    }

    @Description("List of users that are connected to a certain user")
    @ApiResponses(value = {
            @ApiResponse(description = "Information regarding the delivery of the notification", responseCode = "200"),
    })
    @RequestMapping(method = RequestMethod.GET,value = "/users")
    public String sendNotification() {
        // return list users that the logged-in user can send notifications to
        return "";
    }

    @Description("Update the token of a user/device")
    @ApiResponses(value = {
            @ApiResponse(description = "Information regarding the delivery of the notification", responseCode = "200"),
    })
    @RequestMapping(method = RequestMethod.POST, value = "/token")
    public void updateToken(@RequestParam String token) {
        // save token to database
    }

    @Description("Create user in database")
    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void createUser(@RequestBody User user) {
        // parse user data to user model
        Users dtoUser = new Users(user.getName(), user.getEmail());
        // save user to database
        userRepo.save(dtoUser);
    }
}
