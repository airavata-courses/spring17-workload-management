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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-02-22")
public class TaskContext implements org.apache.thrift.TBase<TaskContext, TaskContext._Fields>, java.io.Serializable, Cloneable, Comparable<TaskContext> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TaskContext");

  private static final org.apache.thrift.protocol.TField EXPERIMENT_FIELD_DESC = new org.apache.thrift.protocol.TField("experiment", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField TARGET_MACHINE_FIELD_DESC = new org.apache.thrift.protocol.TField("targetMachine", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField LOCAL_STORAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("localStorage", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField APPLICATION_FIELD_DESC = new org.apache.thrift.protocol.TField("application", org.apache.thrift.protocol.TType.STRUCT, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TaskContextStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TaskContextTupleSchemeFactory());
  }

  public Experiment experiment; // required
  public TargetMachine targetMachine; // optional
  public LocalStorage localStorage; // optional
  public Application application; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EXPERIMENT((short)1, "experiment"),
    TARGET_MACHINE((short)2, "targetMachine"),
    LOCAL_STORAGE((short)3, "localStorage"),
    APPLICATION((short)4, "application");

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
        case 1: // EXPERIMENT
          return EXPERIMENT;
        case 2: // TARGET_MACHINE
          return TARGET_MACHINE;
        case 3: // LOCAL_STORAGE
          return LOCAL_STORAGE;
        case 4: // APPLICATION
          return APPLICATION;
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
  private static final _Fields optionals[] = {_Fields.TARGET_MACHINE,_Fields.LOCAL_STORAGE,_Fields.APPLICATION};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EXPERIMENT, new org.apache.thrift.meta_data.FieldMetaData("experiment", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Experiment.class)));
    tmpMap.put(_Fields.TARGET_MACHINE, new org.apache.thrift.meta_data.FieldMetaData("targetMachine", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TargetMachine.class)));
    tmpMap.put(_Fields.LOCAL_STORAGE, new org.apache.thrift.meta_data.FieldMetaData("localStorage", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, LocalStorage.class)));
    tmpMap.put(_Fields.APPLICATION, new org.apache.thrift.meta_data.FieldMetaData("application", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Application.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TaskContext.class, metaDataMap);
  }

  public TaskContext() {
  }

  public TaskContext(
    Experiment experiment)
  {
    this();
    this.experiment = experiment;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TaskContext(TaskContext other) {
    if (other.isSetExperiment()) {
      this.experiment = new Experiment(other.experiment);
    }
    if (other.isSetTargetMachine()) {
      this.targetMachine = new TargetMachine(other.targetMachine);
    }
    if (other.isSetLocalStorage()) {
      this.localStorage = new LocalStorage(other.localStorage);
    }
    if (other.isSetApplication()) {
      this.application = new Application(other.application);
    }
  }

  public TaskContext deepCopy() {
    return new TaskContext(this);
  }

  @Override
  public void clear() {
    this.experiment = null;
    this.targetMachine = null;
    this.localStorage = null;
    this.application = null;
  }

  public Experiment getExperiment() {
    return this.experiment;
  }

  public TaskContext setExperiment(Experiment experiment) {
    this.experiment = experiment;
    return this;
  }

  public void unsetExperiment() {
    this.experiment = null;
  }

  /** Returns true if field experiment is set (has been assigned a value) and false otherwise */
  public boolean isSetExperiment() {
    return this.experiment != null;
  }

  public void setExperimentIsSet(boolean value) {
    if (!value) {
      this.experiment = null;
    }
  }

  public TargetMachine getTargetMachine() {
    return this.targetMachine;
  }

  public TaskContext setTargetMachine(TargetMachine targetMachine) {
    this.targetMachine = targetMachine;
    return this;
  }

  public void unsetTargetMachine() {
    this.targetMachine = null;
  }

  /** Returns true if field targetMachine is set (has been assigned a value) and false otherwise */
  public boolean isSetTargetMachine() {
    return this.targetMachine != null;
  }

  public void setTargetMachineIsSet(boolean value) {
    if (!value) {
      this.targetMachine = null;
    }
  }

  public LocalStorage getLocalStorage() {
    return this.localStorage;
  }

  public TaskContext setLocalStorage(LocalStorage localStorage) {
    this.localStorage = localStorage;
    return this;
  }

  public void unsetLocalStorage() {
    this.localStorage = null;
  }

  /** Returns true if field localStorage is set (has been assigned a value) and false otherwise */
  public boolean isSetLocalStorage() {
    return this.localStorage != null;
  }

  public void setLocalStorageIsSet(boolean value) {
    if (!value) {
      this.localStorage = null;
    }
  }

  public Application getApplication() {
    return this.application;
  }

  public TaskContext setApplication(Application application) {
    this.application = application;
    return this;
  }

  public void unsetApplication() {
    this.application = null;
  }

  /** Returns true if field application is set (has been assigned a value) and false otherwise */
  public boolean isSetApplication() {
    return this.application != null;
  }

  public void setApplicationIsSet(boolean value) {
    if (!value) {
      this.application = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case EXPERIMENT:
      if (value == null) {
        unsetExperiment();
      } else {
        setExperiment((Experiment)value);
      }
      break;

    case TARGET_MACHINE:
      if (value == null) {
        unsetTargetMachine();
      } else {
        setTargetMachine((TargetMachine)value);
      }
      break;

    case LOCAL_STORAGE:
      if (value == null) {
        unsetLocalStorage();
      } else {
        setLocalStorage((LocalStorage)value);
      }
      break;

    case APPLICATION:
      if (value == null) {
        unsetApplication();
      } else {
        setApplication((Application)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case EXPERIMENT:
      return getExperiment();

    case TARGET_MACHINE:
      return getTargetMachine();

    case LOCAL_STORAGE:
      return getLocalStorage();

    case APPLICATION:
      return getApplication();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case EXPERIMENT:
      return isSetExperiment();
    case TARGET_MACHINE:
      return isSetTargetMachine();
    case LOCAL_STORAGE:
      return isSetLocalStorage();
    case APPLICATION:
      return isSetApplication();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TaskContext)
      return this.equals((TaskContext)that);
    return false;
  }

  public boolean equals(TaskContext that) {
    if (that == null)
      return false;

    boolean this_present_experiment = true && this.isSetExperiment();
    boolean that_present_experiment = true && that.isSetExperiment();
    if (this_present_experiment || that_present_experiment) {
      if (!(this_present_experiment && that_present_experiment))
        return false;
      if (!this.experiment.equals(that.experiment))
        return false;
    }

    boolean this_present_targetMachine = true && this.isSetTargetMachine();
    boolean that_present_targetMachine = true && that.isSetTargetMachine();
    if (this_present_targetMachine || that_present_targetMachine) {
      if (!(this_present_targetMachine && that_present_targetMachine))
        return false;
      if (!this.targetMachine.equals(that.targetMachine))
        return false;
    }

    boolean this_present_localStorage = true && this.isSetLocalStorage();
    boolean that_present_localStorage = true && that.isSetLocalStorage();
    if (this_present_localStorage || that_present_localStorage) {
      if (!(this_present_localStorage && that_present_localStorage))
        return false;
      if (!this.localStorage.equals(that.localStorage))
        return false;
    }

    boolean this_present_application = true && this.isSetApplication();
    boolean that_present_application = true && that.isSetApplication();
    if (this_present_application || that_present_application) {
      if (!(this_present_application && that_present_application))
        return false;
      if (!this.application.equals(that.application))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_experiment = true && (isSetExperiment());
    list.add(present_experiment);
    if (present_experiment)
      list.add(experiment);

    boolean present_targetMachine = true && (isSetTargetMachine());
    list.add(present_targetMachine);
    if (present_targetMachine)
      list.add(targetMachine);

    boolean present_localStorage = true && (isSetLocalStorage());
    list.add(present_localStorage);
    if (present_localStorage)
      list.add(localStorage);

    boolean present_application = true && (isSetApplication());
    list.add(present_application);
    if (present_application)
      list.add(application);

    return list.hashCode();
  }

  @Override
  public int compareTo(TaskContext other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetExperiment()).compareTo(other.isSetExperiment());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExperiment()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.experiment, other.experiment);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTargetMachine()).compareTo(other.isSetTargetMachine());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTargetMachine()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.targetMachine, other.targetMachine);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLocalStorage()).compareTo(other.isSetLocalStorage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLocalStorage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.localStorage, other.localStorage);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetApplication()).compareTo(other.isSetApplication());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetApplication()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.application, other.application);
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
    StringBuilder sb = new StringBuilder("TaskContext(");
    boolean first = true;

    sb.append("experiment:");
    if (this.experiment == null) {
      sb.append("null");
    } else {
      sb.append(this.experiment);
    }
    first = false;
    if (isSetTargetMachine()) {
      if (!first) sb.append(", ");
      sb.append("targetMachine:");
      if (this.targetMachine == null) {
        sb.append("null");
      } else {
        sb.append(this.targetMachine);
      }
      first = false;
    }
    if (isSetLocalStorage()) {
      if (!first) sb.append(", ");
      sb.append("localStorage:");
      if (this.localStorage == null) {
        sb.append("null");
      } else {
        sb.append(this.localStorage);
      }
      first = false;
    }
    if (isSetApplication()) {
      if (!first) sb.append(", ");
      sb.append("application:");
      if (this.application == null) {
        sb.append("null");
      } else {
        sb.append(this.application);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (experiment == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'experiment' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (experiment != null) {
      experiment.validate();
    }
    if (targetMachine != null) {
      targetMachine.validate();
    }
    if (localStorage != null) {
      localStorage.validate();
    }
    if (application != null) {
      application.validate();
    }
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

  private static class TaskContextStandardSchemeFactory implements SchemeFactory {
    public TaskContextStandardScheme getScheme() {
      return new TaskContextStandardScheme();
    }
  }

  private static class TaskContextStandardScheme extends StandardScheme<TaskContext> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TaskContext struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EXPERIMENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.experiment = new Experiment();
              struct.experiment.read(iprot);
              struct.setExperimentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TARGET_MACHINE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.targetMachine = new TargetMachine();
              struct.targetMachine.read(iprot);
              struct.setTargetMachineIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // LOCAL_STORAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.localStorage = new LocalStorage();
              struct.localStorage.read(iprot);
              struct.setLocalStorageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // APPLICATION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.application = new Application();
              struct.application.read(iprot);
              struct.setApplicationIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TaskContext struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.experiment != null) {
        oprot.writeFieldBegin(EXPERIMENT_FIELD_DESC);
        struct.experiment.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.targetMachine != null) {
        if (struct.isSetTargetMachine()) {
          oprot.writeFieldBegin(TARGET_MACHINE_FIELD_DESC);
          struct.targetMachine.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.localStorage != null) {
        if (struct.isSetLocalStorage()) {
          oprot.writeFieldBegin(LOCAL_STORAGE_FIELD_DESC);
          struct.localStorage.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.application != null) {
        if (struct.isSetApplication()) {
          oprot.writeFieldBegin(APPLICATION_FIELD_DESC);
          struct.application.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TaskContextTupleSchemeFactory implements SchemeFactory {
    public TaskContextTupleScheme getScheme() {
      return new TaskContextTupleScheme();
    }
  }

  private static class TaskContextTupleScheme extends TupleScheme<TaskContext> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TaskContext struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      struct.experiment.write(oprot);
      BitSet optionals = new BitSet();
      if (struct.isSetTargetMachine()) {
        optionals.set(0);
      }
      if (struct.isSetLocalStorage()) {
        optionals.set(1);
      }
      if (struct.isSetApplication()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetTargetMachine()) {
        struct.targetMachine.write(oprot);
      }
      if (struct.isSetLocalStorage()) {
        struct.localStorage.write(oprot);
      }
      if (struct.isSetApplication()) {
        struct.application.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TaskContext struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.experiment = new Experiment();
      struct.experiment.read(iprot);
      struct.setExperimentIsSet(true);
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.targetMachine = new TargetMachine();
        struct.targetMachine.read(iprot);
        struct.setTargetMachineIsSet(true);
      }
      if (incoming.get(1)) {
        struct.localStorage = new LocalStorage();
        struct.localStorage.read(iprot);
        struct.setLocalStorageIsSet(true);
      }
      if (incoming.get(2)) {
        struct.application = new Application();
        struct.application.read(iprot);
        struct.setApplicationIsSet(true);
      }
    }
  }

}

