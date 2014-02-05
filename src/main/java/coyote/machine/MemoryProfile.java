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


/**
 */
@XmlRootElement
public class MemoryProfile
{

  public long maxHeapSize = 0;
  public long currentHeapSize = 0;
  public long availableMemory = 0;
  public long freeMemory = 0;
  public long freeHeapSize = 0;
  public float heapPercentage = 0;
  public float usedMemory = 0;
  public float usedMemoryPercentage = 0;
  public float freeMemoryPercentage = 0;




  public MemoryProfile()
  {
    maxHeapSize = MemoryTool.getMaxHeapSize();
    currentHeapSize = MemoryTool.getCurrentHeapSize();
    availableMemory = MemoryTool.getAvailableMemory();
    freeMemory = MemoryTool.getFreeMemory();
    freeHeapSize = MemoryTool.getFreeHeapSize();
    heapPercentage = MemoryTool.getHeapPercentage();
    usedMemory = MemoryTool.getUsedMemory();
    usedMemoryPercentage = MemoryTool.getUsedMemoryPercentage();
    freeMemoryPercentage = MemoryTool.getFreeMemoryPercentage();
  }

}
