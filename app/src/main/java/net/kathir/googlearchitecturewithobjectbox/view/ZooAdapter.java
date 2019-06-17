package net.kathir.googlearchitecturewithobjectbox.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.kathir.googlearchitecturewithobjectbox.R;
import net.kathir.googlearchitecturewithobjectbox.RecyclerViewClickListener;
import net.kathir.googlearchitecturewithobjectbox.model.Zoo;

import java.util.ArrayList;
import java.util.List;

public class ZooAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Zoo> mZoos = new ArrayList();
    private RecyclerViewClickListener mListener;

    public void setOnClickListener(RecyclerViewClickListener listener)
    {
        mListener = listener;
    }

    public void update(List<Zoo> zoos)
    {
        mZoos.clear();
        mZoos.addAll(zoos);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_zoo,parent,false);
        return new ZooViewHolder(v,mListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        ZooViewHolder zooViewHolder = (ZooViewHolder)holder;
        Zoo zoo = mZoos.get(position);
        zooViewHolder.mNameTextView.setText(zoo.getName());

    }

    @Override
    public int getItemCount()
    {
        return mZoos.size();
    }

    @Override
    public long getItemId(int position)
    {
        return mZoos.get(position).getId();
    }


    private static class ZooViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView mNameTextView;
        private RecyclerViewClickListener mListener;

        public ZooViewHolder(View itemView, RecyclerViewClickListener listener)
        {
            super(itemView);
            mListener = listener;
            mNameTextView = itemView.findViewById(R.id.row_zoo_textview_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            int pos = getAdapterPosition();
            if(pos != RecyclerView.NO_POSITION)
            {
                mListener.onClick(view,pos);
            }
        }
    }
}
