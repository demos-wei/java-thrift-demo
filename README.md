# Java thrift demo
A demo to generate java file by thrift command, and use the thrift servicer and client.

Install thrift
```shell
brew install thrift
```

Generate service
```shell
thrift -r -gen java -out src/main/java src/main/thrift/HelloService.thrift
```

Build the server side by running:
```shell
$ bazel build //:thrift-server
$ bazel-bin/thrift-server
#(print logs)
```

Build the client side by running:
```shell
$ bazel build //:thrift-client
$ bazel-bin/thrift-client
#(print logs)
```
