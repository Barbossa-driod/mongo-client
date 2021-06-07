package skype.project.client.mongo.client.dto.propertyRemoteDto;

import lombok.Data;
import skype.project.client.mongo.client.dto.locationRemoteDto.LocationDto;

@Data
public class PropertyFullDto {

    private String id;
    private String size;
    private LocationDto location;
    private String description;
    private String img;
}
