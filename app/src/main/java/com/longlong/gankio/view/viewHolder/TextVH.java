package com.longlong.gankio.view.viewHolder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.longlong.gankio.R;
import com.longlong.gankio.model.bean.Result;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class TextVH extends BaseViewHolder<Result> {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.author)
    TextView author;
    @BindView(R.id.time)
    TextView time;

    public TextVH(ViewGroup parent) {
        super(parent, R.layout.item_text);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(Result data) {
        super.setData(data);
        title.setText(data.getDesc());
        type.setText(data.getType());
        author.setText(data.getWho());
        time.setText(data.getPublishedAt());
    }
}
