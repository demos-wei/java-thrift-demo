package com.example.thrift.server;

import com.example.thrift.impl.HelloServiceImpl;
import com.example.thrift.service.HelloService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

public class HelloServiceServer {
  public static void main(String[] args) {
    try {
      System.out.println("starting server!");
      int port = 5001;
      TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(port);

      THsHaServer.Args serverArgs = new THsHaServer
          .Args(serverSocket)
          .minWorkerThreads(2)
          .minWorkerThreads(4);

      HelloService.Processor<HelloServiceImpl> processor = new HelloService.Processor<>(
          new HelloServiceImpl()
      );

      serverArgs.protocolFactory(new TCompactProtocol.Factory());
      serverArgs.transportFactory(new TFramedTransport.Factory());
      serverArgs.processorFactory(new TProcessorFactory(processor));

      TServer server = new THsHaServer(serverArgs);
      System.out.printf("server start success with port %s!", port);
      System.out.println();
      server.serve();
    } catch (TTransportException e) {
      e.printStackTrace();
    }
  }

}
