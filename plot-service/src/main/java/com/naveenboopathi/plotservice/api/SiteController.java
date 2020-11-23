package com.naveenboopathi.plotservice.api;

import com.naveenboopathi.plotservice.model.Site;
import com.naveenboopathi.plotservice.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/site")
@RestController
public class SiteController {
    private final SiteService siteService;

    @Autowired
    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping
    public List<Site> getAllSites() {
        return this.siteService.getAllSites();
    }

}
