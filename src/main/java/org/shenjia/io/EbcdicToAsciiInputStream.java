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

package org.shenjia.io;

import java.io.IOException;
import java.io.InputStream;

import org.shenjia.util.ByteUtil;

/**
 * EBCDIC 编码转换为 ASCII 编码输入
 * 
 * @author Jason Shen
 */
public class EbcdicToAsciiInputStream extends InputStream {

	private InputStream target;

	/**
	 * 获取目标输入流
	 * 
	 * @return 目标输入流
	 */
	public InputStream getTarget() {
		return target;
	}

	/**
	 * 构造 EBCDIC 编码输入流
	 * 
	 * @param target
	 *            目标输入流
	 */
	public EbcdicToAsciiInputStream(InputStream target) {
		this.target = target;
	}

	/**
	 * 读取一个 EBCDIC 编码整数为 ASCII 编码
	 * 
	 * @return ASCII 编码整数
	 */
	@Override
	public int read() throws IOException {
		return ByteUtil.ebcdicToAscii((byte) target.read());
	}

	/**
	 * 关闭输入流
	 */
	@Override
	public void close() throws IOException {
		target.close();
	}
}
