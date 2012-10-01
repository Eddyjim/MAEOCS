package com.maeocs.handler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class CommHttpGet {

	private static String convertStreamToString(InputStream is)
			throws UnsupportedEncodingException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is,
				"UTF-8"));
		StringBuilder sb = new StringBuilder();
		String line = null;

		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return sb.toString();

	}

	public String execCommHttpGet(String strURL) throws Exception {
		String result = null;
		URL url = new URL(strURL);
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();

		try {
			InputStream in = urlConn.getInputStream();
			result = convertStreamToString(in);

		} catch (Exception e) {
			Log.v("[COMM.GET]", "Network exception", e);
			e.printStackTrace();
		}
		return result;
	}

}
