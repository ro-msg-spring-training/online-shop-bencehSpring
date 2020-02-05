package ro.msg.learning.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dtos.LocationDTO;
import ro.msg.learning.shop.services.LocationService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/location")
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationDTO newLocation(@RequestBody LocationDTO locationDTO) {
        return locationService.createLocation(locationDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteLocation(@PathVariable Integer id) {
        locationService.deleteLocationById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public LocationDTO updateLocation(@PathVariable Integer id, @RequestBody LocationDTO locationDTO) {
        return locationService.updateLocationById(id, locationDTO);
    }
}
