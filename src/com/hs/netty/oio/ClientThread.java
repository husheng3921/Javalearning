package com.hs.netty.oio;

import java.io.*;
import java.net.*;
/**
 * Description:
 * ��վ: <a href="http://www.crazyit.org">���Java����</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ClientThread implements Runnable
{
	// ���̸߳������Socket
	private Socket s;
	// ���߳��������Socket����Ӧ��������
	BufferedReader br = null;
	public ClientThread(Socket s)
		throws IOException
	{
		this.s = s;
		br = new BufferedReader(
			new InputStreamReader(s.getInputStream()));
	}
	public void run()
	{
		try
		{
			String content = null;
			while ((content = br.readLine()) != null)
			{
				System.out.println(content);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
