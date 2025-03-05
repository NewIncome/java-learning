/*
 * This is the blueprint of a House
 * Objects created from this class will have access
 * to the following data and methods, if permitted per
 * the encapsulation levels defined.
 */
public class House {
    private int numStories;
    private int numWindows;
    private String color;

    //No-arg Constructor
    public House() {
        numStories = 1;
        numWindows = 4;
        color = "gray";
    }//end ctor

    //Parameterized ctor
    public House(int numStories, int numWindows, String color) {
        this.numStories = numStories;
        this.numWindows = numWindows;
        this.color = color;
    }//end param ctor

    public int getNumStories() {
        return numStories;
    }

    public void setNumStories(int numStories) {
        this.numStories = numStories;
    }

    public int getNumWindows() {
        return numWindows;
    }

    public void setNumWindows(int numWindows) {
        this.numWindows = numWindows;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}