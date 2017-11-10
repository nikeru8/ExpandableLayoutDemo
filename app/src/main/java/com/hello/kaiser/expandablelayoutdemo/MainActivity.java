package com.hello.kaiser.expandablelayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import iammert.com.expandablelib.ExpandCollapseListener;
import iammert.com.expandablelib.ExpandableLayout;
import iammert.com.expandablelib.Section;

public class MainActivity extends AppCompatActivity {

    private ExpandableLayout expandableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableLayout = (ExpandableLayout) findViewById(R.id.expandableLayout);
        expandableLayout.setRenderer(new ExpandableLayout.Renderer<Parent, Child>() {
            @Override
            public void renderParent(View view, Parent model, boolean isExpanded, int parentPosition) {
                ((TextView) view.findViewById(R.id.tvParent)).setText(model.getCategory());
                view.findViewById(R.id.arrow).setBackgroundResource(isExpanded ? R.drawable.arrow_up : R.drawable.arrow_down);
            }

            @Override
            public void renderChild(View view, Child model, int parentPosition, int childPosition) {
                ((TextView) view.findViewById(R.id.tvChild)).setText(model.getFruit());
                Log.d("checkpoint", "parent position = " + parentPosition);
            }
        });

        //第一個
        List<String> data = new ArrayList<>();
        data.add("Apple");
        data.add("Orange");
        data.add("Banana");
        data.add("Grape");
        data.add("Cherry");
        data.add("Strawberry");
        expandableLayout.addSection(getSection("2017/10/40", data));
        //第二個
        List<String> datatwo = new ArrayList<>();
        datatwo.add("ewr");
        datatwo.add("Ordfvfange");
        datatwo.add("Ban f ana");
        expandableLayout.addSection(getSection("2019/23/33", datatwo));
        //第三個
        List<String> datathree = new ArrayList<>();
        datathree.add("Applevev");
        datathree.add("Orangevfw");
        datathree.add("Bananasfa");
        datathree.add("Grapeff34");
        datathree.add("Cherryfef");
        expandableLayout.addSection(getSection("21313/434/213", datathree));


        expandableLayout.setExpandListener(new ExpandCollapseListener.ExpandListener<Parent>() {
            @Override
            public void onExpanded(int parentIndex, Parent parent, View view) {

            }
        });

        expandableLayout.setCollapseListener(new ExpandCollapseListener.CollapseListener<Parent>() {
            @Override
            public void onCollapsed(int parentIndex, Parent parent, View view) {

            }
        });


    }

    public Section<Parent, Child> getSection(String date,List<String> data) {
        Parent fruitCategory = new Parent(date);
        Section<Parent, Child> section = new Section<>();
        Log.d("checkpoint", "checkpoint hello in getSection "+data.size());

        for (int i = 0; i < data.size(); i++) {
            Child fruit = new Child(data.get(i).toString());
            section.children.add(fruit);
            Log.d("checkpoint", "checkpoint hello = " + i);
        }

        section.parent = fruitCategory;
        section.expanded = true;
        return section;
    }
}
