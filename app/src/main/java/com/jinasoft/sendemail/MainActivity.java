package com.jinasoft.sendemail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{
    private GMailSender m;

    EditText et_content;
    EditText et_title;

    String emailCode;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_send = (Button) this.findViewById(R.id.btn_send);
        et_content = (EditText) findViewById(R.id.et_content);
        et_title = (EditText) findViewById(R.id.et_title);

        emailCode = createEamilCode();

        btn_send.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                GMailSender sender = new GMailSender("EMail", "PW"); // SUBSTITUTE

                if (android.os.Build.VERSION.SDK_INT > 9)
                {

                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();

                    StrictMode.setThreadPolicy(policy);

                }
                // HERE
                try
                {
                    sender.sendMail("title", // subject.getText().toString(),
                            "content", // body.getText().toString(),
                            "sender", // from.getText().toString(),
                            "reciveEmail" // to.getText().toString()
                    );

                    toast();
                } catch (Exception e)
                {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }
        });
    }

    public void toast()
    {
        Toast.makeText(this, "전송되었습니다.", Toast.LENGTH_SHORT).show();
        finish();
    }

    private String createEamilCode() {
        String[] str = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        String newCode = new String();

        for (int i =0; i<8; i++ ) {
            int random = (int ) (Math.random() * str.length);
            newCode += str[random];
        }
        return newCode;

    }
}





