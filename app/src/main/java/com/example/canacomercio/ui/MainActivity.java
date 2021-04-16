package com.example.canacomercio.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.canacomercio.R;
import com.example.canacomercio.retrofit.CanacoApiServicio;
import com.example.canacomercio.retrofit.CanacoCliente;
import com.example.canacomercio.retrofit.response.ResponseLogin;
import com.example.canacomercio.retrofit.request.RequestLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    ImageView btnVerContraseña;
    EditText txtEmail, txtContraseña;
    CanacoCliente canacoCliente;
    CanacoApiServicio canacoApiServicio;
    boolean band = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        retrofitInit();
        findViews();
        events();
    }

    private void retrofitInit() {
        canacoCliente = CanacoCliente.getInstance();
        canacoApiServicio = canacoCliente.getCanacoApiService();
    }

    private void findViews() {
        btnLogin = findViewById(R.id.btnLogin);
        btnVerContraseña = findViewById(R.id.btnvercontraseña);
        txtEmail = findViewById(R.id.txt_email);
        txtContraseña = findViewById(R.id.txt_contraseña);
    }

    private void events() {
        btnLogin.setOnClickListener(this);
        btnVerContraseña.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnvercontraseña:
                if (band){
                    btnVerContraseña.setImageResource(R.drawable.ic_visibility_open);
                    txtContraseña.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    band = false;
                }else{
                    btnVerContraseña.setImageResource(R.drawable.ic_visibility_close);
                    txtContraseña.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    band = true;
                }

                break;
            case R.id.btnLogin:
                goToLogin();
                break;
        }
    }

    private void goToLogin() {
        String email = txtEmail.getText().toString();
        String contraseña = txtContraseña.getText().toString();
        boolean recordar = true;

        if (email.isEmpty()){
            txtEmail.setError("Email requerido");
        }else if (contraseña.isEmpty()){
            txtContraseña.setError("Contraseña requerida");
        }else{
            RequestLogin requestLogin = new RequestLogin(email, contraseña, recordar);

            Call<ResponseLogin> call = canacoApiServicio.doLogin(requestLogin);
            call.enqueue(new Callback<ResponseLogin>() {
                @Override
                public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Sesión iniciada correctamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this, "Algo fue mal, revise sus datos de acceso ", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseLogin> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Problemas de conexión. Inténtelo de nuevo", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}