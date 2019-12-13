package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    double num1;
    double num2;
    //    double num3;
    double res;
    /*
     *
     * calFlag 运算标识
     * 初始状态: 0    加：1     减：2     乘：3     除：4
     *
     * */
    int calFlag = 0;
    //    int calFlag2 = 0;
    Boolean calOp = false;
    Boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        int i = -1 - 2;
//        Log.v("number",String.valueOf(i));

        //横屏转换
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Intent intents = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intents);
        }

        //添加按键屏幕显示
        final EditText text = findViewById(R.id.screen);
        text.setText(text.getText() + "0");


        //清除按钮
        Button clear = findViewById(R.id.clear_btn);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("0");
                calFlag = 0;
                flag = true;
//                calFlag2 = 0;
//                num3 = 0;
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

        Button percent = findViewById(R.id.percent_btn);
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                double res = Double.valueOf(concent);
                text.setText(String.valueOf(res * 0.01));
            }
        });

        //小数点
        Button point = findViewById(R.id.point_btn);
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = String.valueOf(text.getText());
                if (flag) {
                    text.setText(text.getText() + ".");
                }
                flag = false;

            }
        });


        //加减乘除逻辑处理


        Button plus = findViewById(R.id.plus_btn);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (calOp) {
                    if (calFlag == 0) {
                        String content = String.valueOf(text.getText());
                        num1 = Double.valueOf(content);
                        calFlag = 1;
                    } else {
                        String content = String.valueOf(text.getText());
                        num2 = Double.valueOf(content);
                        res = num2;
                        switch (calFlag) {
                            case 0:
                                break;
                            case 1:
                                res = num1 + num2;
                                num1 = res;
                                    if (Math.round(res) - res == 0)
                                    text.setText(String.valueOf((long) res));
                                else
                                    text.setText(String.valueOf(res));
                                break;
                            case 2:
                                res = num1 - num2;
                                num1 = res;
                                if (Math.round(res) - res == 0)
                                    text.setText(String.valueOf((long) res));
                                else
                                    text.setText(String.valueOf(res));
                                break;
                            case 3:
                                res = num1 * num2;
                                num1 = res;
                                if (Math.round(res) - res == 0)
                                    text.setText(String.valueOf((long) res));
                                else
                                    text.setText(String.valueOf(res));
                                break;
                            case 4:
                                res = num1 / num2;
                                num1 = res;
                                if (Math.round(res) - res == 0)
                                    text.setText(String.valueOf((long) res));
                                else
                                    text.setText(String.valueOf(res));
                                break;
                        }
                    }

                }
                calOp = false;
                calFlag = 1;
                flag = true;
            }
        });

        Button minus = findViewById(R.id.thelose_btn);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (calOp) {
                    if (calFlag == 0) {
                        String content = String.valueOf(text.getText());
                        num1 = Double.valueOf(content);
                        calFlag = 2;
                    } else {
                        String content = String.valueOf(text.getText());
                        num2 = Double.valueOf(content);
                        res = num2;
                        switch (calFlag) {
                            case 0:
                                break;
                            case 1:
                                res = num1 + num2;
                                num1 = res;
                                if (Math.round(res) - res == 0)
                                    text.setText(String.valueOf((long) res));
                                else
                                    text.setText(String.valueOf(res));
                                break;
                            case 2:
                                res = num1 - num2;
                                num1 = res;
                                if (Math.round(res) - res == 0)
                                    text.setText(String.valueOf((long) res));
                                else
                                    text.setText(String.valueOf(res));
                                break;
                            case 3:
                                res = num1 * num2;
                                num1 = res;
                                if (Math.round(res) - res == 0)
                                    text.setText(String.valueOf((long) res));
                                else
                                    text.setText(String.valueOf(res));
                                break;
                            case 4:
                                res = num1 / num2;
                                num1 = res;
                                if (Math.round(res) - res == 0)
                                    text.setText(String.valueOf((long) res));
                                else
                                    text.setText(String.valueOf(res));
                                break;
                        }
                    }
                }
                calFlag = 2;
                flag =true;
            }
        });
        Button multiply = findViewById(R.id.multiply_btn);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (calOp) {
                    if (calFlag == 0) {
                        String content = String.valueOf(text.getText());
                        num1 = Double.valueOf(content);
                        calFlag = 3;
                    } else if (calFlag > 2) {
                        String content = String.valueOf(text.getText());
                        num2 = Double.valueOf(content);
                        res = num2;
                        switch (calFlag) {
                            case 3:
                                res = num1 * num2;
                                num1 = res;
                                if (Math.round(res) - res == 0)
                                    text.setText(String.valueOf((long) res));
                                else
                                    text.setText(String.valueOf(res));
                                break;
                            case 4:
                                res = num1 / num2;
                                num1 = res;
                                if (Math.round(res) - res == 0)
                                    text.setText(String.valueOf((long) res));
                                else
                                    text.setText(String.valueOf(res));
                                break;
                        }
                    } else {
//                    num3 = num1;
//                    calFlag2 = calFlag;
                        String content = String.valueOf(text.getText());
                        num1 = Double.valueOf(content);
                    }
                }
                calFlag = 3;
                flag = true;
            }
        });

        Button divide = findViewById(R.id.divide_btn);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (calOp) {
                    if (calFlag == 0) {
                        String content = String.valueOf(text.getText());
                        num1 = Double.valueOf(content);
                        calFlag = 4;
                    } else if (calFlag > 2) {
                        String content = String.valueOf(text.getText());
                        num2 = Double.valueOf(content);
                        res = num2;
                        if (content.equals("0")) {
                            text.setText("Error");
                            calFlag = 0;
                            num1 = 0;
                        } else {
                            switch (calFlag) {
                                case 3:
                                    res = num1 * num2;
                                    num1 = res;
                                    if (Math.round(res) - res == 0)
                                        text.setText(String.valueOf((long) res));
                                    else
                                        text.setText(String.valueOf(res));
                                    break;
                                case 4:
                                    res = num1 / num2;
                                    num1 = res;
                                    if (Math.round(res) - res == 0)
                                        text.setText(String.valueOf((long) res));
                                    else
                                        text.setText(String.valueOf(res));
                                    break;
                            }
                        }
                    } else {
//                    num3 = num1;
//                    calFlag2 = calFlag;
                        String content = String.valueOf(text.getText());
                        num1 = Double.valueOf(content);
                    }
                }
                calFlag = 4;
                flag = true;
            }

        });

        //等号计算结果
        Button equal = findViewById(R.id.equal_btn);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (calOp) {
                    String content = String.valueOf(text.getText());
                    num2 = Double.valueOf(content);
                    res = num2;
                    switch (calFlag) {
                        case 0:
                            break;
                        case 1:
                            res = num1 + num2;
                            num1 = res;
                            if (Math.round(res) - res == 0)
                                text.setText(String.valueOf((long) res));
                            else
                                text.setText(String.valueOf(res));
                            break;
                        case 2:
                            res = num1 - num2;
                            num1 = res;
                            if (Math.round(res) - res == 0)
                                text.setText(String.valueOf((long) res));
                            else
                                text.setText(String.valueOf(res));
                            break;
                        case 3:
                            res = num1 * num2;
                            num1 = res;
                            if (Math.round(res) - res == 0)
                                text.setText(String.valueOf((long) res));
                            else
                                text.setText(String.valueOf(res));
                            break;
                        case 4:
                            res = num1 / num2;
                            num1 = res;
                            if (Math.round(res) - res == 0)
                                text.setText(String.valueOf((long) res));
                            else
                                text.setText(String.valueOf(res));
                            break;
                    }
                    calOp = false;
                }
            }
        });


        //数字按键显示

        Button one = findViewById(R.id.one_btn);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calOp = true;
                String concent = String.valueOf(text.getText());
                if (!flag)
                    text.setText(text.getText() + "1");
                else {
                    if (concent.equals("0") || calFlag != 0)
                        text.setText("1");
                    else
                        text.setText(text.getText() + "1");
                }
            }
        });

        Button two = findViewById(R.id.two_btn);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calOp = true;
                String concent = String.valueOf(text.getText());
                if (!flag)
                    text.setText(text.getText() + "2");
                else {
                    if (concent.equals("0") || calFlag != 0)
                        text.setText("2");
                    else
                        text.setText(text.getText() + "2");
                }
            }
        });

        Button three = findViewById(R.id.three_btn);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concent = String.valueOf(text.getText());
                calOp = true;
                if (!flag)
                    text.setText(text.getText() + "3");
                else {
                    if (concent.equals("0") || calFlag != 0)
                        text.setText("3");
                    else
                        text.setText(text.getText() + "3");
                }
            }
        });

        Button four = findViewById(R.id.four_btn);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calOp = true;
                String concent = String.valueOf(text.getText());
                if (!flag)
                    text.setText(text.getText() + "4");
                else {
                    if (concent.equals("0") || calFlag != 0)
                        text.setText("4");
                    else
                        text.setText(text.getText() + "4");
                }
            }
        });

        Button five = findViewById(R.id.five_btn);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calOp = true;
                String concent = String.valueOf(text.getText());
                if (!flag)
                    text.setText(text.getText() + "5");
                else {
                    if (concent.equals("0") || calFlag != 0)
                        text.setText("5");
                    else
                        text.setText(text.getText() + "5");
                }
            }
        });

        Button six = findViewById(R.id.six_btn);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calOp = true;
                String concent = String.valueOf(text.getText());
                if (!flag)
                    text.setText(text.getText() + "6");
                else {
                    if (concent.equals("0") || calFlag != 0)
                        text.setText("6");
                    else
                        text.setText(text.getText() + "6");
                }
            }
        });

        Button seven = findViewById(R.id.seven_btn);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calOp = true;
                String concent = String.valueOf(text.getText());
                if (!flag)
                    text.setText(text.getText() + "7");
                else {
                    if (concent.equals("0") || calFlag != 0)
                        text.setText("7");
                    else
                        text.setText(text.getText() + "7");
                }
            }
        });

        Button eight = findViewById(R.id.eight_btn);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calOp = true;
                String concent = String.valueOf(text.getText());
                if (!flag)
                    text.setText(text.getText() + "8");
                else {
                    if (concent.equals("0") || calFlag != 0)
                        text.setText("8");
                    else
                        text.setText(text.getText() + "8");
                }
            }
        });

        Button nine = findViewById(R.id.nine_btn);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calOp = true;
                String concent = String.valueOf(text.getText());
                if (!flag)
                    text.setText(text.getText() + "9");
                else {
                    if (concent.equals("0") || calFlag != 0)
                        text.setText("9");
                    else
                        text.setText(text.getText() + "9");
                }
            }
        });

        Button zero = findViewById(R.id.zero_btn);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calOp = true;
                String concent = String.valueOf(text.getText());
                if (!flag)
                    text.setText(text.getText() + "0");
                else {
                    if (concent.equals("0") || calFlag != 0)
                        text.setText("0");
                    else
                        text.setText(text.getText() + "0");
                }
            }
        });


    }
}
