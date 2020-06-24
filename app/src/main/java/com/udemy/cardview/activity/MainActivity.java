package com.udemy.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.udemy.cardview.R;
import com.udemy.cardview.adpater.PostagemAdapter;
import com.udemy.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.HORIZONTAL;

public class MainActivity extends AppCompatActivity {

    private List<Postagem> postagens = new ArrayList<>();
    private RecyclerView recyclerPostagem;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem    =   findViewById(R.id.recyclerView);

        //Define o layout
        /**
         * /LinearLayoutManager layoutManager = new LinearLayoutManager(this);
         * dessa forma utulizando o set Oriention Horizontal criamos uma especie de carrosel
         *   layoutManager.setOrientation(HORIZONTAL);
         **/
        /**
         * dessa forma utilizando o GridLayout conseguimos separar em colunas o nosso layout,
         * sendo que cada card fica em uma coluna
         */
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerPostagem.setLayoutManager(layoutManager);

        //define adapter
        this.prepararPostagens();
        PostagemAdapter adapter = new PostagemAdapter( postagens );
        recyclerPostagem.setAdapter(adapter);

    }

    public void prepararPostagens(){

        Postagem postagem = new Postagem("Rafael Marangoni", "viagens top", R.drawable.imagem1);
        postagens.add(postagem);

        Postagem postagem1 = new Postagem("Rafael Marangoni", "#tbt", R.drawable.imagem2);
        postagens.add(postagem1);

        Postagem postagem2 = new Postagem("Rafael Marangoni", "sdd", R.drawable.imagem3);
        postagens.add(postagem2);

    }
}