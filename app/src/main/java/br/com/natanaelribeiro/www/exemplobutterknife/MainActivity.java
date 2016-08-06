package br.com.natanaelribeiro.www.exemplobutterknife;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edtNome) public EditText edtNome;
    @BindView(R.id.edtSenha) public EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
    }

    public void entrar(View view){
        if(edtNome.getText().toString().equals("a") && edtSenha.getText().toString().equals("a")) {
            FragmentManager fragMgr = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragMgr.beginTransaction();
            fragmentTransaction.addToBackStack("tag");
            fragmentTransaction.add(R.id.frame, new FragmentInicial());
            fragmentTransaction.commitAllowingStateLoss();
            //getFragmentManager().beginTransaction().add(R.id.frame, new FragmentInicial()).commitAllowingStateLoss();
        }
        else
            Toast.makeText(this, "Login inválido", Toast.LENGTH_LONG).show();
    }
}
