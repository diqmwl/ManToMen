package com.project.taeil.mantomen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.taeil.mantomen.R;

import java.io.InputStream;

public class OperateClassActivity extends AppCompatActivity {

    Variable variable;
    VariableOfClass variableOfClass;

    final static String TAG = "AndroidNodeJS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operate_class);


        variableOfClass.getInstance();

        TextView ClassName = findViewById(R.id.OperateActivity_ClassName);
        TextView ClassTuteeID = findViewById(R.id.OperateActivity_ClassTuteeID);
        TextView ClassCategory = findViewById(R.id.OperateActivity_ClassCategory);
        TextView ClassTotalPeople = findViewById(R.id.OperateActivity_ClassTotalPeople);
        TextView ClassCurrentPeople = findViewById(R.id.OperateActivity_ClassCurrentPeople);
        TextView ClassTutorIntro = findViewById(R.id.OperateActivity_ClassTutorIntro);
        TextView ClassIntro = findViewById(R.id.OperateActivity_ClassIntro);
        TextView ClassContents = findViewById(R.id.OperateActivity_ClassContents);

        TextView ClassWhom = findViewById(R.id.OperateActivity_ClassWhom);
        TextView ClassPrice = findViewById(R.id.OperateActivity_ClassPrice);
        TextView ClassHour = findViewById(R.id.OperateActivity_ClassHour);
        TextView ClassNumberOfTime = findViewById(R.id.OperateActivity_ClassNumberOfTime);
        TextView ClassPlace = findViewById(R.id.OperateActivity_ClassPlace);
        TextView ClassPlaceDetail = findViewById(R.id.OperateActivity_ClassPlaceDetail);
        TextView ClassWeek = findViewById(R.id.OperateActivity_ClassWeek);

        TextView ClassTime = findViewById(R.id.OperateActivity_ClassTime);
        TextView ClassFirstTime = findViewById(R.id.OperateActivity_ClassFirstTime);
        // TextView ClassIdentity = findViewById(R.id.OperateActivity_ClassWeek);
        TextView ClassScore = findViewById(R.id.OperateActivity_ClassScore);

        ClassName.setText(variableOfClass.getClassName());
        ClassTuteeID.setText(variableOfClass.getClassTuteeID());
        ClassCategory.setText(variableOfClass.getClassCategory());
        ClassTotalPeople.setText(variableOfClass.getClassTotalPeople() + " 명");
        ClassCurrentPeople.setText(variableOfClass.getClassCurrentPeople() + " 명");
        ClassTutorIntro.setText(variableOfClass.getClassTutorIntro());
        ClassIntro.setText(variableOfClass.getClassIntro());
        ClassContents.setText(variableOfClass.getClassContents());
        ClassWhom.setText(variableOfClass.getClassWhom());
        ClassPrice.setText(variableOfClass.getClassPrice());
        ClassHour.setText(variableOfClass.getClassHour() + "시간 씩");
        ClassNumberOfTime.setText("한타임에 " + variableOfClass.getClassNumberOfTime() + " 시간씩");
        ClassPlace.setText(variableOfClass.getClassPlace());
        ClassPlaceDetail.setText(variableOfClass.getClassPlaceDetail());
        ClassWeek.setText(variableOfClass.getClassWeek());
        ClassTime.setText(variableOfClass.getClassTime());
        ClassFirstTime.setText(variableOfClass.getClassFirstTime() + "부터");
        ClassScore.setText(variableOfClass.getClassScore() + " 점");


        Button backBtn = findViewById(R.id.OperateActivity_Back);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();  // 백버튼
            }
        });

        Log.d("클래스",variableOfClass.getClassIntro());
        Log.d("클래스",variableOfClass.getClassPlace());
        Log.d("클래스",variableOfClass.getClassPlaceDetail());
        new DownloadImageTask((ImageView) findViewById(R.id.OperateActivity_ClassPicture))
                .execute(variableOfClass.getClassPicture());

    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}
