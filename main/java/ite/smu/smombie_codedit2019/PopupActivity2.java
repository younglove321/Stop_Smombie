package ite.smu.smombie_codedit2019;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;


import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

public class PopupActivity2 extends Activity implements View.OnClickListener {

    Button alert;
    private Vibrator vibrator;
    private long[] pattern = {100, 3000, 100, 3000, 100, 3000, 100, 3000};
    private WatchoutDialog2 WatchoutDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup2);
        findViewById(R.id.okbutton2).setOnClickListener(this);
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        initView();
        vibrator.vibrate(pattern, -1);

        int id = getRawResIdByName("greenlight_voice");
        Uri notification = Uri.parse("android.resource://" + getPackageName() + "/" + id);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        r.play();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },3000);

    }
    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.okbutton2:
                PopupActivity2.this.finish();
                break;
        }
    }

    private void initView(){
        WatchoutDialog2 = new WatchoutDialog2(PopupActivity2.this);
        Handler timer = new Handler(); //Handler 생성
        timer.postDelayed(new Runnable(){public void run(){ }}, 2000);
        WatchoutDialog2.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        WatchoutDialog2.dismiss();
    }
}