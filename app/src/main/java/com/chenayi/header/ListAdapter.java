package com.chenayi.header;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Chenwy on 2018/4/8.
 */

public class ListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ListAdapter(List<String> data) {
        super(R.layout.item_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_content, item);
    }
}
