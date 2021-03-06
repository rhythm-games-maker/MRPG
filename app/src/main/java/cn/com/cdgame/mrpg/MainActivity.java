package cn.com.cdgame.mrpg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hankcs.hanlp.HanLP;

import cn.com.cdgame.mrpg.abst.Emotion;
import cn.com.cdgame.mrpg.abst.Friendliness;
import cn.com.cdgame.mrpg.abst.Job;
import cn.com.cdgame.mrpg.object.npc.BaseNPC;
import cn.com.cdgame.mrpg.object.npc.TalkCallback;
import cn.com.cdgame.mrpg.tools.CharAnalysisTool;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    EditText editText;
    Button button;
    BaseNPC testnpc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = (Button) findViewById(R.id.button);
        this.editText = (EditText) findViewById(R.id.editText);
        this.textView = (TextView) findViewById(R.id.textView);
        HanLP.Config.ShowTermNature = false;
        CharAnalysisTool.tool.init(this);
        // test();







    }

    private void test() {
        testnpc = new BaseNPC();
        testnpc.setAge("20");
        testnpc.setGender("M");
        testnpc.setName("小王");
        testnpc.setId("npc000000001");
        Emotion emotion = new Emotion();
        emotion.value = 0;
        Job job = new Job();  //职业
        job.setJobId("job000251525");
        job.setName("商贩");
        job.setLv("1");
        Friendliness friendliness = new Friendliness(); //友善值
        friendliness.value = 0;
        testnpc.setJob(job);
        testnpc.setFriendliness(friendliness);
        testnpc.setEmotion(emotion);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testnpc.talking(editText.getText().toString(), new TalkCallback() {
                    @Override
                    public void onNext(String reply) {
                        textView.setText(reply);
                    }

                    @Override
                    public void onError() {
                        textView.setText("这个人不知道你在说什么的样子");
                    }
                });
            }
        });
    }

}
