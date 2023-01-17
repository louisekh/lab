package service;

import java.util.Date;

public class Hall {
    int placesNum;
    boolean[] reservedPlaces;
    int[] placesCost;
    String movieName;
    Date movieShowDate;

    public int getPlacesNum() {
        return placesNum;
    }

    public void setPlacesNum(int placesNum) {
        this.reservedPlaces = new boolean[placesNum];
        this.placesCost = new int[placesNum];
        this.placesNum = placesNum;
    }

    public boolean[] getReservedPlaces() {
        return reservedPlaces;
    }

    public void setReservedPlaces(boolean[] reservedPlaces) {
        this.reservedPlaces = reservedPlaces;
    }

    public int[] getPlacesCost() {
        return placesCost;
    }

    public void setPlacesCost(int[] placesCost) {
        this.placesCost = placesCost;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getMovieShowDate() {
        return movieShowDate;
    }

    public void setMovieShowDate(Date movieShowDate) {
        this.movieShowDate = movieShowDate;
    }
}
