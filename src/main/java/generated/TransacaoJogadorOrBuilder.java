// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/proto/escamball.proto

package main.java.generated;

public interface TransacaoJogadorOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.TransacaoJogador)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 idTransacao = 1;</code>
   */
  int getIdTransacao();

  /**
   * <code>int32 idTimeProposto = 2;</code>
   */
  int getIdTimeProposto();

  /**
   * <code>int32 idTimeReceptor = 3;</code>
   */
  int getIdTimeReceptor();

  /**
   * <code>.proto.Jogador jogadorProposto = 4;</code>
   */
  boolean hasJogadorProposto();
  /**
   * <code>.proto.Jogador jogadorProposto = 4;</code>
   */
  main.java.generated.Jogador getJogadorProposto();
  /**
   * <code>.proto.Jogador jogadorProposto = 4;</code>
   */
  main.java.generated.JogadorOrBuilder getJogadorPropostoOrBuilder();

  /**
   * <code>.proto.Jogador jogadorDesejado = 5;</code>
   */
  boolean hasJogadorDesejado();
  /**
   * <code>.proto.Jogador jogadorDesejado = 5;</code>
   */
  main.java.generated.Jogador getJogadorDesejado();
  /**
   * <code>.proto.Jogador jogadorDesejado = 5;</code>
   */
  main.java.generated.JogadorOrBuilder getJogadorDesejadoOrBuilder();
}