package com.hackathon.johndeere.Activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.hackathon.johndeere.R;

/**
 * Created by Matheus on 02/02/2017.
 */

public class ChatFragment extends Fragment {

    public WebView mWebView;

    public ChatFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_chat, container, false);

        if (savedInstanceState == null) {
            mWebView = (WebView) v.findViewById(R.id.webView);
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            mWebView.loadUrl("http://bankbox.net.br/john-deere/watson/");
        }

        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mWebView.saveState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        mWebView.restoreState(savedInstanceState);
    }
}