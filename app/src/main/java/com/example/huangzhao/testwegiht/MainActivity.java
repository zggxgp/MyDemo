package com.example.huangzhao.testwegiht;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.ArrayList;
import java.util.Hashtable;

public class MainActivity extends Activity {

    private ListView listView;
    private TextView test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
////
//        RelativeLayout layout = (RelativeLayout) findViewById(R.id.testlayout);
//        RadioButton radioButton = (RadioButton) getLayoutInflater().inflate(R.layout.radio,null);
////        radioButton.setButtonDrawable(null);
//        radioButton.setBackgroundResource(R.drawable.ripple);
//        radioButton.setText("dfasfdasdfasfdaf");
//        radioButton.setTextSize(80);
//
////        RelativeLayout layout = (RelativeLayout) findViewById(R.id.testlayout);
//        Button radioButton = new Button(this);
////        radioButton.setButtonDrawable(null);
//        radioButton.setBackgroundResource(R.drawable.ripple);
//        radioButton.setText("dfasfdasdfasfdaf");
//        radioButton.setTextSize(80);
//
//        layout.addView(radioButton);
//
//        ImageView imageView = (ImageView) findViewById(R.id.qrcode);
//
//        Bitmap qrBitmap = generateQrBitmap("http://i.vip.iqiyi.com/order/preview.action?pid=a0226bd958843452&platform=abaf99397476e27d&",400, 400);
//
//        imageView.setImageBitmap(qrBitmap);
//        test = (TextView) findViewById(R.id.test);
//        test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                test.setTranslationY(30);
//            }
//        });

        listView = (ListView) findViewById(R.id.test_listview);
        ArrayList<String> testList = new ArrayList<>();
        for(int i = 0;i<100;i++){
            testList.add(i,"测试"+i);
        }
        ArrayAdapter testAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,testList);
        listView.setAdapter(testAdapter);

    }


    private Bitmap generateQrBitmap(String str, int width,int height) {
        try {
            Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hints.put(EncodeHintType.MARGIN, 1);
            BitMatrix matrix = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, width, height);
            matrix = deleteWhite(matrix);//删除白边
            width = matrix.getWidth();
            height = matrix.getHeight();
            int[] pixels = new int[width * height];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (matrix.get(x, y)) {
                        pixels[y * width + x] = Color.BLACK;
                    } else {
                        pixels[y * width + x] = Color.WHITE;
                    }
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            return bitmap;
        } catch (Exception e) {
            return null;
        }
    }

    private static BitMatrix deleteWhite(BitMatrix matrix) {
        int[] rec = matrix.getEnclosingRectangle();
        int resWidth = rec[2]+20;
        int resHeight = rec[3]+20;

        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();
        for (int i = 0; i < resWidth; i++) {
            for (int j = 0; j < resHeight; j++) {
                if (matrix.get(i  + rec[0], j + rec[1]))
                    resMatrix.set(i+10, j+10);
            }
        }
        return resMatrix;
    }

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }


}
