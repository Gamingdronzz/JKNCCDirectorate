package com.jknccdirectorate.Model;

/**
 * Created by hp on 11-09-2017.
 */

public class DropdownModel {
    private String heading;
    private String[] list;
    private int icon;

    public DropdownModel(String heading, String[] list, int icon) {
        this.heading = heading;
        this.list = list;
        this.icon = icon;
    }

    public int getIcon() {

        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
    //private int selectedPosition = 0;

    public DropdownModel(String heading, String[] list) {
        this.heading = heading;
        this.list = list;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String[] getList() {
        return list;
    }


    public void setList(String[] list) {
        this.list = list;

    }

 /*   public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }
*/
   /* public DropdownModel(String heading, String[] list, int selectedPosition) {
        this.heading = heading;
        this.list = list;
        this.selectedPosition = selectedPosition;

    }
*/
}