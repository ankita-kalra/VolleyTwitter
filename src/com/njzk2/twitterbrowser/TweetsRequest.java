package com.njzk2.twitterbrowser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONArray;

import com.android.volley.AuthFailureError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonArrayRequest;

public class TweetsRequest extends JsonArrayRequest {

	public TweetsRequest(String url, Listener<JSONArray> listener, ErrorListener errorListener, List<NameValuePair> params) {
		super(url + "?" + URLEncodedUtils.format(params, "UTF-8"), listener, errorListener);
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		Map<String, String> headers = new HashMap<String, String>();
		String auth = "Bearer " + TwitterValues.ACCESS_TOKEN;
		headers.put("Authorization", auth);
		return headers;
	}
}