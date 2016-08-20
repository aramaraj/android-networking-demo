package adalwin.com.mainactivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
//TODO : Packaging
//TODO : Logging / Handling Errors
//TODO : Resizing
//TODO : Caching (Disk + Memory)
//TODO : Listeners/Interface Pattern

public class Davinci {

    private static  Davinci instance;

    protected Davinci(){
    }
    public void load_internal(String url, ImageView imageView){
        new ImageLoaderTask(imageView).execute(url);
    }


    public interface ImageLoadedCallback{
        void onImageLoaded(Bitmap bitmap);
        void onError();

    }

    public static void load(){


    }
    public static void load(String url, ImageView ivImage){



        //kickoff async
        if(instance == null){
            instance= new Davinci();
        }
        instance.load_internal(url, ivImage);
        //Use httpUrlConnection
        //Open Stream
        //Get the image - pull down the bytes
    }

    public class ImageLoaderTask extends AsyncTask<String, Void, Bitmap>{
        private  ImageView ivImage;
        public ImageLoaderTask(ImageView ivImage){
            this.ivImage = ivImage;
        }
        //This happens in the UI thread
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        //This is happening on the background thread
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                // 2. Open InputStream to connection
                conn.connect();
                InputStream in = conn.getInputStream();
                // 3. Download and decode the bitmap using BitmapFactory
                bitmap = BitmapFactory.decodeStream(in);
                in.close();
            }catch(Exception e){

            }
            return bitmap;
        }
       //This happens on the UI thread
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            this.ivImage.setImageBitmap(bitmap);
        }
    }
}