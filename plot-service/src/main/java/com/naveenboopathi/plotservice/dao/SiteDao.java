package com.naveenboopathi.plotservice.dao;

import com.naveenboopathi.plotservice.model.Site;

import java.util.List;

public interface SiteDao {
    List<Site> selectAllSites();
    void setDB();
}
