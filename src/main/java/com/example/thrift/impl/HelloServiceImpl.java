package com.example.thrift.impl;

import com.example.thrift.services.HelloService;
import org.apache.thrift.TException;

public class HelloServiceImpl implements HelloService.Iface {
  @Override
  public String helloString(String para) throws TException {
    return para;
  }
}
