package skype.project.client.mongo.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import skype.project.client.mongo.client.dto.propertyRemoteDto.PropertyCreateDto;
import skype.project.client.mongo.client.dto.propertyRemoteDto.PropertyFullDto;
import skype.project.client.mongo.client.dto.propertyRemoteDto.PropertyPreviewDto;
import skype.project.client.mongo.client.service.PropertyServiceClient;

import java.util.List;

@Controller
public class PropertyControllerClient {

    @Autowired
    PropertyServiceClient propertyServiceClient;

    @GetMapping("/property")
    public String findAll(Model model){
        List<PropertyPreviewDto> property = propertyServiceClient.readAllProperty();
        model.addAttribute("property", property);

        return "property-index";
    }

    @GetMapping("/property/single/{id}")
    public String getSingle(@PathVariable String id, Model model){
        PropertyFullDto foundProperty = propertyServiceClient.readPropertyById(id);
        model.addAttribute("property", foundProperty);

        return "single-property";
    }

    @GetMapping("/property/delete/{id}")
    public String delete (@PathVariable String id){
        propertyServiceClient.deletePropertyById(id);

        return "redirect:/property";
    }

    @GetMapping("/property/change/{id}")
    public String openChangingPage(@PathVariable String id, Model model){
        PropertyFullDto property = propertyServiceClient.readPropertyById(id);
        model.addAttribute("property", property);

        return "change-property";
    }

    @PostMapping("/property/change")
    public String change(PropertyFullDto property){
        propertyServiceClient.updateProperty(property);

        return "redirect:/property";
    }

    @GetMapping("/property/create")
    public String openCreationPage(PropertyCreateDto property, Model model){
        model.addAttribute("property", property);
        return "create-property";
    }

    @PostMapping("/property/create")
    public String create(PropertyCreateDto property){
        PropertyFullDto createdProperty = propertyServiceClient.createProperty(property);

        return "redirect:/property";
    }

    @GetMapping("/property/filter")
    public String openFilterPage(PropertyPreviewDto property, Model model){
        model.addAttribute("property", property);
        return "filter-property";
    }

    @PostMapping("/property/filter")
    public String filter(PropertyPreviewDto property,Model model){
        List<PropertyPreviewDto> propertyFilter = propertyServiceClient.readAllPropertyFilter(property);

        model.addAttribute("property", propertyFilter);
        return "propertyFiltred-index";
    }

}
