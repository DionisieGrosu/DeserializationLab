package com.deserialBNM.deserialBNM;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class requestClass {

	public String returnXML(String date) {
		String output = null;
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("https://bnm.md/en/official_exchange_rates?get_xml=1&date=" + date);

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			output = response.getEntity(String.class);

			

		  } catch (Exception e) {

			e.printStackTrace();

		  }
		return output;

	}
}
