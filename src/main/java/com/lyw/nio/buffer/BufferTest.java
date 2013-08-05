package com.lyw.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BufferTest {

	public static void main(String[] args) {
		 byte[] bufferArea = new byte[50];
		 bufferArea[1] = (byte) 10;
		 ByteBuffer bb = ByteBuffer.wrap(bufferArea);
		 System.out.println("capacity---   " + bb.capacity());
		 System.out.println("position---   " + bb.position());
		 System.out.println("limit-----    " + bb.limit());
		 // Gets a byte element from buffer
		 System.out.println(bb.get());
		 System.out.println("capacity---   " + bb.capacity());
		 System.out.println("position---   " + bb.position());
		 System.out.println("limit-----    " + bb.limit());
		
		 bb.put(10, (byte) 20);
		 System.out.println(bb.get(10));
		
		 bb.flip();
		
		 // printing after fliping
		 System.out.println("capacity---   " + bb.capacity());
		 System.out.println("position---   " + bb.position());
		 System.out.println("limit-----    " + bb.limit());
		
		 bb.clear();
		 bb.put((byte) 1);
		 bb.put((byte) 2);
		 bb.put((byte) 3);
		 bb.mark();
		 bb.put((byte) 4);
		 // printing after putting
		 System.out.println("capacity---   " + bb.capacity());
		 System.out.println("position---   " + bb.position());
		 System.out.println("limit-----    " + bb.limit());
		
		 bb.reset();
		 // printing after resetting
		 System.out.println("capacity---   " + bb.capacity());
		 System.out.println("position---   " + bb.position());
		 System.out.println("limit-----    " + bb.limit());
		 bb.flip();
		 System.out.println("capacity---   " + bb.capacity());
		 System.out.println("position---   " + bb.position());
		 System.out.println("limit-----    " + bb.limit());
		 for (int i = 0; i < bb.limit(); i++) {
		 System.out.println(bb.get());
		 }
		
		 System.out.println("byteBuffer---" + bb.order());
		 System.out.println("native order" + ByteOrder.nativeOrder());
		
		 bb.order(ByteOrder.LITTLE_ENDIAN);
	}

}
