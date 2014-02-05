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
package coyote.boss.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coyote.machine.MachineProfile;


/**
 * This class models demonstration services for the BOSS toolkit.
 */
@Path("/machine")
public class MachineSvc
{

  // Access to logging subsystem
  private static final Logger LOG;

  static
  {
    LOG = LoggerFactory.getLogger( MachineSvc.class );
  }




  /**
   * Return the profile for a particular driver.
   * 
   * http://localhost:8080/demo/machine/profile
   * 
   * @return
   */
  @GET
  @Path("/profile")
  @Produces(MediaType.APPLICATION_JSON)
  public MachineProfile getProfile()
  {
    LOG.info( "getProfile request received" );

    final MachineProfile profile = new MachineProfile();

    LOG.info( "getProfile request completed secussfully" );
    return profile;
  }




  /**
   * Return the profile for a particular trip.
   * 
   * http://localhost:8080/demo/machine/profile
   * 
   * @return
   */
  @POST
  @Path("/profile")
  @Produces(MediaType.APPLICATION_JSON)
  public void saveProfile()
  {
    LOG.info( "saveProfile request received" );

    LOG.info( "saveProfile request completed secussfully" );
  }
}
