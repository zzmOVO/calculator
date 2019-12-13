package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.calculator.calculate;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText text = findViewById(R.id.screen);
        final EditText text1 = findViewById(R.id.text1);

        //函数功能

        Button sin = findViewById(R.id.sin_btn);
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());

                double res = Math.toRadians(Double.valueOf(concent));
                text.setText(String.valueOf(Math.sin(res)));
            }
        });
        Button cos = findViewById(R.id.cos_btn);
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                double res = Math.toRadians(Double.valueOf(concent));
                text.setText(String.valueOf(Math.cos(res)));
            }
        });

        //单位换算
        Button length = findViewById(R.id.length_btn);
        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                double num = Double.valueOf(concent);
                text1.setText(String.valueOf(num*100));
            }
        });

        Button v = findViewById(R.id.v_btn);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                double num = Double.valueOf(concent);
                text1.setText(String.valueOf(num*10000));
            }
        });


        //进制转换

        Button erjiznhi = findViewById(R.id.erjinzhi_btn);
        erjiznhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                int num = Integer.valueOf(concent);
                text1.setText("二进制：" + String.valueOf(Integer.toBinaryString(num)));
            }
        });

        Button bajinzhi = findViewById(R.id.bajinzhi_btn);
        bajinzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                int num = Integer.valueOf(concent);
                text1.setText("八进制：" + String.valueOf(Integer.toOctalString(num)));
            }
        });
        Button shiliujinzhi = findViewById(R.id.shiliujinzhi_btn);
        shiliujinzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                int num = Integer.valueOf(concent);
                text1.setText("十六进制：" + String.valueOf(Integer.toHexString(num)));
            }
        });

        //帮助
        Button help = findViewById(R.id.help_btn);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, "帮助", Toast.LENGTH_SHORT).show();
            }
        });




        //计算器逻辑
        Button clear = findViewById(R.id.clear_btn);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("0");
                text1.setText("");
            }
        });

        Button lose = findViewById(R.id.lose_btn);
        lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (!concent.equals("0"))
                    text.setText("-" + text.getText());

            }
        });

        Button mi = findViewById(R.id.mi_btn);
        mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"^");

            }
        });

        Button equal = findViewById(R.id.equal_btn);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                calculate calculate = new calculate();
                String res = calculate.getEventuate(concent);
                String[] results = res.split("=");
                double result = Double.valueOf(results[1]);
                if (Math.round(result) - result == 0)
                    text.setText(String.valueOf((int) result));
                else
                    text.setText(String.valueOf(result));
            }
        });

        Button point = findViewById(R.id.point_btn);
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + ".");
            }
        });

        Button percent = findViewById(R.id.percent_btn);
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                double res = Double.valueOf(concent);
                text.setText(String.valueOf(res * 0.01));
            }
        });

        Button zuokouhao = findViewById(R.id.zuokouohao_btn);
        zuokouhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("(");
                else
                    text.setText(text.getText() + "(");
            }
        });

        Button youkuohao = findViewById(R.id.youkuohao_btn);
        youkuohao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + ")");
            }
        });

        Button plus = findViewById(R.id.plus_btn);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("+");
                else
                    text.setText(text.getText() + "+");
            }
        });
        Button minus = findViewById(R.id.thelose_btn);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("-");
                else
                    text.setText(text.getText() + "-");
            }
        });
        Button mutiply = findViewById(R.id.multiply_btn);
        mutiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("*");
                else
                    text.setText(text.getText() + "*");
            }
        });
        Button divide = findViewById(R.id.divide_btn);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("/");
                else
                    text.setText(text.getText() + "/");
            }
        });
        Button one = findViewById(R.id.one_btn);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("1");
                else
                    text.setText(text.getText() + "1");
            }
        });
        Button two = findViewById(R.id.two_btn);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("2");
                else
                    text.setText(text.getText() + "2");
            }
        });
        Button three = findViewById(R.id.three_btn);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("3");
                else
                    text.setText(text.getText() + "3");
            }
        });
        Button four = findViewById(R.id.four_btn);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("4");
                else
                    text.setText(text.getText() + "4");
            }
        });
        Button five = findViewById(R.id.five_btn);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("5");
                else
                    text.setText(text.getText() + "5");
            }
        });

        Button six = findViewById(R.id.six_btn);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("6");
                else
                    text.setText(text.getText() + "6");
            }
        });
        Button seven = findViewById(R.id.seven_btn);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("7");
                else
                    text.setText(text.getText() + "7");
            }
        });
        Button eight = findViewById(R.id.eight_btn);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("8");
                else
                    text.setText(text.getText() + "8");
            }
        });
        Button nine = findViewById(R.id.nine_btn);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("9");
                else
                    text.setText(text.getText() + "9");
            }
        });
        Button zero = findViewById(R.id.zero_btn);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                if (concent.equals("0"))
                    text.setText("0");
                else
                    text.setText(text.getText() + "0");
            }
        });


    }

}
