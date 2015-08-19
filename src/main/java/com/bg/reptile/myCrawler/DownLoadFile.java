package com.bg.reptile.myCrawler;

import java.io.IOException;
import javax.xml.ws.http.HTTPException;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.bg.reptile.util.FileUtil;

public class DownLoadFile {
	public String getFileNameByUrl(String url, String contentType) {
		// 移除http://
		url = url.substring(7);
		// text/html类型
		if (contentType.indexOf("html") != -1) {
			url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
			return url;
		}
		// 如application/pdf类型
		else {
			return url.replaceAll(
					"[\\?/:*|<>\"]",
					"_"
							+ "."
							+ contentType.substring(contentType
									.lastIndexOf("/")) + 1);
		}
	}

	/*
	 * 保存网页字节数组到本地文件，filepath为要保存的文件的相对地址
	 */
	private void saveToLocal(byte[] data, String filepath) {
		FileUtil.write(data, filepath);
	}

	// 下载URL指向的网页
	public String downloadFile(String url) {
		String filepath = null;
		// 生成HttpClient对象并设置参数
		HttpClient httpClient = new HttpClient();
		// 设置http连接超时5s
		httpClient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(5000);
		// 生成getMethod方法并设置参数
		GetMethod getMethod = new GetMethod(url);
		// 设置getMethod超时5s
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
		// 设置请求重试处理
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.out.println("Methodfailed:" + getMethod.getStatusLine());
				filepath = null;
			}
			byte[] responseBody = getMethod.getResponseBody();// 读取为字节数组
			// 根据url生成保存时的文件名
			filepath = "F:\\mycrawler_file\\"
					+ getFileNameByUrl(url,
							getMethod.getResponseHeader("Content-Type")
									.getValue());
			saveToLocal(responseBody, filepath);
		} catch (HTTPException e) {
			System.out.println("Pleasecheck you provided URL!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
		}
		return filepath;
	}
}
