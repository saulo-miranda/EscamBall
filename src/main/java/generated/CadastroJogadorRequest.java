// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/proto/escamball.proto

package main.java.generated;

/**
 * Protobuf type {@code proto.CadastroJogadorRequest}
 */
public  final class CadastroJogadorRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:proto.CadastroJogadorRequest)
    CadastroJogadorRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CadastroJogadorRequest.newBuilder() to construct.
  private CadastroJogadorRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CadastroJogadorRequest() {
    nomeJogador_ = "";
    idadeJogador_ = 0;
    preco_ = 0L;
    idTime_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CadastroJogadorRequest(
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
          case 16: {

            idadeJogador_ = input.readInt32();
            break;
          }
          case 24: {

            preco_ = input.readInt64();
            break;
          }
          case 34: {
            main.java.generated.Posicao.Builder subBuilder = null;
            if (posicao_ != null) {
              subBuilder = posicao_.toBuilder();
            }
            posicao_ = input.readMessage(main.java.generated.Posicao.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(posicao_);
              posicao_ = subBuilder.buildPartial();
            }

            break;
          }
          case 42: {
            main.java.generated.Pontuacao.Builder subBuilder = null;
            if (pontuacao_ != null) {
              subBuilder = pontuacao_.toBuilder();
            }
            pontuacao_ = input.readMessage(main.java.generated.Pontuacao.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(pontuacao_);
              pontuacao_ = subBuilder.buildPartial();
            }

            break;
          }
          case 48: {

            idTime_ = input.readInt32();
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
    return main.java.generated.EscamballProtos.internal_static_proto_CadastroJogadorRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return main.java.generated.EscamballProtos.internal_static_proto_CadastroJogadorRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            main.java.generated.CadastroJogadorRequest.class, main.java.generated.CadastroJogadorRequest.Builder.class);
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

  public static final int IDADEJOGADOR_FIELD_NUMBER = 2;
  private int idadeJogador_;
  /**
   * <code>int32 idadeJogador = 2;</code>
   */
  public int getIdadeJogador() {
    return idadeJogador_;
  }

  public static final int PRECO_FIELD_NUMBER = 3;
  private long preco_;
  /**
   * <code>int64 preco = 3;</code>
   */
  public long getPreco() {
    return preco_;
  }

  public static final int POSICAO_FIELD_NUMBER = 4;
  private main.java.generated.Posicao posicao_;
  /**
   * <code>.proto.Posicao posicao = 4;</code>
   */
  public boolean hasPosicao() {
    return posicao_ != null;
  }
  /**
   * <code>.proto.Posicao posicao = 4;</code>
   */
  public main.java.generated.Posicao getPosicao() {
    return posicao_ == null ? main.java.generated.Posicao.getDefaultInstance() : posicao_;
  }
  /**
   * <code>.proto.Posicao posicao = 4;</code>
   */
  public main.java.generated.PosicaoOrBuilder getPosicaoOrBuilder() {
    return getPosicao();
  }

  public static final int PONTUACAO_FIELD_NUMBER = 5;
  private main.java.generated.Pontuacao pontuacao_;
  /**
   * <code>.proto.Pontuacao pontuacao = 5;</code>
   */
  public boolean hasPontuacao() {
    return pontuacao_ != null;
  }
  /**
   * <code>.proto.Pontuacao pontuacao = 5;</code>
   */
  public main.java.generated.Pontuacao getPontuacao() {
    return pontuacao_ == null ? main.java.generated.Pontuacao.getDefaultInstance() : pontuacao_;
  }
  /**
   * <code>.proto.Pontuacao pontuacao = 5;</code>
   */
  public main.java.generated.PontuacaoOrBuilder getPontuacaoOrBuilder() {
    return getPontuacao();
  }

  public static final int IDTIME_FIELD_NUMBER = 6;
  private int idTime_;
  /**
   * <code>int32 idTime = 6;</code>
   */
  public int getIdTime() {
    return idTime_;
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
    if (idadeJogador_ != 0) {
      output.writeInt32(2, idadeJogador_);
    }
    if (preco_ != 0L) {
      output.writeInt64(3, preco_);
    }
    if (posicao_ != null) {
      output.writeMessage(4, getPosicao());
    }
    if (pontuacao_ != null) {
      output.writeMessage(5, getPontuacao());
    }
    if (idTime_ != 0) {
      output.writeInt32(6, idTime_);
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
    if (idadeJogador_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, idadeJogador_);
    }
    if (preco_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, preco_);
    }
    if (posicao_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getPosicao());
    }
    if (pontuacao_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, getPontuacao());
    }
    if (idTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, idTime_);
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
    if (!(obj instanceof main.java.generated.CadastroJogadorRequest)) {
      return super.equals(obj);
    }
    main.java.generated.CadastroJogadorRequest other = (main.java.generated.CadastroJogadorRequest) obj;

    boolean result = true;
    result = result && getNomeJogador()
        .equals(other.getNomeJogador());
    result = result && (getIdadeJogador()
        == other.getIdadeJogador());
    result = result && (getPreco()
        == other.getPreco());
    result = result && (hasPosicao() == other.hasPosicao());
    if (hasPosicao()) {
      result = result && getPosicao()
          .equals(other.getPosicao());
    }
    result = result && (hasPontuacao() == other.hasPontuacao());
    if (hasPontuacao()) {
      result = result && getPontuacao()
          .equals(other.getPontuacao());
    }
    result = result && (getIdTime()
        == other.getIdTime());
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
    hash = (37 * hash) + IDADEJOGADOR_FIELD_NUMBER;
    hash = (53 * hash) + getIdadeJogador();
    hash = (37 * hash) + PRECO_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getPreco());
    if (hasPosicao()) {
      hash = (37 * hash) + POSICAO_FIELD_NUMBER;
      hash = (53 * hash) + getPosicao().hashCode();
    }
    if (hasPontuacao()) {
      hash = (37 * hash) + PONTUACAO_FIELD_NUMBER;
      hash = (53 * hash) + getPontuacao().hashCode();
    }
    hash = (37 * hash) + IDTIME_FIELD_NUMBER;
    hash = (53 * hash) + getIdTime();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static main.java.generated.CadastroJogadorRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.generated.CadastroJogadorRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.generated.CadastroJogadorRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.generated.CadastroJogadorRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.generated.CadastroJogadorRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static main.java.generated.CadastroJogadorRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static main.java.generated.CadastroJogadorRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static main.java.generated.CadastroJogadorRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static main.java.generated.CadastroJogadorRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static main.java.generated.CadastroJogadorRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static main.java.generated.CadastroJogadorRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static main.java.generated.CadastroJogadorRequest parseFrom(
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
  public static Builder newBuilder(main.java.generated.CadastroJogadorRequest prototype) {
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
   * Protobuf type {@code proto.CadastroJogadorRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.CadastroJogadorRequest)
      main.java.generated.CadastroJogadorRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return main.java.generated.EscamballProtos.internal_static_proto_CadastroJogadorRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return main.java.generated.EscamballProtos.internal_static_proto_CadastroJogadorRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              main.java.generated.CadastroJogadorRequest.class, main.java.generated.CadastroJogadorRequest.Builder.class);
    }

    // Construct using main.java.generated.CadastroJogadorRequest.newBuilder()
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

      idadeJogador_ = 0;

      preco_ = 0L;

      if (posicaoBuilder_ == null) {
        posicao_ = null;
      } else {
        posicao_ = null;
        posicaoBuilder_ = null;
      }
      if (pontuacaoBuilder_ == null) {
        pontuacao_ = null;
      } else {
        pontuacao_ = null;
        pontuacaoBuilder_ = null;
      }
      idTime_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return main.java.generated.EscamballProtos.internal_static_proto_CadastroJogadorRequest_descriptor;
    }

    @java.lang.Override
    public main.java.generated.CadastroJogadorRequest getDefaultInstanceForType() {
      return main.java.generated.CadastroJogadorRequest.getDefaultInstance();
    }

    @java.lang.Override
    public main.java.generated.CadastroJogadorRequest build() {
      main.java.generated.CadastroJogadorRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public main.java.generated.CadastroJogadorRequest buildPartial() {
      main.java.generated.CadastroJogadorRequest result = new main.java.generated.CadastroJogadorRequest(this);
      result.nomeJogador_ = nomeJogador_;
      result.idadeJogador_ = idadeJogador_;
      result.preco_ = preco_;
      if (posicaoBuilder_ == null) {
        result.posicao_ = posicao_;
      } else {
        result.posicao_ = posicaoBuilder_.build();
      }
      if (pontuacaoBuilder_ == null) {
        result.pontuacao_ = pontuacao_;
      } else {
        result.pontuacao_ = pontuacaoBuilder_.build();
      }
      result.idTime_ = idTime_;
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
      if (other instanceof main.java.generated.CadastroJogadorRequest) {
        return mergeFrom((main.java.generated.CadastroJogadorRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(main.java.generated.CadastroJogadorRequest other) {
      if (other == main.java.generated.CadastroJogadorRequest.getDefaultInstance()) return this;
      if (!other.getNomeJogador().isEmpty()) {
        nomeJogador_ = other.nomeJogador_;
        onChanged();
      }
      if (other.getIdadeJogador() != 0) {
        setIdadeJogador(other.getIdadeJogador());
      }
      if (other.getPreco() != 0L) {
        setPreco(other.getPreco());
      }
      if (other.hasPosicao()) {
        mergePosicao(other.getPosicao());
      }
      if (other.hasPontuacao()) {
        mergePontuacao(other.getPontuacao());
      }
      if (other.getIdTime() != 0) {
        setIdTime(other.getIdTime());
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
      main.java.generated.CadastroJogadorRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (main.java.generated.CadastroJogadorRequest) e.getUnfinishedMessage();
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

    private int idadeJogador_ ;
    /**
     * <code>int32 idadeJogador = 2;</code>
     */
    public int getIdadeJogador() {
      return idadeJogador_;
    }
    /**
     * <code>int32 idadeJogador = 2;</code>
     */
    public Builder setIdadeJogador(int value) {
      
      idadeJogador_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 idadeJogador = 2;</code>
     */
    public Builder clearIdadeJogador() {
      
      idadeJogador_ = 0;
      onChanged();
      return this;
    }

    private long preco_ ;
    /**
     * <code>int64 preco = 3;</code>
     */
    public long getPreco() {
      return preco_;
    }
    /**
     * <code>int64 preco = 3;</code>
     */
    public Builder setPreco(long value) {
      
      preco_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 preco = 3;</code>
     */
    public Builder clearPreco() {
      
      preco_ = 0L;
      onChanged();
      return this;
    }

    private main.java.generated.Posicao posicao_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        main.java.generated.Posicao, main.java.generated.Posicao.Builder, main.java.generated.PosicaoOrBuilder> posicaoBuilder_;
    /**
     * <code>.proto.Posicao posicao = 4;</code>
     */
    public boolean hasPosicao() {
      return posicaoBuilder_ != null || posicao_ != null;
    }
    /**
     * <code>.proto.Posicao posicao = 4;</code>
     */
    public main.java.generated.Posicao getPosicao() {
      if (posicaoBuilder_ == null) {
        return posicao_ == null ? main.java.generated.Posicao.getDefaultInstance() : posicao_;
      } else {
        return posicaoBuilder_.getMessage();
      }
    }
    /**
     * <code>.proto.Posicao posicao = 4;</code>
     */
    public Builder setPosicao(main.java.generated.Posicao value) {
      if (posicaoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        posicao_ = value;
        onChanged();
      } else {
        posicaoBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.proto.Posicao posicao = 4;</code>
     */
    public Builder setPosicao(
        main.java.generated.Posicao.Builder builderForValue) {
      if (posicaoBuilder_ == null) {
        posicao_ = builderForValue.build();
        onChanged();
      } else {
        posicaoBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.proto.Posicao posicao = 4;</code>
     */
    public Builder mergePosicao(main.java.generated.Posicao value) {
      if (posicaoBuilder_ == null) {
        if (posicao_ != null) {
          posicao_ =
            main.java.generated.Posicao.newBuilder(posicao_).mergeFrom(value).buildPartial();
        } else {
          posicao_ = value;
        }
        onChanged();
      } else {
        posicaoBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.proto.Posicao posicao = 4;</code>
     */
    public Builder clearPosicao() {
      if (posicaoBuilder_ == null) {
        posicao_ = null;
        onChanged();
      } else {
        posicao_ = null;
        posicaoBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.proto.Posicao posicao = 4;</code>
     */
    public main.java.generated.Posicao.Builder getPosicaoBuilder() {
      
      onChanged();
      return getPosicaoFieldBuilder().getBuilder();
    }
    /**
     * <code>.proto.Posicao posicao = 4;</code>
     */
    public main.java.generated.PosicaoOrBuilder getPosicaoOrBuilder() {
      if (posicaoBuilder_ != null) {
        return posicaoBuilder_.getMessageOrBuilder();
      } else {
        return posicao_ == null ?
            main.java.generated.Posicao.getDefaultInstance() : posicao_;
      }
    }
    /**
     * <code>.proto.Posicao posicao = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        main.java.generated.Posicao, main.java.generated.Posicao.Builder, main.java.generated.PosicaoOrBuilder> 
        getPosicaoFieldBuilder() {
      if (posicaoBuilder_ == null) {
        posicaoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            main.java.generated.Posicao, main.java.generated.Posicao.Builder, main.java.generated.PosicaoOrBuilder>(
                getPosicao(),
                getParentForChildren(),
                isClean());
        posicao_ = null;
      }
      return posicaoBuilder_;
    }

    private main.java.generated.Pontuacao pontuacao_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        main.java.generated.Pontuacao, main.java.generated.Pontuacao.Builder, main.java.generated.PontuacaoOrBuilder> pontuacaoBuilder_;
    /**
     * <code>.proto.Pontuacao pontuacao = 5;</code>
     */
    public boolean hasPontuacao() {
      return pontuacaoBuilder_ != null || pontuacao_ != null;
    }
    /**
     * <code>.proto.Pontuacao pontuacao = 5;</code>
     */
    public main.java.generated.Pontuacao getPontuacao() {
      if (pontuacaoBuilder_ == null) {
        return pontuacao_ == null ? main.java.generated.Pontuacao.getDefaultInstance() : pontuacao_;
      } else {
        return pontuacaoBuilder_.getMessage();
      }
    }
    /**
     * <code>.proto.Pontuacao pontuacao = 5;</code>
     */
    public Builder setPontuacao(main.java.generated.Pontuacao value) {
      if (pontuacaoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        pontuacao_ = value;
        onChanged();
      } else {
        pontuacaoBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.proto.Pontuacao pontuacao = 5;</code>
     */
    public Builder setPontuacao(
        main.java.generated.Pontuacao.Builder builderForValue) {
      if (pontuacaoBuilder_ == null) {
        pontuacao_ = builderForValue.build();
        onChanged();
      } else {
        pontuacaoBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.proto.Pontuacao pontuacao = 5;</code>
     */
    public Builder mergePontuacao(main.java.generated.Pontuacao value) {
      if (pontuacaoBuilder_ == null) {
        if (pontuacao_ != null) {
          pontuacao_ =
            main.java.generated.Pontuacao.newBuilder(pontuacao_).mergeFrom(value).buildPartial();
        } else {
          pontuacao_ = value;
        }
        onChanged();
      } else {
        pontuacaoBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.proto.Pontuacao pontuacao = 5;</code>
     */
    public Builder clearPontuacao() {
      if (pontuacaoBuilder_ == null) {
        pontuacao_ = null;
        onChanged();
      } else {
        pontuacao_ = null;
        pontuacaoBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.proto.Pontuacao pontuacao = 5;</code>
     */
    public main.java.generated.Pontuacao.Builder getPontuacaoBuilder() {
      
      onChanged();
      return getPontuacaoFieldBuilder().getBuilder();
    }
    /**
     * <code>.proto.Pontuacao pontuacao = 5;</code>
     */
    public main.java.generated.PontuacaoOrBuilder getPontuacaoOrBuilder() {
      if (pontuacaoBuilder_ != null) {
        return pontuacaoBuilder_.getMessageOrBuilder();
      } else {
        return pontuacao_ == null ?
            main.java.generated.Pontuacao.getDefaultInstance() : pontuacao_;
      }
    }
    /**
     * <code>.proto.Pontuacao pontuacao = 5;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        main.java.generated.Pontuacao, main.java.generated.Pontuacao.Builder, main.java.generated.PontuacaoOrBuilder> 
        getPontuacaoFieldBuilder() {
      if (pontuacaoBuilder_ == null) {
        pontuacaoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            main.java.generated.Pontuacao, main.java.generated.Pontuacao.Builder, main.java.generated.PontuacaoOrBuilder>(
                getPontuacao(),
                getParentForChildren(),
                isClean());
        pontuacao_ = null;
      }
      return pontuacaoBuilder_;
    }

    private int idTime_ ;
    /**
     * <code>int32 idTime = 6;</code>
     */
    public int getIdTime() {
      return idTime_;
    }
    /**
     * <code>int32 idTime = 6;</code>
     */
    public Builder setIdTime(int value) {
      
      idTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 idTime = 6;</code>
     */
    public Builder clearIdTime() {
      
      idTime_ = 0;
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


    // @@protoc_insertion_point(builder_scope:proto.CadastroJogadorRequest)
  }

  // @@protoc_insertion_point(class_scope:proto.CadastroJogadorRequest)
  private static final main.java.generated.CadastroJogadorRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new main.java.generated.CadastroJogadorRequest();
  }

  public static main.java.generated.CadastroJogadorRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CadastroJogadorRequest>
      PARSER = new com.google.protobuf.AbstractParser<CadastroJogadorRequest>() {
    @java.lang.Override
    public CadastroJogadorRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CadastroJogadorRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CadastroJogadorRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CadastroJogadorRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public main.java.generated.CadastroJogadorRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
