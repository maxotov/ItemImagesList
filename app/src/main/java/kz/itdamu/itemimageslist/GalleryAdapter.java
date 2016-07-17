package kz.itdamu.itemimageslist;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import java.util.List;

/**
 * Created by Aibol on 16.07.2016.
 */
public class GalleryAdapter  extends PagerAdapter {
    private List<String> pagerItems;
    private LayoutInflater inflater;
    private Context context;

    public GalleryAdapter(Context context, List<String> pagerItems) {
        super();
        this.pagerItems = pagerItems;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.gallery_item, container, false);
        ImageView imageViewCampaign = (ImageView) layout.findViewById(R.id.imageView);
        imageViewCampaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        displayGalleryItem(imageViewCampaign, pagerItems.get(position));
        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public int getCount() {
        return pagerItems.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    private void displayGalleryItem(ImageView galleryView, String galleryItem) {
            Glide.with(context) // Bind it with the context of the actual view used
                    .load(galleryItem) // Load the image
                    .fitCenter() // scale type
                    .into(galleryView); // Voilla - the target view
    }
}
