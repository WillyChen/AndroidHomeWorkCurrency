package tw.com.hotaicyber.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edntd;
    private Button go_btn;
    private Button go_btn1;
    private TextView jp_text;
    private TextView us_text;
    private float us = 30.9f;
    private float jp = 28.1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    private void findViews() {
        edntd = findViewById(R.id.edntd);
        go_btn1 = findViewById(R.id.go_btn);
        jp_text = findViewById(R.id.jp_text);
        us_text = findViewById(R.id.us_text);
    }

    public void go_btn_click(View view) {
        if (edntd.getText().toString().isEmpty()) {
            showCustomDialog("Problem", "Please enter your NTD amoun");
            return;
        }

        float ntd = Float.parseFloat(edntd.getText().toString());
        Log.d("MainActivity","NTD: " + ntd);

        float usResult = (ntd / us);
        float jpResult = (ntd * jp);

        showCustomDialog("Result","USD is " + Float.toString(usResult));

        jp_text.setText(Float.toString(jpResult));
        us_text.setText(Float.toString(usResult));
    }

    public void showCustomDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK",null)
                .show();
    }

}
