package skype.project.client.mongo.client.dto.userRemoteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import skype.project.client.mongo.client.dto.propertyRemoteDto.PropertyFullDto;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserFullDto {

    private String id;
    private String name;
    private String surname;
    private int age;
    private String sex;
    private PropertyFullDto property;

}
