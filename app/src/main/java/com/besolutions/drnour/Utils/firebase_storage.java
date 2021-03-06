package com.besolutions.drnour.Utils;


import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.besolutions.drnour.local_data.send_data;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.util.UUID;



public class firebase_storage {

    private String imageURL = "NoLink";


    public String uploadImage(Uri customfilepath, final Context context, Boolean isEnglish) {

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReference();

        final String uploading, done, failed;

        if (isEnglish) {
            uploading = "Uploading...";
            done = "Uploaded Successfully";
            failed = "Uploading Failed";
        } else {
            uploading = "???? ????????";
            done = "?? ????? ?????";
            failed = "???";
        }

        if (customfilepath != null) {
            final ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.setTitle(uploading);
            progressDialog.show();

            final StorageReference ref = storageReference.child("images/" + UUID.randomUUID().toString());
            ref.putFile(customfilepath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

                                @Override
                                public void onSuccess(Uri uri) {

                                    progressDialog.dismiss();

                                    Toast.makeText(context, done, Toast.LENGTH_SHORT).show();

                                    imageURL = uri.toString();

                                    send_data.SAVE_IMAGE(context, imageURL);
                                    send_data.SAVE_IMAGE_nav(context, imageURL);

                                }
                            });

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(context, failed, Toast.LENGTH_SHORT).show();
                            Log.e("fafafafaffaffaf",""+e);
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded " + (int) progress + "%");
                        }
                    });
        }

        return imageURL;
    }
}



