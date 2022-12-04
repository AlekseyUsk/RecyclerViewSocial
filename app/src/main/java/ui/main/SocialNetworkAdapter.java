package ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.recyclerviewsocial.R;

import repository.CardData;
import repository.CardSource;

public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.MyViewHolder> {

    public SocialNetworkAdapter(CardSource cardSource) {
        this.cardSource = cardSource;
    }

    Fragment fragment;

    public int getMenuPosition() {
        return menuPosition;
    }

    private int menuPosition;

    public SocialNetworkAdapter() {
    }

    public SocialNetworkAdapter(Fragment fragment) {
        this.fragment = fragment;
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
        private final TextView textViewTitle;
        private final TextView textViewDescription;
        private final ImageView imageView;
        private final CheckBox checkBox;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.title);
            textViewDescription = (TextView) itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.imageView);
            checkBox = (CheckBox) itemView.findViewById(R.id.like);

            fragment.registerForContextMenu(itemView); // зарегистрировал на фрагмент контекстное меню на всю карточку
            // но на кликабельных элементах View работать не будет,нужно выполнить следющие на примере картинки - >
            imageView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    menuPosition = getLayoutPosition();
                   // view.showContextMenu();
                    return false;
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    menuPosition = getLayoutPosition();
                    return false;
                }
            });
        }

        //связываем контент с макетом
        public void bindContentWithLayout(CardData content) {
            textViewTitle.setText(content.getTitle());
            textViewDescription.setText(content.getDescription() + " "+content.getDate());
            imageView.setImageResource(content.getPicture());
            checkBox.setChecked(content.isLike());
        }
    }

}
