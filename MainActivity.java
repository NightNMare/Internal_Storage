package com.example.chap9_2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText content;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = findViewById(R.id.content);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            //editText  내용 로드
            String memo = content.getText().toString();

            //내부저장장치 폴더 만들고 파일 만들기
            FileWriter writer;
            File dir = new File(getFilesDir()+"/myTest");

            //디렉토리 없으면 새로 만들기;
            if (!dir.exists())
                dir.mkdir();

            //파일에 내용 저장
            try {
                writer = new FileWriter(dir + "/test.txt", true);
                writer.write(memo);
                writer.close();
                Toast.makeText(this, "Save File Success", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, ReadActivity.class);
                startActivity(intent);

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Save File Fail", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
