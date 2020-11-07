package ziemansoft.ziemapp.chatterflowtest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ziemansoft.ziemapp.chatterflowtest.R;
import ziemansoft.ziemapp.chatterflowtest.pojo.UserId;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.itemViewHolder> {
    private List<UserId> users = new ArrayList<>();

    public void setUsers(List<UserId> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_item, parent, false);
        return new itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
        UserId userId = users.get(position);
        holder.userName.setText(userId.getUserName());
        holder.userLastName.setText(userId.getUserLastName());
        holder.userAge.setText(userId.getUserAge());
        holder.userAge.setText(userId.getUserSex());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class itemViewHolder extends RecyclerView.ViewHolder{
        private TextView userName;
        private TextView userLastName;
        private TextView userAge;
        private TextView userSex;
        public itemViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.textView);
            userLastName = itemView.findViewById(R.id.textView2);
            userAge = itemView.findViewById(R.id.textView3);
            userSex = itemView.findViewById(R.id.textView4);
        }
    }
}
