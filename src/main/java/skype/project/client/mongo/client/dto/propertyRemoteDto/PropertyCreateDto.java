package skype.project.client.mongo.client.dto.propertyRemoteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import skype.project.client.mongo.client.dto.locationRemoteDto.LocationDto;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropertyCreateDto {

    private String size;
    private String description;
    private String img;
    private LocationDto location;

}
