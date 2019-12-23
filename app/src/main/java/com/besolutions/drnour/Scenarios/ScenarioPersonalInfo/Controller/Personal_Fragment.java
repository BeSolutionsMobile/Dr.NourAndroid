package com.besolutions.drnour.Scenarios.ScenarioPersonalInfo.Controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioHome.Controller.MainActivity;
import com.besolutions.drnour.Scenarios.ScenarioResevation.Controller.Reservation_popup;
import com.besolutions.drnour.Utils.firebase_storage;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class Personal_Fragment extends Fragment {

    private View view;
    TextView txtchangepass,txtaddphone, txtaddphoto;

    Uri selectedImage;
    static Bitmap bitmaps;

    FirebaseStorage storage;
    StorageReference storageReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.personal_fragment, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Personal Info");
        FirebaseApp.initializeApp(getContext());

        FirebaseApp.initializeApp(getActivity());
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        txtchangepass = view.findViewById(R.id.txtPersonalChangePass);
        txtaddphone = view.findViewById(R.id.txtPersonalAddPhone);
        txtaddphoto = view.findViewById(R.id.txtPersonalAddPhoto);


        txtchangepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Change_Password_Popup dialog = new Change_Password_Popup();
                dialog.show(getActivity().getSupportFragmentManager(),"Change_Password_Popup");

            }
        });

        txtaddphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Add_Photo_Popup dialog = new Add_Photo_Popup();
                dialog.show(getActivity().getSupportFragmentManager(),"Add_Photo_Popup");

            }
        });

        txtaddphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Add_Phone_Popup dialog = new Add_Phone_Popup();
                dialog.show(getActivity().getSupportFragmentManager(),"Add_Phone_Popup");

            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }


   /* public void onChooseFile (View v){

        CropImage.activity()
                .setMaxCropResultSize(250,250)
                .setCropShape(CropImageView.CropShape.RECTANGLE)
                .start(getActivity());

    }
*/

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // In fragment class callback


        if (requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){

            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if (resultCode == RESULT_OK){

                selectedImage = result.getUri();
                InputStream imageStream = null;
                try {
                    FileOutputStream fos = null;
                    imageStream = getActivity().getContentResolver().openInputStream(selectedImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Bitmap SelectedPhoto = BitmapFactory.decodeStream(imageStream);
                bitmaps = Bitmap.createScaledBitmap(SelectedPhoto, 300, 300, true);

                firebase_storage firebase_storage=new firebase_storage();
                firebase_storage.uploadImage(selectedImage,getContext(),true);

                Log.e("akakkakkakakkaka",""+selectedImage);


                //SET IMAGE
                Add_Photo_Popup addPhotoPopup=new Add_Photo_Popup();
                addPhotoPopup.set_image(bitmaps,firebase_storage.uploadImage(selectedImage,getContext(),true));

            }
            else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){

                Exception e = result.getError();
                Toast.makeText(getContext(), ""+e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
