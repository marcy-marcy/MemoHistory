package com.marcys.memohistory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private double lambda;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CanvasView cv = findViewById(R.id.canvas_view);
        tv = findViewById(R.id.text_view);

        SeekBar sb = findViewById(R.id.seekBar);
        sb.setOnSeekBarChangeListener(
                new OnSeekBarChangeListener() {
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress, boolean fromUser) {
                        // ツマミをドラッグしたときに呼ばれる
                        String str = String.format(Locale.US, "lambda:%d %%",progress);
                        tv.setText(str);
                        cv.setLambda((double)progress);
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // ツマミに触れたときに呼ばれる
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // ツマミを離したときに呼ばれる
                    }
                }
        );

        //-- Button関連
        Button bt = (Button) findViewById(R.id.clear_button);
        //- 動作設定
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv.allDelete();
            }
        });
    }
}
