package com.tusharmalik.contacts;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etVar1, etVar2;
    Button btne,btnp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etVar1 = (EditText) findViewById(R.id.e1);
        etVar2 = (EditText) findViewById(R.id.e2);
        btne = (Button) findViewById(R.id.b1);
        btnp = (Button) findViewById(R.id.b2);


        btne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input2=etVar1.getText().toString();
                Intent mail = new Intent(Intent.ACTION_SENDTO);
                mail.setData(Uri.fromParts("mailto",input2,null));
//                mail.setType("plain/text");
//                mail.putExtra(Intent.EXTRA_SUBJECT, "Emailing link");
//                mail.putExtra(Intent.EXTRA_TEXT, "Link is \n" +
//                        "This is the body of hte message");
                startActivity(mail);
            }


        });
        btnp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input1="tel:"+etVar2.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(input1));
                startActivity(intent);

            }


        });
    }

}
