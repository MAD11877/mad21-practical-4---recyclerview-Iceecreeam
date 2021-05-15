package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {


    public void IconCLick(View v) {
        RelativeLayout relLay = (RelativeLayout) v.getParent();

        AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);

        TextView nameUser = relLay.findViewById(R.id.NameUser);
        TextView descUser = relLay.findViewById(R.id.DescriptionUser);


        builder.setTitle("Profile");
        builder.setMessage(String.valueOf(nameUser.getText()));
        builder.setPositiveButton("CLOSE", null);
        builder.setNegativeButton("VIEW",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Integer rand = new Random().nextInt();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.putExtra("nameUser", String.valueOf(nameUser.getText()));
                intent.putExtra("descUser", String.valueOf(descUser.getText()));

                startActivity(intent);

            }
        });
        builder.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Context context = getApplicationContext();


        for (int i=0; i <20; i++){
            UserListSingleton.getInstance().UserList.add(new User("Name" + String.valueOf(new Random().nextInt()), "Description " +String.valueOf(new Random().nextInt()), new Random().nextInt() ,  new Random().nextBoolean()));
        }

        RecyclerView recyclerViewCustom = findViewById(R.id.rv);
        AdapterUserList customAdapter = new AdapterUserList(UserListSingleton.getInstance().UserList);
        LinearLayoutManager cLayoutManager = new LinearLayoutManager(this);
        recyclerViewCustom.setLayoutManager(cLayoutManager);
        recyclerViewCustom.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCustom.setAdapter(customAdapter);


 /*ImageView img = (ImageView) findViewById(R.id.userIcon);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);

                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setPositiveButton("CLOSE", null);
                builder.setNegativeButton("VIEW",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Integer rand = new Random().nextInt();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                        intent.putExtra("RandomInt", String.valueOf(rand));
                        startActivity(intent);

                    }
                });
                builder.show();
            }
        });*/
    }



    @Override
    protected void onStart(){
        super.onStart();
        Log.v("Debug", "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Debug", "Resume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v("Debug", "Pause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v("Debug", "Stop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v("Debug", "Destroy");
    }



}

