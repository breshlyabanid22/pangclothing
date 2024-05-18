package Backend;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.function.Consumer;
import java.util.function.Function;

import Backend.Entity.Account;

public class Database {
    final DatabaseReference firebaseDB;

    public Database() {
        this.firebaseDB = FirebaseDatabase.getInstance().getReference("Users");
    }

    public void isUserExist(Consumer<Boolean> callback, String email){
        firebaseDB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists() && snapshot.hasChild(email)){
                    callback.accept(true);
                }else{
                    callback.accept(false);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("FirebaseError", "Error occurred: " + error.getMessage());
            }
        });
    }

    public void getUserData(Consumer<Account> callback, String email) {
        firebaseDB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists() && snapshot.hasChild(email)) {
                    Account account;
                    account = snapshot.child(email).getValue(Account.class);
                        callback.accept(account);
                } else {
                    callback.accept(null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("FirebaseError", "Error occurred: " + error.getMessage());
            }
        });
    }

    public void writeNewUser(Account account){
        firebaseDB.child(account.getLastname()).setValue(account);
    }

}
