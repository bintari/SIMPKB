package com.example.simpkb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewResult= findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://jsonplaceholder.typicode.com")
                .baseUrl("http://simpkb.banyumaskab.go.id/apiandroid/antrian1/")

                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                System.out.println("data retrofit "+response.body());

                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " +response.code());
                    return;
                }
//                List<Post> posts = response.body();
//
//                for (Post post: posts){
////                    String content = "";
////                    content += "ID: "+ post.getId() + "\n";
////                    content += "UserID: "+ post.getUserId() + "\n";
////                    content += "Title: "+ post.getTitle() + "\n";
////                    content += "Text: "+ post.getText() + "\n\n";
//
//                    String content = "";
//                    content += "Status: "+ post.getStatus() + "\n";
//                    content += "message: "+ post.getMessage() + "\n";
//                    content += "data: "+ post.getData() + "\n";
//                    content += "no antrian: "+ post.getNo_antrian() + "\n";
//                    content += "total: "+ post.getTotal() + "\n";
//
//                    textViewResult.append(content);
//
//                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }
}