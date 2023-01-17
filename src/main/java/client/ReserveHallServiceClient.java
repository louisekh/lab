package client;

import org.camunda.bpm.client.ExternalTaskClient;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReserveHallServiceClient {
    private static URL getWSDLURL(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return url;
    }

    public void process(URL url) {

        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();

        client.subscribe("reserve")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {

                    try {
                        Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Reservation reservation = new Reservation(url);
                    ReserveHallPlaceService port = reservation.getReservationPort();

                    Hall hall = new Hall();
                    hall.setMovieName("Movie");
                    hall.setPlacesNum(10);

                    List<Integer> places = new ArrayList<>();
                    places.add(1);
                    places.add(4);
                    hall = port.reservePlace(hall, places);

                    for (int i : places) {

                        System.out.println("Place with number " + i + " was reserved");

                    }

                    Map<String, Object> variables = new HashMap<>();
                    variables.put("movieName", hall.getMovieName());
                    variables.put("placesNum", hall.getPlacesNum());
                    variables.put("reservedPlaces", hall.getReservedPlaces());
                    variables.put("placesCost", hall.getPlacesCost());

                    // Complete the task
                    externalTaskService.complete(externalTask, variables);
                })
                .open();

    }

    public static void main(String[] args) {
        URL url = getWSDLURL("http://localhost:9091/ReservePlaces?wsdl");
        ReserveHallServiceClient client = new ReserveHallServiceClient();
        client.process(url);
    }
}
