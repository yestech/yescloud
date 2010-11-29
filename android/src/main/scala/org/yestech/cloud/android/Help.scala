package org.yestech.cloud.android

import android.os.Bundle
import android.view.KeyEvent
import android.webkit.{WebViewClient, WebView}
import android.app.Activity

/**
 *
 *
 */

class Help extends Activity {
  var mWebView: WebView = null;

  @Override
  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.help);
    val helpUrl = getString(R.string.help_url);
    mWebView = findViewById (R.id.help_webview).asInstanceOf[WebView];
    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.setWebViewClient(new HelpWebViewClient());
    mWebView.loadUrl(helpUrl);
  }

  @Override
  override def onKeyDown(keyCode: Int, event: KeyEvent): Boolean = {
    if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
      mWebView.goBack();
      return true;
    }
    return super.onKeyDown(keyCode, event);
  }

  private class HelpWebViewClient extends WebViewClient {
    @Override
    override def shouldOverrideUrlLoading(view: WebView, url: String): Boolean = {
      view.loadUrl(url);
      return true;
    }
  }
}
