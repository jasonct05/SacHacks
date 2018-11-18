package Model;

public class Location {
    public double latitude;
    public double longitude;

    public Location(double latitude, double longtitude) {
        this.latitude = latitude;
        this.longitude = longtitude;
    }

    @Override
    public String toString() {
        return "[" + this.latitude + ", " + this.longitude + "]";
    }
}
