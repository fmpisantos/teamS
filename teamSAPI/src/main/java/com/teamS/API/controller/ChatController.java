package com.teamS.API.controller;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.teamS.API.DTO.*;
import com.teamS.API.DAO.Chats.Chat;
import com.teamS.API.DAO.Security.User.Devices;
import com.teamS.API.repository.IChatRepository;
import com.teamS.API.repository.IDeviceRepository;
import com.teamS.API.repository.IUserLoginRepository;
import com.teamS.API.services.FirebaseMessagingService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@SecurityRequirement(name = "Bearer")
public class ChatController {
    private final FirebaseMessagingService firebaseMessagingService;
    private final IDeviceRepository deviceRepo;
    private final IUserLoginRepository userRepo;
    private final IChatRepository chatRepo;

    public ChatController(FirebaseMessagingService firebaseMessagingService, IDeviceRepository deviceRepo, IUserLoginRepository userRepo, IChatRepository chatRepo) {
        this.firebaseMessagingService = firebaseMessagingService;
        this.deviceRepo = deviceRepo;
        this.userRepo = userRepo;
        this.chatRepo = chatRepo;
    }

    @Description("Simple string response to check if server is running")
    @ApiResponses(value = {
            @ApiResponse(description = "Hello world", responseCode = "200"),
    })
    @RequestMapping(method = RequestMethod.GET, value = "/", name="Hello world")
    public ResponseEntity<String> Controller(Authentication authentication){
        return ResponseEntity.ok("Hello " + authentication.getName());
    }

    @Description("Send a notification to a specific token/device")
    @ApiResponses(value = {
            @ApiResponse(description = "Information regarding the delivery of the notification", responseCode = "200"),
    })
    @RequestMapping(method = RequestMethod.GET,value = "/notification")
    @ResponseBody
    public ResponseEntity<String> sendNotification(Authentication authentication, @RequestBody Note note,
                                   @RequestParam String id) throws FirebaseMessagingException {
        try{
            Devices device = deviceRepo.findByUserId(Long.parseLong(id));
            if(device == null)
                return ResponseEntity.badRequest().body("User has no device registered");
            firebaseMessagingService.sendNotification(note, device.getToken());
            return ResponseEntity.ok("Notification sent to " + id);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Notification not sent to " + id);
        }
    }

    @Description("List of users that are connected to a certain user")
    @ApiResponses(value = {
            @ApiResponse(description = "Information regarding the delivery of the notification", responseCode = "200"),
    })
    @RequestMapping(method = RequestMethod.GET,value = "/users")
    public ResponseEntity<List<ChatDTO>> sendNotification(Authentication authentication) throws FirebaseMessagingException {
        try {
            long userId = userRepo.findByUsername(authentication.getName()).getId();
            List<Chat> chats = chatRepo.findInChatByUserId1OrUserId2AndActive(userId, true);
            List<ChatDTO> chatDTOs = new ArrayList<>();
            for (Chat chat : chats)
                chatDTOs.add(chat.getUserId2() == userId ? new ChatDTO(chat.getUserId1()) : new ChatDTO(chat.getUserId2()));
            return ResponseEntity.ok(chatDTOs);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Description("Update the token of a user/device")
    @RequestMapping(method = RequestMethod.POST, value = "/token")
    public ResponseEntity updateToken(Authentication authentication, @RequestParam String token) {
        try
        {
            long id = userRepo.findByUsername(authentication.getName()).getId();
            Devices device = deviceRepo.findByUserId(id);
            if ( device != null )
                device.setToken(token);
            else
                device = new Devices(token, id);
            deviceRepo.save(device);
            return ResponseEntity.ok("Token updated");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Token not updated");
        }
    }

    @Description("Create a new chat")
    @RequestMapping(method = RequestMethod.POST, value = "/chat")
    public ResponseEntity createChat(Authentication authentication, @RequestParam long id) {
        try
        {
            long userId = userRepo.findByUsername(authentication.getName()).getId();
            if(userRepo.findById(Integer.parseInt(""+id)).isEmpty())
                return ResponseEntity.badRequest().body("User does not exist");
            Chat chat = new Chat(userId, id);
            chatRepo.save(chat);
            return ResponseEntity.ok("Chat created");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Chat not created");
        }
    }
}
