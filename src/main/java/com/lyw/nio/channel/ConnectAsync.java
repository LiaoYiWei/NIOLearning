package com.lyw.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectAsync {
	public static void main(String[] argv) throws IOException {
		String host = "localhost";
		int port = 8080;
		if (argv.length == 2) {
			host = argv[0];
			port = Integer.parseInt(argv[1]);
		}
		InetSocketAddress addr = new InetSocketAddress(host, port);

		SocketChannel sc = SocketChannel.open();
		sc.configureBlocking(false);
		System.out.println("initiating connection");
		sc.connect(addr);
		while (!sc.finishConnect()) {
			doSomethingUseful();
		}
		System.out.println("connection established");
		// Do something with the connected socket
		// The SocketChannel is still nonblocking
		sc.close();
	}

	private static void doSomethingUseful() {
		System.out.println("doing something useless");
	}
}
