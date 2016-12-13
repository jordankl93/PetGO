package br.fabio.professor.acessandoobancosqlite;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity  {
    Button b1,b2;
    EditText ed1,ed2;
    private final int menuCadastrar = 6543;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        b2 = (Button)findViewById(R.id.button2);
        tx1 = (TextView)findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("admin") &&
                        ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecionando...",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Login/Senha incorretos!",Toast.LENGTH_SHORT).show();

                            tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CadastrarActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case menuCadastrar:
                Intent i = new Intent(MainActivity.this, CadastrarActivity.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//
//import br.fabio.professor.dao.DaoPessoa;
//import br.fabio.professor.modelo.Pessoa;
//
//public class MainActivity extends AppCompatActivity {
//
//    private final int menuCadastrar = 6543;
//    private ListView lista;
//    private DaoPessoa daoPessoa;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        lista = (ListView) findViewById(R.id.lista);
//        daoPessoa = new DaoPessoa(this);
//
//        setTitle("Listar Pessoas");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        ArrayList<String> values = new ArrayList<String>();
//        final ArrayList<Pessoa> pessoas = daoPessoa.getTodos();
//        for(Pessoa p : pessoas){
//            values.add(p.getNome());
//        }
//        Log.e("apk", values.size() + "");
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, values);
//
//        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Pessoa p = pessoas.get(position);
//                Intent i = new Intent(MainActivity.this, CadastrarActivity.class);
//                i.putExtra("id", p.getId());
//                startActivity(i);
//            }
//        });
//
//        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
//                final Pessoa p = pessoas.get(position);
//
//                new AlertDialog.Builder(MainActivity.this)
//                        .setMessage("Tem certeza que deseja remover " + p.getNome() + "?").setCancelable(false)
//                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                if (daoPessoa.delete(p.getId())) {
//                                    Toast.makeText(MainActivity.this, p.getNome() + " removido com Sucesso",
//                                            Toast.LENGTH_SHORT).show();
//                                    onResume();
//                                } else {
//                                    Toast.makeText(MainActivity.this, "Erro ao remover " + p.getNome(),
//                                            Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        }).setNegativeButton("Não", null).show();
//
//                return false;
//            }
//        });
//
//        lista.setAdapter(adapter);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.add(0, menuCadastrar, 0, "Cadastrar");
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case menuCadastrar:
//                Intent i = new Intent(MainActivity.this, CadastrarActivity.class);
//                startActivity(i);
//                break;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
