package com.example.anil.smarthelpline.Navigation_Elements;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.anil.smarthelpline.MainActivity;
import com.example.anil.smarthelpline.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class feedback_Fragment extends Fragment implements View.OnClickListener {


    EditText name,sendTo,subject,emailText;
    Button sendFeedback;
    public feedback_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).setTItleSupport("Feedback");


        name = (EditText) getView().findViewById(R.id.name);
        sendTo = (EditText) getView().findViewById(R.id.sendTo);
        subject = (EditText) getView().findViewById(R.id.subject);
        emailText = (EditText) getView().findViewById(R.id.emailText);
        sendFeedback = (Button) getView().findViewById(R.id.sendFeedback);

        if (name.getText().toString().equals(" "))
            name.setError("Name field is empty!!");
        else if (sendTo.getText().toString().equals(" "))
            sendTo.setError("Mandatory field!");
        else if (subject.getText().toString().equals(" "))
            subject.setError("Subject field is empty!!");
        else if (emailText.getText().toString().equals(" "))
            emailText.setError("message field is empty!!");
            sendFeedback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String sub = subject.getText().toString();
                    String msg = emailText.getText().toString();

                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.setData(Uri.parse("mailTo:"));
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"Skraghav80@gmail.com"});
                    email.putExtra(Intent.EXTRA_SUBJECT, sub);
                    email.putExtra(Intent.EXTRA_TEXT, "Dear Sonu, \n" + msg + "\n regards, " + sendTo.getText().toString());

                    email.setType("message/rfc822");
                    startActivity(Intent.createChooser(email, "Choose an Email sender :"));
                }
            });

        }


        @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_feedback, container, false);



       return view;
    }

    @Override
    public void onClick(View view) {

    }
}
