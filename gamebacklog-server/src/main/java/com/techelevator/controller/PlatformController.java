package com.techelevator.controller;


import com.techelevator.model.Genre;
import com.techelevator.model.Platform;
import com.techelevator.service.PlatformService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping( path = "/platforms" )
public class PlatformController {

    private PlatformService platformService;

    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Platform> getPlatforms() {
        return platformService.getPlatforms();
    }

}
