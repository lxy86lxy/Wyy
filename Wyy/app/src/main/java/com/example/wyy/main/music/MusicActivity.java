package com.example.wyy.main.music;

import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.wyy.R;
import com.example.wyy.classes.MusicUrlClass.Music;
import com.example.wyy.classes.SelectClass.Select;
import com.example.wyy.string.Strings;
import com.example.wyy.util.HttpBack;
import com.example.wyy.util.HttpUtil;
import com.example.wyy.util.JsonUtil;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MusicActivity extends AppCompatActivity {
        List<Select> sListList;
        private Timer timer;
        static SeekBar sb;
        static TextView tv_progress;
        static TextView tv_total;
        TextView name_song;
        private ObjectAnimator animator;
        RadioButton radioButton1,radioButton2;
        CheckBox checkBox;
        String name;
        String address;
        String address1;
        Music music;
        String url;
        Intent intent1;
        private static int progress123;
        MediaPlayer player;
        Button button,button1;
        private boolean isUnbind =false;//记录服务是否被解绑
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_music);
                intent1=getIntent();

                init();
        }
        private void init(){
                tv_progress=findViewById(R.id.tv_progress);
                tv_total=findViewById(R.id.tv_total);
                sb=findViewById(R.id.seekBar);
                name_song=findViewById(R.id.song_name);
                checkBox=findViewById(R.id.music_radioButton_center);
                radioButton1=findViewById(R.id.music_radioButton_left);
                radioButton2=findViewById(R.id.music_radioButton_right);
                button=findViewById(R.id.music_button_left);
                button1=findViewById(R.id.music_button_right);
                player=new MediaPlayer();
                checkBox.setChecked(true);
                //转换
                sListList=(List<Select>) intent1.getSerializableExtra("like");
                ImageView iv_music=findViewById(R.id.musicImage);
                String url1=intent1.getStringExtra("url");
                //可以使用返回的数据下载图片
                Glide.with(this).load(url1).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_music);
                name=intent1.getStringExtra("name");
                name_song.setText(name);
                address1=intent1.getStringExtra("id");
                button.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void onClick(View v) {
                                Intent intent=new Intent(MusicActivity.this,WordActivity.class);
                                intent.putExtra("ly",address1);
                                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MusicActivity.this).toBundle());
                        }
                });
                button1.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void onClick(View v) {
                                Intent intent=new Intent(MusicActivity.this, CommentActivity.class);
                                intent.putExtra("ly",address1);
                                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(MusicActivity.this).toBundle());
                        }
                });
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if(checkBox.isChecked()){

                                        try{
                                                player.seekTo(progress123);
                                                player.start();
                                                animator.start();
                                                /*addTimer();//添加计时器*/
                                        }catch(Exception e){
                                                e.printStackTrace();
                                        }

                                }else{
                                        player.pause();
                                        animator.pause();
                                        progress123= sb.getProgress();
                                }
                        }
                });

                //上一曲
                radioButton1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                checkBox.setChecked(true);
                                for (int i = 0; i < sListList.size(); i++) {
                                        if(sListList.get(i).getMusicId().equalsIgnoreCase(address1)){
                                                int p=i;
                                                p--;
                                                address1=String.valueOf(sListList.get(p).getMusicId());
                                                Glide.with(MusicActivity.this).load(sListList.get(p).getPicUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_music);
                                                name_song.setText(sListList.get(p).getName());
                                                updata();
                                                animator.start();
                                                break;
                                        }
                                }
                        }
                });
                //下一曲
                radioButton2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                checkBox.setChecked(true);

                                for (int i = 0; i < sListList.size(); i++) {
                                        if(sListList.get(i).getMusicId().equalsIgnoreCase(address1)){
                                                int p1=i;
                                                p1++;
                                                address1=String.valueOf(sListList.get(p1).getMusicId());
                                                Glide.with(MusicActivity.this).load(sListList.get(p1).getPicUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_music);
                                                name_song.setText(sListList.get(p1).getName());
                                                updata();
                                                animator.start();
                                                break;
                                        }
                                }
                        }
                });

                //为滑动条添加事件监听
                sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                //进度条改变时，会调用此方法
                                if (progress==seekBar.getMax()){//当滑动条到末端时，结束动画
                                        animator.pause();//停止播放动画
                                        player.pause();
                                }
                        }
                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {//滑动条开始滑动时调用
                        }
                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {//滑动条停止滑动时调用
                                //根据拖动的进度改变音乐播放进度
                                int progress=seekBar.getProgress();//获取seekBar的进度
                                //????????????????????????????????????
                                progress123=progress;

                                player.seekTo(progress);
                        }
                });

                animator=ObjectAnimator.ofFloat(iv_music,"rotation",0f,360.0f);
                animator.setDuration(10000);//动画旋转一周的时间为10秒
                animator.setInterpolator(new LinearInterpolator());//匀速
                animator.setRepeatCount(-1);//-1表示设置动画无限循环
                if (checkBox.isChecked()){
                        updata();
                        animator.start();
                }
        }

        private void updata() {
                address= Strings.MUSIC_URL+address1;
                new HttpUtil().sendHttpRequest(address, new HttpBack() {
                        @Override
                        public void onFinish(String response) {
                                Log.d("sssssssssssss","正在进行");
                                music=new JsonUtil().JsonMusic(response);
                                runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                                url=music.getUrl();
//                                                Log.d("BBBBBBBBB",url);




//                    成功
                                                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                                try{
                                                        player.reset();//重置音乐播放器
                                                        //加载多媒体文件
                                                        player.setDataSource(url);
                                                        player.prepare();//预加载音频
                                                        player.start();//播放音乐
                                                        addTimer();//添加计时器
                                                }catch(Exception e){
                                                        e.printStackTrace();
                                                }
                                        }

                                });
                        }

                        @Override
                        public void onError(Exception e) {
                                Log.d("LLLLLLLL","请求失败");
                        }
                });
        }

//内存泄漏
        public static Handler handler=new Handler(){//创建消息处理器对象
                //在主线程中处理从子线程发送过来的消息
                @Override
                public void handleMessage(Message msg){
                        Bundle bundle=msg.getData();//获取从子线程发送过来的音乐播放进度
                        //????????????????????????????????????
                        int duration=bundle.getInt("duration");//总时间
                        int currentPosition=bundle.getInt("currentPosition");//进程速度位置
                        sb.setMax(duration);
                        sb.setProgress(currentPosition);
                        //歌曲总时长
                        int minute=duration/1000/60;
                        int second=duration/1000%60;
                        String strMinute=null;
                        String strSecond=null;
                        if(minute<10){//如果歌曲的时间中的分钟小于10
                                strMinute="0"+minute;//在分钟的前面加一个0
                        }else{
                                strMinute=minute+"";
                        }
                        if (second<10){//如果歌曲中的秒钟小于10
                                strSecond="0"+second;//在秒钟前面加一个0
                        }else{
                                strSecond=second+"";
                        }
                        tv_total.setText(strMinute+":"+strSecond);
                        //歌曲当前播放时长
                        minute=currentPosition/1000/60;
                        second=currentPosition/1000%60;
                        if(minute<10){//如果歌曲的时间中的分钟小于10
                                strMinute="0"+minute;//在分钟的前面加一个0
                        }else{
                                strMinute=minute+" ";
                        }
                        if (second<10){//如果歌曲中的秒钟小于10
                                strSecond="0"+second;//在秒钟前面加一个0
                        }else{
                                strSecond=second+" ";
                        }
                        tv_progress.setText(strMinute+":"+strSecond);
                }
        };

        private void unbind(boolean isUnbind){
                if(!isUnbind){//判断服务是否被解绑
                        /*  musicControl.pausePlay();//暂停播放音乐*/
                        player.pause();//暂停播放音乐
                        /*  unbindService(conn);//解绑服务*/

                        if(player==null) return;
                        if(player.isPlaying()) player.stop();//停止播放音乐
                        player.release();//释放占用的资源
                        player=null;//将player置为空
                }
        }

        @Override
        protected void onDestroy(){
                super.onDestroy();
                unbind(isUnbind);//解绑服务
        }


        //计时器
        public void addTimer(){ //添加计时器用于设置音乐播放器中的播放进度条
                if(timer==null){
                        timer=new Timer();//创建计时器对象
                        TimerTask task=new TimerTask() {
                                @Override
                                public void run() {
                                        if (player==null) return;
                                        int duration=player.getDuration();//获取歌曲总时长
                                        int currentPosition=player.getCurrentPosition();//获取播放进度
                                        Message msg=MusicActivity.handler.obtainMessage();//创建消息对象
                                        //将音乐的总时长和播放进度封装至消息对象中
                                        Bundle bundle=new Bundle();
                                        bundle.putInt("duration",duration);
                                        bundle.putInt("currentPosition",currentPosition);
                                        msg.setData(bundle);
                                        //将消息发送到主线程的消息队列
                                        MusicActivity.handler.sendMessage(msg);
                                }
                        };
                        //开始计时任务后的5毫秒，第一次执行task任务，以后每500毫秒执行一次
                        timer.schedule(task,5,500);
                }
        }
}
