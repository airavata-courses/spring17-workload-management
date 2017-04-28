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
package org.apache.airavata.sga.commons.db.model;

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
public class TaskStateEntity implements org.apache.thrift.TBase<TaskStateEntity, TaskStateEntity._Fields>, java.io.Serializable, Cloneable, Comparable<TaskStateEntity> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TaskStateEntity");

  private static final org.apache.thrift.protocol.TField TASK_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("taskId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TASK_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("taskName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField TASK_START_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("taskStartTime", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField TASK_END_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("taskEndTime", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField TASK_LAST_UPDATED_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("taskLastUpdatedTime", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField EXPERIMENT_FIELD_DESC = new org.apache.thrift.protocol.TField("experiment", org.apache.thrift.protocol.TType.STRUCT, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TaskStateEntityStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TaskStateEntityTupleSchemeFactory());
  }

  public String taskId; // required
  public String taskName; // required
  public long taskStartTime; // required
  public long taskEndTime; // optional
  public long taskLastUpdatedTime; // optional
  public ExperimentEntity experiment; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TASK_ID((short)1, "taskId"),
    TASK_NAME((short)2, "taskName"),
    TASK_START_TIME((short)3, "taskStartTime"),
    TASK_END_TIME((short)4, "taskEndTime"),
    TASK_LAST_UPDATED_TIME((short)5, "taskLastUpdatedTime"),
    EXPERIMENT((short)6, "experiment");

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
        case 1: // TASK_ID
          return TASK_ID;
        case 2: // TASK_NAME
          return TASK_NAME;
        case 3: // TASK_START_TIME
          return TASK_START_TIME;
        case 4: // TASK_END_TIME
          return TASK_END_TIME;
        case 5: // TASK_LAST_UPDATED_TIME
          return TASK_LAST_UPDATED_TIME;
        case 6: // EXPERIMENT
          return EXPERIMENT;
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
  private static final int __TASKSTARTTIME_ISSET_ID = 0;
  private static final int __TASKENDTIME_ISSET_ID = 1;
  private static final int __TASKLASTUPDATEDTIME_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TASK_END_TIME,_Fields.TASK_LAST_UPDATED_TIME};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TASK_ID, new org.apache.thrift.meta_data.FieldMetaData("taskId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TASK_NAME, new org.apache.thrift.meta_data.FieldMetaData("taskName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TASK_START_TIME, new org.apache.thrift.meta_data.FieldMetaData("taskStartTime", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.TASK_END_TIME, new org.apache.thrift.meta_data.FieldMetaData("taskEndTime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.TASK_LAST_UPDATED_TIME, new org.apache.thrift.meta_data.FieldMetaData("taskLastUpdatedTime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.EXPERIMENT, new org.apache.thrift.meta_data.FieldMetaData("experiment", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ExperimentEntity.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TaskStateEntity.class, metaDataMap);
  }

  public TaskStateEntity() {
  }

  public TaskStateEntity(
    String taskId,
    String taskName,
    long taskStartTime,
    ExperimentEntity experiment)
  {
    this();
    this.taskId = taskId;
    this.taskName = taskName;
    this.taskStartTime = taskStartTime;
    setTaskStartTimeIsSet(true);
    this.experiment = experiment;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TaskStateEntity(TaskStateEntity other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetTaskId()) {
      this.taskId = other.taskId;
    }
    if (other.isSetTaskName()) {
      this.taskName = other.taskName;
    }
    this.taskStartTime = other.taskStartTime;
    this.taskEndTime = other.taskEndTime;
    this.taskLastUpdatedTime = other.taskLastUpdatedTime;
    if (other.isSetExperiment()) {
      this.experiment = new ExperimentEntity(other.experiment);
    }
  }

  public TaskStateEntity deepCopy() {
    return new TaskStateEntity(this);
  }

  @Override
  public void clear() {
    this.taskId = null;
    this.taskName = null;
    setTaskStartTimeIsSet(false);
    this.taskStartTime = 0;
    setTaskEndTimeIsSet(false);
    this.taskEndTime = 0;
    setTaskLastUpdatedTimeIsSet(false);
    this.taskLastUpdatedTime = 0;
    this.experiment = null;
  }

  public String getTaskId() {
    return this.taskId;
  }

  public TaskStateEntity setTaskId(String taskId) {
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

  public String getTaskName() {
    return this.taskName;
  }

  public TaskStateEntity setTaskName(String taskName) {
    this.taskName = taskName;
    return this;
  }

  public void unsetTaskName() {
    this.taskName = null;
  }

  /** Returns true if field taskName is set (has been assigned a value) and false otherwise */
  public boolean isSetTaskName() {
    return this.taskName != null;
  }

  public void setTaskNameIsSet(boolean value) {
    if (!value) {
      this.taskName = null;
    }
  }

  public long getTaskStartTime() {
    return this.taskStartTime;
  }

  public TaskStateEntity setTaskStartTime(long taskStartTime) {
    this.taskStartTime = taskStartTime;
    setTaskStartTimeIsSet(true);
    return this;
  }

  public void unsetTaskStartTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TASKSTARTTIME_ISSET_ID);
  }

  /** Returns true if field taskStartTime is set (has been assigned a value) and false otherwise */
  public boolean isSetTaskStartTime() {
    return EncodingUtils.testBit(__isset_bitfield, __TASKSTARTTIME_ISSET_ID);
  }

  public void setTaskStartTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TASKSTARTTIME_ISSET_ID, value);
  }

  public long getTaskEndTime() {
    return this.taskEndTime;
  }

  public TaskStateEntity setTaskEndTime(long taskEndTime) {
    this.taskEndTime = taskEndTime;
    setTaskEndTimeIsSet(true);
    return this;
  }

  public void unsetTaskEndTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TASKENDTIME_ISSET_ID);
  }

  /** Returns true if field taskEndTime is set (has been assigned a value) and false otherwise */
  public boolean isSetTaskEndTime() {
    return EncodingUtils.testBit(__isset_bitfield, __TASKENDTIME_ISSET_ID);
  }

  public void setTaskEndTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TASKENDTIME_ISSET_ID, value);
  }

  public long getTaskLastUpdatedTime() {
    return this.taskLastUpdatedTime;
  }

  public TaskStateEntity setTaskLastUpdatedTime(long taskLastUpdatedTime) {
    this.taskLastUpdatedTime = taskLastUpdatedTime;
    setTaskLastUpdatedTimeIsSet(true);
    return this;
  }

  public void unsetTaskLastUpdatedTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TASKLASTUPDATEDTIME_ISSET_ID);
  }

  /** Returns true if field taskLastUpdatedTime is set (has been assigned a value) and false otherwise */
  public boolean isSetTaskLastUpdatedTime() {
    return EncodingUtils.testBit(__isset_bitfield, __TASKLASTUPDATEDTIME_ISSET_ID);
  }

  public void setTaskLastUpdatedTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TASKLASTUPDATEDTIME_ISSET_ID, value);
  }

  public ExperimentEntity getExperiment() {
    return this.experiment;
  }

  public TaskStateEntity setExperiment(ExperimentEntity experiment) {
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

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TASK_ID:
      if (value == null) {
        unsetTaskId();
      } else {
        setTaskId((String)value);
      }
      break;

    case TASK_NAME:
      if (value == null) {
        unsetTaskName();
      } else {
        setTaskName((String)value);
      }
      break;

    case TASK_START_TIME:
      if (value == null) {
        unsetTaskStartTime();
      } else {
        setTaskStartTime((Long)value);
      }
      break;

    case TASK_END_TIME:
      if (value == null) {
        unsetTaskEndTime();
      } else {
        setTaskEndTime((Long)value);
      }
      break;

    case TASK_LAST_UPDATED_TIME:
      if (value == null) {
        unsetTaskLastUpdatedTime();
      } else {
        setTaskLastUpdatedTime((Long)value);
      }
      break;

    case EXPERIMENT:
      if (value == null) {
        unsetExperiment();
      } else {
        setExperiment((ExperimentEntity)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TASK_ID:
      return getTaskId();

    case TASK_NAME:
      return getTaskName();

    case TASK_START_TIME:
      return getTaskStartTime();

    case TASK_END_TIME:
      return getTaskEndTime();

    case TASK_LAST_UPDATED_TIME:
      return getTaskLastUpdatedTime();

    case EXPERIMENT:
      return getExperiment();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TASK_ID:
      return isSetTaskId();
    case TASK_NAME:
      return isSetTaskName();
    case TASK_START_TIME:
      return isSetTaskStartTime();
    case TASK_END_TIME:
      return isSetTaskEndTime();
    case TASK_LAST_UPDATED_TIME:
      return isSetTaskLastUpdatedTime();
    case EXPERIMENT:
      return isSetExperiment();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TaskStateEntity)
      return this.equals((TaskStateEntity)that);
    return false;
  }

  public boolean equals(TaskStateEntity that) {
    if (that == null)
      return false;

    boolean this_present_taskId = true && this.isSetTaskId();
    boolean that_present_taskId = true && that.isSetTaskId();
    if (this_present_taskId || that_present_taskId) {
      if (!(this_present_taskId && that_present_taskId))
        return false;
      if (!this.taskId.equals(that.taskId))
        return false;
    }

    boolean this_present_taskName = true && this.isSetTaskName();
    boolean that_present_taskName = true && that.isSetTaskName();
    if (this_present_taskName || that_present_taskName) {
      if (!(this_present_taskName && that_present_taskName))
        return false;
      if (!this.taskName.equals(that.taskName))
        return false;
    }

    boolean this_present_taskStartTime = true;
    boolean that_present_taskStartTime = true;
    if (this_present_taskStartTime || that_present_taskStartTime) {
      if (!(this_present_taskStartTime && that_present_taskStartTime))
        return false;
      if (this.taskStartTime != that.taskStartTime)
        return false;
    }

    boolean this_present_taskEndTime = true && this.isSetTaskEndTime();
    boolean that_present_taskEndTime = true && that.isSetTaskEndTime();
    if (this_present_taskEndTime || that_present_taskEndTime) {
      if (!(this_present_taskEndTime && that_present_taskEndTime))
        return false;
      if (this.taskEndTime != that.taskEndTime)
        return false;
    }

    boolean this_present_taskLastUpdatedTime = true && this.isSetTaskLastUpdatedTime();
    boolean that_present_taskLastUpdatedTime = true && that.isSetTaskLastUpdatedTime();
    if (this_present_taskLastUpdatedTime || that_present_taskLastUpdatedTime) {
      if (!(this_present_taskLastUpdatedTime && that_present_taskLastUpdatedTime))
        return false;
      if (this.taskLastUpdatedTime != that.taskLastUpdatedTime)
        return false;
    }

    boolean this_present_experiment = true && this.isSetExperiment();
    boolean that_present_experiment = true && that.isSetExperiment();
    if (this_present_experiment || that_present_experiment) {
      if (!(this_present_experiment && that_present_experiment))
        return false;
      if (!this.experiment.equals(that.experiment))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_taskId = true && (isSetTaskId());
    list.add(present_taskId);
    if (present_taskId)
      list.add(taskId);

    boolean present_taskName = true && (isSetTaskName());
    list.add(present_taskName);
    if (present_taskName)
      list.add(taskName);

    boolean present_taskStartTime = true;
    list.add(present_taskStartTime);
    if (present_taskStartTime)
      list.add(taskStartTime);

    boolean present_taskEndTime = true && (isSetTaskEndTime());
    list.add(present_taskEndTime);
    if (present_taskEndTime)
      list.add(taskEndTime);

    boolean present_taskLastUpdatedTime = true && (isSetTaskLastUpdatedTime());
    list.add(present_taskLastUpdatedTime);
    if (present_taskLastUpdatedTime)
      list.add(taskLastUpdatedTime);

    boolean present_experiment = true && (isSetExperiment());
    list.add(present_experiment);
    if (present_experiment)
      list.add(experiment);

    return list.hashCode();
  }

  @Override
  public int compareTo(TaskStateEntity other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = Boolean.valueOf(isSetTaskName()).compareTo(other.isSetTaskName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTaskName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.taskName, other.taskName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTaskStartTime()).compareTo(other.isSetTaskStartTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTaskStartTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.taskStartTime, other.taskStartTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTaskEndTime()).compareTo(other.isSetTaskEndTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTaskEndTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.taskEndTime, other.taskEndTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTaskLastUpdatedTime()).compareTo(other.isSetTaskLastUpdatedTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTaskLastUpdatedTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.taskLastUpdatedTime, other.taskLastUpdatedTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    StringBuilder sb = new StringBuilder("TaskStateEntity(");
    boolean first = true;

    sb.append("taskId:");
    if (this.taskId == null) {
      sb.append("null");
    } else {
      sb.append(this.taskId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("taskName:");
    if (this.taskName == null) {
      sb.append("null");
    } else {
      sb.append(this.taskName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("taskStartTime:");
    sb.append(this.taskStartTime);
    first = false;
    if (isSetTaskEndTime()) {
      if (!first) sb.append(", ");
      sb.append("taskEndTime:");
      sb.append(this.taskEndTime);
      first = false;
    }
    if (isSetTaskLastUpdatedTime()) {
      if (!first) sb.append(", ");
      sb.append("taskLastUpdatedTime:");
      sb.append(this.taskLastUpdatedTime);
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("experiment:");
    if (this.experiment == null) {
      sb.append("null");
    } else {
      sb.append(this.experiment);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (taskId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'taskId' was not present! Struct: " + toString());
    }
    if (taskName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'taskName' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'taskStartTime' because it's a primitive and you chose the non-beans generator.
    if (experiment == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'experiment' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (experiment != null) {
      experiment.validate();
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TaskStateEntityStandardSchemeFactory implements SchemeFactory {
    public TaskStateEntityStandardScheme getScheme() {
      return new TaskStateEntityStandardScheme();
    }
  }

  private static class TaskStateEntityStandardScheme extends StandardScheme<TaskStateEntity> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TaskStateEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TASK_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.taskId = iprot.readString();
              struct.setTaskIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TASK_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.taskName = iprot.readString();
              struct.setTaskNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TASK_START_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.taskStartTime = iprot.readI64();
              struct.setTaskStartTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TASK_END_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.taskEndTime = iprot.readI64();
              struct.setTaskEndTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TASK_LAST_UPDATED_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.taskLastUpdatedTime = iprot.readI64();
              struct.setTaskLastUpdatedTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // EXPERIMENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.experiment = new ExperimentEntity();
              struct.experiment.read(iprot);
              struct.setExperimentIsSet(true);
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
      if (!struct.isSetTaskStartTime()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'taskStartTime' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TaskStateEntity struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.taskId != null) {
        oprot.writeFieldBegin(TASK_ID_FIELD_DESC);
        oprot.writeString(struct.taskId);
        oprot.writeFieldEnd();
      }
      if (struct.taskName != null) {
        oprot.writeFieldBegin(TASK_NAME_FIELD_DESC);
        oprot.writeString(struct.taskName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(TASK_START_TIME_FIELD_DESC);
      oprot.writeI64(struct.taskStartTime);
      oprot.writeFieldEnd();
      if (struct.isSetTaskEndTime()) {
        oprot.writeFieldBegin(TASK_END_TIME_FIELD_DESC);
        oprot.writeI64(struct.taskEndTime);
        oprot.writeFieldEnd();
      }
      if (struct.isSetTaskLastUpdatedTime()) {
        oprot.writeFieldBegin(TASK_LAST_UPDATED_TIME_FIELD_DESC);
        oprot.writeI64(struct.taskLastUpdatedTime);
        oprot.writeFieldEnd();
      }
      if (struct.experiment != null) {
        oprot.writeFieldBegin(EXPERIMENT_FIELD_DESC);
        struct.experiment.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TaskStateEntityTupleSchemeFactory implements SchemeFactory {
    public TaskStateEntityTupleScheme getScheme() {
      return new TaskStateEntityTupleScheme();
    }
  }

  private static class TaskStateEntityTupleScheme extends TupleScheme<TaskStateEntity> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TaskStateEntity struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.taskId);
      oprot.writeString(struct.taskName);
      oprot.writeI64(struct.taskStartTime);
      struct.experiment.write(oprot);
      BitSet optionals = new BitSet();
      if (struct.isSetTaskEndTime()) {
        optionals.set(0);
      }
      if (struct.isSetTaskLastUpdatedTime()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetTaskEndTime()) {
        oprot.writeI64(struct.taskEndTime);
      }
      if (struct.isSetTaskLastUpdatedTime()) {
        oprot.writeI64(struct.taskLastUpdatedTime);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TaskStateEntity struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.taskId = iprot.readString();
      struct.setTaskIdIsSet(true);
      struct.taskName = iprot.readString();
      struct.setTaskNameIsSet(true);
      struct.taskStartTime = iprot.readI64();
      struct.setTaskStartTimeIsSet(true);
      struct.experiment = new ExperimentEntity();
      struct.experiment.read(iprot);
      struct.setExperimentIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.taskEndTime = iprot.readI64();
        struct.setTaskEndTimeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.taskLastUpdatedTime = iprot.readI64();
        struct.setTaskLastUpdatedTimeIsSet(true);
      }
    }
  }

}
