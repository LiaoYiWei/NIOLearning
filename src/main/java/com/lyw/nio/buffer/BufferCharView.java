package com.lyw.nio.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

/**
 * * Test asCharBuffer view. * * Created May 2002 * @author Ron Hitchens
 * (ron@ronsoft.com)
 */
public class BufferCharView {
	public static void main(String[] argv) throws Exception {
		ByteBuffer byteBuffer = ByteBuffer.allocate(7).order(
				ByteOrder.LITTLE_ENDIAN);
		CharBuffer charBuffer = byteBuffer.asCharBuffer();
		byteBuffer.put(1, (byte) 0);
		byteBuffer.put(0, (byte) 'H');
		byteBuffer.put(3, (byte) 0);
		byteBuffer.put(2, (byte) 'i');
		byteBuffer.put(5, (byte) 0);
		byteBuffer.put(4, (byte) '!');
		byteBuffer.put(6, (byte) 0);
		println(byteBuffer);
		println(charBuffer);
	
		for (int i = 0; i < byteBuffer.limit(); i++) {
			System.out.println(byteBuffer.get());
		}
		
	}

	// Print info about a buffer
	private static void println(Buffer buffer) {
		System.out.println("pos=" + buffer.position() + ", limit="
				+ buffer.limit() + ", capacity=" + buffer.capacity() + ": '"
				+ buffer.toString() + "'");
	}
}