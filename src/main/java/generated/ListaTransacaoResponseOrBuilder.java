// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/proto/escamball.proto

package main.java.generated;

public interface ListaTransacaoResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.ListaTransacaoResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string responseMessage = 1;</code>
   */
  java.lang.String getResponseMessage();
  /**
   * <code>string responseMessage = 1;</code>
   */
  com.google.protobuf.ByteString
      getResponseMessageBytes();

  /**
   * <code>repeated .proto.TransacaoJogador transacoes = 2;</code>
   */
  java.util.List<main.java.generated.TransacaoJogador> 
      getTransacoesList();
  /**
   * <code>repeated .proto.TransacaoJogador transacoes = 2;</code>
   */
  main.java.generated.TransacaoJogador getTransacoes(int index);
  /**
   * <code>repeated .proto.TransacaoJogador transacoes = 2;</code>
   */
  int getTransacoesCount();
  /**
   * <code>repeated .proto.TransacaoJogador transacoes = 2;</code>
   */
  java.util.List<? extends main.java.generated.TransacaoJogadorOrBuilder> 
      getTransacoesOrBuilderList();
  /**
   * <code>repeated .proto.TransacaoJogador transacoes = 2;</code>
   */
  main.java.generated.TransacaoJogadorOrBuilder getTransacoesOrBuilder(
      int index);
}
