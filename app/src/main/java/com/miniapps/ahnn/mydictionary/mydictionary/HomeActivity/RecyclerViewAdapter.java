package com.miniapps.ahnn.mydictionary.mydictionary.HomeActivity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.miniapps.ahnn.mydictionary.mydictionary.R;
import com.miniapps.ahnn.mydictionary.mydictionary.Word;

import java.util.ArrayList;

import static com.miniapps.ahnn.mydictionary.mydictionary.R.id.btn_dialog_bottom_sheet_ok;

/**
 * Created by NaderNabil on 4/22/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private Context context;
    private ArrayList<Word> Items;
    private HomePresenter presenter;

    public RecyclerViewAdapter(Context context, ArrayList<Word> Items, HomePresenter presenter) {
        this.context = context;
        this.Items = Items;
        this.presenter = presenter;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new RecyclerViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.round_view.setBackgroundTintList(ColorStateList.valueOf(getRandomMaterialColor()));
        holder.big_letter.setText(Items.get(position).getWord().toString().substring(0, 1));
        holder.english.setText(Items.get(position).getWord());
        holder.arabic.setText(Items.get(position).getMeaning());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(context);
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View dialogView = inflater.inflate(R.layout.dialog_bottom_sheet, null);
                final TextView word = (TextView) dialogView.findViewById(R.id.detail_word);
                TextView mean = (TextView) dialogView.findViewById(R.id.detail_meaning);
                TextView example = (TextView) dialogView.findViewById(R.id.detail_example);
                ImageView view = (ImageView) dialogView.findViewById(R.id.Speak_word);
                Button btn_dialog_bottom_sheet_ok = (Button) dialogView.findViewById(R.id.btn_dialog_bottom_sheet_ok);
                Button btn_dialog_bottom_sheet_delete = (Button) dialogView.findViewById(R.id.btn_dialog_bottom_sheet_delete);
                Button btn_dialog_bottom_sheet_edit = (Button) dialogView.findViewById(R.id.btn_dialog_bottom_sheet_edit);
                mBottomSheetDialog.setContentView(dialogView);
                word.setText(Items.get(position).getWord());
                mean.setText(Items.get(position).getMeaning());
                example.setText(Items.get(position).getExample());
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String sp = word.getText().toString();
                        Log.d("Ahmedddd", sp);
                       // presenter.speakWords(sp);
                    }
                });
                btn_dialog_bottom_sheet_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mBottomSheetDialog.dismiss();
                    }
                });
                btn_dialog_bottom_sheet_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mBottomSheetDialog.dismiss();
                        Items.remove(position);
                        notifyItemRemoved(position);
                        presenter.DeleteWord(Items.get(position));

                    }
                });
                btn_dialog_bottom_sheet_edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mBottomSheetDialog.dismiss();
                        presenter.UpdateWord(Items.get(position));
                    }
                });
                mBottomSheetDialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    private int getRandomMaterialColor() {
        int returnColor = Color.GRAY;
        int arrayId = context.getResources().getIdentifier("mdcolor_400", "array", context.getPackageName());

        if (arrayId != 0) {
            TypedArray colors = context.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }
        return returnColor;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        public RelativeLayout round_view;
        public TextView big_letter;
        public TextView english;
        public TextView arabic;

        private RecyclerViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            round_view = (RelativeLayout) mView.findViewById(R.id.round_view);
            big_letter = (TextView) mView.findViewById(R.id.tv_inside_round);
            english = (TextView) mView.findViewById(R.id.tv_recycler_item_1);
            arabic = (TextView) mView.findViewById(R.id.tv_recycler_item_2);
        }
    }
}