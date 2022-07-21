// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/proto/escamball.proto

package main.java.generated;

/**
 * Protobuf type {@code proto.PesquisaPorIdJogadorRequest}
 */
public  final class PesquisaPorIdJogadorRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:proto.PesquisaPorIdJogadorRequest)
    PesquisaPorIdJogadorRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PesquisaPorIdJogadorRequest.newBuilder() to construct.
  private PesquisaPorIdJogadorRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PesquisaPorIdJogadorRequest() {
    idJogador_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PesquisaPorIdJogadorRequest(
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
          case 8: {

            idJogador_ = input.readInt32();
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
    return main.java.generated.EscamballProtos.internal_static_proto_PesquisaPorIdJogadorRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return main.java.generated.EscamballProtos.internal_static_proto_PesquisaPorIdJogadorRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            main.java.generated.PesquisaPorIdJogadorRequest.class, main.java.generated.PesquisaPorIdJogadorRequest.Builder.class);
  }

  public static final int IDJOGADOR_FIELD_NUMBER = 1;
  private int idJogador_;
  /**
   * <code>int32 idJogador = 1;</code>
   */
  public int getIdJogador() {
    return idJogador_;
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
    if (idJogador_ != 0) {
      output.writeInt32(1, idJogador_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (idJogador_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, idJogador_);
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
    if (!(obj instanceof main.java.generated.PesquisaPorIdJogadorRequest)) {
      return super.equals(obj);
    }
    main.java.generated.PesquisaPorIdJogadorRequest other = (main.java.generated.PesquisaPorIdJogadorRequest) obj;

    boolean result = true;
    result = result && (getIdJogador()
        == other.getIdJogador());
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
    hash = (37 * hash) + IDJOGADOR_FIELD_NUMBER;
    hash = (53 * hash) + getIdJogador();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static main.java.generated.PesquisaPorIdJogadorRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.generated.PesquisaPorIdJogadorRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.generated.PesquisaPorIdJogadorRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.generated.PesquisaPorIdJogadorRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.generated.PesquisaPorIdJogadorRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.generated.PesquisaPorIdJogadorRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.generated.PesquisaPorIdJogadorRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static main.java.generated.PesquisaPorIdJogadorRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static main.java.generated.PesquisaPorIdJogadorRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static main.java.generated.PesquisaPorIdJogadorRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static main.java.generated.PesquisaPorIdJogadorRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static main.java.generated.PesquisaPorIdJogadorRequest parseFrom(
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
  public static Builder newBuilder(main.java.generated.PesquisaPorIdJogadorRequest prototype) {
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
   * Protobuf type {@code proto.PesquisaPorIdJogadorRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.PesquisaPorIdJogadorRequest)
      main.java.generated.PesquisaPorIdJogadorRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return main.java.generated.EscamballProtos.internal_static_proto_PesquisaPorIdJogadorRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return main.java.generated.EscamballProtos.internal_static_proto_PesquisaPorIdJogadorRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              main.java.generated.PesquisaPorIdJogadorRequest.class, main.java.generated.PesquisaPorIdJogadorRequest.Builder.class);
    }

    // Construct using main.java.generated.PesquisaPorIdJogadorRequest.newBuilder()
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
      idJogador_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return main.java.generated.EscamballProtos.internal_static_proto_PesquisaPorIdJogadorRequest_descriptor;
    }

    @java.lang.Override
    public main.java.generated.PesquisaPorIdJogadorRequest getDefaultInstanceForType() {
      return main.java.generated.PesquisaPorIdJogadorRequest.getDefaultInstance();
    }

    @java.lang.Override
    public main.java.generated.PesquisaPorIdJogadorRequest build() {
      main.java.generated.PesquisaPorIdJogadorRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public main.java.generated.PesquisaPorIdJogadorRequest buildPartial() {
      main.java.generated.PesquisaPorIdJogadorRequest result = new main.java.generated.PesquisaPorIdJogadorRequest(this);
      result.idJogador_ = idJogador_;
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
      if (other instanceof main.java.generated.PesquisaPorIdJogadorRequest) {
        return mergeFrom((main.java.generated.PesquisaPorIdJogadorRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(main.java.generated.PesquisaPorIdJogadorRequest other) {
      if (other == main.java.generated.PesquisaPorIdJogadorRequest.getDefaultInstance()) return this;
      if (other.getIdJogador() != 0) {
        setIdJogador(other.getIdJogador());
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
      main.java.generated.PesquisaPorIdJogadorRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (main.java.generated.PesquisaPorIdJogadorRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int idJogador_ ;
    /**
     * <code>int32 idJogador = 1;</code>
     */
    public int getIdJogador() {
      return idJogador_;
    }
    /**
     * <code>int32 idJogador = 1;</code>
     */
    public Builder setIdJogador(int value) {
      
      idJogador_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 idJogador = 1;</code>
     */
    public Builder clearIdJogador() {
      
      idJogador_ = 0;
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


    // @@protoc_insertion_point(builder_scope:proto.PesquisaPorIdJogadorRequest)
  }

  // @@protoc_insertion_point(class_scope:proto.PesquisaPorIdJogadorRequest)
  private static final main.java.generated.PesquisaPorIdJogadorRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new main.java.generated.PesquisaPorIdJogadorRequest();
  }

  public static main.java.generated.PesquisaPorIdJogadorRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PesquisaPorIdJogadorRequest>
      PARSER = new com.google.protobuf.AbstractParser<PesquisaPorIdJogadorRequest>() {
    @java.lang.Override
    public PesquisaPorIdJogadorRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PesquisaPorIdJogadorRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PesquisaPorIdJogadorRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PesquisaPorIdJogadorRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public main.java.generated.PesquisaPorIdJogadorRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

