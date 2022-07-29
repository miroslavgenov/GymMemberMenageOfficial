package com.miroslav.gymmembermenageofficial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.miroslav.gymmembermenageofficial.databinding.ActivityAddClientBinding;

public class AddClientActivity extends AppCompatActivity {
    private ActivityAddClientBinding activityAddClientBinding;
    private EditText clientNameEditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main();
    }

    void setClientNameEditText(EditText src){
        this.clientNameEditText = src;
    }

    EditText getClientNameEditText(){
        return this.clientNameEditText;
    }

    String getClientNameString() {
        try {
            EditText edt = this.getClientNameEditText();
            if (edt != null) {
                String clientName = edt.getText().toString();
                if (clientName != null) {

                    return clientName;
                }
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void main() {
        setContextView();
        this.setClientNameEditText(this.getActivityAddClientBinding().editTextClientName);
        onAddButton();
        onCancelButton();
    }

    private void onAddButton() {
        executeAddButtonEventListenerAndAddClient();
    }

    private void executeAddButtonEventListenerAndAddClient() {
        getActivityAddClientBinding().buttonAddAddClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addClient();
            }
        });
    }

    private void addClient() {
        String clientName = this.getClientNameString();
        if(clientName!=null){

            Log.d("AddClient",clientName);

        }
    }

    private void onCancelButton() {
        executeCancelButtonEventListenerAndCloseActivity();
    }

    private void executeCancelButtonEventListenerAndCloseActivity() {
        this.getActivityAddClientBinding().buttonCancelAddClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private ActivityAddClientBinding getActivityAddClientBinding() {
        return this.activityAddClientBinding!=null?activityAddClientBinding:null;
    }


    private void setContextView() {
        this.activityAddClientBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_client);
    }


}





























