package com.example.thrift.client;

import com.example.thrift.services.HelloService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.layered.TFramedTransport;

public class HelloServiceClient {
  public static void main(String[] args) {
    try {
      int port = 5001;
      String host = "localhost";
      TTransport transport = new TFramedTransport(new TSocket(host, port), 600);

      TProtocol protocol = new TCompactProtocol(transport);
      HelloService.Client client = new HelloService.Client(protocol);
      transport.open();
      String result = client.helloString("hello!");
      System.out.println(result);
    } catch (TException e) {
      e.printStackTrace();
    }
  }
}
