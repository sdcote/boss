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

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class MachineProfile
{

  public MemoryProfile MemoryProfile = new MemoryProfile();




  public MachineProfile()
  {

  }
}
