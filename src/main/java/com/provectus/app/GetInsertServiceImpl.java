package com.provectus.app;

import com.google.common.base.Charsets;
import io.grpc.stub.StreamObserver;
import org.tikv.common.TiConfiguration;
import org.tikv.common.TiSession;
import org.tikv.raw.RawKVClient;
import shade.com.google.protobuf.ByteString;

public class GetInsertServiceImpl
    extends com.provectus.app.GetInsertServiceGrpc.GetInsertServiceImplBase {
  @Override
  public void get(
      com.provectus.app.GetInsertServiceOuterClass.HelloUID request,
      StreamObserver<com.provectus.app.GetInsertServiceOuterClass.HelloResponse> responseObserver) {
    System.out.println("get");
    System.out.println(request);

    RawKVClient dbClient = SingletonDB.getInstance().client;

    // You must use a builder to construct a new Protobuffer object
    ByteString res =
        dbClient.get(ByteString.copyFrom(String.valueOf(request.getUid()), Charsets.UTF_8));

    com.provectus.app.GetInsertServiceOuterClass.HelloResponse response =
        com.provectus.app.GetInsertServiceOuterClass.HelloResponse.newBuilder()
            .setResult(res.toString())
            .build();

    // Use responseObserver to send a single response back
    responseObserver.onNext(response);

    // When you are done, you must call onCompleted.
    responseObserver.onCompleted();
  }

  @Override
  public void insert(
      com.provectus.app.GetInsertServiceOuterClass.HelloMessage request,
      io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
    // HelloRequest has toString auto-generated.
    System.out.println("insert");
    System.out.println(request);
    TiConfiguration conf = TiConfiguration.createRawDefault("pd0:2379");
    System.out.println(1);
    System.out.println("2");
    System.out.println(conf);
    TiSession session = TiSession.create(conf);
    System.out.println("3");
    RawKVClient client = session.createRawClient();
    System.out.println("4");
//
//    RawKVClient dbClient = SingletonDB.getInstance().client;
//    System.out.println(dbClient);
//    System.out.println("done");
//    dbClient.put(
//        ByteString.copyFrom(request.getName(), Charsets.UTF_8),
//        ByteString.copyFrom("hello-message", Charsets.UTF_8));
//    ByteString res = dbClient.get(ByteString.copyFrom(String.valueOf("hello"), Charsets.UTF_8));
//    System.out.println(res);
//    System.out.println(res.toString());


    // When you are done, you must call onCompleted.
    responseObserver.onCompleted();
  }
}
