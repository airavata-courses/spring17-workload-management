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
public class ExperimentEntity implements org.apache.thrift.TBase<ExperimentEntity, ExperimentEntity._Fields>, java.io.Serializable, Cloneable, Comparable<ExperimentEntity> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ExperimentEntity");

  private static final org.apache.thrift.protocol.TField EXPERIMENT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("experimentId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField EXPERIMENT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("experimentName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField EXPERIMENT_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("experimentStatus", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField EXPERIMENT_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("experimentType", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField EXPERIMENT_START_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("experimentStartTime", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField EXPERIMENT_END_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("experimentEndTime", org.apache.thrift.protocol.TType.I64, (short)6);
  private static final org.apache.thrift.protocol.TField EXPERIMENT_LAST_UPDATED_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("experimentLastUpdatedTime", org.apache.thrift.protocol.TType.I64, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ExperimentEntityStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ExperimentEntityTupleSchemeFactory());
  }

  public String experimentId; // required
  public String experimentName; // required
  public String experimentStatus; // required
  public String experimentType; // required
  public long experimentStartTime; // required
  public long experimentEndTime; // optional
  public long experimentLastUpdatedTime; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EXPERIMENT_ID((short)1, "experimentId"),
    EXPERIMENT_NAME((short)2, "experimentName"),
    EXPERIMENT_STATUS((short)3, "experimentStatus"),
    EXPERIMENT_TYPE((short)4, "experimentType"),
    EXPERIMENT_START_TIME((short)5, "experimentStartTime"),
    EXPERIMENT_END_TIME((short)6, "experimentEndTime"),
    EXPERIMENT_LAST_UPDATED_TIME((short)7, "experimentLastUpdatedTime");

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
        case 1: // EXPERIMENT_ID
          return EXPERIMENT_ID;
        case 2: // EXPERIMENT_NAME
          return EXPERIMENT_NAME;
        case 3: // EXPERIMENT_STATUS
          return EXPERIMENT_STATUS;
        case 4: // EXPERIMENT_TYPE
          return EXPERIMENT_TYPE;
        case 5: // EXPERIMENT_START_TIME
          return EXPERIMENT_START_TIME;
        case 6: // EXPERIMENT_END_TIME
          return EXPERIMENT_END_TIME;
        case 7: // EXPERIMENT_LAST_UPDATED_TIME
          return EXPERIMENT_LAST_UPDATED_TIME;
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
  private static final int __EXPERIMENTSTARTTIME_ISSET_ID = 0;
  private static final int __EXPERIMENTENDTIME_ISSET_ID = 1;
  private static final int __EXPERIMENTLASTUPDATEDTIME_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.EXPERIMENT_END_TIME,_Fields.EXPERIMENT_LAST_UPDATED_TIME};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EXPERIMENT_ID, new org.apache.thrift.meta_data.FieldMetaData("experimentId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EXPERIMENT_NAME, new org.apache.thrift.meta_data.FieldMetaData("experimentName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EXPERIMENT_STATUS, new org.apache.thrift.meta_data.FieldMetaData("experimentStatus", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EXPERIMENT_TYPE, new org.apache.thrift.meta_data.FieldMetaData("experimentType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EXPERIMENT_START_TIME, new org.apache.thrift.meta_data.FieldMetaData("experimentStartTime", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.EXPERIMENT_END_TIME, new org.apache.thrift.meta_data.FieldMetaData("experimentEndTime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.EXPERIMENT_LAST_UPDATED_TIME, new org.apache.thrift.meta_data.FieldMetaData("experimentLastUpdatedTime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ExperimentEntity.class, metaDataMap);
  }

  public ExperimentEntity() {
  }

  public ExperimentEntity(
    String experimentId,
    String experimentName,
    String experimentStatus,
    String experimentType,
    long experimentStartTime)
  {
    this();
    this.experimentId = experimentId;
    this.experimentName = experimentName;
    this.experimentStatus = experimentStatus;
    this.experimentType = experimentType;
    this.experimentStartTime = experimentStartTime;
    setExperimentStartTimeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ExperimentEntity(ExperimentEntity other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetExperimentId()) {
      this.experimentId = other.experimentId;
    }
    if (other.isSetExperimentName()) {
      this.experimentName = other.experimentName;
    }
    if (other.isSetExperimentStatus()) {
      this.experimentStatus = other.experimentStatus;
    }
    if (other.isSetExperimentType()) {
      this.experimentType = other.experimentType;
    }
    this.experimentStartTime = other.experimentStartTime;
    this.experimentEndTime = other.experimentEndTime;
    this.experimentLastUpdatedTime = other.experimentLastUpdatedTime;
  }

  public ExperimentEntity deepCopy() {
    return new ExperimentEntity(this);
  }

  @Override
  public void clear() {
    this.experimentId = null;
    this.experimentName = null;
    this.experimentStatus = null;
    this.experimentType = null;
    setExperimentStartTimeIsSet(false);
    this.experimentStartTime = 0;
    setExperimentEndTimeIsSet(false);
    this.experimentEndTime = 0;
    setExperimentLastUpdatedTimeIsSet(false);
    this.experimentLastUpdatedTime = 0;
  }

  public String getExperimentId() {
    return this.experimentId;
  }

  public ExperimentEntity setExperimentId(String experimentId) {
    this.experimentId = experimentId;
    return this;
  }

  public void unsetExperimentId() {
    this.experimentId = null;
  }

  /** Returns true if field experimentId is set (has been assigned a value) and false otherwise */
  public boolean isSetExperimentId() {
    return this.experimentId != null;
  }

  public void setExperimentIdIsSet(boolean value) {
    if (!value) {
      this.experimentId = null;
    }
  }

  public String getExperimentName() {
    return this.experimentName;
  }

  public ExperimentEntity setExperimentName(String experimentName) {
    this.experimentName = experimentName;
    return this;
  }

  public void unsetExperimentName() {
    this.experimentName = null;
  }

  /** Returns true if field experimentName is set (has been assigned a value) and false otherwise */
  public boolean isSetExperimentName() {
    return this.experimentName != null;
  }

  public void setExperimentNameIsSet(boolean value) {
    if (!value) {
      this.experimentName = null;
    }
  }

  public String getExperimentStatus() {
    return this.experimentStatus;
  }

  public ExperimentEntity setExperimentStatus(String experimentStatus) {
    this.experimentStatus = experimentStatus;
    return this;
  }

  public void unsetExperimentStatus() {
    this.experimentStatus = null;
  }

  /** Returns true if field experimentStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetExperimentStatus() {
    return this.experimentStatus != null;
  }

  public void setExperimentStatusIsSet(boolean value) {
    if (!value) {
      this.experimentStatus = null;
    }
  }

  public String getExperimentType() {
    return this.experimentType;
  }

  public ExperimentEntity setExperimentType(String experimentType) {
    this.experimentType = experimentType;
    return this;
  }

  public void unsetExperimentType() {
    this.experimentType = null;
  }

  /** Returns true if field experimentType is set (has been assigned a value) and false otherwise */
  public boolean isSetExperimentType() {
    return this.experimentType != null;
  }

  public void setExperimentTypeIsSet(boolean value) {
    if (!value) {
      this.experimentType = null;
    }
  }

  public long getExperimentStartTime() {
    return this.experimentStartTime;
  }

  public ExperimentEntity setExperimentStartTime(long experimentStartTime) {
    this.experimentStartTime = experimentStartTime;
    setExperimentStartTimeIsSet(true);
    return this;
  }

  public void unsetExperimentStartTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __EXPERIMENTSTARTTIME_ISSET_ID);
  }

  /** Returns true if field experimentStartTime is set (has been assigned a value) and false otherwise */
  public boolean isSetExperimentStartTime() {
    return EncodingUtils.testBit(__isset_bitfield, __EXPERIMENTSTARTTIME_ISSET_ID);
  }

  public void setExperimentStartTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __EXPERIMENTSTARTTIME_ISSET_ID, value);
  }

  public long getExperimentEndTime() {
    return this.experimentEndTime;
  }

  public ExperimentEntity setExperimentEndTime(long experimentEndTime) {
    this.experimentEndTime = experimentEndTime;
    setExperimentEndTimeIsSet(true);
    return this;
  }

  public void unsetExperimentEndTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __EXPERIMENTENDTIME_ISSET_ID);
  }

  /** Returns true if field experimentEndTime is set (has been assigned a value) and false otherwise */
  public boolean isSetExperimentEndTime() {
    return EncodingUtils.testBit(__isset_bitfield, __EXPERIMENTENDTIME_ISSET_ID);
  }

  public void setExperimentEndTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __EXPERIMENTENDTIME_ISSET_ID, value);
  }

  public long getExperimentLastUpdatedTime() {
    return this.experimentLastUpdatedTime;
  }

  public ExperimentEntity setExperimentLastUpdatedTime(long experimentLastUpdatedTime) {
    this.experimentLastUpdatedTime = experimentLastUpdatedTime;
    setExperimentLastUpdatedTimeIsSet(true);
    return this;
  }

  public void unsetExperimentLastUpdatedTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __EXPERIMENTLASTUPDATEDTIME_ISSET_ID);
  }

  /** Returns true if field experimentLastUpdatedTime is set (has been assigned a value) and false otherwise */
  public boolean isSetExperimentLastUpdatedTime() {
    return EncodingUtils.testBit(__isset_bitfield, __EXPERIMENTLASTUPDATEDTIME_ISSET_ID);
  }

  public void setExperimentLastUpdatedTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __EXPERIMENTLASTUPDATEDTIME_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case EXPERIMENT_ID:
      if (value == null) {
        unsetExperimentId();
      } else {
        setExperimentId((String)value);
      }
      break;

    case EXPERIMENT_NAME:
      if (value == null) {
        unsetExperimentName();
      } else {
        setExperimentName((String)value);
      }
      break;

    case EXPERIMENT_STATUS:
      if (value == null) {
        unsetExperimentStatus();
      } else {
        setExperimentStatus((String)value);
      }
      break;

    case EXPERIMENT_TYPE:
      if (value == null) {
        unsetExperimentType();
      } else {
        setExperimentType((String)value);
      }
      break;

    case EXPERIMENT_START_TIME:
      if (value == null) {
        unsetExperimentStartTime();
      } else {
        setExperimentStartTime((Long)value);
      }
      break;

    case EXPERIMENT_END_TIME:
      if (value == null) {
        unsetExperimentEndTime();
      } else {
        setExperimentEndTime((Long)value);
      }
      break;

    case EXPERIMENT_LAST_UPDATED_TIME:
      if (value == null) {
        unsetExperimentLastUpdatedTime();
      } else {
        setExperimentLastUpdatedTime((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case EXPERIMENT_ID:
      return getExperimentId();

    case EXPERIMENT_NAME:
      return getExperimentName();

    case EXPERIMENT_STATUS:
      return getExperimentStatus();

    case EXPERIMENT_TYPE:
      return getExperimentType();

    case EXPERIMENT_START_TIME:
      return getExperimentStartTime();

    case EXPERIMENT_END_TIME:
      return getExperimentEndTime();

    case EXPERIMENT_LAST_UPDATED_TIME:
      return getExperimentLastUpdatedTime();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case EXPERIMENT_ID:
      return isSetExperimentId();
    case EXPERIMENT_NAME:
      return isSetExperimentName();
    case EXPERIMENT_STATUS:
      return isSetExperimentStatus();
    case EXPERIMENT_TYPE:
      return isSetExperimentType();
    case EXPERIMENT_START_TIME:
      return isSetExperimentStartTime();
    case EXPERIMENT_END_TIME:
      return isSetExperimentEndTime();
    case EXPERIMENT_LAST_UPDATED_TIME:
      return isSetExperimentLastUpdatedTime();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ExperimentEntity)
      return this.equals((ExperimentEntity)that);
    return false;
  }

  public boolean equals(ExperimentEntity that) {
    if (that == null)
      return false;

    boolean this_present_experimentId = true && this.isSetExperimentId();
    boolean that_present_experimentId = true && that.isSetExperimentId();
    if (this_present_experimentId || that_present_experimentId) {
      if (!(this_present_experimentId && that_present_experimentId))
        return false;
      if (!this.experimentId.equals(that.experimentId))
        return false;
    }

    boolean this_present_experimentName = true && this.isSetExperimentName();
    boolean that_present_experimentName = true && that.isSetExperimentName();
    if (this_present_experimentName || that_present_experimentName) {
      if (!(this_present_experimentName && that_present_experimentName))
        return false;
      if (!this.experimentName.equals(that.experimentName))
        return false;
    }

    boolean this_present_experimentStatus = true && this.isSetExperimentStatus();
    boolean that_present_experimentStatus = true && that.isSetExperimentStatus();
    if (this_present_experimentStatus || that_present_experimentStatus) {
      if (!(this_present_experimentStatus && that_present_experimentStatus))
        return false;
      if (!this.experimentStatus.equals(that.experimentStatus))
        return false;
    }

    boolean this_present_experimentType = true && this.isSetExperimentType();
    boolean that_present_experimentType = true && that.isSetExperimentType();
    if (this_present_experimentType || that_present_experimentType) {
      if (!(this_present_experimentType && that_present_experimentType))
        return false;
      if (!this.experimentType.equals(that.experimentType))
        return false;
    }

    boolean this_present_experimentStartTime = true;
    boolean that_present_experimentStartTime = true;
    if (this_present_experimentStartTime || that_present_experimentStartTime) {
      if (!(this_present_experimentStartTime && that_present_experimentStartTime))
        return false;
      if (this.experimentStartTime != that.experimentStartTime)
        return false;
    }

    boolean this_present_experimentEndTime = true && this.isSetExperimentEndTime();
    boolean that_present_experimentEndTime = true && that.isSetExperimentEndTime();
    if (this_present_experimentEndTime || that_present_experimentEndTime) {
      if (!(this_present_experimentEndTime && that_present_experimentEndTime))
        return false;
      if (this.experimentEndTime != that.experimentEndTime)
        return false;
    }

    boolean this_present_experimentLastUpdatedTime = true && this.isSetExperimentLastUpdatedTime();
    boolean that_present_experimentLastUpdatedTime = true && that.isSetExperimentLastUpdatedTime();
    if (this_present_experimentLastUpdatedTime || that_present_experimentLastUpdatedTime) {
      if (!(this_present_experimentLastUpdatedTime && that_present_experimentLastUpdatedTime))
        return false;
      if (this.experimentLastUpdatedTime != that.experimentLastUpdatedTime)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_experimentId = true && (isSetExperimentId());
    list.add(present_experimentId);
    if (present_experimentId)
      list.add(experimentId);

    boolean present_experimentName = true && (isSetExperimentName());
    list.add(present_experimentName);
    if (present_experimentName)
      list.add(experimentName);

    boolean present_experimentStatus = true && (isSetExperimentStatus());
    list.add(present_experimentStatus);
    if (present_experimentStatus)
      list.add(experimentStatus);

    boolean present_experimentType = true && (isSetExperimentType());
    list.add(present_experimentType);
    if (present_experimentType)
      list.add(experimentType);

    boolean present_experimentStartTime = true;
    list.add(present_experimentStartTime);
    if (present_experimentStartTime)
      list.add(experimentStartTime);

    boolean present_experimentEndTime = true && (isSetExperimentEndTime());
    list.add(present_experimentEndTime);
    if (present_experimentEndTime)
      list.add(experimentEndTime);

    boolean present_experimentLastUpdatedTime = true && (isSetExperimentLastUpdatedTime());
    list.add(present_experimentLastUpdatedTime);
    if (present_experimentLastUpdatedTime)
      list.add(experimentLastUpdatedTime);

    return list.hashCode();
  }

  @Override
  public int compareTo(ExperimentEntity other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetExperimentId()).compareTo(other.isSetExperimentId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExperimentId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.experimentId, other.experimentId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExperimentName()).compareTo(other.isSetExperimentName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExperimentName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.experimentName, other.experimentName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExperimentStatus()).compareTo(other.isSetExperimentStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExperimentStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.experimentStatus, other.experimentStatus);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExperimentType()).compareTo(other.isSetExperimentType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExperimentType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.experimentType, other.experimentType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExperimentStartTime()).compareTo(other.isSetExperimentStartTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExperimentStartTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.experimentStartTime, other.experimentStartTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExperimentEndTime()).compareTo(other.isSetExperimentEndTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExperimentEndTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.experimentEndTime, other.experimentEndTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExperimentLastUpdatedTime()).compareTo(other.isSetExperimentLastUpdatedTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExperimentLastUpdatedTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.experimentLastUpdatedTime, other.experimentLastUpdatedTime);
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
    StringBuilder sb = new StringBuilder("ExperimentEntity(");
    boolean first = true;

    sb.append("experimentId:");
    if (this.experimentId == null) {
      sb.append("null");
    } else {
      sb.append(this.experimentId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("experimentName:");
    if (this.experimentName == null) {
      sb.append("null");
    } else {
      sb.append(this.experimentName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("experimentStatus:");
    if (this.experimentStatus == null) {
      sb.append("null");
    } else {
      sb.append(this.experimentStatus);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("experimentType:");
    if (this.experimentType == null) {
      sb.append("null");
    } else {
      sb.append(this.experimentType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("experimentStartTime:");
    sb.append(this.experimentStartTime);
    first = false;
    if (isSetExperimentEndTime()) {
      if (!first) sb.append(", ");
      sb.append("experimentEndTime:");
      sb.append(this.experimentEndTime);
      first = false;
    }
    if (isSetExperimentLastUpdatedTime()) {
      if (!first) sb.append(", ");
      sb.append("experimentLastUpdatedTime:");
      sb.append(this.experimentLastUpdatedTime);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (experimentId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'experimentId' was not present! Struct: " + toString());
    }
    if (experimentName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'experimentName' was not present! Struct: " + toString());
    }
    if (experimentStatus == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'experimentStatus' was not present! Struct: " + toString());
    }
    if (experimentType == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'experimentType' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'experimentStartTime' because it's a primitive and you chose the non-beans generator.
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ExperimentEntityStandardSchemeFactory implements SchemeFactory {
    public ExperimentEntityStandardScheme getScheme() {
      return new ExperimentEntityStandardScheme();
    }
  }

  private static class ExperimentEntityStandardScheme extends StandardScheme<ExperimentEntity> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ExperimentEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EXPERIMENT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.experimentId = iprot.readString();
              struct.setExperimentIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // EXPERIMENT_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.experimentName = iprot.readString();
              struct.setExperimentNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // EXPERIMENT_STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.experimentStatus = iprot.readString();
              struct.setExperimentStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // EXPERIMENT_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.experimentType = iprot.readString();
              struct.setExperimentTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // EXPERIMENT_START_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.experimentStartTime = iprot.readI64();
              struct.setExperimentStartTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // EXPERIMENT_END_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.experimentEndTime = iprot.readI64();
              struct.setExperimentEndTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // EXPERIMENT_LAST_UPDATED_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.experimentLastUpdatedTime = iprot.readI64();
              struct.setExperimentLastUpdatedTimeIsSet(true);
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
      if (!struct.isSetExperimentStartTime()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'experimentStartTime' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ExperimentEntity struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.experimentId != null) {
        oprot.writeFieldBegin(EXPERIMENT_ID_FIELD_DESC);
        oprot.writeString(struct.experimentId);
        oprot.writeFieldEnd();
      }
      if (struct.experimentName != null) {
        oprot.writeFieldBegin(EXPERIMENT_NAME_FIELD_DESC);
        oprot.writeString(struct.experimentName);
        oprot.writeFieldEnd();
      }
      if (struct.experimentStatus != null) {
        oprot.writeFieldBegin(EXPERIMENT_STATUS_FIELD_DESC);
        oprot.writeString(struct.experimentStatus);
        oprot.writeFieldEnd();
      }
      if (struct.experimentType != null) {
        oprot.writeFieldBegin(EXPERIMENT_TYPE_FIELD_DESC);
        oprot.writeString(struct.experimentType);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(EXPERIMENT_START_TIME_FIELD_DESC);
      oprot.writeI64(struct.experimentStartTime);
      oprot.writeFieldEnd();
      if (struct.isSetExperimentEndTime()) {
        oprot.writeFieldBegin(EXPERIMENT_END_TIME_FIELD_DESC);
        oprot.writeI64(struct.experimentEndTime);
        oprot.writeFieldEnd();
      }
      if (struct.isSetExperimentLastUpdatedTime()) {
        oprot.writeFieldBegin(EXPERIMENT_LAST_UPDATED_TIME_FIELD_DESC);
        oprot.writeI64(struct.experimentLastUpdatedTime);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ExperimentEntityTupleSchemeFactory implements SchemeFactory {
    public ExperimentEntityTupleScheme getScheme() {
      return new ExperimentEntityTupleScheme();
    }
  }

  private static class ExperimentEntityTupleScheme extends TupleScheme<ExperimentEntity> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ExperimentEntity struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.experimentId);
      oprot.writeString(struct.experimentName);
      oprot.writeString(struct.experimentStatus);
      oprot.writeString(struct.experimentType);
      oprot.writeI64(struct.experimentStartTime);
      BitSet optionals = new BitSet();
      if (struct.isSetExperimentEndTime()) {
        optionals.set(0);
      }
      if (struct.isSetExperimentLastUpdatedTime()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetExperimentEndTime()) {
        oprot.writeI64(struct.experimentEndTime);
      }
      if (struct.isSetExperimentLastUpdatedTime()) {
        oprot.writeI64(struct.experimentLastUpdatedTime);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ExperimentEntity struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.experimentId = iprot.readString();
      struct.setExperimentIdIsSet(true);
      struct.experimentName = iprot.readString();
      struct.setExperimentNameIsSet(true);
      struct.experimentStatus = iprot.readString();
      struct.setExperimentStatusIsSet(true);
      struct.experimentType = iprot.readString();
      struct.setExperimentTypeIsSet(true);
      struct.experimentStartTime = iprot.readI64();
      struct.setExperimentStartTimeIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.experimentEndTime = iprot.readI64();
        struct.setExperimentEndTimeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.experimentLastUpdatedTime = iprot.readI64();
        struct.setExperimentLastUpdatedTimeIsSet(true);
      }
    }
  }

}

