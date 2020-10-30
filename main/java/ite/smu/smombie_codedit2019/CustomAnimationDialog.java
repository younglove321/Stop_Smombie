package ite.smu.smombie_codedit2019;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class CustomAnimationDialog extends Dialog {
    private Context c;
    private ImageView logo01;
    private ImageView logo02;
    //private ImageView logo_book;

    public CustomAnimationDialog(Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCanceledOnTouchOutside(false);

        c=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_animation_dialog);
//        logo01 = (ImageView) findViewById(R.id.intro_face);
//        Animation anim = AnimationUtils.loadAnimation(c, R.anim.logo);
//        logo01.setAnimation(anim);

        logo02 = (ImageView)findViewById(R.id.intro_hand);
        Animation animation = AnimationUtils.loadAnimation(c, R.anim.hand);
        logo02.setAnimation(animation);
    }
}
