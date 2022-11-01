package com.example.thrift.impl;

import com.example.thrift.service.HelloService;

public class HelloServiceImpl implements HelloService.Iface {

  @Override
  public String sayHello(String para) {
    return para;
  }
}
