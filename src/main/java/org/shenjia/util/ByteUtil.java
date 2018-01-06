/*
 * Copyright 2018-present The Guawa Project.
 *
 * The Guawa Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.shenjia.util;

/**
 * 字节工具类
 * 
 * @author Jason Shen
 */
public final class ByteUtil {

	private static byte[] ASCII_TO_EBCDIC = new byte[256];
	private static byte[] EBCDIC_TO_ASCII = new byte[256];
	static {
		ASCII_TO_EBCDIC[0x00] = (byte) 0x00;
		ASCII_TO_EBCDIC[0x01] = (byte) 0x01;
		ASCII_TO_EBCDIC[0x02] = (byte) 0x02;
		ASCII_TO_EBCDIC[0x03] = (byte) 0x03;
		ASCII_TO_EBCDIC[0x04] = (byte) 0x37;
		ASCII_TO_EBCDIC[0x05] = (byte) 0x2D;
		ASCII_TO_EBCDIC[0x06] = (byte) 0x2E;
		ASCII_TO_EBCDIC[0x07] = (byte) 0x2F;
		ASCII_TO_EBCDIC[0x08] = (byte) 0x16;
		ASCII_TO_EBCDIC[0x09] = (byte) 0x05;
		ASCII_TO_EBCDIC[0x0A] = (byte) 0x25;
		ASCII_TO_EBCDIC[0x0B] = (byte) 0x0B;
		ASCII_TO_EBCDIC[0x0C] = (byte) 0x0C;
		ASCII_TO_EBCDIC[0x0D] = (byte) 0x0D;
		ASCII_TO_EBCDIC[0x0E] = (byte) 0x0E;
		ASCII_TO_EBCDIC[0x0F] = (byte) 0x0F;
		ASCII_TO_EBCDIC[0x10] = (byte) 0x10;
		ASCII_TO_EBCDIC[0x11] = (byte) 0x11;
		ASCII_TO_EBCDIC[0x12] = (byte) 0x12;
		ASCII_TO_EBCDIC[0x13] = (byte) 0x13;
		ASCII_TO_EBCDIC[0x14] = (byte) 0x3C;
		ASCII_TO_EBCDIC[0x15] = (byte) 0x3D;
		ASCII_TO_EBCDIC[0x16] = (byte) 0x32;
		ASCII_TO_EBCDIC[0x17] = (byte) 0x26;
		ASCII_TO_EBCDIC[0x18] = (byte) 0x18;
		ASCII_TO_EBCDIC[0x19] = (byte) 0x19;
		ASCII_TO_EBCDIC[0x1A] = (byte) 0x3F;
		ASCII_TO_EBCDIC[0x1B] = (byte) 0x27;
		ASCII_TO_EBCDIC[0x1C] = (byte) 0x1C;
		ASCII_TO_EBCDIC[0x1D] = (byte) 0x1D;
		ASCII_TO_EBCDIC[0x1E] = (byte) 0x1E;
		ASCII_TO_EBCDIC[0x1F] = (byte) 0x1F;
		ASCII_TO_EBCDIC[0x20] = (byte) 0x40;
		ASCII_TO_EBCDIC[0x21] = (byte) 0x4F;
		ASCII_TO_EBCDIC[0x22] = (byte) 0x7F;
		ASCII_TO_EBCDIC[0x23] = (byte) 0x7B;
		ASCII_TO_EBCDIC[0x24] = (byte) 0x5B;
		ASCII_TO_EBCDIC[0x25] = (byte) 0x6C;
		ASCII_TO_EBCDIC[0x26] = (byte) 0x50;
		ASCII_TO_EBCDIC[0x27] = (byte) 0x7D;
		ASCII_TO_EBCDIC[0x28] = (byte) 0x4D;
		ASCII_TO_EBCDIC[0x29] = (byte) 0x5D;
		ASCII_TO_EBCDIC[0x2A] = (byte) 0x5C;
		ASCII_TO_EBCDIC[0x2B] = (byte) 0x4E;
		ASCII_TO_EBCDIC[0x2C] = (byte) 0x6B;
		ASCII_TO_EBCDIC[0x2D] = (byte) 0x60;
		ASCII_TO_EBCDIC[0x2E] = (byte) 0x4B;
		ASCII_TO_EBCDIC[0x2F] = (byte) 0x61;
		ASCII_TO_EBCDIC[0x30] = (byte) 0xF0;
		ASCII_TO_EBCDIC[0x31] = (byte) 0xF1;
		ASCII_TO_EBCDIC[0x32] = (byte) 0xF2;
		ASCII_TO_EBCDIC[0x33] = (byte) 0xF3;
		ASCII_TO_EBCDIC[0x34] = (byte) 0xF4;
		ASCII_TO_EBCDIC[0x35] = (byte) 0xF5;
		ASCII_TO_EBCDIC[0x36] = (byte) 0xF6;
		ASCII_TO_EBCDIC[0x37] = (byte) 0xF7;
		ASCII_TO_EBCDIC[0x38] = (byte) 0xF8;
		ASCII_TO_EBCDIC[0x39] = (byte) 0xF9;
		ASCII_TO_EBCDIC[0x3A] = (byte) 0x7A;
		ASCII_TO_EBCDIC[0x3B] = (byte) 0x5E;
		ASCII_TO_EBCDIC[0x3C] = (byte) 0x4C;
		ASCII_TO_EBCDIC[0x3D] = (byte) 0x7E;
		ASCII_TO_EBCDIC[0x3E] = (byte) 0x6E;
		ASCII_TO_EBCDIC[0x3F] = (byte) 0x6F;
		ASCII_TO_EBCDIC[0x40] = (byte) 0x7C;
		ASCII_TO_EBCDIC[0x41] = (byte) 0xC1;
		ASCII_TO_EBCDIC[0x42] = (byte) 0xC2;
		ASCII_TO_EBCDIC[0x43] = (byte) 0xC3;
		ASCII_TO_EBCDIC[0x44] = (byte) 0xC4;
		ASCII_TO_EBCDIC[0x45] = (byte) 0xC5;
		ASCII_TO_EBCDIC[0x46] = (byte) 0xC6;
		ASCII_TO_EBCDIC[0x47] = (byte) 0xC7;
		ASCII_TO_EBCDIC[0x48] = (byte) 0xC8;
		ASCII_TO_EBCDIC[0x49] = (byte) 0xC9;
		ASCII_TO_EBCDIC[0x4A] = (byte) 0xD1;
		ASCII_TO_EBCDIC[0x4B] = (byte) 0xD2;
		ASCII_TO_EBCDIC[0x4C] = (byte) 0xD3;
		ASCII_TO_EBCDIC[0x4D] = (byte) 0xD4;
		ASCII_TO_EBCDIC[0x4E] = (byte) 0xD5;
		ASCII_TO_EBCDIC[0x4F] = (byte) 0xD6;
		ASCII_TO_EBCDIC[0x50] = (byte) 0xD7;
		ASCII_TO_EBCDIC[0x51] = (byte) 0xD8;
		ASCII_TO_EBCDIC[0x52] = (byte) 0xD9;
		ASCII_TO_EBCDIC[0x53] = (byte) 0xE2;
		ASCII_TO_EBCDIC[0x54] = (byte) 0xE3;
		ASCII_TO_EBCDIC[0x55] = (byte) 0xE4;
		ASCII_TO_EBCDIC[0x56] = (byte) 0xE5;
		ASCII_TO_EBCDIC[0x57] = (byte) 0xE6;
		ASCII_TO_EBCDIC[0x58] = (byte) 0xE7;
		ASCII_TO_EBCDIC[0x59] = (byte) 0xE8;
		ASCII_TO_EBCDIC[0x5A] = (byte) 0xE9;
		ASCII_TO_EBCDIC[0x5B] = (byte) 0x4A;
		ASCII_TO_EBCDIC[0x5C] = (byte) 0xE0;
		ASCII_TO_EBCDIC[0x5D] = (byte) 0x5A;
		ASCII_TO_EBCDIC[0x5E] = (byte) 0x5F;
		ASCII_TO_EBCDIC[0x5F] = (byte) 0x6D;
		ASCII_TO_EBCDIC[0x60] = (byte) 0x79;
		ASCII_TO_EBCDIC[0x61] = (byte) 0x81;
		ASCII_TO_EBCDIC[0x62] = (byte) 0x82;
		ASCII_TO_EBCDIC[0x63] = (byte) 0x83;
		ASCII_TO_EBCDIC[0x64] = (byte) 0x84;
		ASCII_TO_EBCDIC[0x65] = (byte) 0x85;
		ASCII_TO_EBCDIC[0x66] = (byte) 0x86;
		ASCII_TO_EBCDIC[0x67] = (byte) 0x87;
		ASCII_TO_EBCDIC[0x68] = (byte) 0x88;
		ASCII_TO_EBCDIC[0x69] = (byte) 0x89;
		ASCII_TO_EBCDIC[0x6A] = (byte) 0x91;
		ASCII_TO_EBCDIC[0x6B] = (byte) 0x92;
		ASCII_TO_EBCDIC[0x6C] = (byte) 0x93;
		ASCII_TO_EBCDIC[0x6D] = (byte) 0x94;
		ASCII_TO_EBCDIC[0x6E] = (byte) 0x95;
		ASCII_TO_EBCDIC[0x6F] = (byte) 0x96;
		ASCII_TO_EBCDIC[0x70] = (byte) 0x97;
		ASCII_TO_EBCDIC[0x71] = (byte) 0x98;
		ASCII_TO_EBCDIC[0x72] = (byte) 0x99;
		ASCII_TO_EBCDIC[0x73] = (byte) 0xA2;
		ASCII_TO_EBCDIC[0x74] = (byte) 0xA3;
		ASCII_TO_EBCDIC[0x75] = (byte) 0xA4;
		ASCII_TO_EBCDIC[0x76] = (byte) 0xA5;
		ASCII_TO_EBCDIC[0x77] = (byte) 0xA6;
		ASCII_TO_EBCDIC[0x78] = (byte) 0xA7;
		ASCII_TO_EBCDIC[0x79] = (byte) 0xA8;
		ASCII_TO_EBCDIC[0x7A] = (byte) 0xA9;
		ASCII_TO_EBCDIC[0x7B] = (byte) 0xC0;
		ASCII_TO_EBCDIC[0x7C] = (byte) 0x6A;
		ASCII_TO_EBCDIC[0x7D] = (byte) 0xD0;
		ASCII_TO_EBCDIC[0x7E] = (byte) 0xA1;
		ASCII_TO_EBCDIC[0x7F] = (byte) 0x07;
		ASCII_TO_EBCDIC[0x80] = (byte) 0x20;
		ASCII_TO_EBCDIC[0x81] = (byte) 0x21;
		ASCII_TO_EBCDIC[0x82] = (byte) 0x22;
		ASCII_TO_EBCDIC[0x83] = (byte) 0x23;
		ASCII_TO_EBCDIC[0x84] = (byte) 0x24;
		ASCII_TO_EBCDIC[0x85] = (byte) 0x15;
		ASCII_TO_EBCDIC[0x86] = (byte) 0x06;
		ASCII_TO_EBCDIC[0x87] = (byte) 0x17;
		ASCII_TO_EBCDIC[0x88] = (byte) 0x28;
		ASCII_TO_EBCDIC[0x89] = (byte) 0x29;
		ASCII_TO_EBCDIC[0x8A] = (byte) 0x2A;
		ASCII_TO_EBCDIC[0x8B] = (byte) 0x2B;
		ASCII_TO_EBCDIC[0x8C] = (byte) 0x2C;
		ASCII_TO_EBCDIC[0x8D] = (byte) 0x09;
		ASCII_TO_EBCDIC[0x8E] = (byte) 0x0A;
		ASCII_TO_EBCDIC[0x8F] = (byte) 0x1B;
		ASCII_TO_EBCDIC[0x90] = (byte) 0x30;
		ASCII_TO_EBCDIC[0x91] = (byte) 0x31;
		ASCII_TO_EBCDIC[0x92] = (byte) 0x1A;
		ASCII_TO_EBCDIC[0x93] = (byte) 0x33;
		ASCII_TO_EBCDIC[0x94] = (byte) 0x34;
		ASCII_TO_EBCDIC[0x95] = (byte) 0x35;
		ASCII_TO_EBCDIC[0x96] = (byte) 0x36;
		ASCII_TO_EBCDIC[0x97] = (byte) 0x08;
		ASCII_TO_EBCDIC[0x98] = (byte) 0x38;
		ASCII_TO_EBCDIC[0x99] = (byte) 0x39;
		ASCII_TO_EBCDIC[0x9A] = (byte) 0x3A;
		ASCII_TO_EBCDIC[0x9B] = (byte) 0x3B;
		ASCII_TO_EBCDIC[0x9C] = (byte) 0x04;
		ASCII_TO_EBCDIC[0x9D] = (byte) 0x14;
		ASCII_TO_EBCDIC[0x9E] = (byte) 0x3E;
		ASCII_TO_EBCDIC[0x9F] = (byte) 0xE1;
		ASCII_TO_EBCDIC[0xA0] = (byte) 0x41;
		ASCII_TO_EBCDIC[0xA1] = (byte) 0x42;
		ASCII_TO_EBCDIC[0xA2] = (byte) 0x43;
		ASCII_TO_EBCDIC[0xA3] = (byte) 0x44;
		ASCII_TO_EBCDIC[0xA4] = (byte) 0x45;
		ASCII_TO_EBCDIC[0xA5] = (byte) 0x46;
		ASCII_TO_EBCDIC[0xA6] = (byte) 0x47;
		ASCII_TO_EBCDIC[0xA7] = (byte) 0x48;
		ASCII_TO_EBCDIC[0xA8] = (byte) 0x49;
		ASCII_TO_EBCDIC[0xA9] = (byte) 0x51;
		ASCII_TO_EBCDIC[0xAA] = (byte) 0x52;
		ASCII_TO_EBCDIC[0xAB] = (byte) 0x53;
		ASCII_TO_EBCDIC[0xAC] = (byte) 0x54;
		ASCII_TO_EBCDIC[0xAD] = (byte) 0x55;
		ASCII_TO_EBCDIC[0xAE] = (byte) 0x56;
		ASCII_TO_EBCDIC[0xAF] = (byte) 0x57;
		ASCII_TO_EBCDIC[0xB0] = (byte) 0x58;
		ASCII_TO_EBCDIC[0xB1] = (byte) 0x59;
		ASCII_TO_EBCDIC[0xB2] = (byte) 0x62;
		ASCII_TO_EBCDIC[0xB3] = (byte) 0x63;
		ASCII_TO_EBCDIC[0xB4] = (byte) 0x64;
		ASCII_TO_EBCDIC[0xB5] = (byte) 0x65;
		ASCII_TO_EBCDIC[0xB6] = (byte) 0x66;
		ASCII_TO_EBCDIC[0xB7] = (byte) 0x67;
		ASCII_TO_EBCDIC[0xB8] = (byte) 0x68;
		ASCII_TO_EBCDIC[0xB9] = (byte) 0x69;
		ASCII_TO_EBCDIC[0xBA] = (byte) 0x70;
		ASCII_TO_EBCDIC[0xBB] = (byte) 0x71;
		ASCII_TO_EBCDIC[0xBC] = (byte) 0x72;
		ASCII_TO_EBCDIC[0xBD] = (byte) 0x73;
		ASCII_TO_EBCDIC[0xBE] = (byte) 0x74;
		ASCII_TO_EBCDIC[0xBF] = (byte) 0x75;
		ASCII_TO_EBCDIC[0xC0] = (byte) 0x76;
		ASCII_TO_EBCDIC[0xC1] = (byte) 0x77;
		ASCII_TO_EBCDIC[0xC2] = (byte) 0x78;
		ASCII_TO_EBCDIC[0xC3] = (byte) 0x80;
		ASCII_TO_EBCDIC[0xC4] = (byte) 0x8A;
		ASCII_TO_EBCDIC[0xC5] = (byte) 0x8B;
		ASCII_TO_EBCDIC[0xC6] = (byte) 0x8C;
		ASCII_TO_EBCDIC[0xC7] = (byte) 0x8D;
		ASCII_TO_EBCDIC[0xC8] = (byte) 0x8E;
		ASCII_TO_EBCDIC[0xC9] = (byte) 0x8F;
		ASCII_TO_EBCDIC[0xCA] = (byte) 0x90;
		ASCII_TO_EBCDIC[0xCB] = (byte) 0x9A;
		ASCII_TO_EBCDIC[0xCC] = (byte) 0x9B;
		ASCII_TO_EBCDIC[0xCD] = (byte) 0x9C;
		ASCII_TO_EBCDIC[0xCE] = (byte) 0x9D;
		ASCII_TO_EBCDIC[0xCF] = (byte) 0x9E;
		ASCII_TO_EBCDIC[0xD0] = (byte) 0x9F;
		ASCII_TO_EBCDIC[0xD1] = (byte) 0xA0;
		ASCII_TO_EBCDIC[0xD2] = (byte) 0xAA;
		ASCII_TO_EBCDIC[0xD3] = (byte) 0xAB;
		ASCII_TO_EBCDIC[0xD4] = (byte) 0xAC;
		ASCII_TO_EBCDIC[0xD5] = (byte) 0xAD;
		ASCII_TO_EBCDIC[0xD6] = (byte) 0xAE;
		ASCII_TO_EBCDIC[0xD7] = (byte) 0xAF;
		ASCII_TO_EBCDIC[0xD8] = (byte) 0xB0;
		ASCII_TO_EBCDIC[0xD9] = (byte) 0xB1;
		ASCII_TO_EBCDIC[0xDA] = (byte) 0xB2;
		ASCII_TO_EBCDIC[0xDB] = (byte) 0xB3;
		ASCII_TO_EBCDIC[0xDC] = (byte) 0xB4;
		ASCII_TO_EBCDIC[0xDD] = (byte) 0xB5;
		ASCII_TO_EBCDIC[0xDE] = (byte) 0xB6;
		ASCII_TO_EBCDIC[0xDF] = (byte) 0xB7;
		ASCII_TO_EBCDIC[0xE0] = (byte) 0xB8;
		ASCII_TO_EBCDIC[0xE1] = (byte) 0xB9;
		ASCII_TO_EBCDIC[0xE2] = (byte) 0xBA;
		ASCII_TO_EBCDIC[0xE3] = (byte) 0xBB;
		ASCII_TO_EBCDIC[0xE4] = (byte) 0xBC;
		ASCII_TO_EBCDIC[0xE5] = (byte) 0xBD;
		ASCII_TO_EBCDIC[0xE6] = (byte) 0xBE;
		ASCII_TO_EBCDIC[0xE7] = (byte) 0xBF;
		ASCII_TO_EBCDIC[0xE8] = (byte) 0xCA;
		ASCII_TO_EBCDIC[0xE9] = (byte) 0xCB;
		ASCII_TO_EBCDIC[0xEA] = (byte) 0xCC;
		ASCII_TO_EBCDIC[0xEB] = (byte) 0xCD;
		ASCII_TO_EBCDIC[0xEC] = (byte) 0xCE;
		ASCII_TO_EBCDIC[0xED] = (byte) 0xCF;
		ASCII_TO_EBCDIC[0xEE] = (byte) 0xDA;
		ASCII_TO_EBCDIC[0xEF] = (byte) 0xDB;
		ASCII_TO_EBCDIC[0xF0] = (byte) 0xDC;
		ASCII_TO_EBCDIC[0xF1] = (byte) 0xDD;
		ASCII_TO_EBCDIC[0xF2] = (byte) 0xDE;
		ASCII_TO_EBCDIC[0xF3] = (byte) 0xDF;
		ASCII_TO_EBCDIC[0xF4] = (byte) 0xEA;
		ASCII_TO_EBCDIC[0xF5] = (byte) 0xEB;
		ASCII_TO_EBCDIC[0xF6] = (byte) 0xEC;
		ASCII_TO_EBCDIC[0xF7] = (byte) 0xED;
		ASCII_TO_EBCDIC[0xF8] = (byte) 0xEE;
		ASCII_TO_EBCDIC[0xF9] = (byte) 0xEF;
		ASCII_TO_EBCDIC[0xFA] = (byte) 0xFA;
		ASCII_TO_EBCDIC[0xFB] = (byte) 0xFB;
		ASCII_TO_EBCDIC[0xFC] = (byte) 0xFC;
		ASCII_TO_EBCDIC[0xFD] = (byte) 0xFD;
		ASCII_TO_EBCDIC[0xFE] = (byte) 0xFE;
		ASCII_TO_EBCDIC[0xFF] = (byte) 0xFF;
		for (int i = 0; i < 256; ++i) {
			EBCDIC_TO_ASCII[ASCII_TO_EBCDIC[i] & 0xFF] = (byte) i;
		}
	}

	/**
	 * 禁用构造方法
	 */
	private ByteUtil() {
	}

	/**
	 * 把一个字节从 ASCII 编码转会为 EBCDIC 编码
	 * 
	 * @param asciiByte
	 *            ASCII 字节
	 * @return EBCDIC 字节
	 */
	public static byte asciiToEbcdic(final byte asciiByte) {
		return ASCII_TO_EBCDIC[asciiByte & 0xFF];
	}

	/**
	 * 把一个字节数据从 ASCII 编码转会为 EBICIC 编码
	 * 
	 * @param asciiBytes
	 *            ASCII 字节数组
	 * @return EBCDIC 字节数组
	 */
	public static byte[] asciiToEbcdic(final byte[] asciiBytes) {
		for (int i = 0; i < asciiBytes.length; ++i) {
			asciiBytes[i] = asciiToEbcdic(asciiBytes[i]);
		}
		return asciiBytes;
	}

	/**
	 * 把一个字节从 EBCDIC 编码转会为 ASCII 编码
	 * 
	 * @param ebcdicByte
	 *            EBCDIC 字节
	 * @return ASCII 字节
	 */
	public static byte ebcdicToAscii(final byte ebcdicByte) {
		return EBCDIC_TO_ASCII[ebcdicByte & 0xFF];
	}

	/**
	 * 把一个字节数据从 EBICIC 编码转会为 ASCII 编码
	 * 
	 * @param ebcdicBytes
	 *            EBICIC 字节数组
	 * @return ASCII 字节数组
	 */
	public static byte[] ebcdicToAscii(final byte[] ebcdicBytes) {
		for (int i = 0; i < ebcdicBytes.length; ++i) {
			ebcdicBytes[i] = ebcdicToAscii(ebcdicBytes[i]);
		}
		return ebcdicBytes;
	}
}
