package skype.project.client.mongo.client.service;

import skype.project.client.mongo.client.dto.propertyRemoteDto.PropertyCreateDto;
import skype.project.client.mongo.client.dto.propertyRemoteDto.PropertyFullDto;
import skype.project.client.mongo.client.dto.propertyRemoteDto.PropertyPreviewDto;

import java.util.List;

public interface PropertyServiceClient {

    List<PropertyPreviewDto> readAllProperty();

    List<PropertyPreviewDto> readAllPropertyFilter(PropertyPreviewDto filterDto);

    PropertyFullDto readPropertyById(String id);

    void deletePropertyById(String id);

    PropertyFullDto createProperty(PropertyCreateDto createDto);

    void updateProperty(PropertyFullDto fullDto);
}
