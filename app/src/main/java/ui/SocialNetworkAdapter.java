package ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.recyclerviewsocial.R;

import repository.CardData;
import repository.CardSource;

public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.MyViewHolder> {

    public SocialNetworkAdapter(CardSource cardSource) {
        this.cardSource = cardSource;
    }

    public SocialNetworkAdapter() {

    }

    public void setData(CardSource cardSource) {
        this.cardSource = cardSource;
        notifyDataSetChanged(); // метод команда отрисовать (ВСЕ! - могут проблемы быть) данные
    }

    private CardSource cardSource;

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater.inflate(R.layout.fragment_social_network_cardview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindContentWithLayout(cardSource.getCardData(position));
    }

    @Override
    public int getItemCount() {
        return cardSource.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private ImageView imageView;
        private CheckBox checkBox;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.title);
            textViewDescription = (TextView) itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.imageView);
            checkBox = (CheckBox) itemView.findViewById(R.id.like);
            /*textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(getLayoutPosition());
                    }
                }
            });*/
        }

        //связываем контент с макетом
        public void bindContentWithLayout(CardData content) {
            textViewTitle.setText(content.getTitle());
            textViewDescription.setText(content.getDescription());
            imageView.setImageResource(content.getPicture());
            checkBox.setChecked(content.isLike());
        }
    }

}
