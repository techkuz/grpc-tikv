package com.pv.app;
//
// import com.google.protobuf.Empty;
// import io.grpc.ManagedChannel;
// import io.grpc.ManagedChannelBuilder;
// import org.tikv.common.TiConfiguration;
// import org.tikv.common.TiSession;
import io.grpc.*;

//
public class Client {
  public static void main(String[] args) throws Exception {
    // Channel is the abstraction to connect to a service endpoint
    // Let's use plaintext communication because we don't have certs
    final ManagedChannel channel =
        ManagedChannelBuilder.forTarget("0.0.0.0:8080").usePlaintext().build();
    //        RawKVClient dbclient = SingletonDB.getInstance().client;
    //        dbclient.put(ByteString.copyFrom("hello-key", Charsets.UTF_8),
    // ByteString.copyFrom("hello-message", Charsets.UTF_8));
    //        System.out.println(dbclient.get(ByteString.copyFrom("hello-key", Charsets.UTF_8)));
    //        System.out.println( "Hello World!" );

    // It is up to the client to determine whether to block the call
    // Here we create a blocking stub, but an async stub,
    // or an async stub with Future are always possible.

    GetInsertServiceGrpc.GetInsertServiceBlockingStub stub =
        GetInsertServiceGrpc.newBlockingStub(channel);
    GetInsertServiceOuterClass.HelloMessage request =
        GetInsertServiceOuterClass.HelloMessage.newBuilder().setName("hello").build();

    //        System.out.println(channel.);
    System.out.println(request);
    //        RawKVClient dbclient = SingletonDB.getInstance().client;
    //
    //        TiConfiguration conf = TiConfiguration.createRawDefault("pd0:2379");
    //        System.out.println("T1");
    ////
    //        TiSession session = TiSession.create(conf);
    //        System.out.println("T2");
    ////
    //        RawKVClient dbclient = session.createRawClient();
    ////
    //        System.out.println("T3");
    ////
    ////
    //        dbclient.put(ByteString.copyFrom("hello-key", Charsets.UTF_8),
    // ByteString.copyFrom("hello-message", Charsets.UTF_8));
    //        System.out.println(dbclient.get(ByteString.copyFrom("hello-key", Charsets.UTF_8)));

    System.out.println("b4 req");

    // Finally, make the call using the stub
    stub.insert(request);
    //
    //        System.out.println( "Hello World!-4" );

    // x

    // A Channel should be shutdown before stopping the process.
    channel.shutdownNow();
  }
}
