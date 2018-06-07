package com.example.quynhlinh.sodienthoai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quynhlinh.sodienthoai.adapter.sodienthoaiAdapter;
import com.example.quynhlinh.sodienthoai.model.sodienthoai;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<sodienthoai> arrayList;
    sodienthoaiAdapter adapter;
    ListView lview;
    Button btnsend;
    int vitri=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,nhapsdt.class);
                startActivityForResult(intent,1000);
            }
        });
        lview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayList.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Đã Xóa",Toast.LENGTH_LONG).show();
                return false;
            }
        });
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sodienthoai sdt=arrayList.get(i);
                String name=sdt.getTen();
                String sodt=sdt.getSdt();
                Intent intent=new Intent(MainActivity.this,nhapsdt.class);
                intent.putExtra("name",name);
                intent.putExtra("sdt",sodt);
                startActivityForResult(intent,90);
                vitri=i;
            }
        });
    }

    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1000 && resultCode==RESULT_OK && data!=null){
            String name=data.getStringExtra("name");
            String sdt=data.getStringExtra("sdt");
            arrayList.add(new sodienthoai(name,sdt));
            adapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this,"Thêm Thành Công",Toast.LENGTH_LONG).show();
        }else if(requestCode==90 && resultCode==RESULT_OK && data!=null){
            String name=data.getStringExtra("name");
            String sdt=data.getStringExtra("sdt");
            arrayList.set(vitri,new sodienthoai(name,sdt));
            adapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this,"Sửa Thành Công",Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void init(){
        lview=(ListView) findViewById(R.id.lview);
        arrayList=new ArrayList<>();
        arrayList.add(new sodienthoai("Tran Van A","0961688293"));

        adapter=new sodienthoaiAdapter(MainActivity.this,R.layout.dong_sdt,arrayList);
        lview.setAdapter(adapter);
        btnsend=(Button) findViewById(R.id.btnsend);
    }
}
