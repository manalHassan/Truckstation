package truckstationsa.truckstation;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class SinglePostView extends AppCompatActivity {
 private DatabaseReference mDatabase;
 private String post_id=null;
 private ImageView postImage;
 private TextView post_title;
 private TextView post_dec;
 private TextView post_OwnerID;
 private TextView post_OwnerName;
 private Button removeButton;
 FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_post_view);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("postsTest3");
        post_id = getIntent().getExtras().getString("post_id");
        mAuth= FirebaseAuth.getInstance();

        postImage=(ImageView)findViewById(R.id.single_post_image);
        post_title=(TextView)findViewById(R.id.single_imageTitle);
        post_dec=(TextView)findViewById(R.id.single_imageDesc);
        post_OwnerName=(TextView)findViewById(R.id.single_userName);
        removeButton=(Button) findViewById(R.id.removePostButton);
        mDatabase.child(post_id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String postTitle=(String) dataSnapshot.child("name").getValue();
                String postDesc=(String) dataSnapshot.child("desc").getValue();
                String postOwnerID=(String) dataSnapshot.child("uid").getValue();
                String post_image=(String) dataSnapshot.child("image").getValue();
                String postUsername=(String) dataSnapshot.child("username").getValue();

                post_title.setText(postTitle);
                post_dec.setText(postDesc);
                post_OwnerName.setText(postUsername);

                Picasso.with(SinglePostView.this).load(post_image).into(postImage);

                if(mAuth.getCurrentUser().getUid().equals(postOwnerID)){
                    removeButton.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    mDatabase.child(post_id).removeValue();
                    Intent intent=new Intent(SinglePostView.this,PublicOwnerProfileActivity.class);
                    startActivity(intent);
            }
        });
    }
}
