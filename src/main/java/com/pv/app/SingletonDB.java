package com.pv.app;

import org.tikv.common.TiConfiguration;
import org.tikv.common.TiSession;
import org.tikv.raw.RawKVClient;

public class SingletonDB {
  private static final SingletonDB SINGLE_INSTANCE = new SingletonDB();
  public TiConfiguration conf;
  public TiSession session;
  public RawKVClient client;

  private SingletonDB() {
    System.out.println("singleton");

    this.conf = TiConfiguration.createRawDefault("pd0:2379");
    System.out.println("2");
    System.out.println(conf);
    this.session = TiSession.create(conf);
    System.out.println("3");
    this.client = session.createRawClient();
    System.out.println("4");
  }

  public static SingletonDB getInstance() {
    return SINGLE_INSTANCE;
  }
}
