package com.kffuck.mikum.zhiyue.square;


import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kffuck.mikum.zhiyue.MainActivity;
import com.kffuck.mikum.zhiyue.R;
import com.kffuck.mikum.zhiyue.model.TweetObj;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.TweetHolder>{
    private List<TweetObj> tweetObjs;
    private Context context;
    private ImageLoader imageLoader = ImageLoader.getInstance();

    public TweetAdapter(Context context, List<TweetObj> tweetObjs) {
        super();
        this.context = context;
        this.tweetObjs = tweetObjs;
    }

    @Override
    public TweetHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.tweet_item, null);

        TweetHolder holder = new TweetHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(TweetHolder holder, int position) {
        holder.nickname_text.setText(tweetObjs.get(position).nickname);
        holder.time_text.setText(tweetObjs.get(position).time);
        imageLoader.displayImage(tweetObjs.get(position).avatar, holder.avatar_image);
        holder.content_text.setText(tweetObjs.get(position).content);
    }

    @Override
    public int getItemCount() {
        return tweetObjs.size();
    }

    static class TweetHolder extends RecyclerView.ViewHolder{

        CircleImageView avatar_image;
        TextView nickname_text,time_text,content_text;

        public TweetHolder(View itemView) {
            super(itemView);

            avatar_image = (CircleImageView) itemView.findViewById(R.id.tweet_avatar);
            nickname_text = (TextView) itemView.findViewById(R.id.tweet_nickname);
            time_text = (TextView) itemView.findViewById(R.id.tweet_time);
            content_text = (TextView) itemView.findViewById(R.id.tweet_content);
        }


    }
}
