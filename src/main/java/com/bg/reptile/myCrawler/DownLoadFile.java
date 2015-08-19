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
		// �Ƴ�http://
		url = url.substring(7);
		// text/html����
		if (contentType.indexOf("html") != -1) {
			url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
			return url;
		}
		// ��application/pdf����
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
	 * ������ҳ�ֽ����鵽�����ļ���filepathΪҪ������ļ�����Ե�ַ
	 */
	private void saveToLocal(byte[] data, String filepath) {
		FileUtil.write(data, filepath);
	}

	// ����URLָ�����ҳ
	public String downloadFile(String url) {
		String filepath = null;
		// ����HttpClient�������ò���
		HttpClient httpClient = new HttpClient();
		// ����http���ӳ�ʱ5s
		httpClient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(5000);
		// ����getMethod���������ò���
		GetMethod getMethod = new GetMethod(url);
		// ����getMethod��ʱ5s
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
		// �����������Դ���
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.out.println("Methodfailed:" + getMethod.getStatusLine());
				filepath = null;
			}
			byte[] responseBody = getMethod.getResponseBody();// ��ȡΪ�ֽ�����
			// ����url���ɱ���ʱ���ļ���
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
