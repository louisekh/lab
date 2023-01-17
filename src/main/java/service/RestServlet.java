package service;

import org.camunda.bpm.client.ExternalTaskClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.io.IOException;
import java.net.URI;

@Path("/service")
public class RestServlet {

    // http://localhost:9090/app/rest/service/confirm

    @GET
    @Path("/confirm")
    @Produces(MediaType.APPLICATION_JSON)
    public Response noteUser() throws IOException {

        Ticket ticket = new Ticket();
        ticket.setMovieName("Movie");
        ticket.setPlaceNum(1);

        String string = "Ticket was successfully reserved and paid. \n The ticket has been sent to your email.";

        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();

        client.subscribe("confirm")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {

                    try {
                        Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // Complete the task
                    externalTaskService.complete(externalTask);
                })
                .open();

        return Response.ok(string).build();
    }
}
