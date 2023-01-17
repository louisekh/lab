package service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.Random;

@WebService(serviceName = "Reservation", portName = "ReservationPort")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ReserveHallPlaceService {

    @WebMethod(operationName = "ReservePlace")
    public Hall reservePlaces(Hall hall, int[] placeNumbers) {

        for (int i : placeNumbers) {

            hall.reservedPlaces[i] = true;

            System.out.println("Place with number " + i + "was reserved");

        }

        Random random = new Random();

        for (int i : placeNumbers) {

            hall.placesCost[i] = random.nextInt(5) * 100;

        }

        return hall;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9091/ReservePlaces", new ReserveHallPlaceService());
    }
}
