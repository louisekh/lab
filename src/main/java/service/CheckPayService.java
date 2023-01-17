package service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;


@WebService(serviceName = "Check", portName = "CheckPort")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class CheckPayService {

    @WebMethod(operationName = "CheckPay")
    public Paycheck checkPay(Hall hall, Boolean confirm) {

        try {
            Thread.sleep(1000 * 5);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Paycheck paycheck = new Paycheck();
        paycheck.setProduct(hall.getMovieName());
        int sumCost = 0;
        int index = 0;
        if (confirm) {

            for (boolean i : hall.getReservedPlaces()) {
                if (i) {
                    sumCost += hall.placesCost[index];
                }
                index += 1;
            }
            paycheck.setCheckCost(sumCost);
            paycheck.setCheckPaid(true);

        }
        return paycheck;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9092/CheckPay", new CheckPayService());
    }
}
