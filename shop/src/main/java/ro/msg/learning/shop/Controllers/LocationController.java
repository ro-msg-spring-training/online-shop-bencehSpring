package ro.msg.learning.shop.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.DTO.LocationDTO;
import ro.msg.learning.shop.Services.LocationService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/location")
public class LocationController {


    private final LocationService locationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationDTO newLocation(@RequestBody LocationDTO locationDTO) {
        return locationService.createLocation(locationDTO.getLocationName(), locationDTO.getAddressDTO().getAddressCountry(), locationDTO.getAddressDTO().getAddressCity(),
                locationDTO.getAddressDTO().getAddressStreet());
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteLocation(@PathVariable Integer id) {
        locationService.deleteLocationById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public LocationDTO updateLocation(@PathVariable Integer id, @RequestBody LocationDTO locationDTO) {
        return locationService.updateLocationById(id, locationDTO.getLocationName(), locationDTO.getAddressDTO().getAddressCountry(), locationDTO.getAddressDTO().getAddressCity(),
                locationDTO.getAddressDTO().getAddressStreet());
    }

}
