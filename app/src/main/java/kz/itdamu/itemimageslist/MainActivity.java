package kz.itdamu.itemimageslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Item> items;
    private RecyclerView mRecyclerView;
    private ItemAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.listItem);
        items = fillItems();
        mAdapter = new ItemAdapter(items, this);
        mLayoutManager = new LinearLayoutManager(this);
        // use a linear layout manager
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    private List<Item> fillItems(){
        List<Item> items = new ArrayList<>();
        Item item1 = new Item(1, "item1", "http://192.168.1.73/MallBackend/images/icon/shop11.png", "http://192.168.1.73/MallBackend/images/icon/shop12.png");
        Item item2 = new Item(2, "item2");
        Item item3 = new Item(3, "item3", "http://192.168.1.73/MallBackend/images/icon/shop25.png", "http://192.168.1.73/MallBackend/images/icon/shop26.png");
        Item item4 = new Item(4, "item4", "http://192.168.1.73/MallBackend/images/icon/shop29.png");
        Item item5 = new Item(5, "item5");
        Item item6 = new Item(6, "item6", "http://192.168.1.73/MallBackend/images/icon/shop33.png", "http://192.168.1.73/MallBackend/images/icon/shop41.png");
        Item item7 = new Item(7, "item7", "http://192.168.1.73/MallBackend/images/icon/nemo.jpg");
        Item item8 = new Item(8, "item8", "http://192.168.1.73/MallBackend/images/icon/shop42.png", "http://192.168.1.73/MallBackend/images/icon/shop43.png", "http://192.168.1.73/MallBackend/images/icon/shop44.png");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        return items;
    }
}
