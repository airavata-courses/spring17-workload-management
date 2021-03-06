    /*
     * Licensed to the Apache Software Foundation (ASF) under one or more
     * contributor license agreements.  See the NOTICE file distributed with
     * this work for additional information regarding copyright ownership.
     * The ASF licenses this file to You under the Apache License, Version 2.0
     * (the "License"); you may not use this file except in compliance with
     * the License.  You may obtain a copy of the License at
     *
     *     http://www.apache.org/licenses/LICENSE-2.0
     *
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     */
/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.sga.commons.model;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)")
public class Application implements org.apache.thrift.TBase<Application, Application._Fields>, java.io.Serializable, Cloneable, Comparable<Application> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Application");

  private static final org.apache.thrift.protocol.TField COMMANDS_FIELD_DESC = new org.apache.thrift.protocol.TField("commands", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField INPUTS_FIELD_DESC = new org.apache.thrift.protocol.TField("inputs", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField OUTPUTS_FIELD_DESC = new org.apache.thrift.protocol.TField("outputs", org.apache.thrift.protocol.TType.LIST, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ApplicationStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ApplicationTupleSchemeFactory());
  }

  public List<String> commands; // required
  public List<Data> inputs; // optional
  public List<Data> outputs; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    COMMANDS((short)1, "commands"),
    INPUTS((short)2, "inputs"),
    OUTPUTS((short)3, "outputs");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // COMMANDS
          return COMMANDS;
        case 2: // INPUTS
          return INPUTS;
        case 3: // OUTPUTS
          return OUTPUTS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.INPUTS,_Fields.OUTPUTS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.COMMANDS, new org.apache.thrift.meta_data.FieldMetaData("commands", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.INPUTS, new org.apache.thrift.meta_data.FieldMetaData("inputs", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Data.class))));
    tmpMap.put(_Fields.OUTPUTS, new org.apache.thrift.meta_data.FieldMetaData("outputs", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Data.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Application.class, metaDataMap);
  }

  public Application() {
  }

  public Application(
    List<String> commands)
  {
    this();
    this.commands = commands;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Application(Application other) {
    if (other.isSetCommands()) {
      List<String> __this__commands = new ArrayList<String>(other.commands);
      this.commands = __this__commands;
    }
    if (other.isSetInputs()) {
      List<Data> __this__inputs = new ArrayList<Data>(other.inputs.size());
      for (Data other_element : other.inputs) {
        __this__inputs.add(new Data(other_element));
      }
      this.inputs = __this__inputs;
    }
    if (other.isSetOutputs()) {
      List<Data> __this__outputs = new ArrayList<Data>(other.outputs.size());
      for (Data other_element : other.outputs) {
        __this__outputs.add(new Data(other_element));
      }
      this.outputs = __this__outputs;
    }
  }

  public Application deepCopy() {
    return new Application(this);
  }

  @Override
  public void clear() {
    this.commands = null;
    this.inputs = null;
    this.outputs = null;
  }

  public int getCommandsSize() {
    return (this.commands == null) ? 0 : this.commands.size();
  }

  public java.util.Iterator<String> getCommandsIterator() {
    return (this.commands == null) ? null : this.commands.iterator();
  }

  public void addToCommands(String elem) {
    if (this.commands == null) {
      this.commands = new ArrayList<String>();
    }
    this.commands.add(elem);
  }

  public List<String> getCommands() {
    return this.commands;
  }

  public Application setCommands(List<String> commands) {
    this.commands = commands;
    return this;
  }

  public void unsetCommands() {
    this.commands = null;
  }

  /** Returns true if field commands is set (has been assigned a value) and false otherwise */
  public boolean isSetCommands() {
    return this.commands != null;
  }

  public void setCommandsIsSet(boolean value) {
    if (!value) {
      this.commands = null;
    }
  }

  public int getInputsSize() {
    return (this.inputs == null) ? 0 : this.inputs.size();
  }

  public java.util.Iterator<Data> getInputsIterator() {
    return (this.inputs == null) ? null : this.inputs.iterator();
  }

  public void addToInputs(Data elem) {
    if (this.inputs == null) {
      this.inputs = new ArrayList<Data>();
    }
    this.inputs.add(elem);
  }

  public List<Data> getInputs() {
    return this.inputs;
  }

  public Application setInputs(List<Data> inputs) {
    this.inputs = inputs;
    return this;
  }

  public void unsetInputs() {
    this.inputs = null;
  }

  /** Returns true if field inputs is set (has been assigned a value) and false otherwise */
  public boolean isSetInputs() {
    return this.inputs != null;
  }

  public void setInputsIsSet(boolean value) {
    if (!value) {
      this.inputs = null;
    }
  }

  public int getOutputsSize() {
    return (this.outputs == null) ? 0 : this.outputs.size();
  }

  public java.util.Iterator<Data> getOutputsIterator() {
    return (this.outputs == null) ? null : this.outputs.iterator();
  }

  public void addToOutputs(Data elem) {
    if (this.outputs == null) {
      this.outputs = new ArrayList<Data>();
    }
    this.outputs.add(elem);
  }

  public List<Data> getOutputs() {
    return this.outputs;
  }

  public Application setOutputs(List<Data> outputs) {
    this.outputs = outputs;
    return this;
  }

  public void unsetOutputs() {
    this.outputs = null;
  }

  /** Returns true if field outputs is set (has been assigned a value) and false otherwise */
  public boolean isSetOutputs() {
    return this.outputs != null;
  }

  public void setOutputsIsSet(boolean value) {
    if (!value) {
      this.outputs = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case COMMANDS:
      if (value == null) {
        unsetCommands();
      } else {
        setCommands((List<String>)value);
      }
      break;

    case INPUTS:
      if (value == null) {
        unsetInputs();
      } else {
        setInputs((List<Data>)value);
      }
      break;

    case OUTPUTS:
      if (value == null) {
        unsetOutputs();
      } else {
        setOutputs((List<Data>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case COMMANDS:
      return getCommands();

    case INPUTS:
      return getInputs();

    case OUTPUTS:
      return getOutputs();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case COMMANDS:
      return isSetCommands();
    case INPUTS:
      return isSetInputs();
    case OUTPUTS:
      return isSetOutputs();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Application)
      return this.equals((Application)that);
    return false;
  }

  public boolean equals(Application that) {
    if (that == null)
      return false;

    boolean this_present_commands = true && this.isSetCommands();
    boolean that_present_commands = true && that.isSetCommands();
    if (this_present_commands || that_present_commands) {
      if (!(this_present_commands && that_present_commands))
        return false;
      if (!this.commands.equals(that.commands))
        return false;
    }

    boolean this_present_inputs = true && this.isSetInputs();
    boolean that_present_inputs = true && that.isSetInputs();
    if (this_present_inputs || that_present_inputs) {
      if (!(this_present_inputs && that_present_inputs))
        return false;
      if (!this.inputs.equals(that.inputs))
        return false;
    }

    boolean this_present_outputs = true && this.isSetOutputs();
    boolean that_present_outputs = true && that.isSetOutputs();
    if (this_present_outputs || that_present_outputs) {
      if (!(this_present_outputs && that_present_outputs))
        return false;
      if (!this.outputs.equals(that.outputs))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_commands = true && (isSetCommands());
    list.add(present_commands);
    if (present_commands)
      list.add(commands);

    boolean present_inputs = true && (isSetInputs());
    list.add(present_inputs);
    if (present_inputs)
      list.add(inputs);

    boolean present_outputs = true && (isSetOutputs());
    list.add(present_outputs);
    if (present_outputs)
      list.add(outputs);

    return list.hashCode();
  }

  @Override
  public int compareTo(Application other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCommands()).compareTo(other.isSetCommands());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCommands()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.commands, other.commands);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetInputs()).compareTo(other.isSetInputs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInputs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.inputs, other.inputs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOutputs()).compareTo(other.isSetOutputs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOutputs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.outputs, other.outputs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Application(");
    boolean first = true;

    sb.append("commands:");
    if (this.commands == null) {
      sb.append("null");
    } else {
      sb.append(this.commands);
    }
    first = false;
    if (isSetInputs()) {
      if (!first) sb.append(", ");
      sb.append("inputs:");
      if (this.inputs == null) {
        sb.append("null");
      } else {
        sb.append(this.inputs);
      }
      first = false;
    }
    if (isSetOutputs()) {
      if (!first) sb.append(", ");
      sb.append("outputs:");
      if (this.outputs == null) {
        sb.append("null");
      } else {
        sb.append(this.outputs);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (commands == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'commands' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ApplicationStandardSchemeFactory implements SchemeFactory {
    public ApplicationStandardScheme getScheme() {
      return new ApplicationStandardScheme();
    }
  }

  private static class ApplicationStandardScheme extends StandardScheme<Application> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Application struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COMMANDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.commands = new ArrayList<String>(_list0.size);
                String _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = iprot.readString();
                  struct.commands.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setCommandsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // INPUTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list3 = iprot.readListBegin();
                struct.inputs = new ArrayList<Data>(_list3.size);
                Data _elem4;
                for (int _i5 = 0; _i5 < _list3.size; ++_i5)
                {
                  _elem4 = new Data();
                  _elem4.read(iprot);
                  struct.inputs.add(_elem4);
                }
                iprot.readListEnd();
              }
              struct.setInputsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // OUTPUTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list6 = iprot.readListBegin();
                struct.outputs = new ArrayList<Data>(_list6.size);
                Data _elem7;
                for (int _i8 = 0; _i8 < _list6.size; ++_i8)
                {
                  _elem7 = new Data();
                  _elem7.read(iprot);
                  struct.outputs.add(_elem7);
                }
                iprot.readListEnd();
              }
              struct.setOutputsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Application struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.commands != null) {
        oprot.writeFieldBegin(COMMANDS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.commands.size()));
          for (String _iter9 : struct.commands)
          {
            oprot.writeString(_iter9);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.inputs != null) {
        if (struct.isSetInputs()) {
          oprot.writeFieldBegin(INPUTS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.inputs.size()));
            for (Data _iter10 : struct.inputs)
            {
              _iter10.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.outputs != null) {
        if (struct.isSetOutputs()) {
          oprot.writeFieldBegin(OUTPUTS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.outputs.size()));
            for (Data _iter11 : struct.outputs)
            {
              _iter11.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ApplicationTupleSchemeFactory implements SchemeFactory {
    public ApplicationTupleScheme getScheme() {
      return new ApplicationTupleScheme();
    }
  }

  private static class ApplicationTupleScheme extends TupleScheme<Application> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Application struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.commands.size());
        for (String _iter12 : struct.commands)
        {
          oprot.writeString(_iter12);
        }
      }
      BitSet optionals = new BitSet();
      if (struct.isSetInputs()) {
        optionals.set(0);
      }
      if (struct.isSetOutputs()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetInputs()) {
        {
          oprot.writeI32(struct.inputs.size());
          for (Data _iter13 : struct.inputs)
          {
            _iter13.write(oprot);
          }
        }
      }
      if (struct.isSetOutputs()) {
        {
          oprot.writeI32(struct.outputs.size());
          for (Data _iter14 : struct.outputs)
          {
            _iter14.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Application struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list15 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
        struct.commands = new ArrayList<String>(_list15.size);
        String _elem16;
        for (int _i17 = 0; _i17 < _list15.size; ++_i17)
        {
          _elem16 = iprot.readString();
          struct.commands.add(_elem16);
        }
      }
      struct.setCommandsIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list18 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.inputs = new ArrayList<Data>(_list18.size);
          Data _elem19;
          for (int _i20 = 0; _i20 < _list18.size; ++_i20)
          {
            _elem19 = new Data();
            _elem19.read(iprot);
            struct.inputs.add(_elem19);
          }
        }
        struct.setInputsIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list21 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.outputs = new ArrayList<Data>(_list21.size);
          Data _elem22;
          for (int _i23 = 0; _i23 < _list21.size; ++_i23)
          {
            _elem22 = new Data();
            _elem22.read(iprot);
            struct.outputs.add(_elem22);
          }
        }
        struct.setOutputsIsSet(true);
      }
    }
  }

}

