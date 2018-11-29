package ser421.edu.asu.dpanfili_act3;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button submitBtn;
    private EditText nameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitBtn = (Button)findViewById(R.id.button);
        nameTxt = (EditText)findViewById(R.id.editText);

        //Add listener when button is clicked.
        //Do this onCreate as we have to set this up on initialization
        //Not on each lifecycle event

        submitBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String s = nameTxt.getText().toString().trim();
                if(s != null && !s.equals("")){
                    Intent goToGamePort = new Intent(MainActivity.this,WebActivity.class);
                    goToGamePort.putExtra("username",s);
                    startActivity(goToGamePort);

                }
                else{
                    Toast.makeText(getApplicationContext(), "Put in a name! ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }




}
