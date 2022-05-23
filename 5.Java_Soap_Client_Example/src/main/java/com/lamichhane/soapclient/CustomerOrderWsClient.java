package com.lamichhane.soapclient;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;
import com.bharath.ws.trainings.Product;
import com.lamichhane.soapwebservice.CustomerOrdersWsImplService;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException
	{
		CustomerOrdersWsImplService service=new CustomerOrdersWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
        CustomerOrdersPortType customerordersWsImplPort=service.getCustomerOrdersWsImplPort();
        GetOrdersRequest request=new GetOrdersRequest();
        request.setCustomerId(BigInteger.valueOf(1));
        GetOrdersResponse response=customerordersWsImplPort.getOrders(request);
        List<Order> orders=response.getOrder();
        for(Order order:orders)
        {
        	List<Product> products=order.getProduct();
        	for(Product product:products)
        	{
        		System.out.println("Product Description "+product.getDescription());
        		System.out.println("Product Quantity "+product.getQuantity());
        	}
        }
        
	}

}
