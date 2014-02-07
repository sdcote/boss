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

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class models a servlet intended to initialize the runtime environment
 * for the demonstration services.
 */
public class InitMachineService extends GenericServlet
{

  /**
   * 
   */
  private static final long serialVersionUID = -5490426583885157920L;

  private static Logger LOG;

  static
  {
    LOG = LoggerFactory.getLogger( InitMachineService.class );
  }




  /*
   * @see javax.servlet.GenericServlet#init()
   */
  @Override
  public void init() throws ServletException
  {
    super.init();

    try
    {
      final InitialContext ic = new InitialContext();
      final DataSource datasource = (DataSource)ic.lookup( "java:comp/env/jdbc/boss" );
      if( datasource != null )
      {

        Connection con = null;
        Statement stmt = null;
        try
        {
          con = datasource.getConnection();
          con.setAutoCommit( false );

          stmt = con.createStatement();

          stmt.execute( "DROP TABLE IF EXISTS operator;" );
          stmt.execute( "CREATE TABLE IF NOT EXISTS operator (ID char(50) NOT NULL, Last_Name char(50),First_Name char(50),Email char(50), Phone_Number char(15))" );

          // Some dummy data to insert.
          final String[] ids = new String[] { "751cb391", "0cf0df08", "b4919cad", "53e537fb", "86b238ce" };
          final String[] firstNames = new String[] { "Anna", "Bill", "Cindy", "Don", "Eric" };
          final String[] lastNames = new String[] { "Allen", "Brown", "Chu", "Dodd", "Estavez" };
          final String[] emails = new String[] { "aang@example.com", "b.brown@example.com", "cindy@example.com", "d.d@example.com", "e.estavez@example.com" };
          final String[] phoneNumbers = new String[] { "123-456-7890", "555-444-3333", "555-867-5309", "555-555-1212", "781-555-0000" };

          final PreparedStatement pstmt = con.prepareStatement( "INSERT INTO operator (ID, Last_Name, First_Name, Email, Phone_Number)" + " VALUES(?,?,?,?,?)" );

          // Add rows to a batch in a loop. Each iteration adds a new row.
          for( int i = 0; i < firstNames.length; i++ )
          {
            pstmt.setString( 1, ids[i] );
            pstmt.setString( 2, lastNames[i] );
            pstmt.setString( 3, firstNames[i] );
            pstmt.setString( 4, emails[i] );
            pstmt.setString( 5, phoneNumbers[i] );
            // Add row to the batch.
            pstmt.addBatch();
          }

          try
          {
            pstmt.executeBatch();
            con.commit();
            LOG.info( "Operator data base initialized successfully" );
          }
          catch( final SQLException e )
          {
            LOG.error( "Error message: " + e.getMessage() );
          }

          if( stmt != null )
            stmt.close();
        }
        catch( final SQLException e )
        {
          LOG.error( e.getMessage() );
        }
        finally
        {
          try
          {
            if( con != null )
              con.close();
          }
          catch( final SQLException e )
          {
            LOG.error( e.getMessage() );
          }
        }
      }
      else
        LOG.error( "Failure: data source lookup failed" );
    }
    catch( final NamingException e )
    {
      LOG.error( "NAMING EXCEPTION:" + e.getMessage() );
    }

  }




  /*
   * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest,
   * javax.servlet.ServletResponse)
   */
  @Override
  public void service( final ServletRequest req, final ServletResponse res ) throws ServletException, IOException
  {
    // This should never be called
  }

}
