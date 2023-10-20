package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText ed_name;
    private TextView tv_text, tv_name, tv_winner, tv_mmora, tv_comra;
    private RadioButton btn_scissor, btn_stone, btn_paper;
    private Button btn_mora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_name = findViewById(R.id.ed_name);
        tv_text = findViewById(R.id.tv_text);
        tv_name = findViewById(R.id.tv_name);
        tv_winner = findViewById(R.id.tv_winner);
        tv_mmora = findViewById(R.id.tv_mmora);
        tv_comra = findViewById(R.id.tv_comra);
        btn_scissor = findViewById(R.id.btn_scissor);
        btn_stone = findViewById(R.id.btn_stone);
        btn_paper = findViewById(R.id.btn_paper);
        btn_mora = findViewById(R.id.btn_mora);

        btn_mora.setOnClickListener(view -> {
            if (ed_name.length() < 1) {
                tv_text.setText("請輸入玩家姓名");
            } else {

                tv_name.setText(String.format("名字\n%s", ed_name.getText().toString()));

                if (btn_scissor.isChecked()) {
                    tv_mmora.setText("我方出拳\n剪刀");
                }
                if (btn_stone.isChecked()) {
                    tv_mmora.setText("我方出拳\n石頭");
                } else {
                    tv_mmora.setText("我方出拳\n布");
                }

                int computer_random = (int) (Math.random() * 3);

                if (computer_random == 0) {
                    tv_comra.setText("電腦出拳\n剪刀");
                }
                if (computer_random == 1) {
                    tv_comra.setText("電腦出拳\n石頭");
                } else {
                    tv_comra.setText("我方出拳\n布");
                }

                if ((btn_scissor.isChecked() && computer_random == 2) ||
                        (btn_stone.isChecked() && computer_random == 0) ||
                        (btn_paper.isChecked() && computer_random == 1)) {
                    tv_winner.setText("勝利者\n" + ed_name.getText().toString());
                    tv_text.setText("恭喜你獲勝了!");
                } else if ((btn_scissor.isChecked() && computer_random == 1) ||
                        (btn_stone.isChecked() && computer_random == 2) ||
                        (btn_paper.isChecked() && computer_random == 0)) {
                    tv_winner.setText("勝利者\n電腦");
                    tv_text.setText("可惜 電腦獲勝了!");
                } else {
                    tv_winner.setText("勝利者\n平手");
                    tv_text.setText("平局 再來一次!");
                }
            }
        });
    }
}