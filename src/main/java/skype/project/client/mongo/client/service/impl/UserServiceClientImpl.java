package skype.project.client.mongo.client.service.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import skype.project.client.mongo.client.dto.userRemoteDto.UserCreateDto;
import skype.project.client.mongo.client.dto.userRemoteDto.UserFullDto;
import skype.project.client.mongo.client.dto.userRemoteDto.UserPreviewDto;
import skype.project.client.mongo.client.service.UserServiceClient;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceClientImpl implements UserServiceClient {

    @Override
    public List<UserPreviewDto> readAllUser() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserPreviewDto[]> response = restTemplate.getForEntity("http://localhost:8090/user", UserPreviewDto[].class);

        UserPreviewDto[] foundAllUser = response.getBody();
        List<UserPreviewDto> allUser = Arrays.asList(foundAllUser);

        HttpStatus statusCode = response.getStatusCode();
        Integer statusCodeValue = response.getStatusCodeValue();
        HttpHeaders headers = response.getHeaders();

        System.out.println("allProperty " + allUser);
        System.out.println("STATUS " +statusCode);
        System.out.println("STATUS CODE VALUE " +statusCodeValue);
        System.out.println("HEADERS " + headers);

        return allUser;
    }

    @Override
    public UserFullDto readUserById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserFullDto> response = restTemplate.getForEntity("http://localhost:8090/user/{id}", UserFullDto.class, id);

        UserFullDto foundUser = response.getBody();

        HttpStatus statusCode = response.getStatusCode();
        Integer statusCodeValue = response.getStatusCodeValue();
        HttpHeaders headers = response.getHeaders();

        System.out.println("foundUser " + foundUser);
        System.out.println("STATUS " +statusCode);
        System.out.println("STATUS CODE VALUE " +statusCodeValue);
        System.out.println("HEADERS " + headers);

        return foundUser;
    }

    @Override
    public void deleteUserById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8090/user/{id}", id);
    }

    @Override
    public UserFullDto createUser(UserCreateDto createDto) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserFullDto> response = restTemplate.postForEntity("http://localhost:8090/user/create", createDto, UserFullDto.class);

        HttpStatus statusCode = response.getStatusCode();
        UserFullDto savedUser = response.getBody();

        System.out.println("STATUS " +statusCode);
        System.out.println("BODY " +savedUser);

        return savedUser;
    }

    @Override
    public void updateUser(UserFullDto fullDto) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8090/user/update", fullDto);
    }
}
