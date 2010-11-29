package org.yestech.cloud.android

import android.os.Bundle
import android.view.{MenuItem, Menu}
import android.content.{DialogInterface, Intent}
import android.app.{AlertDialog, Activity}

/**
 *
 *
 */

class MyCloud extends Activity {
  @Override
  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.cloud)
  }

  /**
   * Create the Menu Options
   *
   * @param menu
   * @return
   */
  @Override
  override def onCreateOptionsMenu(menu: Menu): Boolean = {
    val inflater = getMenuInflater();
    inflater.inflate(R.menu.main, menu);
    return true;
  }

  @Override
  override def onOptionsItemSelected(item: MenuItem): Boolean = {
    // Handle item selection
    item.getItemId() match {
      case R.id.about_menu =>
        showAbout();
        return true;
//      case R.id.help_menu =>
//        showHelp();
//        return true;
      case R.id.quit_menu =>
        quit();
        return true;
       case _ =>
          return super.onOptionsItemSelected(item);
    }
  }

  private def showAbout(): Unit = {
    val builder = new AlertDialog.Builder(this);
    builder.setTitle(R.string.about_title)
            .setIcon(R.drawable.about_icon)
            .setMessage(R.string.about_text)
            .setCancelable(true)
            .setNeutralButton(R.string.close_button, new DialogInterface.OnClickListener() {
      override def onClick(dialog: DialogInterface, id: Int): Unit = {
        dialog.dismiss();
      }
    });
    val aboutDialog = builder.create();
    aboutDialog.show();
  }

  private def showHelp(): Unit = {
    val myIntent = new Intent(this, classOf[Help]);
    startActivity(myIntent);
  }

  private def quit(): Unit = {
    finish();
  }
}
