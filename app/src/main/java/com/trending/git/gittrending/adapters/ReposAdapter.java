package com.trending.git.gittrending.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.trending.git.gittrending.R;
import com.trending.git.gittrending.classes.Repos;


import java.util.List;

public class ReposAdapter extends BaseAdapter {
    private Context myContext;
    private List<Repos> listOfRepos;

    //constructor

    public ReposAdapter(Context myContext, List<Repos> listOfRepos) {
        this.myContext = myContext;
        listOfRepos = listOfRepos;
    }

    @Override
    public int getCount() {
        return listOfRepos.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfRepos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(myContext, R.layout.repos_item,null);
        TextView tvrepos = view.findViewById(R.id.tvReposName);
        TextView tvdesc = view.findViewById(R.id.tvDescription);
        TextView tvowner = view.findViewById(R.id.tvOwnerName);
        TextView tvscore = view.findViewById(R.id.tvscore);
        /////////////////////////////////

        /////////////////////////////////
        tvrepos.setText(listOfRepos.get(position).getRepo_name());
        tvdesc.setText(listOfRepos.get(position).getRepo_desc());
        tvowner.setText(listOfRepos.get(position).getOwner_name());
        tvscore.setText(String.valueOf(listOfRepos.get(position).getScore()));
        return null;
    }


}
