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

/**
 *
 */
public class MemoryTool
{

  /**
   * Returns the maximum amount of memory that the virtual machine will attempt 
   * to use.
   * 
   * <p>The heap can grow to this limit but never more than this.</p>
   * 
   * <p>Keep in mind this and all memory values are approximate as the garbage 
   * collector can be running at the same time. Also, other threads may be 
   * allocating object on the heap, changing the values between calls.</p>
   *  
   * @return The maximum number of bytes the heap can ever allocate.
   */
  public static long getMaxHeapSize()
  {
    return Runtime.getRuntime().maxMemory();
  }




  /**
   * Returns the total amount of memory currently in use by the heap. 
   * 
   * <p>It is composed of all currently allocated objects and possibly some 
   * space that was freed by the garbage collector.</p>
   * 
   * <p>Heap size is allocated and release in blocks. This is the current size
   * of the heap allocation.</p>
   * 
   * <p>Keep in mind this and all memory values are approximate as the garbage 
   * collector can be running at the same time. Also, other threads may be 
   * allocating object on the heap, changing the values between calls.</p>
   *  
   * @return The number of bytes currently allocated by the heap.
   */
  public static long getCurrentHeapSize()
  {
    return Runtime.getRuntime().totalMemory();
  }




  /**
   * Available memory is the maximum memory available to the VM less the total 
   * memory currently allocated for the heap.
   * 
   * <p>This is different from free memory in that this returns the difference 
   * between the allocated heap and the maximum Heap size. It does not include 
   * the amount of memory available on the current heap allocation.</p>
   * 
   * <p>Keep in mind this and all memory values are approximate as the garbage 
   * collector can be running at the same time. Also, other threads may be 
   * allocating object on the heap, changing the values between calls.</p>
   *  
   * @return The number of bytes the heap can grow before MaxMemory is reached. 
   */
  public static long getAvailableMemory()
  {
    return Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory();
  }




  /**
   * Free memory is the total amount of memory that can be allocated prior to
   * running out of memory in the VM.
   * 
   * <p>This can be used to approximate the amount of memory available to the 
   * application. This will never be totally accurate because the garbage 
   * collection process could change things at any time.</p>
   *  
   * <p>Keep in mind this and all memory values are approximate as the garbage 
   * collector can be running at the same time. Also, other threads may be 
   * allocating object on the heap, changing the values between calls.</p>
   *  
   * @return Available Memory and Free Heap size added together.
   */
  public static long getFreeMemory()
  {
    return Runtime.getRuntime().freeMemory() + ( Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() );
  }




  /**
   * Returns an approximation of the total amount of memory currently available 
   * on the heap for newly allocated objects.
   * 
   * <p>This is what is available on the current heap allocation before the 
   * next block of memory is requested to be added to total heap memory. In 
   * other words, this is the number of bytes available before the heap will 
   * attempt to grow.</p>
   * 
   * <p>Keep in mind this and all memory values are approximate as the garbage 
   * collector can be running at the same time. Also, other threads may be 
   * allocating object on the heap, changing the values between calls.</p>
   *  
   * @return The number of bytes available on the currently allocated heap.
   */
  public static long getFreeHeapSize()
  {
    return Runtime.getRuntime().freeMemory();
  }




  /**
   * Return the percentage of the Maximum Memory the currently allocated heap 
   * occupies.
   * 
   * <p>In some cases this will always return 1.0 indicating that all memory 
   * has been allocated to the heap. These cases include runtimes where the Ms 
   * and Mx systems properties are set to the same value. This will not mean 
   * that the runtime is out of memory, just that the heap has been allocated 
   * to fill the entire space. The FreeHeap value will then determine the 
   * amount of free memory and should be the same value as FreeMemory.</p>
   *  
   * <p>Keep in mind this and all memory values are approximate as the garbage 
   * collector can be running at the same time. Also, other threads may be 
   * allocating object on the heap, changing the values between calls.</p>
   *  
   * @return The percentage of maximum heap memory currently allocated to the 
   *         heap.
   */
  public static float getHeapPercentage()
  {
    return (float)( 1 - ( (float)getAvailableMemory() / (float)getMaxHeapSize() ) ); // percent of max
  }




  /**
   * Return the amount of memory used by the heap.
   * 
   * <p>This shows how much memory is used in the currently allocated heap. The
   * MaxHeapSize thould equale this return value added to the FreeMemory 
   * value.</p>
   * 
   * <p>Keep in mind this and all memory values are approximate as the garbage 
   * collector can be running at the same time. Also, other threads may be 
   * allocating object on the heap, changing the values between calls.</p>
   *  
   * @return Total used memory percentage of maximum memory.
   */
  public static float getUsedMemory()
  {
    return getMaxHeapSize() - getFreeMemory();
  }




  /**
   * Return the percentage of used memory of the maximum memory.
   * 
   * <p>This is different from the Heap Percentage in that this calculation
   * takes both available memory and free heap to determine how much memory is
   * actually used by the runtime.</p>
   *  
   * <p>Keep in mind this and all memory values are approximate as the garbage 
   * collector can be running at the same time. Also, other threads may be 
   * allocating object on the heap, changing the values between calls.</p>
   *  
   * @return Total used memory percentage of maximum memory.
   */
  public static float getUsedMemoryPercentage()
  {
    return (float)( 1 - ( (float)getFreeMemory() / (float)getMaxHeapSize() ) ); // percent of max
  }




  /**
   * <p>Keep in mind this and all memory values are approximate as the garbage 
   * collector can be running at the same time. Also, other threads may be 
   * allocating object on the heap, changing the values between calls.</p>
   *  
   * @return The percentage of total free memory available both on the heap and 
   *         memory that has not yet been allocated to the heap.
   */
  public static float getFreeMemoryPercentage()
  {
    return (float)( (float)getFreeMemory() / (float)getMaxHeapSize() );
  }

}
