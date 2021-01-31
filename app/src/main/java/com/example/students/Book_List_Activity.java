package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import  android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Book_List_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book__list_);
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String author = ((Books_genre) adapterView.getItemAtPosition(i)).toString();
                Intent intent =new Intent(Book_List_Activity.this, genreBooksActivity.class);
                intent.putExtra(BooksListActivity.AUTHOR, author);
                startActivity(intent);
            }
        };
        ListView listView = (ListView) findViewById(R.id.author_list);
        listView.setOnItemClickListener(listener);
        ArrayAdapter<Books_genre> adapter = new ArrayAdapter<Books_genre>(
                this,
                android.R.layout.simple_list_item_1,
                Books_genre.getGenreList()
        );
        listView.setAdapter(adapter);
    }
}