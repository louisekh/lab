package client_async;

import client.Reservation;
import client.ReserveHallPlaceService;
import org.camunda.bpm.client.ExternalTaskClient;

import javax.xml.ws.Response;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CheckPayClient {

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

        client.subscribe("payment")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {

                    try {
                        Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Check check = new Check(url);
                    CheckPayService checkPayService = check.getCheckPort();

                    Hall hall = new Hall();
                    hall.setMovieName("Movie");
                    hall.setPlacesNum(10);

                    List<Integer> places = new ArrayList<>();
                    places.add(1);
                    places.add(4);
                    hall.placesCost = new ArrayList<>();
                    hall.reservedPlaces = new ArrayList<>();
                    for (int j = 0; j <=10; j ++) {
                        hall.reservedPlaces.add(false);
                        hall.placesCost.add(0);
                    }

                    for (int i : places) {
                        hall.reservedPlaces.set(i, true);
                    }

                    Random random = new Random();

                    for (int i : places) {
                        hall.placesCost.set(i, random.nextInt(5) * 100);
                    }

                    Response<CheckPayResponse> response = checkPayService.checkPayAsync(hall, true);

                    System.out.println("Polling started");
                    while(!response.isDone()) {
                        try {
                            System.out.println("Polling...");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Paycheck paycheck = new Paycheck();
                    try {

                        paycheck = response.get().getReturn();
                        System.out.println("Pay cost " + paycheck.getCheckCost());

                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    Map<String, Object> variables = new HashMap<>();
                    variables.put("pay", true);

                    // Complete the task
                    externalTaskService.complete(externalTask, variables);
                })
                .open();

    }

    public static void main(String[] args) {
        URL url = getWSDLURL("http://localhost:9092/CheckPay?wsdl");
        CheckPayClient client = new CheckPayClient();
        client.process(url);
    }
}
