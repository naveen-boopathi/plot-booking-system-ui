package com.naveenboopathi.plotservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Site {
    private String site;
    private int plot1;
    private int plot2;
    private int plot3;
    private int plot4;
    private int plot5;
    private int plot6;

    public Site(@JsonProperty("site") String site,
                @JsonProperty("Plot 1") int plot1,
                @JsonProperty("Plot 2") int plot2,
                @JsonProperty("Plot 3") int plot3,
                @JsonProperty("Plot 4") int plot4,
                @JsonProperty("Plot 5") int plot5,
                @JsonProperty("Plot 6") int plot6) {
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

    public int getPlot1() {
        return plot1;
    }

    public void setPlot1(int plot1) {
        this.plot1 = plot1;
    }

    public int getPlot2() {
        return plot2;
    }

    public void setPlot2(int plot2) {
        this.plot2 = plot2;
    }

    public int getPlot3() {
        return plot3;
    }

    public void setPlot3(int plot3) {
        this.plot3 = plot3;
    }

    public int getPlot4() {
        return plot4;
    }

    public void setPlot4(int plot4) {
        this.plot4 = plot4;
    }

    public int getPlot5() {
        return plot5;
    }

    public void setPlot5(int plot5) {
        this.plot5 = plot5;
    }

    public int getPlot6() {
        return plot6;
    }

    public void setPlot6(int plot6) {
        this.plot6 = plot6;
    }

}
