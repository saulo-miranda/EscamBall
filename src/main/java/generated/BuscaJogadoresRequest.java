// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/proto/escamball.proto

package main.java.generated;

/**
 * Protobuf type {@code proto.BuscaJogadoresRequest}
 */
public  final class BuscaJogadoresRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:proto.BuscaJogadoresRequest)
    BuscaJogadoresRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BuscaJogadoresRequest.newBuilder() to construct.
  private BuscaJogadoresRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BuscaJogadoresRequest() {
    nomeJogador_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BuscaJogadoresRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            nomeJogador_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return main.java.generated.EscamballProtos.internal_static_proto_BuscaJogadoresRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return main.java.generated.EscamballProtos.internal_static_proto_BuscaJogadoresRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            main.java.generated.BuscaJogadoresRequest.class, main.java.generated.BuscaJogadoresRequest.Builder.class);
  }

  public static final int NOMEJOGADOR_FIELD_NUMBER = 1;
  private volatile java.lang.Object nomeJogador_;
  /**
   * <code>string nomeJogador = 1;</code>
   */
  public java.lang.String getNomeJogador() {
    java.lang.Object ref = nomeJogador_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      nomeJogador_ = s;
      return s;
    }
  }
  /**
   * <code>string nomeJogador = 1;</code>
   */
  public com.google.protobuf.ByteString
      getNomeJogadorBytes() {
    java.lang.Object ref = nomeJogador_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      nomeJogador_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getNomeJogadorBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, nomeJogador_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNomeJogadorBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, nomeJogador_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof main.java.generated.BuscaJogadoresRequest)) {
      return super.equals(obj);
    }
    main.java.generated.BuscaJogadoresRequest other = (main.java.generated.BuscaJogadoresRequest) obj;

    boolean result = true;
    result = result && getNomeJogador()
        .equals(other.getNomeJogador());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NOMEJOGADOR_FIELD_NUMBER;
    hash = (53 * hash) + getNomeJogador().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static main.java.generated.BuscaJogadoresRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.generated.BuscaJogadoresRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.generated.BuscaJogadoresRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.generated.BuscaJogadoresRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.generated.BuscaJogadoresRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.generated.BuscaJogadoresRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.generated.BuscaJogadoresRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static main.java.generated.BuscaJogadoresRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static main.java.generated.BuscaJogadoresRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static main.java.generated.BuscaJogadoresRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static main.java.generated.BuscaJogadoresRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static main.java.generated.BuscaJogadoresRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(main.java.generated.BuscaJogadoresRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code proto.BuscaJogadoresRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.BuscaJogadoresRequest)
      main.java.generated.BuscaJogadoresRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return main.java.generated.EscamballProtos.internal_static_proto_BuscaJogadoresRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return main.java.generated.EscamballProtos.internal_static_proto_BuscaJogadoresRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              main.java.generated.BuscaJogadoresRequest.class, main.java.generated.BuscaJogadoresRequest.Builder.class);
    }

    // Construct using main.java.generated.BuscaJogadoresRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      nomeJogador_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return main.java.generated.EscamballProtos.internal_static_proto_BuscaJogadoresRequest_descriptor;
    }

    @java.lang.Override
    public main.java.generated.BuscaJogadoresRequest getDefaultInstanceForType() {
      return main.java.generated.BuscaJogadoresRequest.getDefaultInstance();
    }

    @java.lang.Override
    public main.java.generated.BuscaJogadoresRequest build() {
      main.java.generated.BuscaJogadoresRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public main.java.generated.BuscaJogadoresRequest buildPartial() {
      main.java.generated.BuscaJogadoresRequest result = new main.java.generated.BuscaJogadoresRequest(this);
      result.nomeJogador_ = nomeJogador_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof main.java.generated.BuscaJogadoresRequest) {
        return mergeFrom((main.java.generated.BuscaJogadoresRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(main.java.generated.BuscaJogadoresRequest other) {
      if (other == main.java.generated.BuscaJogadoresRequest.getDefaultInstance()) return this;
      if (!other.getNomeJogador().isEmpty()) {
        nomeJogador_ = other.nomeJogador_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      main.java.generated.BuscaJogadoresRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (main.java.generated.BuscaJogadoresRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object nomeJogador_ = "";
    /**
     * <code>string nomeJogador = 1;</code>
     */
    public java.lang.String getNomeJogador() {
      java.lang.Object ref = nomeJogador_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        nomeJogador_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string nomeJogador = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNomeJogadorBytes() {
      java.lang.Object ref = nomeJogador_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        nomeJogador_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string nomeJogador = 1;</code>
     */
    public Builder setNomeJogador(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      nomeJogador_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string nomeJogador = 1;</code>
     */
    public Builder clearNomeJogador() {
      
      nomeJogador_ = getDefaultInstance().getNomeJogador();
      onChanged();
      return this;
    }
    /**
     * <code>string nomeJogador = 1;</code>
     */
    public Builder setNomeJogadorBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      nomeJogador_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:proto.BuscaJogadoresRequest)
  }

  // @@protoc_insertion_point(class_scope:proto.BuscaJogadoresRequest)
  private static final main.java.generated.BuscaJogadoresRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new main.java.generated.BuscaJogadoresRequest();
  }

  public static main.java.generated.BuscaJogadoresRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BuscaJogadoresRequest>
      PARSER = new com.google.protobuf.AbstractParser<BuscaJogadoresRequest>() {
    @java.lang.Override
    public BuscaJogadoresRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BuscaJogadoresRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BuscaJogadoresRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BuscaJogadoresRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public main.java.generated.BuscaJogadoresRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
