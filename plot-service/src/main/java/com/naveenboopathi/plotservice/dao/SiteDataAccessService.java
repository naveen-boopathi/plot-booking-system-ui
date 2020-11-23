package com.naveenboopathi.plotservice.dao;

import com.naveenboopathi.plotservice.model.Site;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("localDao")
public class SiteDataAccessService implements SiteDao{
    private static List<Site> db = new ArrayList<>();

    @Override
    public List<Site> selectAllSites() {
        if(db.size() <= 0) {
            setDB();
        }
        return db;
    }

    @Override
    public void setDB() {
        List<Site> db = new ArrayList<>();
        Site mySite1 = new Site("Site 1", "0", "0", "0", "0", "0", "0");
        Site myRoad1 = new Site("Road 1", "100", "100", "100", "100", "100", "100");
        Site mySite2 = new Site("Site 2", "0", "0", "0", "0", "0", "0");
        Site mySite3 = new Site("Site 3", "0", "0", "0", "0", "0", "0");
        Site myRoad2 = new Site("Road 2", "100", "100", "100", "100", "100", "100");
        Site mySite4 = new Site("Site 4", "0", "0", "0", "0", "0", "0");
        Site mySite5 = new Site("Site 5", "0", "0", "0", "0", "0", "0");
        Site myRoad3 = new Site("Road 3", "100", "100", "100", "100", "100", "100");
        Site mySite6 = new Site("Site 6", "0", "0", "0", "0", "0", "0");
        Site mySite7 = new Site("Site 7", "0", "0", "0", "0", "0", "0");
        Site myRoad4 = new Site("Road 4", "100", "100", "100", "100", "100", "100");
        Site mySite8 = new Site("Site 8", "0", "0", "0", "0", "0", "0");
        db.add(mySite1);
        db.add(myRoad1);
        db.add(mySite2);
        db.add(mySite3);
        db.add(myRoad2);
        db.add(mySite4);
        db.add(mySite5);
        db.add(myRoad3);
        db.add(mySite6);
        db.add(mySite7);
        db.add(myRoad4);
        db.add(mySite8);
        SiteDataAccessService.db = db;
    }
}
