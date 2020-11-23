package com.naveenboopathi.plotservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Site {
    private String site;
    private String plot1;
    private String plot2;
    private String plot3;
    private String plot4;
    private String plot5;
    private String plot6;

    public Site(@JsonProperty("site") String site,
                @JsonProperty("Plot 1") String plot1,
                @JsonProperty("Plot 2") String plot2,
                @JsonProperty("Plot 3") String plot3,
                @JsonProperty("Plot 4") String plot4,
                @JsonProperty("Plot 5") String plot5,
                @JsonProperty("Plot 6") String plot6) {
        this.site = site;
        this.plot1 = plot1;
        this.plot2 = plot2;
        this.plot3 = plot3;
        this.plot4 = plot4;
        this.plot5 = plot5;
        this.plot6 = plot6;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPlot1() {
        return plot1;
    }

    public void setPlot1(String plot1) {
        this.plot1 = plot1;
    }

    public String getPlot2() {
        return plot2;
    }

    public void setPlot2(String plot2) {
        this.plot2 = plot2;
    }

    public String getPlot3() {
        return plot3;
    }

    public void setPlot3(String plot3) {
        this.plot3 = plot3;
    }

    public String getPlot4() {
        return plot4;
    }

    public void setPlot4(String plot4) {
        this.plot4 = plot4;
    }

    public String getPlot5() {
        return plot5;
    }

    public void setPlot5(String plot5) {
        this.plot5 = plot5;
    }

    public String getPlot6() {
        return plot6;
    }

    public void setPlot6(String plot6) {
        this.plot6 = plot6;
    }
}
