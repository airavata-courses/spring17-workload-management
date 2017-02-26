/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.sga.commons.model;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum MachineType implements org.apache.thrift.TEnum {
  CLOUD(0),
  HPC(1),
  VM(2);

  private final int value;

  private MachineType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static MachineType findByValue(int value) { 
    switch (value) {
      case 0:
        return CLOUD;
      case 1:
        return HPC;
      case 2:
        return VM;
      default:
        return null;
    }
  }
}
