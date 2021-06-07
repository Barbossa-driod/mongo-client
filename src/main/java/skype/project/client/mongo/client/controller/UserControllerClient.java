package skype.project.client.mongo.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import skype.project.client.mongo.client.dto.userRemoteDto.UserCreateDto;
import skype.project.client.mongo.client.dto.userRemoteDto.UserFullDto;
import skype.project.client.mongo.client.dto.userRemoteDto.UserPreviewDto;
import skype.project.client.mongo.client.service.UserServiceClient;

import java.util.List;

@Controller
public class UserControllerClient {

    @Autowired
    UserServiceClient userServiceClient;

    @GetMapping("/user")
    public String findAll(Model model){
        List<UserPreviewDto> users = userServiceClient.readAllUser();
        model.addAttribute("users", users);

        return "user-index";
    }

    @GetMapping("/user/single/{id}")
    public String getSingle(@PathVariable String id, Model model){
        UserFullDto foundUser = userServiceClient.readUserById(id);
        System.out.println(foundUser);
        model.addAttribute("user", foundUser);

        return "single-user";
    }

    @GetMapping("/user/delete/{id}")
    public String delete (@PathVariable String id){
        userServiceClient.deleteUserById(id);

        return "redirect:/user";
    }

    @GetMapping("/user/change/{id}")
    public String openChangingPage(@PathVariable String id, Model model){
        UserFullDto user = userServiceClient.readUserById(id);
        model.addAttribute("user", user);

        return "change-user";
    }

    @PostMapping("/user/change")
    public String change(UserFullDto user){
        userServiceClient.updateUser(user);

        return "redirect:/user";
    }

    @GetMapping("/user/create")
    public String openCreationPage(UserCreateDto user, Model model){
        model.addAttribute("user", user);
        return "create-user";
    }

    @PostMapping("/user/create")
    public String create(UserCreateDto user){
        UserFullDto createdUser = userServiceClient.createUser(user);
        return "redirect:/user";
    }
}
