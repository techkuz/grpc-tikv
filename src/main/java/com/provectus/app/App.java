package com.provectus.app;

import io.grpc.Server;
import io.grpc.ServerBuilder;

// import org.tikv.common.TiConfiguration;
// import org.tikv.common.TiSession;
// import org.tikv.raw.RawKVClient;
// import shade.com.google.common.base.Charsets;
// import shade.com.google.protobuf.ByteString;
//
// import java.util.List;

/** Hello world! */
public class App {
  public static void main(String[] args) throws Exception {
    //        DBInstance = SingletonDB.getInstance();

    System.out.println("Hello-start");
    Server server = ServerBuilder.forPort(8080).addService(new GetInsertServiceImpl()).build();

    // Start the server
    server.start();

    // Server threads are running in the background.
    System.out.println("Server started");
    // Don't exit the main thread. Wait until server is terminated.
    server.awaitTermination();

    //        client.put(ByteString.copyFrom("hello-key", Charsets.UTF_8),
    // ByteString.copyFrom("hello-message", Charsets.UTF_8));
    //        System.out.println(client.get(ByteString.copyFrom("hello-key", Charsets.UTF_8)));
    //        System.out.println( "Hello World!" );
  }
}
