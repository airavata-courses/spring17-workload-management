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
public class TaskContext implements org.apache.thrift.TBase<TaskContext, TaskContext._Fields>, java.io.Serializable, Cloneable, Comparable<TaskContext> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TaskContext");

  private static final org.apache.thrift.protocol.TField EXPERIMENT_FIELD_DESC = new org.apache.thrift.protocol.TField("experiment", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField TASK_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("taskId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField TARGET_MACHINE_FIELD_DESC = new org.apache.thrift.protocol.TField("targetMachine", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField LOCAL_STORAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("localStorage", org.apache.thrift.protocol.TType.STRUCT, (short)4);
  private static final org.apache.thrift.protocol.TField APPLICATION_FIELD_DESC = new org.apache.thrift.protocol.TField("application", org.apache.thrift.protocol.TType.STRUCT, (short)5);
  private static final org.apache.thrift.protocol.TField DATA_STAGING_DIRECTION_FIELD_DESC = new org.apache.thrift.protocol.TField("dataStagingDirection", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField QUEUE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("queueName", org.apache.thrift.protocol.TType.STRING, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TaskContextStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TaskContextTupleSchemeFactory());
  }

  public Experiment experiment; // required
  public String taskId; // required
  public TargetMachine targetMachine; // optional
  public LocalStorage localStorage; // optional
  public Application application; // optional
  /**
   * 
   * @see DataStagingDirection
   */
  public DataStagingDirection dataStagingDirection; // optional
  public String queueName; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EXPERIMENT((short)1, "experiment"),
    TASK_ID((short)2, "taskId"),
    TARGET_MACHINE((short)3, "targetMachine"),
    LOCAL_STORAGE((short)4, "localStorage"),
    APPLICATION((short)5, "application"),
    /**
     * 
     * @see DataStagingDirection
     */
    DATA_STAGING_DIRECTION((short)6, "dataStagingDirection"),
    QUEUE_NAME((short)7, "queueName");

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
        case 2: // TASK_ID
          return TASK_ID;
        case 3: // TARGET_MACHINE
          return TARGET_MACHINE;
        case 4: // LOCAL_STORAGE
          return LOCAL_STORAGE;
        case 5: // APPLICATION
          return APPLICATION;
        case 6: // DATA_STAGING_DIRECTION
          return DATA_STAGING_DIRECTION;
        case 7: // QUEUE_NAME
          return QUEUE_NAME;
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
  private static final _Fields optionals[] = {_Fields.TARGET_MACHINE,_Fields.LOCAL_STORAGE,_Fields.APPLICATION,_Fields.DATA_STAGING_DIRECTION,_Fields.QUEUE_NAME};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EXPERIMENT, new org.apache.thrift.meta_data.FieldMetaData("experiment", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Experiment.class)));
    tmpMap.put(_Fields.TASK_ID, new org.apache.thrift.meta_data.FieldMetaData("taskId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TARGET_MACHINE, new org.apache.thrift.meta_data.FieldMetaData("targetMachine", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TargetMachine.class)));
    tmpMap.put(_Fields.LOCAL_STORAGE, new org.apache.thrift.meta_data.FieldMetaData("localStorage", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, LocalStorage.class)));
    tmpMap.put(_Fields.APPLICATION, new org.apache.thrift.meta_data.FieldMetaData("application", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Application.class)));
    tmpMap.put(_Fields.DATA_STAGING_DIRECTION, new org.apache.thrift.meta_data.FieldMetaData("dataStagingDirection", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, DataStagingDirection.class)));
    tmpMap.put(_Fields.QUEUE_NAME, new org.apache.thrift.meta_data.FieldMetaData("queueName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TaskContext.class, metaDataMap);
  }

  public TaskContext() {
  }

  public TaskContext(
    Experiment experiment,
    String taskId)
  {
    this();
    this.experiment = experiment;
    this.taskId = taskId;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TaskContext(TaskContext other) {
    if (other.isSetExperiment()) {
      this.experiment = new Experiment(other.experiment);
    }
    if (other.isSetTaskId()) {
      this.taskId = other.taskId;
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
    if (other.isSetDataStagingDirection()) {
      this.dataStagingDirection = other.dataStagingDirection;
    }
    if (other.isSetQueueName()) {
      this.queueName = other.queueName;
    }
  }

  public TaskContext deepCopy() {
    return new TaskContext(this);
  }

  @Override
  public void clear() {
    this.experiment = null;
    this.taskId = null;
    this.targetMachine = null;
    this.localStorage = null;
    this.application = null;
    this.dataStagingDirection = null;
    this.queueName = null;
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

  public String getTaskId() {
    return this.taskId;
  }

  public TaskContext setTaskId(String taskId) {
    this.taskId = taskId;
    return this;
  }

  public void unsetTaskId() {
    this.taskId = null;
  }

  /** Returns true if field taskId is set (has been assigned a value) and false otherwise */
  public boolean isSetTaskId() {
    return this.taskId != null;
  }

  public void setTaskIdIsSet(boolean value) {
    if (!value) {
      this.taskId = null;
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

  /**
   * 
   * @see DataStagingDirection
   */
  public DataStagingDirection getDataStagingDirection() {
    return this.dataStagingDirection;
  }

  /**
   * 
   * @see DataStagingDirection
   */
  public TaskContext setDataStagingDirection(DataStagingDirection dataStagingDirection) {
    this.dataStagingDirection = dataStagingDirection;
    return this;
  }

  public void unsetDataStagingDirection() {
    this.dataStagingDirection = null;
  }

  /** Returns true if field dataStagingDirection is set (has been assigned a value) and false otherwise */
  public boolean isSetDataStagingDirection() {
    return this.dataStagingDirection != null;
  }

  public void setDataStagingDirectionIsSet(boolean value) {
    if (!value) {
      this.dataStagingDirection = null;
    }
  }

  public String getQueueName() {
    return this.queueName;
  }

  public TaskContext setQueueName(String queueName) {
    this.queueName = queueName;
    return this;
  }

  public void unsetQueueName() {
    this.queueName = null;
  }

  /** Returns true if field queueName is set (has been assigned a value) and false otherwise */
  public boolean isSetQueueName() {
    return this.queueName != null;
  }

  public void setQueueNameIsSet(boolean value) {
    if (!value) {
      this.queueName = null;
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

    case TASK_ID:
      if (value == null) {
        unsetTaskId();
      } else {
        setTaskId((String)value);
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

    case DATA_STAGING_DIRECTION:
      if (value == null) {
        unsetDataStagingDirection();
      } else {
        setDataStagingDirection((DataStagingDirection)value);
      }
      break;

    case QUEUE_NAME:
      if (value == null) {
        unsetQueueName();
      } else {
        setQueueName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case EXPERIMENT:
      return getExperiment();

    case TASK_ID:
      return getTaskId();

    case TARGET_MACHINE:
      return getTargetMachine();

    case LOCAL_STORAGE:
      return getLocalStorage();

    case APPLICATION:
      return getApplication();

    case DATA_STAGING_DIRECTION:
      return getDataStagingDirection();

    case QUEUE_NAME:
      return getQueueName();

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
    case TASK_ID:
      return isSetTaskId();
    case TARGET_MACHINE:
      return isSetTargetMachine();
    case LOCAL_STORAGE:
      return isSetLocalStorage();
    case APPLICATION:
      return isSetApplication();
    case DATA_STAGING_DIRECTION:
      return isSetDataStagingDirection();
    case QUEUE_NAME:
      return isSetQueueName();
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

    boolean this_present_taskId = true && this.isSetTaskId();
    boolean that_present_taskId = true && that.isSetTaskId();
    if (this_present_taskId || that_present_taskId) {
      if (!(this_present_taskId && that_present_taskId))
        return false;
      if (!this.taskId.equals(that.taskId))
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

    boolean this_present_dataStagingDirection = true && this.isSetDataStagingDirection();
    boolean that_present_dataStagingDirection = true && that.isSetDataStagingDirection();
    if (this_present_dataStagingDirection || that_present_dataStagingDirection) {
      if (!(this_present_dataStagingDirection && that_present_dataStagingDirection))
        return false;
      if (!this.dataStagingDirection.equals(that.dataStagingDirection))
        return false;
    }

    boolean this_present_queueName = true && this.isSetQueueName();
    boolean that_present_queueName = true && that.isSetQueueName();
    if (this_present_queueName || that_present_queueName) {
      if (!(this_present_queueName && that_present_queueName))
        return false;
      if (!this.queueName.equals(that.queueName))
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

    boolean present_taskId = true && (isSetTaskId());
    list.add(present_taskId);
    if (present_taskId)
      list.add(taskId);

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

    boolean present_dataStagingDirection = true && (isSetDataStagingDirection());
    list.add(present_dataStagingDirection);
    if (present_dataStagingDirection)
      list.add(dataStagingDirection.getValue());

    boolean present_queueName = true && (isSetQueueName());
    list.add(present_queueName);
    if (present_queueName)
      list.add(queueName);

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
    lastComparison = Boolean.valueOf(isSetTaskId()).compareTo(other.isSetTaskId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTaskId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.taskId, other.taskId);
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
    lastComparison = Boolean.valueOf(isSetDataStagingDirection()).compareTo(other.isSetDataStagingDirection());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDataStagingDirection()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dataStagingDirection, other.dataStagingDirection);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQueueName()).compareTo(other.isSetQueueName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQueueName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.queueName, other.queueName);
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
    if (!first) sb.append(", ");
    sb.append("taskId:");
    if (this.taskId == null) {
      sb.append("null");
    } else {
      sb.append(this.taskId);
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
    if (isSetDataStagingDirection()) {
      if (!first) sb.append(", ");
      sb.append("dataStagingDirection:");
      if (this.dataStagingDirection == null) {
        sb.append("null");
      } else {
        sb.append(this.dataStagingDirection);
      }
      first = false;
    }
    if (isSetQueueName()) {
      if (!first) sb.append(", ");
      sb.append("queueName:");
      if (this.queueName == null) {
        sb.append("null");
      } else {
        sb.append(this.queueName);
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
    if (taskId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'taskId' was not present! Struct: " + toString());
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
          case 2: // TASK_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.taskId = iprot.readString();
              struct.setTaskIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TARGET_MACHINE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.targetMachine = new TargetMachine();
              struct.targetMachine.read(iprot);
              struct.setTargetMachineIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // LOCAL_STORAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.localStorage = new LocalStorage();
              struct.localStorage.read(iprot);
              struct.setLocalStorageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // APPLICATION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.application = new Application();
              struct.application.read(iprot);
              struct.setApplicationIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // DATA_STAGING_DIRECTION
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.dataStagingDirection = org.apache.airavata.sga.commons.model.DataStagingDirection.findByValue(iprot.readI32());
              struct.setDataStagingDirectionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // QUEUE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.queueName = iprot.readString();
              struct.setQueueNameIsSet(true);
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
      if (struct.taskId != null) {
        oprot.writeFieldBegin(TASK_ID_FIELD_DESC);
        oprot.writeString(struct.taskId);
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
      if (struct.dataStagingDirection != null) {
        if (struct.isSetDataStagingDirection()) {
          oprot.writeFieldBegin(DATA_STAGING_DIRECTION_FIELD_DESC);
          oprot.writeI32(struct.dataStagingDirection.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.queueName != null) {
        if (struct.isSetQueueName()) {
          oprot.writeFieldBegin(QUEUE_NAME_FIELD_DESC);
          oprot.writeString(struct.queueName);
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
      oprot.writeString(struct.taskId);
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
      if (struct.isSetDataStagingDirection()) {
        optionals.set(3);
      }
      if (struct.isSetQueueName()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetTargetMachine()) {
        struct.targetMachine.write(oprot);
      }
      if (struct.isSetLocalStorage()) {
        struct.localStorage.write(oprot);
      }
      if (struct.isSetApplication()) {
        struct.application.write(oprot);
      }
      if (struct.isSetDataStagingDirection()) {
        oprot.writeI32(struct.dataStagingDirection.getValue());
      }
      if (struct.isSetQueueName()) {
        oprot.writeString(struct.queueName);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TaskContext struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.experiment = new Experiment();
      struct.experiment.read(iprot);
      struct.setExperimentIsSet(true);
      struct.taskId = iprot.readString();
      struct.setTaskIdIsSet(true);
      BitSet incoming = iprot.readBitSet(5);
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
      if (incoming.get(3)) {
        struct.dataStagingDirection = org.apache.airavata.sga.commons.model.DataStagingDirection.findByValue(iprot.readI32());
        struct.setDataStagingDirectionIsSet(true);
      }
      if (incoming.get(4)) {
        struct.queueName = iprot.readString();
        struct.setQueueNameIsSet(true);
      }
    }
  }

}

