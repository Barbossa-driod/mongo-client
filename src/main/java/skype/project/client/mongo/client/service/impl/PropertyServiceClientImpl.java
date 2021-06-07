package skype.project.client.mongo.client.service.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import skype.project.client.mongo.client.dto.propertyRemoteDto.PropertyCreateDto;
import skype.project.client.mongo.client.dto.propertyRemoteDto.PropertyFullDto;
import skype.project.client.mongo.client.dto.propertyRemoteDto.PropertyPreviewDto;
import skype.project.client.mongo.client.service.PropertyServiceClient;

import java.util.Arrays;
import java.util.List;


@Component
public class PropertyServiceClientImpl implements PropertyServiceClient {

    @Override
    public List<PropertyPreviewDto> readAllProperty(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PropertyPreviewDto[]> response = restTemplate.getForEntity("http://localhost:8090/property", PropertyPreviewDto[].class);

        PropertyPreviewDto[] foundAllProperty = response.getBody();
        List<PropertyPreviewDto> allProperty = Arrays.asList(foundAllProperty);

        HttpStatus statusCode = response.getStatusCode();
        Integer statusCodeValue = response.getStatusCodeValue();
        HttpHeaders headers = response.getHeaders();

        System.out.println("allProperty" + allProperty);
        System.out.println("STATUS " +statusCode);
        System.out.println("STATUS CODE VALUE " +statusCodeValue);
        System.out.println("HEADERS " + headers);

        return allProperty;
    }

    @Override
    public List<PropertyPreviewDto> readAllPropertyFilter(PropertyPreviewDto filterDto) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PropertyPreviewDto[]> response = restTemplate.postForEntity("http://localhost:8090/property/filter", filterDto, PropertyPreviewDto[].class);

        PropertyPreviewDto[] foundAllProperty = response.getBody();
        List<PropertyPreviewDto> allProperty = Arrays.asList(foundAllProperty);

        HttpStatus statusCode = response.getStatusCode();
        Integer statusCodeValue = response.getStatusCodeValue();
        HttpHeaders headers = response.getHeaders();

        System.out.println("allProperty" + allProperty);
        System.out.println("STATUS " +statusCode);
        System.out.println("STATUS CODE VALUE " +statusCodeValue);
        System.out.println("HEADERS " + headers);

        return allProperty;
    }

    @Override
    public PropertyFullDto readPropertyById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PropertyFullDto> response = restTemplate.getForEntity("http://localhost:8090/property/{id}", PropertyFullDto.class, id);

        PropertyFullDto foundProperty = response.getBody();

        HttpStatus statusCode = response.getStatusCode();
        Integer statusCodeValue = response.getStatusCodeValue();
        HttpHeaders headers = response.getHeaders();

        System.out.println("foundProperty" + foundProperty);
        System.out.println("STATUS " +statusCode);
        System.out.println("STATUS CODE VALUE " +statusCodeValue);
        System.out.println("HEADERS " + headers);

        return foundProperty;
    }

    @Override
    public void deletePropertyById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8090/property/{id}", id);
    }

    @Override
    public PropertyFullDto createProperty(PropertyCreateDto createDto) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PropertyFullDto> response = restTemplate.postForEntity("http://localhost:8090/property/create", createDto, PropertyFullDto.class);

        HttpStatus statusCode = response.getStatusCode();
        PropertyFullDto savedProperty = response.getBody();

        System.out.println("STATUS " +statusCode);
        System.out.println("BODY " +savedProperty);

        return savedProperty;
    }

    @Override
    public void updateProperty(PropertyFullDto fullDto) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8090/property/update", fullDto);
    }
}
