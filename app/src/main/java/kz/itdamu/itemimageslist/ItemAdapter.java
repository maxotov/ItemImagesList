package kz.itdamu.itemimageslist;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.viewpagerindicator.UnderlinePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aibol on 16.07.2016.
 */
public class ItemAdapter extends RecyclerView.Adapter {
    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;
    private List<Item> items;
    private Activity activity;

    public ItemAdapter(List<Item> itemList, Activity act){
        this.items = itemList;
        this.activity = act;
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == VIEW_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_row, parent, false);

            vh = new ShopViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.progress_item, parent, false);

            vh = new ProgressViewHolder(v);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ShopViewHolder) {
            Item shop = items.get(position);
            ((ShopViewHolder) holder).name.setText(shop.getName());
            ((ShopViewHolder) holder).id.setText(String.valueOf(shop.getId()));
            GalleryAdapter adapter;
            if(!shop.getImgUris().isEmpty()) {
                adapter = new GalleryAdapter(activity, shop.getImgUris());
            } else {
                List<String> noImages = new ArrayList<>();
                noImages.add("http://192.168.1.73/MallBackend/images/icon/no_media.jpg");
                adapter = new GalleryAdapter(activity, noImages);
            }
            ((ShopViewHolder) holder).pager.setAdapter(adapter);
            ((ShopViewHolder) holder).underlinePageIndicator.setViewPager(((ShopViewHolder) holder).pager);
            //((ShopViewHolder) holder).pager.setClipToPadding(false);
            //((ShopViewHolder) holder).pager.setPadding(40, 0, 40, 0);
        } else {
            ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView id;
        public ViewPager pager;
        public UnderlinePageIndicator underlinePageIndicator;

        public ShopViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.item_name);
            id = (TextView) v.findViewById(R.id.item_id);
            pager = (ViewPager) v.findViewById(R.id.pager);
            underlinePageIndicator = (UnderlinePageIndicator)v.findViewById(R.id.indicator);


            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("Mall id = ", shopId.getText().toString());
                    /**Intent intent = new Intent(activity, MainActivity.class);
                     intent.putExtra("id", mallId.getText().toString());
                     intent.putExtra("title", name.getText().toString());
                     activity.startActivity(intent);*/
                }
            });
        }
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;
        public ProgressViewHolder(View v) {
            super(v);
            progressBar = (ProgressBar) v.findViewById(R.id.progressBar1);
        }
    }

}
