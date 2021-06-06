package pl.deren.demo.Java;

public abstract class Wasp {
    int wings;
    String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWings() {
        return wings;
    }

    public void setWings(int wings) {
        this.wings = wings;
    }
    public abstract void getFly();
}
