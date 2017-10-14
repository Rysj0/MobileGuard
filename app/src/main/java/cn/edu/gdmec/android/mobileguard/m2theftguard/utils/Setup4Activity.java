package cn.edu.gdmec.android.mobileguard.m2theftguard.utils;


import android.os.Bundle;
import android.widget.RadioButton;

import cn.edu.gdmec.android.mobileguard.R;

public class Setup4Activity extends BaseSetUpActivity {
    @Override
    protected void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_setup_4);
        //设置第2个小圆点的颜色
        ((RadioButton) findViewById(R.id.rb_four)).setChecked(true);
    }
    @Override
    public void showNext(){
        startActivityAndFinishSelf(LostFindActivity.class);
    }

    @Override
    public void showPre(){
        startActivityAndFinishSelf(Setup3Activity.class);
    }
}
