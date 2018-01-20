package haojun.android_common.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import haojun.android_common.R;
import haojun.android_common.adapter.BaseRVAdapter;
import haojun.android_common.adapter.BaseViewHolder;
import haojun.android_common.model.Book;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_main);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new BookRVAdapter(this, R.layout.item_rv));

        getBooks();
    }

    private void getBooks() {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            books.add(new Book(UUID.randomUUID().toString(), "Book" + i, 100, "2018-01-01 00:00:00"));
        }
        ((BookRVAdapter) rv.getAdapter()).setData(books);
    }

    private class BookRVAdapter extends BaseRVAdapter<Book> {

        BookRVAdapter(Context context, int layoutId) {
            super(context, layoutId);
        }

        @Override
        protected void convert(Context context, BaseViewHolder holder, Book book) {
            holder.setText(R.id.tv_item_rv_id, book.getId())
                    .setText(R.id.tv_item_rv_title, book.getTitle())
                    .setText(R.id.tv_item_rv_price, String.valueOf(book.getPrice()))
                    .setText(R.id.tv_item_rv_create_date, book.getCreateDate());
        }
    }

}
