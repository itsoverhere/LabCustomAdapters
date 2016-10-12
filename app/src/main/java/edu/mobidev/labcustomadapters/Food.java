package edu.mobidev.labcustomadapters;

/**
 * Created by student on 11/10/2016.
 */

public class Food {

    private String name;
    private int icon;

    public Food() {
    }

    public Food(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
