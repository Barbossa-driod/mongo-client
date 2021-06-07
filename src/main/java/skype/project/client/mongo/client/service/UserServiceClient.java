package skype.project.client.mongo.client.service;

import skype.project.client.mongo.client.dto.userRemoteDto.UserCreateDto;
import skype.project.client.mongo.client.dto.userRemoteDto.UserFullDto;
import skype.project.client.mongo.client.dto.userRemoteDto.UserPreviewDto;

import java.util.List;

public interface UserServiceClient {

    List<UserPreviewDto> readAllUser();

    UserFullDto readUserById(String id);

    void deleteUserById(String id);

    UserFullDto createUser(UserCreateDto createDto);

    void updateUser(UserFullDto fullDto);
}
