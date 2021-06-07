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
public class PropertyPreviewDto {

    private String id;
    private String size;
    private String img;
    private LocationDto location;

}
