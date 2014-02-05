/*
 * Copyright (c) 2013 Stephan D. Cote' - All rights reserved.
 * 
 * This program and the accompanying materials are made available under the 
 * terms of the MIT License which accompanies this distribution, and is 
 * available at http://creativecommons.org/licenses/MIT/
 *
 * Contributors:
 *   Stephan D. Cote 
 *      - Initial implementation
 */
package coyote.machine;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


/**
 * This is a very simple JSON client to test the services
 */
public class JsonClient
{

  public static void main( String[] args )
  {
    Client client = Client.create();

    // Perform a GET request
    WebResource webResource = client.resource( "http://localhost:8080/boss/machine/profile" );
    ClientResponse response = webResource.accept( "application/json" ).get( ClientResponse.class );
    if( response.getStatus() != 200 )
    {
      throw new RuntimeException( "Failed : HTTP error code : " + response.getStatus() );
    }

    MachineProfile output = response.getEntity( MachineProfile.class );

    System.out.println( "Output json client .... \n" );
    System.out.println( output );

    // Test out the POST request
    webResource = client.resource( "http://localhost:8080/boss/machine/profile" );
    webResource.accept( "application/json" ).post( ClientResponse.class, output );
  }
}