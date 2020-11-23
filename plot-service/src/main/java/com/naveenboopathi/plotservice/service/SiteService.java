package com.naveenboopathi.plotservice.service;

import com.naveenboopathi.plotservice.dao.SiteDao;
import com.naveenboopathi.plotservice.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {
    private final SiteDao siteDao;

    @Autowired
    public SiteService(@Qualifier("localDao") SiteDao siteDao) {
        this.siteDao = siteDao;
    }

    public List<Site> getAllSites() {
        return this.siteDao.selectAllSites();
    }
}
