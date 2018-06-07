package com.example.quynhlinh.sodienthoai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class nhapsdt extends AppCompatActivity {
    EditText edten,edsdt;
    Button btnthem,btnxoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhapsdt);
        init();
            btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String name=edten.getText().toString().trim();
                    String sdt=edsdt.getText().toString().trim();
                    Integer.parseInt(sdt);
                    Intent intent=getIntent();
                    intent.putExtra("name",name);
                    intent.putExtra("sdt",sdt);
                    setResult(RESULT_OK,intent);
                    finish();
                }catch (Exception e){
                    Toast.makeText(nhapsdt.this,"Lỗi"+e,Toast.LENGTH_LONG).show();
                }

            }
        });
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String sdt=intent.getStringExtra("sdt");
        edsdt.setText(sdt);
        edten.setText(name);
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String name=edten.getText().toString().trim();
                    String sdt=edsdt.getText().toString().trim();
                    Integer.parseInt(sdt);
                    Intent intent=getIntent();
                    intent.putExtra("name",name);
                    intent.putExtra("sdt",sdt);
                    setResult(RESULT_OK,intent);
                    finish();
                }catch (Exception e){
                    Toast.makeText(nhapsdt.this,"Lỗi"+e,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void init(){
        edsdt = (EditText)findViewById(R.id.edsdt);
        edten = (EditText)findViewById(R.id.edten);
        btnthem = (Button) findViewById(R.id.btnthem);
        btnxoa = (Button) findViewById(R.id.btnxoa);
    }

}
