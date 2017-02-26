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

// TODO: Auto-generated Javadoc
/**
 * The Class JobUpdateKey.
 */
@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * Job update key.
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-10-21")
public class JobUpdateKey implements org.apache.thrift.TBase<JobUpdateKey, JobUpdateKey._Fields>, java.io.Serializable, Cloneable, Comparable<JobUpdateKey> {
  
  /** The Constant STRUCT_DESC. */
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("JobUpdateKey");

  /** The Constant JOB_FIELD_DESC. */
  private static final org.apache.thrift.protocol.TField JOB_FIELD_DESC = new org.apache.thrift.protocol.TField("job", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  
  /** The Constant ID_FIELD_DESC. */
  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.STRING, (short)2);

  /** The Constant schemes. */
  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new JobUpdateKeyStandardSchemeFactory());
    schemes.put(TupleScheme.class, new JobUpdateKeyTupleSchemeFactory());
  }

  /** Job being updated. */
  public JobKey job; // required
  /**
   * Update ID.
   */
  public String id; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    
    /** Job being updated. */
    JOB((short)1, "job"),
    /**
     * Update ID.
     */
    ID((short)2, "id");

    /** The Constant byName. */
    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     *
     * @param fieldId the field id
     * @return the fields
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // JOB
          return JOB;
        case 2: // ID
          return ID;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     *
     * @param fieldId the field id
     * @return the fields
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     *
     * @param name the name
     * @return the fields
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    /** The thrift id. */
    private final short _thriftId;
    
    /** The field name. */
    private final String _fieldName;

    /**
     * Instantiates a new fields.
     *
     * @param thriftId the thrift id
     * @param fieldName the field name
     */
    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    /* (non-Javadoc)
     * @see org.apache.thrift.TFieldIdEnum#getThriftFieldId()
     */
    public short getThriftFieldId() {
      return _thriftId;
    }

    /* (non-Javadoc)
     * @see org.apache.thrift.TFieldIdEnum#getFieldName()
     */
    public String getFieldName() {
      return _fieldName;
    }
  }

  /** The Constant metaDataMap. */
  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.JOB, new org.apache.thrift.meta_data.FieldMetaData("job", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, JobKey.class)));
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(JobUpdateKey.class, metaDataMap);
  }

  /**
   * Instantiates a new job update key.
   */
  public JobUpdateKey() {
  }

  /**
   * Instantiates a new job update key.
   *
   * @param job the job
   * @param id the id
   */
  public JobUpdateKey(
    JobKey job,
    String id)
  {
    this();
    this.job = job;
    this.id = id;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   *
   * @param other the other
   */
  public JobUpdateKey(JobUpdateKey other) {
    if (other.isSetJob()) {
      this.job = new JobKey(other.job);
    }
    if (other.isSetId()) {
      this.id = other.id;
    }
  }

  /* (non-Javadoc)
   * @see org.apache.thrift.TBase#deepCopy()
   */
  public JobUpdateKey deepCopy() {
    return new JobUpdateKey(this);
  }

  /* (non-Javadoc)
   * @see org.apache.thrift.TBase#clear()
   */
  @Override
  public void clear() {
    this.job = null;
    this.id = null;
  }

  /**
   * Job being updated.
   *
   * @return the job
   */
  public JobKey getJob() {
    return this.job;
  }

  /**
   * Job being updated.
   *
   * @param job the job
   * @return the job update key
   */
  public JobUpdateKey setJob(JobKey job) {
    this.job = job;
    return this;
  }

  /**
   * Unset job.
   */
  public void unsetJob() {
    this.job = null;
  }

  /**
   *  Returns true if field job is set (has been assigned a value) and false otherwise.
   *
   * @return true, if is sets the job
   */
  public boolean isSetJob() {
    return this.job != null;
  }

  /**
   * Sets the job is set.
   *
   * @param value the new job is set
   */
  public void setJobIsSet(boolean value) {
    if (!value) {
      this.job = null;
    }
  }

  /**
   * Update ID.
   *
   * @return the id
   */
  public String getId() {
    return this.id;
  }

  /**
   * Update ID.
   *
   * @param id the id
   * @return the job update key
   */
  public JobUpdateKey setId(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unset id.
   */
  public void unsetId() {
    this.id = null;
  }

  /**
   *  Returns true if field id is set (has been assigned a value) and false otherwise.
   *
   * @return true, if is sets the id
   */
  public boolean isSetId() {
    return this.id != null;
  }

  /**
   * Sets the id is set.
   *
   * @param value the new id is set
   */
  public void setIdIsSet(boolean value) {
    if (!value) {
      this.id = null;
    }
  }

  /* (non-Javadoc)
   * @see org.apache.thrift.TBase#setFieldValue(org.apache.thrift.TFieldIdEnum, java.lang.Object)
   */
  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case JOB:
      if (value == null) {
        unsetJob();
      } else {
        setJob((JobKey)value);
      }
      break;

    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((String)value);
      }
      break;

    }
  }

  /* (non-Javadoc)
   * @see org.apache.thrift.TBase#getFieldValue(org.apache.thrift.TFieldIdEnum)
   */
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case JOB:
      return getJob();

    case ID:
      return getId();

    }
    throw new IllegalStateException();
  }

  /**
   *  Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise.
   *
   * @param field the field
   * @return true, if is sets the
   */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case JOB:
      return isSetJob();
    case ID:
      return isSetId();
    }
    throw new IllegalStateException();
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof JobUpdateKey)
      return this.equals((JobUpdateKey)that);
    return false;
  }

  /**
   * Equals.
   *
   * @param that the that
   * @return true, if successful
   */
  public boolean equals(JobUpdateKey that) {
    if (that == null)
      return false;

    boolean this_present_job = true && this.isSetJob();
    boolean that_present_job = true && that.isSetJob();
    if (this_present_job || that_present_job) {
      if (!(this_present_job && that_present_job))
        return false;
      if (!this.job.equals(that.job))
        return false;
    }

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (!this.id.equals(that.id))
        return false;
    }

    return true;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_job = true && (isSetJob());
    list.add(present_job);
    if (present_job)
      list.add(job);

    boolean present_id = true && (isSetId());
    list.add(present_id);
    if (present_id)
      list.add(id);

    return list.hashCode();
  }

  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(JobUpdateKey other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetJob()).compareTo(other.isSetJob());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJob()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.job, other.job);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  /* (non-Javadoc)
   * @see org.apache.thrift.TBase#fieldForId(int)
   */
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  /* (non-Javadoc)
   * @see org.apache.thrift.TBase#read(org.apache.thrift.protocol.TProtocol)
   */
  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  /* (non-Javadoc)
   * @see org.apache.thrift.TBase#write(org.apache.thrift.protocol.TProtocol)
   */
  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("JobUpdateKey(");
    boolean first = true;

    sb.append("job:");
    if (this.job == null) {
      sb.append("null");
    } else {
      sb.append(this.job);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("id:");
    if (this.id == null) {
      sb.append("null");
    } else {
      sb.append(this.id);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  /**
   * Validate.
   *
   * @throws TException the t exception
   */
  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (job != null) {
      job.validate();
    }
  }

  /**
   * Write object.
   *
   * @param out the out
   * @throws IOException Signals that an I/O exception has occurred.
   */
  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  /**
   * Read object.
   *
   * @param in the in
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws ClassNotFoundException the class not found exception
   */
  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  /**
   * A factory for creating JobUpdateKeyStandardScheme objects.
   */
  private static class JobUpdateKeyStandardSchemeFactory implements SchemeFactory {
    
    /* (non-Javadoc)
     * @see org.apache.thrift.scheme.SchemeFactory#getScheme()
     */
    public JobUpdateKeyStandardScheme getScheme() {
      return new JobUpdateKeyStandardScheme();
    }
  }

  /**
   * The Class JobUpdateKeyStandardScheme.
   */
  private static class JobUpdateKeyStandardScheme extends StandardScheme<JobUpdateKey> {

    /* (non-Javadoc)
     * @see org.apache.thrift.scheme.IScheme#read(org.apache.thrift.protocol.TProtocol, org.apache.thrift.TBase)
     */
    public void read(org.apache.thrift.protocol.TProtocol iprot, JobUpdateKey struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // JOB
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.job = new JobKey();
              struct.job.read(iprot);
              struct.setJobIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id = iprot.readString();
              struct.setIdIsSet(true);
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

    /* (non-Javadoc)
     * @see org.apache.thrift.scheme.IScheme#write(org.apache.thrift.protocol.TProtocol, org.apache.thrift.TBase)
     */
    public void write(org.apache.thrift.protocol.TProtocol oprot, JobUpdateKey struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.job != null) {
        oprot.writeFieldBegin(JOB_FIELD_DESC);
        struct.job.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.id != null) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeString(struct.id);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  /**
   * A factory for creating JobUpdateKeyTupleScheme objects.
   */
  private static class JobUpdateKeyTupleSchemeFactory implements SchemeFactory {
    
    /* (non-Javadoc)
     * @see org.apache.thrift.scheme.SchemeFactory#getScheme()
     */
    public JobUpdateKeyTupleScheme getScheme() {
      return new JobUpdateKeyTupleScheme();
    }
  }

  /**
   * The Class JobUpdateKeyTupleScheme.
   */
  private static class JobUpdateKeyTupleScheme extends TupleScheme<JobUpdateKey> {

    /* (non-Javadoc)
     * @see org.apache.thrift.scheme.IScheme#write(org.apache.thrift.protocol.TProtocol, org.apache.thrift.TBase)
     */
    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, JobUpdateKey struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetJob()) {
        optionals.set(0);
      }
      if (struct.isSetId()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetJob()) {
        struct.job.write(oprot);
      }
      if (struct.isSetId()) {
        oprot.writeString(struct.id);
      }
    }

    /* (non-Javadoc)
     * @see org.apache.thrift.scheme.IScheme#read(org.apache.thrift.protocol.TProtocol, org.apache.thrift.TBase)
     */
    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, JobUpdateKey struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.job = new JobKey();
        struct.job.read(iprot);
        struct.setJobIsSet(true);
      }
      if (incoming.get(1)) {
        struct.id = iprot.readString();
        struct.setIdIsSet(true);
      }
    }
  }

}

