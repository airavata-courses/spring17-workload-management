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
 * The Class GetPendingReasonResult.
 */
@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-10-21")
public class GetPendingReasonResult implements org.apache.thrift.TBase<GetPendingReasonResult, GetPendingReasonResult._Fields>, java.io.Serializable, Cloneable, Comparable<GetPendingReasonResult> {
  
  /** The Constant STRUCT_DESC. */
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GetPendingReasonResult");

  /** The Constant REASONS_FIELD_DESC. */
  private static final org.apache.thrift.protocol.TField REASONS_FIELD_DESC = new org.apache.thrift.protocol.TField("reasons", org.apache.thrift.protocol.TType.SET, (short)1);

  /** The Constant schemes. */
  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GetPendingReasonResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GetPendingReasonResultTupleSchemeFactory());
  }

  /** The reasons. */
  public Set<PendingReason> reasons; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    
    /** The reasons. */
    REASONS((short)1, "reasons");

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
        case 1: // REASONS
          return REASONS;
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
    tmpMap.put(_Fields.REASONS, new org.apache.thrift.meta_data.FieldMetaData("reasons", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PendingReason.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GetPendingReasonResult.class, metaDataMap);
  }

  /**
   * Instantiates a new gets the pending reason result.
   */
  public GetPendingReasonResult() {
  }

  /**
   * Instantiates a new gets the pending reason result.
   *
   * @param reasons the reasons
   */
  public GetPendingReasonResult(
    Set<PendingReason> reasons)
  {
    this();
    this.reasons = reasons;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   *
   * @param other the other
   */
  public GetPendingReasonResult(GetPendingReasonResult other) {
    if (other.isSetReasons()) {
      Set<PendingReason> __this__reasons = new HashSet<PendingReason>(other.reasons.size());
      for (PendingReason other_element : other.reasons) {
        __this__reasons.add(new PendingReason(other_element));
      }
      this.reasons = __this__reasons;
    }
  }

  /* (non-Javadoc)
   * @see org.apache.thrift.TBase#deepCopy()
   */
  public GetPendingReasonResult deepCopy() {
    return new GetPendingReasonResult(this);
  }

  /* (non-Javadoc)
   * @see org.apache.thrift.TBase#clear()
   */
  @Override
  public void clear() {
    this.reasons = null;
  }

  /**
   * Gets the reasons size.
   *
   * @return the reasons size
   */
  public int getReasonsSize() {
    return (this.reasons == null) ? 0 : this.reasons.size();
  }

  /**
   * Gets the reasons iterator.
   *
   * @return the reasons iterator
   */
  public java.util.Iterator<PendingReason> getReasonsIterator() {
    return (this.reasons == null) ? null : this.reasons.iterator();
  }

  /**
   * Adds the to reasons.
   *
   * @param elem the elem
   */
  public void addToReasons(PendingReason elem) {
    if (this.reasons == null) {
      this.reasons = new HashSet<PendingReason>();
    }
    this.reasons.add(elem);
  }

  /**
   * Gets the reasons.
   *
   * @return the reasons
   */
  public Set<PendingReason> getReasons() {
    return this.reasons;
  }

  /**
   * Sets the reasons.
   *
   * @param reasons the reasons
   * @return the gets the pending reason result
   */
  public GetPendingReasonResult setReasons(Set<PendingReason> reasons) {
    this.reasons = reasons;
    return this;
  }

  /**
   * Unset reasons.
   */
  public void unsetReasons() {
    this.reasons = null;
  }

  /**
   *  Returns true if field reasons is set (has been assigned a value) and false otherwise.
   *
   * @return true, if is sets the reasons
   */
  public boolean isSetReasons() {
    return this.reasons != null;
  }

  /**
   * Sets the reasons is set.
   *
   * @param value the new reasons is set
   */
  public void setReasonsIsSet(boolean value) {
    if (!value) {
      this.reasons = null;
    }
  }

  /* (non-Javadoc)
   * @see org.apache.thrift.TBase#setFieldValue(org.apache.thrift.TFieldIdEnum, java.lang.Object)
   */
  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case REASONS:
      if (value == null) {
        unsetReasons();
      } else {
        setReasons((Set<PendingReason>)value);
      }
      break;

    }
  }

  /* (non-Javadoc)
   * @see org.apache.thrift.TBase#getFieldValue(org.apache.thrift.TFieldIdEnum)
   */
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case REASONS:
      return getReasons();

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
    case REASONS:
      return isSetReasons();
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
    if (that instanceof GetPendingReasonResult)
      return this.equals((GetPendingReasonResult)that);
    return false;
  }

  /**
   * Equals.
   *
   * @param that the that
   * @return true, if successful
   */
  public boolean equals(GetPendingReasonResult that) {
    if (that == null)
      return false;

    boolean this_present_reasons = true && this.isSetReasons();
    boolean that_present_reasons = true && that.isSetReasons();
    if (this_present_reasons || that_present_reasons) {
      if (!(this_present_reasons && that_present_reasons))
        return false;
      if (!this.reasons.equals(that.reasons))
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

    boolean present_reasons = true && (isSetReasons());
    list.add(present_reasons);
    if (present_reasons)
      list.add(reasons);

    return list.hashCode();
  }

  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(GetPendingReasonResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetReasons()).compareTo(other.isSetReasons());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReasons()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.reasons, other.reasons);
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
    StringBuilder sb = new StringBuilder("GetPendingReasonResult(");
    boolean first = true;

    sb.append("reasons:");
    if (this.reasons == null) {
      sb.append("null");
    } else {
      sb.append(this.reasons);
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
   * A factory for creating GetPendingReasonResultStandardScheme objects.
   */
  private static class GetPendingReasonResultStandardSchemeFactory implements SchemeFactory {
    
    /* (non-Javadoc)
     * @see org.apache.thrift.scheme.SchemeFactory#getScheme()
     */
    public GetPendingReasonResultStandardScheme getScheme() {
      return new GetPendingReasonResultStandardScheme();
    }
  }

  /**
   * The Class GetPendingReasonResultStandardScheme.
   */
  private static class GetPendingReasonResultStandardScheme extends StandardScheme<GetPendingReasonResult> {

    /* (non-Javadoc)
     * @see org.apache.thrift.scheme.IScheme#read(org.apache.thrift.protocol.TProtocol, org.apache.thrift.TBase)
     */
    public void read(org.apache.thrift.protocol.TProtocol iprot, GetPendingReasonResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // REASONS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set318 = iprot.readSetBegin();
                struct.reasons = new HashSet<PendingReason>(2*_set318.size);
                PendingReason _elem319;
                for (int _i320 = 0; _i320 < _set318.size; ++_i320)
                {
                  _elem319 = new PendingReason();
                  _elem319.read(iprot);
                  struct.reasons.add(_elem319);
                }
                iprot.readSetEnd();
              }
              struct.setReasonsIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, GetPendingReasonResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.reasons != null) {
        oprot.writeFieldBegin(REASONS_FIELD_DESC);
        {
          oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, struct.reasons.size()));
          for (PendingReason _iter321 : struct.reasons)
          {
            _iter321.write(oprot);
          }
          oprot.writeSetEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  /**
   * A factory for creating GetPendingReasonResultTupleScheme objects.
   */
  private static class GetPendingReasonResultTupleSchemeFactory implements SchemeFactory {
    
    /* (non-Javadoc)
     * @see org.apache.thrift.scheme.SchemeFactory#getScheme()
     */
    public GetPendingReasonResultTupleScheme getScheme() {
      return new GetPendingReasonResultTupleScheme();
    }
  }

  /**
   * The Class GetPendingReasonResultTupleScheme.
   */
  private static class GetPendingReasonResultTupleScheme extends TupleScheme<GetPendingReasonResult> {

    /* (non-Javadoc)
     * @see org.apache.thrift.scheme.IScheme#write(org.apache.thrift.protocol.TProtocol, org.apache.thrift.TBase)
     */
    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GetPendingReasonResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetReasons()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetReasons()) {
        {
          oprot.writeI32(struct.reasons.size());
          for (PendingReason _iter322 : struct.reasons)
          {
            _iter322.write(oprot);
          }
        }
      }
    }

    /* (non-Javadoc)
     * @see org.apache.thrift.scheme.IScheme#read(org.apache.thrift.protocol.TProtocol, org.apache.thrift.TBase)
     */
    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GetPendingReasonResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TSet _set323 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.reasons = new HashSet<PendingReason>(2*_set323.size);
          PendingReason _elem324;
          for (int _i325 = 0; _i325 < _set323.size; ++_i325)
          {
            _elem324 = new PendingReason();
            _elem324.read(iprot);
            struct.reasons.add(_elem324);
          }
        }
        struct.setReasonsIsSet(true);
      }
    }
  }

}

