package ite.smu.smombie_codedit2019;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WatchoutDialog2 extends Dialog {
    private Context c;
    private ImageView logo01;
    private ImageView logo02;

    public WatchoutDialog2(Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCanceledOnTouchOutside(false);

        c=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchout_dialog2);

        logo01 = (ImageView)findViewById(R.id.pic1);
        Animation animation = AnimationUtils.loadAnimation(c, R.anim.wave);
        logo01.setAnimation(animation);
//
//        logo02 = (ImageView)findViewById(R.id.intro_hand);
//        Animation animation2 = AnimationUtils.loadAnimation(c, R.anim.hand);
//        logo02.setAnimation(animation2);
    }
}
