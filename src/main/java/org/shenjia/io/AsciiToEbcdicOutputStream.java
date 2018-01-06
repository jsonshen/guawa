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
import java.io.OutputStream;

import org.shenjia.util.ByteUtil;

/**
 * ASCII 编码转换为 EBCDIC 编码输出
 * 
 * @author Jason Shen
 */
public class AsciiToEbcdicOutputStream extends OutputStream {

	private OutputStream target;

	/**
	 * 获取目标输出流
	 * 
	 * @return 目标输出流
	 */
	public OutputStream getTarget() {
		return target;
	}

	/**
	 * 构造 EBCDIC 编码输出流
	 * 
	 * @param target
	 *            目标输出流
	 */
	public AsciiToEbcdicOutputStream(OutputStream target) {
		this.target = target;
	}

	/**
	 * 输出一个 ASCII 编码整数为 EBCDIC 编码
	 */
	@Override
	public void write(int b) throws IOException {
		target.write(ByteUtil.asciiToEbcdic((byte) b));
	}

	/**
	 * 刷新输出流
	 */
	@Override
	public void flush() throws IOException {
		target.flush();
	}

	/**
	 * 关闭输出流
	 */
	@Override
	public void close() throws IOException {
		target.close();
	}

}
