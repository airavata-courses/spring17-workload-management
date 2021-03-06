/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.cloud.aurora.client.sdk;

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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-10-21")
public class InstanceConfigRewrite implements org.apache.thrift.TBase<InstanceConfigRewrite, InstanceConfigRewrite._Fields>, java.io.Serializable, Cloneable, Comparable<InstanceConfigRewrite> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("InstanceConfigRewrite");

  private static final org.apache.thrift.protocol.TField INSTANCE_KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("instanceKey", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField OLD_TASK_FIELD_DESC = new org.apache.thrift.protocol.TField("oldTask", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField REWRITTEN_TASK_FIELD_DESC = new org.apache.thrift.protocol.TField("rewrittenTask", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new InstanceConfigRewriteStandardSchemeFactory());
    schemes.put(TupleScheme.class, new InstanceConfigRewriteTupleSchemeFactory());
  }

  /**
   * Key for the task to rewrite.
   */
  public InstanceKey instanceKey; // required
  /**
   * The original configuration.
   */
  public TaskConfig oldTask; // required
  /**
   * The rewritten configuration.
   */
  public TaskConfig rewrittenTask; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * Key for the task to rewrite.
     */
    INSTANCE_KEY((short)1, "instanceKey"),
    /**
     * The original configuration.
     */
    OLD_TASK((short)2, "oldTask"),
    /**
     * The rewritten configuration.
     */
    REWRITTEN_TASK((short)3, "rewrittenTask");

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
        case 1: // INSTANCE_KEY
          return INSTANCE_KEY;
        case 2: // OLD_TASK
          return OLD_TASK;
        case 3: // REWRITTEN_TASK
          return REWRITTEN_TASK;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.INSTANCE_KEY, new org.apache.thrift.meta_data.FieldMetaData("instanceKey", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, InstanceKey.class)));
    tmpMap.put(_Fields.OLD_TASK, new org.apache.thrift.meta_data.FieldMetaData("oldTask", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TaskConfig.class)));
    tmpMap.put(_Fields.REWRITTEN_TASK, new org.apache.thrift.meta_data.FieldMetaData("rewrittenTask", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TaskConfig.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(InstanceConfigRewrite.class, metaDataMap);
  }

  public InstanceConfigRewrite() {
  }

  public InstanceConfigRewrite(
    InstanceKey instanceKey,
    TaskConfig oldTask,
    TaskConfig rewrittenTask)
  {
    this();
    this.instanceKey = instanceKey;
    this.oldTask = oldTask;
    this.rewrittenTask = rewrittenTask;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public InstanceConfigRewrite(InstanceConfigRewrite other) {
    if (other.isSetInstanceKey()) {
      this.instanceKey = new InstanceKey(other.instanceKey);
    }
    if (other.isSetOldTask()) {
      this.oldTask = new TaskConfig(other.oldTask);
    }
    if (other.isSetRewrittenTask()) {
      this.rewrittenTask = new TaskConfig(other.rewrittenTask);
    }
  }

  public InstanceConfigRewrite deepCopy() {
    return new InstanceConfigRewrite(this);
  }

  @Override
  public void clear() {
    this.instanceKey = null;
    this.oldTask = null;
    this.rewrittenTask = null;
  }

  /**
   * Key for the task to rewrite.
   */
  public InstanceKey getInstanceKey() {
    return this.instanceKey;
  }

  /**
   * Key for the task to rewrite.
   */
  public InstanceConfigRewrite setInstanceKey(InstanceKey instanceKey) {
    this.instanceKey = instanceKey;
    return this;
  }

  public void unsetInstanceKey() {
    this.instanceKey = null;
  }

  /** Returns true if field instanceKey is set (has been assigned a value) and false otherwise */
  public boolean isSetInstanceKey() {
    return this.instanceKey != null;
  }

  public void setInstanceKeyIsSet(boolean value) {
    if (!value) {
      this.instanceKey = null;
    }
  }

  /**
   * The original configuration.
   */
  public TaskConfig getOldTask() {
    return this.oldTask;
  }

  /**
   * The original configuration.
   */
  public InstanceConfigRewrite setOldTask(TaskConfig oldTask) {
    this.oldTask = oldTask;
    return this;
  }

  public void unsetOldTask() {
    this.oldTask = null;
  }

  /** Returns true if field oldTask is set (has been assigned a value) and false otherwise */
  public boolean isSetOldTask() {
    return this.oldTask != null;
  }

  public void setOldTaskIsSet(boolean value) {
    if (!value) {
      this.oldTask = null;
    }
  }

  /**
   * The rewritten configuration.
   */
  public TaskConfig getRewrittenTask() {
    return this.rewrittenTask;
  }

  /**
   * The rewritten configuration.
   */
  public InstanceConfigRewrite setRewrittenTask(TaskConfig rewrittenTask) {
    this.rewrittenTask = rewrittenTask;
    return this;
  }

  public void unsetRewrittenTask() {
    this.rewrittenTask = null;
  }

  /** Returns true if field rewrittenTask is set (has been assigned a value) and false otherwise */
  public boolean isSetRewrittenTask() {
    return this.rewrittenTask != null;
  }

  public void setRewrittenTaskIsSet(boolean value) {
    if (!value) {
      this.rewrittenTask = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case INSTANCE_KEY:
      if (value == null) {
        unsetInstanceKey();
      } else {
        setInstanceKey((InstanceKey)value);
      }
      break;

    case OLD_TASK:
      if (value == null) {
        unsetOldTask();
      } else {
        setOldTask((TaskConfig)value);
      }
      break;

    case REWRITTEN_TASK:
      if (value == null) {
        unsetRewrittenTask();
      } else {
        setRewrittenTask((TaskConfig)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case INSTANCE_KEY:
      return getInstanceKey();

    case OLD_TASK:
      return getOldTask();

    case REWRITTEN_TASK:
      return getRewrittenTask();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case INSTANCE_KEY:
      return isSetInstanceKey();
    case OLD_TASK:
      return isSetOldTask();
    case REWRITTEN_TASK:
      return isSetRewrittenTask();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof InstanceConfigRewrite)
      return this.equals((InstanceConfigRewrite)that);
    return false;
  }

  public boolean equals(InstanceConfigRewrite that) {
    if (that == null)
      return false;

    boolean this_present_instanceKey = true && this.isSetInstanceKey();
    boolean that_present_instanceKey = true && that.isSetInstanceKey();
    if (this_present_instanceKey || that_present_instanceKey) {
      if (!(this_present_instanceKey && that_present_instanceKey))
        return false;
      if (!this.instanceKey.equals(that.instanceKey))
        return false;
    }

    boolean this_present_oldTask = true && this.isSetOldTask();
    boolean that_present_oldTask = true && that.isSetOldTask();
    if (this_present_oldTask || that_present_oldTask) {
      if (!(this_present_oldTask && that_present_oldTask))
        return false;
      if (!this.oldTask.equals(that.oldTask))
        return false;
    }

    boolean this_present_rewrittenTask = true && this.isSetRewrittenTask();
    boolean that_present_rewrittenTask = true && that.isSetRewrittenTask();
    if (this_present_rewrittenTask || that_present_rewrittenTask) {
      if (!(this_present_rewrittenTask && that_present_rewrittenTask))
        return false;
      if (!this.rewrittenTask.equals(that.rewrittenTask))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_instanceKey = true && (isSetInstanceKey());
    list.add(present_instanceKey);
    if (present_instanceKey)
      list.add(instanceKey);

    boolean present_oldTask = true && (isSetOldTask());
    list.add(present_oldTask);
    if (present_oldTask)
      list.add(oldTask);

    boolean present_rewrittenTask = true && (isSetRewrittenTask());
    list.add(present_rewrittenTask);
    if (present_rewrittenTask)
      list.add(rewrittenTask);

    return list.hashCode();
  }

  @Override
  public int compareTo(InstanceConfigRewrite other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetInstanceKey()).compareTo(other.isSetInstanceKey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInstanceKey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.instanceKey, other.instanceKey);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOldTask()).compareTo(other.isSetOldTask());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOldTask()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.oldTask, other.oldTask);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRewrittenTask()).compareTo(other.isSetRewrittenTask());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRewrittenTask()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rewrittenTask, other.rewrittenTask);
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
    StringBuilder sb = new StringBuilder("InstanceConfigRewrite(");
    boolean first = true;

    sb.append("instanceKey:");
    if (this.instanceKey == null) {
      sb.append("null");
    } else {
      sb.append(this.instanceKey);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("oldTask:");
    if (this.oldTask == null) {
      sb.append("null");
    } else {
      sb.append(this.oldTask);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("rewrittenTask:");
    if (this.rewrittenTask == null) {
      sb.append("null");
    } else {
      sb.append(this.rewrittenTask);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (instanceKey != null) {
      instanceKey.validate();
    }
    if (oldTask != null) {
      oldTask.validate();
    }
    if (rewrittenTask != null) {
      rewrittenTask.validate();
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

  private static class InstanceConfigRewriteStandardSchemeFactory implements SchemeFactory {
    public InstanceConfigRewriteStandardScheme getScheme() {
      return new InstanceConfigRewriteStandardScheme();
    }
  }

  private static class InstanceConfigRewriteStandardScheme extends StandardScheme<InstanceConfigRewrite> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, InstanceConfigRewrite struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // INSTANCE_KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.instanceKey = new InstanceKey();
              struct.instanceKey.read(iprot);
              struct.setInstanceKeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // OLD_TASK
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.oldTask = new TaskConfig();
              struct.oldTask.read(iprot);
              struct.setOldTaskIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // REWRITTEN_TASK
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.rewrittenTask = new TaskConfig();
              struct.rewrittenTask.read(iprot);
              struct.setRewrittenTaskIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, InstanceConfigRewrite struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.instanceKey != null) {
        oprot.writeFieldBegin(INSTANCE_KEY_FIELD_DESC);
        struct.instanceKey.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.oldTask != null) {
        oprot.writeFieldBegin(OLD_TASK_FIELD_DESC);
        struct.oldTask.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.rewrittenTask != null) {
        oprot.writeFieldBegin(REWRITTEN_TASK_FIELD_DESC);
        struct.rewrittenTask.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class InstanceConfigRewriteTupleSchemeFactory implements SchemeFactory {
    public InstanceConfigRewriteTupleScheme getScheme() {
      return new InstanceConfigRewriteTupleScheme();
    }
  }

  private static class InstanceConfigRewriteTupleScheme extends TupleScheme<InstanceConfigRewrite> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, InstanceConfigRewrite struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetInstanceKey()) {
        optionals.set(0);
      }
      if (struct.isSetOldTask()) {
        optionals.set(1);
      }
      if (struct.isSetRewrittenTask()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetInstanceKey()) {
        struct.instanceKey.write(oprot);
      }
      if (struct.isSetOldTask()) {
        struct.oldTask.write(oprot);
      }
      if (struct.isSetRewrittenTask()) {
        struct.rewrittenTask.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, InstanceConfigRewrite struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.instanceKey = new InstanceKey();
        struct.instanceKey.read(iprot);
        struct.setInstanceKeyIsSet(true);
      }
      if (incoming.get(1)) {
        struct.oldTask = new TaskConfig();
        struct.oldTask.read(iprot);
        struct.setOldTaskIsSet(true);
      }
      if (incoming.get(2)) {
        struct.rewrittenTask = new TaskConfig();
        struct.rewrittenTask.read(iprot);
        struct.setRewrittenTaskIsSet(true);
      }
    }
  }

}

