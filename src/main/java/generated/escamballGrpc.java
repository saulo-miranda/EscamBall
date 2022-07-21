package main.java.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.27.2)",
    comments = "Source: main/proto/escamball.proto")
public final class escamballGrpc {

  private escamballGrpc() {}

  public static final String SERVICE_NAME = "proto.escamball";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<main.java.generated.CadastroRequest,
      main.java.generated.APIResponse> getCadastroMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "cadastro",
      requestType = main.java.generated.CadastroRequest.class,
      responseType = main.java.generated.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<main.java.generated.CadastroRequest,
      main.java.generated.APIResponse> getCadastroMethod() {
    io.grpc.MethodDescriptor<main.java.generated.CadastroRequest, main.java.generated.APIResponse> getCadastroMethod;
    if ((getCadastroMethod = escamballGrpc.getCadastroMethod) == null) {
      synchronized (escamballGrpc.class) {
        if ((getCadastroMethod = escamballGrpc.getCadastroMethod) == null) {
          escamballGrpc.getCadastroMethod = getCadastroMethod =
              io.grpc.MethodDescriptor.<main.java.generated.CadastroRequest, main.java.generated.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "cadastro"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.CadastroRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new escamballMethodDescriptorSupplier("cadastro"))
              .build();
        }
      }
    }
    return getCadastroMethod;
  }

  private static volatile io.grpc.MethodDescriptor<main.java.generated.CadastroJogadorRequest,
      main.java.generated.APIResponse> getCadastroJogadorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "cadastroJogador",
      requestType = main.java.generated.CadastroJogadorRequest.class,
      responseType = main.java.generated.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<main.java.generated.CadastroJogadorRequest,
      main.java.generated.APIResponse> getCadastroJogadorMethod() {
    io.grpc.MethodDescriptor<main.java.generated.CadastroJogadorRequest, main.java.generated.APIResponse> getCadastroJogadorMethod;
    if ((getCadastroJogadorMethod = escamballGrpc.getCadastroJogadorMethod) == null) {
      synchronized (escamballGrpc.class) {
        if ((getCadastroJogadorMethod = escamballGrpc.getCadastroJogadorMethod) == null) {
          escamballGrpc.getCadastroJogadorMethod = getCadastroJogadorMethod =
              io.grpc.MethodDescriptor.<main.java.generated.CadastroJogadorRequest, main.java.generated.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "cadastroJogador"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.CadastroJogadorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new escamballMethodDescriptorSupplier("cadastroJogador"))
              .build();
        }
      }
    }
    return getCadastroJogadorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<main.java.generated.TransacaoRequest,
      main.java.generated.APIResponse> getNovaTransacaoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "novaTransacao",
      requestType = main.java.generated.TransacaoRequest.class,
      responseType = main.java.generated.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<main.java.generated.TransacaoRequest,
      main.java.generated.APIResponse> getNovaTransacaoMethod() {
    io.grpc.MethodDescriptor<main.java.generated.TransacaoRequest, main.java.generated.APIResponse> getNovaTransacaoMethod;
    if ((getNovaTransacaoMethod = escamballGrpc.getNovaTransacaoMethod) == null) {
      synchronized (escamballGrpc.class) {
        if ((getNovaTransacaoMethod = escamballGrpc.getNovaTransacaoMethod) == null) {
          escamballGrpc.getNovaTransacaoMethod = getNovaTransacaoMethod =
              io.grpc.MethodDescriptor.<main.java.generated.TransacaoRequest, main.java.generated.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "novaTransacao"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.TransacaoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new escamballMethodDescriptorSupplier("novaTransacao"))
              .build();
        }
      }
    }
    return getNovaTransacaoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<main.java.generated.RespostaTransacaoRequest,
      main.java.generated.APIResponse> getResponderTransacaoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "responderTransacao",
      requestType = main.java.generated.RespostaTransacaoRequest.class,
      responseType = main.java.generated.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<main.java.generated.RespostaTransacaoRequest,
      main.java.generated.APIResponse> getResponderTransacaoMethod() {
    io.grpc.MethodDescriptor<main.java.generated.RespostaTransacaoRequest, main.java.generated.APIResponse> getResponderTransacaoMethod;
    if ((getResponderTransacaoMethod = escamballGrpc.getResponderTransacaoMethod) == null) {
      synchronized (escamballGrpc.class) {
        if ((getResponderTransacaoMethod = escamballGrpc.getResponderTransacaoMethod) == null) {
          escamballGrpc.getResponderTransacaoMethod = getResponderTransacaoMethod =
              io.grpc.MethodDescriptor.<main.java.generated.RespostaTransacaoRequest, main.java.generated.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "responderTransacao"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.RespostaTransacaoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new escamballMethodDescriptorSupplier("responderTransacao"))
              .build();
        }
      }
    }
    return getResponderTransacaoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<main.java.generated.LoginRequest,
      main.java.generated.TimeResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = main.java.generated.LoginRequest.class,
      responseType = main.java.generated.TimeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<main.java.generated.LoginRequest,
      main.java.generated.TimeResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<main.java.generated.LoginRequest, main.java.generated.TimeResponse> getLoginMethod;
    if ((getLoginMethod = escamballGrpc.getLoginMethod) == null) {
      synchronized (escamballGrpc.class) {
        if ((getLoginMethod = escamballGrpc.getLoginMethod) == null) {
          escamballGrpc.getLoginMethod = getLoginMethod =
              io.grpc.MethodDescriptor.<main.java.generated.LoginRequest, main.java.generated.TimeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.TimeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new escamballMethodDescriptorSupplier("login"))
              .build();
        }
      }
    }
    return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdTimeRequest,
      main.java.generated.TimeResponse> getRecuperaTimePeloIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "recuperaTimePeloId",
      requestType = main.java.generated.PesquisaPorIdTimeRequest.class,
      responseType = main.java.generated.TimeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdTimeRequest,
      main.java.generated.TimeResponse> getRecuperaTimePeloIdMethod() {
    io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdTimeRequest, main.java.generated.TimeResponse> getRecuperaTimePeloIdMethod;
    if ((getRecuperaTimePeloIdMethod = escamballGrpc.getRecuperaTimePeloIdMethod) == null) {
      synchronized (escamballGrpc.class) {
        if ((getRecuperaTimePeloIdMethod = escamballGrpc.getRecuperaTimePeloIdMethod) == null) {
          escamballGrpc.getRecuperaTimePeloIdMethod = getRecuperaTimePeloIdMethod =
              io.grpc.MethodDescriptor.<main.java.generated.PesquisaPorIdTimeRequest, main.java.generated.TimeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "recuperaTimePeloId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.PesquisaPorIdTimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.TimeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new escamballMethodDescriptorSupplier("recuperaTimePeloId"))
              .build();
        }
      }
    }
    return getRecuperaTimePeloIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdJogadorRequest,
      main.java.generated.JogadorResponse> getRecuperaJogadorPeloIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "recuperaJogadorPeloId",
      requestType = main.java.generated.PesquisaPorIdJogadorRequest.class,
      responseType = main.java.generated.JogadorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdJogadorRequest,
      main.java.generated.JogadorResponse> getRecuperaJogadorPeloIdMethod() {
    io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdJogadorRequest, main.java.generated.JogadorResponse> getRecuperaJogadorPeloIdMethod;
    if ((getRecuperaJogadorPeloIdMethod = escamballGrpc.getRecuperaJogadorPeloIdMethod) == null) {
      synchronized (escamballGrpc.class) {
        if ((getRecuperaJogadorPeloIdMethod = escamballGrpc.getRecuperaJogadorPeloIdMethod) == null) {
          escamballGrpc.getRecuperaJogadorPeloIdMethod = getRecuperaJogadorPeloIdMethod =
              io.grpc.MethodDescriptor.<main.java.generated.PesquisaPorIdJogadorRequest, main.java.generated.JogadorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "recuperaJogadorPeloId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.PesquisaPorIdJogadorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.JogadorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new escamballMethodDescriptorSupplier("recuperaJogadorPeloId"))
              .build();
        }
      }
    }
    return getRecuperaJogadorPeloIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdTransacaoRequest,
      main.java.generated.TransacaoResponse> getRecuperaTransacaoPeloIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "recuperaTransacaoPeloId",
      requestType = main.java.generated.PesquisaPorIdTransacaoRequest.class,
      responseType = main.java.generated.TransacaoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdTransacaoRequest,
      main.java.generated.TransacaoResponse> getRecuperaTransacaoPeloIdMethod() {
    io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdTransacaoRequest, main.java.generated.TransacaoResponse> getRecuperaTransacaoPeloIdMethod;
    if ((getRecuperaTransacaoPeloIdMethod = escamballGrpc.getRecuperaTransacaoPeloIdMethod) == null) {
      synchronized (escamballGrpc.class) {
        if ((getRecuperaTransacaoPeloIdMethod = escamballGrpc.getRecuperaTransacaoPeloIdMethod) == null) {
          escamballGrpc.getRecuperaTransacaoPeloIdMethod = getRecuperaTransacaoPeloIdMethod =
              io.grpc.MethodDescriptor.<main.java.generated.PesquisaPorIdTransacaoRequest, main.java.generated.TransacaoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "recuperaTransacaoPeloId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.PesquisaPorIdTransacaoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.TransacaoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new escamballMethodDescriptorSupplier("recuperaTransacaoPeloId"))
              .build();
        }
      }
    }
    return getRecuperaTransacaoPeloIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<main.java.generated.BuscaJogadoresRequest,
      main.java.generated.ListaJogadoresResponse> getBuscaJogadoresNomeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "buscaJogadoresNome",
      requestType = main.java.generated.BuscaJogadoresRequest.class,
      responseType = main.java.generated.ListaJogadoresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<main.java.generated.BuscaJogadoresRequest,
      main.java.generated.ListaJogadoresResponse> getBuscaJogadoresNomeMethod() {
    io.grpc.MethodDescriptor<main.java.generated.BuscaJogadoresRequest, main.java.generated.ListaJogadoresResponse> getBuscaJogadoresNomeMethod;
    if ((getBuscaJogadoresNomeMethod = escamballGrpc.getBuscaJogadoresNomeMethod) == null) {
      synchronized (escamballGrpc.class) {
        if ((getBuscaJogadoresNomeMethod = escamballGrpc.getBuscaJogadoresNomeMethod) == null) {
          escamballGrpc.getBuscaJogadoresNomeMethod = getBuscaJogadoresNomeMethod =
              io.grpc.MethodDescriptor.<main.java.generated.BuscaJogadoresRequest, main.java.generated.ListaJogadoresResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "buscaJogadoresNome"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.BuscaJogadoresRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.ListaJogadoresResponse.getDefaultInstance()))
              .setSchemaDescriptor(new escamballMethodDescriptorSupplier("buscaJogadoresNome"))
              .build();
        }
      }
    }
    return getBuscaJogadoresNomeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<main.java.generated.BuscaJogadoresPosicaoRequest,
      main.java.generated.ListaJogadoresResponse> getBuscaJogadoresPosicaoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "buscaJogadoresPosicao",
      requestType = main.java.generated.BuscaJogadoresPosicaoRequest.class,
      responseType = main.java.generated.ListaJogadoresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<main.java.generated.BuscaJogadoresPosicaoRequest,
      main.java.generated.ListaJogadoresResponse> getBuscaJogadoresPosicaoMethod() {
    io.grpc.MethodDescriptor<main.java.generated.BuscaJogadoresPosicaoRequest, main.java.generated.ListaJogadoresResponse> getBuscaJogadoresPosicaoMethod;
    if ((getBuscaJogadoresPosicaoMethod = escamballGrpc.getBuscaJogadoresPosicaoMethod) == null) {
      synchronized (escamballGrpc.class) {
        if ((getBuscaJogadoresPosicaoMethod = escamballGrpc.getBuscaJogadoresPosicaoMethod) == null) {
          escamballGrpc.getBuscaJogadoresPosicaoMethod = getBuscaJogadoresPosicaoMethod =
              io.grpc.MethodDescriptor.<main.java.generated.BuscaJogadoresPosicaoRequest, main.java.generated.ListaJogadoresResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "buscaJogadoresPosicao"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.BuscaJogadoresPosicaoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.ListaJogadoresResponse.getDefaultInstance()))
              .setSchemaDescriptor(new escamballMethodDescriptorSupplier("buscaJogadoresPosicao"))
              .build();
        }
      }
    }
    return getBuscaJogadoresPosicaoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdTimeRequest,
      main.java.generated.ListaJogadoresResponse> getExibeListaJogadoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "exibeListaJogadores",
      requestType = main.java.generated.PesquisaPorIdTimeRequest.class,
      responseType = main.java.generated.ListaJogadoresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdTimeRequest,
      main.java.generated.ListaJogadoresResponse> getExibeListaJogadoresMethod() {
    io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdTimeRequest, main.java.generated.ListaJogadoresResponse> getExibeListaJogadoresMethod;
    if ((getExibeListaJogadoresMethod = escamballGrpc.getExibeListaJogadoresMethod) == null) {
      synchronized (escamballGrpc.class) {
        if ((getExibeListaJogadoresMethod = escamballGrpc.getExibeListaJogadoresMethod) == null) {
          escamballGrpc.getExibeListaJogadoresMethod = getExibeListaJogadoresMethod =
              io.grpc.MethodDescriptor.<main.java.generated.PesquisaPorIdTimeRequest, main.java.generated.ListaJogadoresResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "exibeListaJogadores"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.PesquisaPorIdTimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.ListaJogadoresResponse.getDefaultInstance()))
              .setSchemaDescriptor(new escamballMethodDescriptorSupplier("exibeListaJogadores"))
              .build();
        }
      }
    }
    return getExibeListaJogadoresMethod;
  }

  private static volatile io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdTimeRequest,
      main.java.generated.ListaTransacaoResponse> getHistoricoTransacoesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "historicoTransacoes",
      requestType = main.java.generated.PesquisaPorIdTimeRequest.class,
      responseType = main.java.generated.ListaTransacaoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdTimeRequest,
      main.java.generated.ListaTransacaoResponse> getHistoricoTransacoesMethod() {
    io.grpc.MethodDescriptor<main.java.generated.PesquisaPorIdTimeRequest, main.java.generated.ListaTransacaoResponse> getHistoricoTransacoesMethod;
    if ((getHistoricoTransacoesMethod = escamballGrpc.getHistoricoTransacoesMethod) == null) {
      synchronized (escamballGrpc.class) {
        if ((getHistoricoTransacoesMethod = escamballGrpc.getHistoricoTransacoesMethod) == null) {
          escamballGrpc.getHistoricoTransacoesMethod = getHistoricoTransacoesMethod =
              io.grpc.MethodDescriptor.<main.java.generated.PesquisaPorIdTimeRequest, main.java.generated.ListaTransacaoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "historicoTransacoes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.PesquisaPorIdTimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.java.generated.ListaTransacaoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new escamballMethodDescriptorSupplier("historicoTransacoes"))
              .build();
        }
      }
    }
    return getHistoricoTransacoesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static escamballStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<escamballStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<escamballStub>() {
        @java.lang.Override
        public escamballStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new escamballStub(channel, callOptions);
        }
      };
    return escamballStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static escamballBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<escamballBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<escamballBlockingStub>() {
        @java.lang.Override
        public escamballBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new escamballBlockingStub(channel, callOptions);
        }
      };
    return escamballBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static escamballFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<escamballFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<escamballFutureStub>() {
        @java.lang.Override
        public escamballFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new escamballFutureStub(channel, callOptions);
        }
      };
    return escamballFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class escamballImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Cadastro no banco
     * </pre>
     */
    public void cadastro(main.java.generated.CadastroRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCadastroMethod(), responseObserver);
    }

    /**
     */
    public void cadastroJogador(main.java.generated.CadastroJogadorRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCadastroJogadorMethod(), responseObserver);
    }

    /**
     */
    public void novaTransacao(main.java.generated.TransacaoRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getNovaTransacaoMethod(), responseObserver);
    }

    /**
     * <pre>
     *Atualização no banco de dados
     * </pre>
     */
    public void responderTransacao(main.java.generated.RespostaTransacaoRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getResponderTransacaoMethod(), responseObserver);
    }

    /**
     * <pre>
     *Recuperação do time
     * </pre>
     */
    public void login(main.java.generated.LoginRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.TimeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void recuperaTimePeloId(main.java.generated.PesquisaPorIdTimeRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.TimeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRecuperaTimePeloIdMethod(), responseObserver);
    }

    /**
     * <pre>
     *Recuperação do Jogador
     * </pre>
     */
    public void recuperaJogadorPeloId(main.java.generated.PesquisaPorIdJogadorRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.JogadorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRecuperaJogadorPeloIdMethod(), responseObserver);
    }

    /**
     * <pre>
     *Recuperacao da transacao
     * </pre>
     */
    public void recuperaTransacaoPeloId(main.java.generated.PesquisaPorIdTransacaoRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.TransacaoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRecuperaTransacaoPeloIdMethod(), responseObserver);
    }

    /**
     * <pre>
     *Funções que resgatam listas de jogadores
     * </pre>
     */
    public void buscaJogadoresNome(main.java.generated.BuscaJogadoresRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.ListaJogadoresResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBuscaJogadoresNomeMethod(), responseObserver);
    }

    /**
     */
    public void buscaJogadoresPosicao(main.java.generated.BuscaJogadoresPosicaoRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.ListaJogadoresResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBuscaJogadoresPosicaoMethod(), responseObserver);
    }

    /**
     */
    public void exibeListaJogadores(main.java.generated.PesquisaPorIdTimeRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.ListaJogadoresResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getExibeListaJogadoresMethod(), responseObserver);
    }

    /**
     * <pre>
     *Função para resgate da lista de transações
     * </pre>
     */
    public void historicoTransacoes(main.java.generated.PesquisaPorIdTimeRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.ListaTransacaoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHistoricoTransacoesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCadastroMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                main.java.generated.CadastroRequest,
                main.java.generated.APIResponse>(
                  this, METHODID_CADASTRO)))
          .addMethod(
            getCadastroJogadorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                main.java.generated.CadastroJogadorRequest,
                main.java.generated.APIResponse>(
                  this, METHODID_CADASTRO_JOGADOR)))
          .addMethod(
            getNovaTransacaoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                main.java.generated.TransacaoRequest,
                main.java.generated.APIResponse>(
                  this, METHODID_NOVA_TRANSACAO)))
          .addMethod(
            getResponderTransacaoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                main.java.generated.RespostaTransacaoRequest,
                main.java.generated.APIResponse>(
                  this, METHODID_RESPONDER_TRANSACAO)))
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                main.java.generated.LoginRequest,
                main.java.generated.TimeResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getRecuperaTimePeloIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                main.java.generated.PesquisaPorIdTimeRequest,
                main.java.generated.TimeResponse>(
                  this, METHODID_RECUPERA_TIME_PELO_ID)))
          .addMethod(
            getRecuperaJogadorPeloIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                main.java.generated.PesquisaPorIdJogadorRequest,
                main.java.generated.JogadorResponse>(
                  this, METHODID_RECUPERA_JOGADOR_PELO_ID)))
          .addMethod(
            getRecuperaTransacaoPeloIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                main.java.generated.PesquisaPorIdTransacaoRequest,
                main.java.generated.TransacaoResponse>(
                  this, METHODID_RECUPERA_TRANSACAO_PELO_ID)))
          .addMethod(
            getBuscaJogadoresNomeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                main.java.generated.BuscaJogadoresRequest,
                main.java.generated.ListaJogadoresResponse>(
                  this, METHODID_BUSCA_JOGADORES_NOME)))
          .addMethod(
            getBuscaJogadoresPosicaoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                main.java.generated.BuscaJogadoresPosicaoRequest,
                main.java.generated.ListaJogadoresResponse>(
                  this, METHODID_BUSCA_JOGADORES_POSICAO)))
          .addMethod(
            getExibeListaJogadoresMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                main.java.generated.PesquisaPorIdTimeRequest,
                main.java.generated.ListaJogadoresResponse>(
                  this, METHODID_EXIBE_LISTA_JOGADORES)))
          .addMethod(
            getHistoricoTransacoesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                main.java.generated.PesquisaPorIdTimeRequest,
                main.java.generated.ListaTransacaoResponse>(
                  this, METHODID_HISTORICO_TRANSACOES)))
          .build();
    }
  }

  /**
   */
  public static final class escamballStub extends io.grpc.stub.AbstractAsyncStub<escamballStub> {
    private escamballStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected escamballStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new escamballStub(channel, callOptions);
    }

    /**
     * <pre>
     *Cadastro no banco
     * </pre>
     */
    public void cadastro(main.java.generated.CadastroRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCadastroMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cadastroJogador(main.java.generated.CadastroJogadorRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCadastroJogadorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void novaTransacao(main.java.generated.TransacaoRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getNovaTransacaoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Atualização no banco de dados
     * </pre>
     */
    public void responderTransacao(main.java.generated.RespostaTransacaoRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResponderTransacaoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Recuperação do time
     * </pre>
     */
    public void login(main.java.generated.LoginRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.TimeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void recuperaTimePeloId(main.java.generated.PesquisaPorIdTimeRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.TimeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRecuperaTimePeloIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Recuperação do Jogador
     * </pre>
     */
    public void recuperaJogadorPeloId(main.java.generated.PesquisaPorIdJogadorRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.JogadorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRecuperaJogadorPeloIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Recuperacao da transacao
     * </pre>
     */
    public void recuperaTransacaoPeloId(main.java.generated.PesquisaPorIdTransacaoRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.TransacaoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRecuperaTransacaoPeloIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Funções que resgatam listas de jogadores
     * </pre>
     */
    public void buscaJogadoresNome(main.java.generated.BuscaJogadoresRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.ListaJogadoresResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBuscaJogadoresNomeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void buscaJogadoresPosicao(main.java.generated.BuscaJogadoresPosicaoRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.ListaJogadoresResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBuscaJogadoresPosicaoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void exibeListaJogadores(main.java.generated.PesquisaPorIdTimeRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.ListaJogadoresResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getExibeListaJogadoresMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Função para resgate da lista de transações
     * </pre>
     */
    public void historicoTransacoes(main.java.generated.PesquisaPorIdTimeRequest request,
        io.grpc.stub.StreamObserver<main.java.generated.ListaTransacaoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHistoricoTransacoesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class escamballBlockingStub extends io.grpc.stub.AbstractBlockingStub<escamballBlockingStub> {
    private escamballBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected escamballBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new escamballBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Cadastro no banco
     * </pre>
     */
    public main.java.generated.APIResponse cadastro(main.java.generated.CadastroRequest request) {
      return blockingUnaryCall(
          getChannel(), getCadastroMethod(), getCallOptions(), request);
    }

    /**
     */
    public main.java.generated.APIResponse cadastroJogador(main.java.generated.CadastroJogadorRequest request) {
      return blockingUnaryCall(
          getChannel(), getCadastroJogadorMethod(), getCallOptions(), request);
    }

    /**
     */
    public main.java.generated.APIResponse novaTransacao(main.java.generated.TransacaoRequest request) {
      return blockingUnaryCall(
          getChannel(), getNovaTransacaoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Atualização no banco de dados
     * </pre>
     */
    public main.java.generated.APIResponse responderTransacao(main.java.generated.RespostaTransacaoRequest request) {
      return blockingUnaryCall(
          getChannel(), getResponderTransacaoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Recuperação do time
     * </pre>
     */
    public main.java.generated.TimeResponse login(main.java.generated.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public main.java.generated.TimeResponse recuperaTimePeloId(main.java.generated.PesquisaPorIdTimeRequest request) {
      return blockingUnaryCall(
          getChannel(), getRecuperaTimePeloIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Recuperação do Jogador
     * </pre>
     */
    public main.java.generated.JogadorResponse recuperaJogadorPeloId(main.java.generated.PesquisaPorIdJogadorRequest request) {
      return blockingUnaryCall(
          getChannel(), getRecuperaJogadorPeloIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Recuperacao da transacao
     * </pre>
     */
    public main.java.generated.TransacaoResponse recuperaTransacaoPeloId(main.java.generated.PesquisaPorIdTransacaoRequest request) {
      return blockingUnaryCall(
          getChannel(), getRecuperaTransacaoPeloIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Funções que resgatam listas de jogadores
     * </pre>
     */
    public main.java.generated.ListaJogadoresResponse buscaJogadoresNome(main.java.generated.BuscaJogadoresRequest request) {
      return blockingUnaryCall(
          getChannel(), getBuscaJogadoresNomeMethod(), getCallOptions(), request);
    }

    /**
     */
    public main.java.generated.ListaJogadoresResponse buscaJogadoresPosicao(main.java.generated.BuscaJogadoresPosicaoRequest request) {
      return blockingUnaryCall(
          getChannel(), getBuscaJogadoresPosicaoMethod(), getCallOptions(), request);
    }

    /**
     */
    public main.java.generated.ListaJogadoresResponse exibeListaJogadores(main.java.generated.PesquisaPorIdTimeRequest request) {
      return blockingUnaryCall(
          getChannel(), getExibeListaJogadoresMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Função para resgate da lista de transações
     * </pre>
     */
    public main.java.generated.ListaTransacaoResponse historicoTransacoes(main.java.generated.PesquisaPorIdTimeRequest request) {
      return blockingUnaryCall(
          getChannel(), getHistoricoTransacoesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class escamballFutureStub extends io.grpc.stub.AbstractFutureStub<escamballFutureStub> {
    private escamballFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected escamballFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new escamballFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Cadastro no banco
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<main.java.generated.APIResponse> cadastro(
        main.java.generated.CadastroRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCadastroMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<main.java.generated.APIResponse> cadastroJogador(
        main.java.generated.CadastroJogadorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCadastroJogadorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<main.java.generated.APIResponse> novaTransacao(
        main.java.generated.TransacaoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getNovaTransacaoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Atualização no banco de dados
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<main.java.generated.APIResponse> responderTransacao(
        main.java.generated.RespostaTransacaoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getResponderTransacaoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Recuperação do time
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<main.java.generated.TimeResponse> login(
        main.java.generated.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<main.java.generated.TimeResponse> recuperaTimePeloId(
        main.java.generated.PesquisaPorIdTimeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRecuperaTimePeloIdMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Recuperação do Jogador
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<main.java.generated.JogadorResponse> recuperaJogadorPeloId(
        main.java.generated.PesquisaPorIdJogadorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRecuperaJogadorPeloIdMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Recuperacao da transacao
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<main.java.generated.TransacaoResponse> recuperaTransacaoPeloId(
        main.java.generated.PesquisaPorIdTransacaoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRecuperaTransacaoPeloIdMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Funções que resgatam listas de jogadores
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<main.java.generated.ListaJogadoresResponse> buscaJogadoresNome(
        main.java.generated.BuscaJogadoresRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBuscaJogadoresNomeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<main.java.generated.ListaJogadoresResponse> buscaJogadoresPosicao(
        main.java.generated.BuscaJogadoresPosicaoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBuscaJogadoresPosicaoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<main.java.generated.ListaJogadoresResponse> exibeListaJogadores(
        main.java.generated.PesquisaPorIdTimeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getExibeListaJogadoresMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Função para resgate da lista de transações
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<main.java.generated.ListaTransacaoResponse> historicoTransacoes(
        main.java.generated.PesquisaPorIdTimeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHistoricoTransacoesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CADASTRO = 0;
  private static final int METHODID_CADASTRO_JOGADOR = 1;
  private static final int METHODID_NOVA_TRANSACAO = 2;
  private static final int METHODID_RESPONDER_TRANSACAO = 3;
  private static final int METHODID_LOGIN = 4;
  private static final int METHODID_RECUPERA_TIME_PELO_ID = 5;
  private static final int METHODID_RECUPERA_JOGADOR_PELO_ID = 6;
  private static final int METHODID_RECUPERA_TRANSACAO_PELO_ID = 7;
  private static final int METHODID_BUSCA_JOGADORES_NOME = 8;
  private static final int METHODID_BUSCA_JOGADORES_POSICAO = 9;
  private static final int METHODID_EXIBE_LISTA_JOGADORES = 10;
  private static final int METHODID_HISTORICO_TRANSACOES = 11;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final escamballImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(escamballImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CADASTRO:
          serviceImpl.cadastro((main.java.generated.CadastroRequest) request,
              (io.grpc.stub.StreamObserver<main.java.generated.APIResponse>) responseObserver);
          break;
        case METHODID_CADASTRO_JOGADOR:
          serviceImpl.cadastroJogador((main.java.generated.CadastroJogadorRequest) request,
              (io.grpc.stub.StreamObserver<main.java.generated.APIResponse>) responseObserver);
          break;
        case METHODID_NOVA_TRANSACAO:
          serviceImpl.novaTransacao((main.java.generated.TransacaoRequest) request,
              (io.grpc.stub.StreamObserver<main.java.generated.APIResponse>) responseObserver);
          break;
        case METHODID_RESPONDER_TRANSACAO:
          serviceImpl.responderTransacao((main.java.generated.RespostaTransacaoRequest) request,
              (io.grpc.stub.StreamObserver<main.java.generated.APIResponse>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((main.java.generated.LoginRequest) request,
              (io.grpc.stub.StreamObserver<main.java.generated.TimeResponse>) responseObserver);
          break;
        case METHODID_RECUPERA_TIME_PELO_ID:
          serviceImpl.recuperaTimePeloId((main.java.generated.PesquisaPorIdTimeRequest) request,
              (io.grpc.stub.StreamObserver<main.java.generated.TimeResponse>) responseObserver);
          break;
        case METHODID_RECUPERA_JOGADOR_PELO_ID:
          serviceImpl.recuperaJogadorPeloId((main.java.generated.PesquisaPorIdJogadorRequest) request,
              (io.grpc.stub.StreamObserver<main.java.generated.JogadorResponse>) responseObserver);
          break;
        case METHODID_RECUPERA_TRANSACAO_PELO_ID:
          serviceImpl.recuperaTransacaoPeloId((main.java.generated.PesquisaPorIdTransacaoRequest) request,
              (io.grpc.stub.StreamObserver<main.java.generated.TransacaoResponse>) responseObserver);
          break;
        case METHODID_BUSCA_JOGADORES_NOME:
          serviceImpl.buscaJogadoresNome((main.java.generated.BuscaJogadoresRequest) request,
              (io.grpc.stub.StreamObserver<main.java.generated.ListaJogadoresResponse>) responseObserver);
          break;
        case METHODID_BUSCA_JOGADORES_POSICAO:
          serviceImpl.buscaJogadoresPosicao((main.java.generated.BuscaJogadoresPosicaoRequest) request,
              (io.grpc.stub.StreamObserver<main.java.generated.ListaJogadoresResponse>) responseObserver);
          break;
        case METHODID_EXIBE_LISTA_JOGADORES:
          serviceImpl.exibeListaJogadores((main.java.generated.PesquisaPorIdTimeRequest) request,
              (io.grpc.stub.StreamObserver<main.java.generated.ListaJogadoresResponse>) responseObserver);
          break;
        case METHODID_HISTORICO_TRANSACOES:
          serviceImpl.historicoTransacoes((main.java.generated.PesquisaPorIdTimeRequest) request,
              (io.grpc.stub.StreamObserver<main.java.generated.ListaTransacaoResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class escamballBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    escamballBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return main.java.generated.EscamballProtos.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("escamball");
    }
  }

  private static final class escamballFileDescriptorSupplier
      extends escamballBaseDescriptorSupplier {
    escamballFileDescriptorSupplier() {}
  }

  private static final class escamballMethodDescriptorSupplier
      extends escamballBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    escamballMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (escamballGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new escamballFileDescriptorSupplier())
              .addMethod(getCadastroMethod())
              .addMethod(getCadastroJogadorMethod())
              .addMethod(getNovaTransacaoMethod())
              .addMethod(getResponderTransacaoMethod())
              .addMethod(getLoginMethod())
              .addMethod(getRecuperaTimePeloIdMethod())
              .addMethod(getRecuperaJogadorPeloIdMethod())
              .addMethod(getRecuperaTransacaoPeloIdMethod())
              .addMethod(getBuscaJogadoresNomeMethod())
              .addMethod(getBuscaJogadoresPosicaoMethod())
              .addMethod(getExibeListaJogadoresMethod())
              .addMethod(getHistoricoTransacoesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
