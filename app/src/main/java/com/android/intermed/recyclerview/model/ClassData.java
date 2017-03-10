package com.android.intermed.recyclerview.model;

import com.android.intermed.recyclerview.R;

import java.util.ArrayList;
import java.util.List;


public class ClassData
{
    private static final String[] title ={"Amalia Nurul Balqis", "Sistem Informasi", "Fakultas Ilmu Komputer", "Jakarta", "Musik"};

        private static final int[] icon = {R.drawable.user, R.drawable.si, R.drawable.comp, R.drawable.home, R.drawable.music};

        public static List<ListItem> getListData(){
            List<ListItem> data = new ArrayList<>();

            for (int x=0; x<4; x++){

                for (int i = 0; i <title.length && i < icon.length; i++) {
                    ListItem item = new ListItem();

                    item.setImage(icon[i]);
                    item.setTitle(title[i]);
                    data.add(item);
                }
            }
            return data;
        }

}
