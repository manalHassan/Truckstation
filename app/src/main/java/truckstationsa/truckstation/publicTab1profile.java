package truckstationsa.truckstation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hadeel on 2/10/18.
 */

public class publicTab1profile extends Fragment {
    Button button;
    DatabaseReference databaseref;
    DatabaseReference databaseReferences;
    TextView username;
    TextView mail;
    TextView phone;
    TextView wwh;
    FirebaseAuth firebaseAuth;
    private TextView location;
    DatabaseReference database;
    String address;
    List<Post> artists;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView= inflater.inflate(R.layout.public_tab1_profile, container, false);
       // databaseref = FirebaseDatabase.getInstance().getReference("");
        artists = new ArrayList<>();

/*
        databaseref.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        Log.e(dataSnapshot.getKey(),dataSnapshot.getChildrenCount() + "");
    }
 @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});
*/

       // Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
       // ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
      //  setHasOptionsMenu(true);//Make sure you have this line of code
        databaseref = FirebaseDatabase.getInstance().getReference();

        // Read from the database
        databaseref.child("PublicFoodTruckOwner").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                String user1 = user.getUid();//customer id is the same as rating id to make it easy to refer

                String name = dataSnapshot.child(user1).child("fusername").getValue(String.class);
              int phonnum = dataSnapshot.child(user1).child("fponeNoumber").getValue(int.class);
                String email = dataSnapshot.child(user1).child("femail").getValue(String.class);
                String cc = dataSnapshot.child(user1).child("qusins").getValue(String.class);
               // String wh=dataSnapshot.child(user1).child("fworkingHours").getValue(String.class);
                String logo = dataSnapshot.child(user1).child("url").getValue(String.class);
                ImageView mg= (ImageView) rootView.findViewById(R.id.mg);
               // Glide.with(getActivity()).load(logo).override(45, 72).into(mg);
                username = (TextView) rootView.findViewById(R.id.type);
                username.setText(" " + cc);
                TextView profilename = (TextView) rootView.findViewById(R.id.user);
                profilename.setText(name);
             //   wwh= (TextView) rootView.findViewById(R.id.wh);
             //   wwh.setText(" " + wh);
                mail = (TextView) rootView.findViewById(R.id.email);
                mail.setText(" " + email);
               phone = (TextView) rootView.findViewById(R.id.phone);
               phone.setText(" " + phonnum + " ");



            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getActivity(), "لايوجد اتصال بالانترنت", Toast.LENGTH_LONG).show();
            }
        });

        databaseReferences = FirebaseDatabase.getInstance().getReference();
       // databaseReferences.orderByChild("uid").equalTo(user1);
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String user1 = user.getUid();//customer id is the same as rating id to make it easy to refer
        databaseReferences.child("postsTest3").orderByChild("uid").equalTo(user1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                artists.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Post artist =new Post(ds.getValue(Post.class));
                    artists.add(artist);
                }


                //creating adapter
             int posts= artists.size();
                TextView t=rootView.findViewById(R.id.pp);
                t.setText(posts+" ");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //
        return rootView;
    }


}
